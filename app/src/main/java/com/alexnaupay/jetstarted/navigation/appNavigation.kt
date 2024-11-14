package com.alexnaupay.jetstarted.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alexnaupay.jetstarted.screens.FirstScreen
import com.alexnaupay.jetstarted.screens.SecondScreen
import com.alexnaupay.jetstarted.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {

        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(route = AppScreens.FirstScreen.route) {
            FirstScreen(navController)
        }

        composable(
            route = AppScreens.SecondScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type =
                    NavType.StringType
            })
        ) {
            SecondScreen(navController, it.arguments?.getString("text"))
        }
    }

}