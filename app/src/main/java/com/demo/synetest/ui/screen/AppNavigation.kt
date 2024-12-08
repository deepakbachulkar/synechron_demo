package com.demo.synetest.ui.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.demo.synetest.ui.screen.details_item.ItemDetailsScreen
import com.demo.synetest.ui.screen.list_items.ListItemsScreen
import com.demo.synetest.ui.screen.list_items.viewmodel.ListItemsViewModel

@Composable
fun AppNavigationGraph(viewModel: ViewModel ){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.LIST_ITEM_SCREEN){
        composable(Routes.LIST_ITEM_SCREEN){
            ListItemsScreen(viewModel = viewModel as ListItemsViewModel,
                onClickShow = {
                    navController.navigate("${Routes.Item_DETAILS_SCREEN}/$it")
                }
            )
        }
        composable("${Routes.Item_DETAILS_SCREEN}/{dbn}", arguments = listOf(
            navArgument("dbn"){
                type = NavType.StringType
            }
        )){
            val dbn = it.arguments?.getString("dbn")
            ItemDetailsScreen(viewModel as ListItemsViewModel, dbn?:"")
        }
    }
}