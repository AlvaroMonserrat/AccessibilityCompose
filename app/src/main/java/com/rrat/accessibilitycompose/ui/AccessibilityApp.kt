
package com.rrat.accessibilitycompose.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rrat.accessibilitycompose.data.repository.AppContainer
import com.rrat.accessibilitycompose.ui.componets.AppDrawer
import com.rrat.accessibilitycompose.ui.theme.AccessibilityComposeTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AccessibilityApp(
    appContainer: AppContainer
){

    AccessibilityComposeTheme {

        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: MainDestinations.HOME_ROUTE

        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                AppDrawer(
                    currentRoute = currentRoute,
                    navigateToHome = { navController.navigate(MainDestinations.HOME_ROUTE)},
                    navigateToInterests = { navController.navigate(MainDestinations.INTERESTS_ROUTE) },
                    closeDrawer = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.close()
                        }
                    }
                )
            }
        ) {
            AccessibilityNavGraph(
                appContainer = appContainer,
                navController = navController,
                scaffoldState = scaffoldState
            )
        }

    }
}


