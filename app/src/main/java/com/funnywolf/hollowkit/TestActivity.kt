package com.excelsior

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class TestActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // Enables Always-on
        setAmbientEnabled()
    }
}