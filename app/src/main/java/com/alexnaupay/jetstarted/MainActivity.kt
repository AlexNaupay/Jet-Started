package com.alexnaupay.jetstarted

import android.content.res.Configuration
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexnaupay.jetstarted.ui.theme.BlueI
import com.alexnaupay.jetstarted.ui.theme.JetStartedTheme

private val messages: List<Message> = listOf(
    Message("First message", "This is the first message"),
    Message("Second message", "This is the second message"),
    Message("Third message", "This is the third message"),
    Message("Fourth message", "This is the fourth message"),
    Message("Fifth message", "This is the fifth message"),
    Message("Sixth message", "This is the sixth message"),
    Message("Seventh message", "This is the seventh message"),
    Message("Eighth message", "This is the eighth message"),
    Message("Ninth message", "This is the ninth message"),
    Message("Tenth message", "This is the tenth message"),
    Message("Eleventh message", "This is the eleventh message"),
    Message("Twelfth message", "This is the twelfth message"),
    Message("Thirteenth message", "This is the thirteenth message"),
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            JetStartedTheme {
                MessagesList(messages)
            }
        }
    }
}

@Composable
fun MessagesList(messages: List<Message> = emptyList()){
    LazyColumn {
        items(messages) { message ->
            MessageComponent(message)
        }
    }
}

@Composable
fun MessageComponent(message: Message) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        GenericImage()
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            GenericText(
                text = message.title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            GenericText(message.title, color = BlueI)
        }
    }
}

@Composable
fun GenericImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Foreground icon of Android",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)
    )

}

@Composable
fun GenericText(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle.Default
) {
    Text(
        text = text,
        color = color,
        style = style,
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES,  showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetStartedTheme {
        MessagesList(messages = messages)
    }
}

data class Message(val title: String, val body: String)
