package com.excelsior.activity_study

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.excelsior.common.log
import com.excelsior.common.open
import com.funnywolf.hollowkit.R
import kotlinx.android.synthetic.main.activity_demo.*


open class DemoBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        tv.text=this.javaClass.simpleName +"in task${taskId}"
        root.addView(createBtn("jump standard",root, View.OnClickListener {
            open("/activity/StandardActivity")
        }))
        root.addView(createBtn("jump singleTop",root, View.OnClickListener {
            open("/activity/SingleTopActivity")
        }))
        root.addView(createBtn("jump singleTask",root, View.OnClickListener {
            open("/activity/SingleTaskActivity")
        }))
        root.addView(createBtn("jump singleInstance",root, View.OnClickListener {
            open("/activity/SingleInstanceActivity")
        }))

    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onResume() {
        super.onResume()
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        var msg = "task size = ${manager.appTasks.size}\n"
        manager.getRunningTasks(10).forEach {
            msg+="${it.taskId} task has ${it.numActivities} activity \n"
            log(it)
        }


        desc.text= msg
    }

    private fun createBtn(text:String,root:ViewGroup,listener: View.OnClickListener?= null):Button{
       return (layoutInflater.inflate(R.layout.widget_btn, root, false) as Button).also {
           it.text = text
           listener?.let { listener ->
               it.setOnClickListener(listener)
           }
       }
    }
}

@Route(path = "/activity/StandardActivity")
class StandardActivity : DemoBaseActivity()

@Route(path = "/activity/SingleTopActivity")
class SingleTopActivity : DemoBaseActivity()

@Route(path = "/activity/SingleTaskActivity")
class SingleTaskActivity : DemoBaseActivity()

@Route(path = "/activity/SingleInstanceActivity")
class SingleInstanceActivity : DemoBaseActivity()