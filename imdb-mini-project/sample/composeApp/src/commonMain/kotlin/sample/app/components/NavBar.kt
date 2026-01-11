package sample.app.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*

@Composable
fun NavBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 16.dp,
        modifier = Modifier.height(70.dp)
    ) {
        NavRipple(
            label = "Home",
            icon = Icons.Default.Home,
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) }
        )

        NavRipple(
            label = "Profile",
            icon = Icons.Default.Person,
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) }
        )

        NavRipple(
            label = "Logout",
            icon = Icons.Default.ExitToApp,
            selected = false,
            onClick = {}
        )
    }
}