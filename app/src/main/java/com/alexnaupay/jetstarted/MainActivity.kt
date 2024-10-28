package com.alexnaupay.jetstarted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexnaupay.jetstarted.ui.theme.JetStartedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            JetStartedTheme {
                MyUI()
            }
        }
    }
}

@Composable
fun MyUI() {
    Row(modifier = Modifier.padding(8.dp)) {
        GenericImage()
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            GenericText("Hello @alexh")
            Spacer(modifier = Modifier.height(4.dp) )
            GenericText("How Are You")
        }
    }
}

@Composable
fun GenericImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Foreground icon of Android",
        modifier = Modifier.clip(CircleShape).background(Color.Gray).size(64.dp)
    )

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
        MyUI()
    }
}
