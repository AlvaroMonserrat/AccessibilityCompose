package com.rrat.accessibilitycompose.ui.componets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rrat.accessibilitycompose.ui.MainDestinations


@Composable
fun AppDrawer(
    currentRoute: String,
    navigateToHome: ()->Unit,
    navigateToInterests: ()->Unit,
    closeDrawer: ()->Unit,
){
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(24.dp))
        Logo(Modifier.padding(16.dp))
        Divider(color=MaterialTheme.colors.onSurface.copy(alpha = .2f))
        DrawerButton(
            icon = Icons.Filled.Home,
            label = "Home",
            isSelected = currentRoute == MainDestinations.HOME_ROUTE,
            action = {
                navigateToHome()
                closeDrawer()
            }
        )

        DrawerButton(
            icon = Icons.Filled.List,
            label = "Interests",
            isSelected = currentRoute == MainDestinations.INTERESTS_ROUTE,
            action = {
                navigateToInterests()
                closeDrawer()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppDrawerPreview(){
    AppDrawer(
        currentRoute = "",
        navigateToHome = { /*TODO*/ },
        navigateToInterests = { /*TODO*/ }
    ) {

    }
}