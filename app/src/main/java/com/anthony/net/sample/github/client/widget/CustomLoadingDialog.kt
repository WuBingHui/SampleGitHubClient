package com.anthony.net.sample.github.client.widget

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.fragment.app.DialogFragment
import com.anthony.net.sample.github.client.databinding.FragmentLoadingDialogBinding

class CustomLoadingDialog : DialogFragment() {

    private lateinit var viewBinding: FragmentLoadingDialogBinding

    private var insideFormDegrees = 0f
    private var insideToDegrees = -360f
    private var outsideFormDegrees = 0f
    private var outsideToDegrees = 360f
    private var duration = 1000L
    var outsideAnimation =
        RotateAnimation(
            outsideFormDegrees,
            outsideToDegrees,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
    var insideAnimation =
        RotateAnimation(
            insideFormDegrees,
            insideToDegrees,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )


    companion object {
        fun newInstance(): CustomLoadingDialog {
            val fragment = CustomLoadingDialog()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        dialog?.let {
            it.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            it.requestWindowFeature(Window.FEATURE_NO_TITLE)
        }

        isCancelable = false

        viewBinding = FragmentLoadingDialogBinding.inflate(inflater, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startInsideAnimation()

        startOutsideAnimation()

    }

    private fun startInsideAnimation() {
        insideAnimation.duration = duration
        insideAnimation.fillAfter = true
        insideAnimation.repeatCount = 0
        viewBinding.wheelInsideImg.animation = insideAnimation
        insideAnimation.setAnimationListener(insideWheelAnimation)
        insideAnimation.startNow()
    }

    private fun startOutsideAnimation() {
        outsideAnimation.duration = duration
        outsideAnimation.fillAfter = true
        outsideAnimation.repeatCount = 0
        viewBinding.wheelOutsideImg.animation = outsideAnimation
        outsideAnimation.setAnimationListener(outsideWheelAnimation)
        outsideAnimation.startNow()
    }

    private val outsideWheelAnimation = object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {
        }

        override fun onAnimationEnd(animation: Animation) {
            outsideFormDegrees += 360f
            outsideToDegrees += 360f
            outsideAnimation =
                RotateAnimation(
                    outsideFormDegrees,
                    outsideToDegrees,
                    Animation.RELATIVE_TO_SELF,
                    0.5f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f
                )
            outsideAnimation.duration = duration
            outsideAnimation.fillAfter = true
            outsideAnimation.repeatCount = 0
            viewBinding.wheelOutsideImg.animation = outsideAnimation
            outsideAnimation.setAnimationListener(this)
            outsideAnimation.startNow()
        }

        override fun onAnimationRepeat(animation: Animation) {
        }
    }

    private val insideWheelAnimation = object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {
        }

        override fun onAnimationEnd(animation: Animation) {
            insideFormDegrees -= 360f
            insideToDegrees -= 360f
            insideAnimation =
                RotateAnimation(
                    insideFormDegrees,
                    insideToDegrees,
                    Animation.RELATIVE_TO_SELF,
                    0.5f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f
                )
            insideAnimation.duration = duration
            insideAnimation.fillAfter = true
            insideAnimation.repeatCount = 0
            viewBinding.wheelInsideImg.animation = insideAnimation
            insideAnimation.setAnimationListener(this)
            insideAnimation.startNow()
        }

        override fun onAnimationRepeat(animation: Animation) {
        }
    }


}