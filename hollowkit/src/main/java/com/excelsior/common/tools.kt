package com.excelsior.common

import com.alibaba.android.arouter.launcher.ARouter
import java.util.*

fun open(url:String){
    ARouter.getInstance().build(url).navigation();
}

fun log(o:Any ){
    com.orhanobut.logger.Logger.d( o)

}