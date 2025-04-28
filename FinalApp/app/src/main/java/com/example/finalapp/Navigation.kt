package com.example.finalapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class Navigation {
    @Preview(showBackground = true)
    @Composable
    fun NavigationApp() {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomBarNavigation(navController)}
        ) { innerPadding ->
            NavigationGraph(navController, Modifier.padding(innerPadding))
        }
    }
}

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    data object Home : Screen("home", "Home", Icons.Default.Home)
    data object Search : Screen("search", "Search", Icons.Default.Search)
    data object Bookmarks : Screen("bookmarks", "Bookmarks", Icons.Default.Star)
    data object List : Screen("list", "Lists", Icons.Default.ShoppingCart)
    data object Settings : Screen("settings", "Settings", Icons.Default.Settings)
}

@Composable
fun BottomBarNavigation(navController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Bookmarks,
        Screen.List,
        Screen.Settings
    )
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                            inclusive = false
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title) }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Search.route) { SearchScreen(navController) }
        composable(Screen.Bookmarks.route) { BookmarksScreen(navController) }
        composable(Screen.List.route) { ListScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    HomePage()
}

@Composable
fun SearchScreen(navController: NavHostController) {
    SearchPage()
}

@Composable
fun BookmarksScreen(navController: NavHostController) {
    BookmarksPage()
}

@Composable
fun ListScreen(navController: NavHostController) {
    ListPage()
}

@Composable
fun SettingsScreen(navController: NavHostController) {
    SettingsPage()
}







