package com.alexnaupay.jetstarted.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController? = null) {
    Scaffold() { innerPadding ->
        Row(modifier = Modifier.padding(innerPadding)) {
            ContentScreen(navController)
        }
    }
}

@Composable
fun ContentScreen(navController: NavController?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello navigation")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {navController?.popBackStack() }) {
            Text("Return to previous")
        }
    }
}

@Composable
@Preview
fun Preview() {
    SecondScreen()
}