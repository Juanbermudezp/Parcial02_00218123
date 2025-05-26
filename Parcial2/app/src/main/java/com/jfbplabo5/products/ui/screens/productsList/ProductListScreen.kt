package com.jfbplabo5.products.ui.screens.productsList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jfbplabo5.products.data.models.Product
import com.jfbplabo5.products.ui.components.ProductCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    productViewModel: ProductViewModel = viewModel(),
    onProductClick: (Product) -> Unit,
    onViewCartClick: () -> Unit
) {
    val searchText by productViewModel.searchText
    val filteredProducts = productViewModel.filteredProducts

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Catálogo de Productos") },
                actions = {
                    IconButton(onClick = onViewCartClick) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Ver Carrito")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = searchText,
                onValueChange = { productViewModel.onSearchTextChanged(it) },
                label = { Text("Buscar productos o categoría") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filteredProducts) { product ->
                    ProductCard(product = product) {
                        onProductClick(it) // Navega a la pantalla de detalle al hacer clic [cite: 5]
                    }
                }
            }
        }
    }
}