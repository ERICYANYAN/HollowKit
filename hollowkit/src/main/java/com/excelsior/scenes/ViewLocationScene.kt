package com.excelsior.scenes

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.bytedance.scene.Scene
import com.funnywolf.hollowkit.R
import com.orhanobut.logger.Logger

class ViewLocationScene : Scene() {

    lateinit var panel:FrameLayout
    lateinit var dot:TouchView
    lateinit var dotLocation:TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.view_location_scene, container, false)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        panel = view.findViewById(R.id.panel)
        dot = view.findViewById(R.id.dot)
        dotLocation =view.findViewById(R.id.dot_location)
        dot.setOnTouchListener(View.OnTouchListener { v, event ->
            showLocation(v, event)
            return@OnTouchListener false
        })
        showLocation(dot)
    }

    private fun showLocation(v: View, event: MotionEvent?=null) {
        dotLocation.text = "getLeft(${v.left})\n+\ntranslationX(${v.translationX})\n=\nx(${v.x})" +
                "\n\nevent.getX=${event?.x}\n\nevent.getRawX=${event?.rawX}"
    }


}


/**
 * 一个跟手的view
 * */
class TouchView : View{

    var lastX = 0f
    var lastY = 0f

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x = event?.rawX?:0F
        val y  = event?.rawY?:0F
        // 得到屏幕上的位置
        when (event?.action) {
            MotionEvent.ACTION_DOWN->{
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_MOVE ->{
                val deltaX = x - lastX
                val deltaY = y - lastY
                translationX += deltaX
                translationY += deltaY
            }
        }

        lastX = x
        lastY = y
        return true


    }
}