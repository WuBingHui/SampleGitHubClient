package com.anthony.net.sample.github.client.network



enum class Status(val value: String) {
    SUCCESS("success"),
    FAILED("failed"),
}


data class Resource<out T>(val status: Status, val data: T? = null, val message: String? = "") {
    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String? = "", data: T?): Resource<T> {
            return Resource(
                Status.FAILED,
                data,
                msg
            )
        }

    }
}