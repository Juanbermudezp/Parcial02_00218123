package com.jfbplabo5.products.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jfbplabo5.products.ui.screens.cart.CartScreen
import com.jfbplabo5.products.ui.screens.productDetails.ProductDetailScreen
import com.jfbplabo5.products.ui.screens.productsList.ProductListScreen
import com.jfbplabo5.products.ui.screens.productsList.ProductViewModel


@Composable
fun AppNavigation(
    navController: NavHostController,
    productViewModel: ProductViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ProductList.route
    ) {
        composable(Screen.ProductList.route) {
            ProductListScreen(
                productViewModel = productViewModel,
                onProductClick = { product ->
                    productViewModel.selectProduct(product)
                    navController.navigate(Screen.ProductDetail.route)
                },
                onViewCartClick = {
                    navController.navigate(Screen.Cart.route)
                }
            )
        }
        composable(Screen.ProductDetail.route) {
            ProductDetailScreen(
                productViewModel = productViewModel,
                onBackClick = { navController.popBackStack() },
                onAddToCartClick = { product ->
                    productViewModel.addProductToCart(product)
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Cart.route) {
            CartScreen(
                productViewModel = productViewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}