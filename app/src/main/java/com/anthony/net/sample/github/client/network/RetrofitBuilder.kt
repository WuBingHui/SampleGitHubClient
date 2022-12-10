package com.anthony.net.sample.github.client.network


import com.anthony.net.sample.github.client.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.IOException
import java.util.concurrent.TimeUnit


object RetrofitBuilder {

    val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    fun createOkHttpClient(): OkHttpClient {

        val httpClient = OkHttpClient.Builder()

        val httpLoggingInterceptor = HttpLoggingInterceptor()

        httpLoggingInterceptor.level =
            HttpLoggingInterceptor.Level.BODY

        httpClient
            .retryOnConnectionFailure(true)//默認重試一次，需要重試n次的話需要實現攔截器
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .followRedirects(false)
            .followSslRedirects(false)
            .addInterceptor(httpLoggingInterceptor)

        httpClient.addInterceptor(RedirectInterceptor())


        return httpClient.build()

    }

    inline fun <reified T> createService(): T {
        val contentType = "application/json".toMediaType()
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
        return retrofit.create(T::class.java)
    }


    private fun createResponse(chain: Interceptor.Chain, request: Request): Response {

        return chain.proceed(
            request.newBuilder()
                .header("Accept", "application/vnd.github+json")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .method(request.method, request.body).build()
        )

    }

    class RedirectInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {

            val request = chain.request()
            val response = createResponse(chain, request)

//            when (response.code) {
//                in 400..900 -> {
//                    throw IOException(response.toString())
//                }
//            }

            return response

        }
    }
}

