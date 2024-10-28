package com.alexnaupay.jetstarted.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavController? = null, text: String? = null) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 8.dp).clickable {
                            navController?.popBackStack()
                        })
                    Text("Second Screen")
                }
            }
        )
    }) { innerPadding ->
        Row(modifier = Modifier.padding(innerPadding)) {
            ContentScreen(navController, text)
        }
    }
}

@Composable
fun ContentScreen(navController: NavController?, text: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello navigation")
        text?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Text(it)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController?.popBackStack() }) {
            Text("Return to previous")
        }
    }
}

@Composable
@Preview
fun Preview() {
    SecondScreen()
}