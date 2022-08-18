package com.rrat.accessibilitycompose

import android.app.Application
import com.rrat.accessibilitycompose.data.repository.AppContainer
import com.rrat.accessibilitycompose.data.repository.AppContainerImpl

class AccessibilityApplication: Application() {


    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }

}