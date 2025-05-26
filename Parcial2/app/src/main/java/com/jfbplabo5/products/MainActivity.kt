package com.jfbplabo5.products;

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jfbplabo5.products.ui.navigation.AppNavigation
import com.jfbplabo5.products.ui.screens.productsList.ProductViewModel
import com.jfbplabo5.products.ui.theme.ProductsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductCatalogApp()
                }
            }
        }
    }
}

@Composable
fun ProductCatalogApp() {
    val navController = rememberNavController()
    val productViewModel: ProductViewModel = viewModel()

    AppNavigation(navController = navController, productViewModel = productViewModel)
}