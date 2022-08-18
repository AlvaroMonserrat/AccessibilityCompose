package com.rrat.accessibilitycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rrat.accessibilitycompose.ui.AccessibilityApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val applicationContainer = (application as AccessibilityApplication).container

        setContent {
            AccessibilityApp(applicationContainer)
        }
    }
}

