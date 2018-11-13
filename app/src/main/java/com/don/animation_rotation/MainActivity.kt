package com.don.animation_rotation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.view.animation.TranslateAnimation


class MainActivity : AppCompatActivity() {


    var isUp: Boolean = false

    var rotationAngle = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ll_orient.setOnClickListener {
            rotationAngle = if (rotationAngle == 0f) 180f else 0f //toggle
            iv.animate().rotation(rotationAngle).setDuration(500).start()


            if (isUp) {
                slideDown(ll_visible_gone)
//                myButton.setText("Slide up")
            } else {
                slideUp(ll_visible_gone);
//                myButton.setText("Slide down")
            }

            isUp = !isUp
        }
    }


    // slide the view from below itself to the current position
    fun slideUp(view: View) {
        view.setVisibility(View.VISIBLE)
        val animate = TranslateAnimation(
            0f, // fromXDelta
            0f, // toXDelta
            view.getHeight().toFloat(), // fromYDelta
            0f
        )                // toYDelta
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    // slide the view from its current position to below itself
    fun slideDown(view: View) {
        val animate = TranslateAnimation(
            0f, // fromXDelta
            0f, // toXDelta
            0f, // fromYDelta
            view.getHeight().toFloat()
        ) // toYDelta
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
    }
}
