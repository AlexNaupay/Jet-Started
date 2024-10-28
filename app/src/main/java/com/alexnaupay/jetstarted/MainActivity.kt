package com.alexnaupay.jetstarted

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    Message(
        "First message",
        "This is the first message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit"
    ),
    Message(
        "Second message",
        "This is the second message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
    Message(
        "Third message",
        "This is the third message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
    Message(
        "Fourth message",
        "This is the fourth message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
    Message(
        "Fifth message",
        "This is the fifth message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
    Message(
        "Sixth message",
        "This is the sixth message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
    Message(
        "Seventh message",
        "This is the seventh message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
    Message(
        "Eighth message",
        "This is the eighth message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
    Message(
        "Ninth message",
        "This is the ninth message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
    Message(
        "Tenth message",
        "This is the tenth message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
    Message(
        "Eleventh message",
        "This is the eleventh message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
    Message(
        "Twelfth message",
        "This is the twelfth message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
    Message(
        "Thirteenth message",
        "This is the thirteenth message Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut iquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse"
    ),
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
fun MessagesList(messages: List<Message> = emptyList()) {
    LazyColumn {
        items(messages) { message ->
            MessageComponent(message)
        }
    }
}

@Composable
fun MessageComponent(message: Message) {
    // Remember the expanded state
    // If the message is expanded, display all its content
    // otherwise only display the first line
    // mutableStateOf is used to allow the state to be modified (then re-render the UI)
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        GenericImage()
        Spacer(modifier = Modifier.width(8.dp))
        Column(Modifier.clickable {
            expanded = !expanded
        }) {
            GenericText(
                text = message.title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.height(4.dp))
            GenericText(message.body, color = BlueI, lines = if (expanded) Int.MAX_VALUE else 1)
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
    style: TextStyle = TextStyle.Default,
    lines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        color = color,
        style = style,
        maxLines = lines,
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
