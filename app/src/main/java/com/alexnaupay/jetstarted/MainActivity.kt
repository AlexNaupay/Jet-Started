package com.alexnaupay.jetstarted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.alexnaupay.jetstarted.navigation.AppNavigation
import com.alexnaupay.jetstarted.screens.Message
import com.alexnaupay.jetstarted.ui.theme.JetStartedTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            JetStartedTheme {
                AppNavigation()
            }
        }
    }
}
