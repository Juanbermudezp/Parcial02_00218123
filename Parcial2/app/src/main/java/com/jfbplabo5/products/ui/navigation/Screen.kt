package com.jfbplabo5.products.ui.navigation


sealed class Screen(val route: String) {
    object ProductList : Screen("product_list")
    object ProductDetail : Screen("product_detail")
    object Cart : Screen("cart")
}