package com.alexnaupay.jetstarted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alexnaupay.jetstarted.ui.theme.JetStartedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            JetStartedTheme {
                GenericText("Hello @alexh")
            }
        }
    }
}


@Composable
fun GenericText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetStartedTheme {
        GenericText("Hello @alexh")
    }
}
