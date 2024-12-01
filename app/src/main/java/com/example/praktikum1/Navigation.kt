package com.example.praktikum1

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum1.Pages.HomePage
import com.example.praktikum1.Pages.LoginPage
//import com.example.praktikum1.Pages.SignUpPage

@Composable
fun Navigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login"){
            LoginPage(modifier, navController, authViewModel )
        }
        composable("signup"){
            SignUpPage(modifier, navController, authViewModel )
        }
        composable("home"){
            HomePage(modifier, navController, authViewModel )
        }
    })
}
