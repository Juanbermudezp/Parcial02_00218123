package com.jfbplabo5.products.ui.screens.productsList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jfbplabo5.products.data.models.Product
import com.jfbplabo5.products.data.repository.ProductRepository

class ProductViewModel : ViewModel() {

    private val _products = mutableStateListOf<Product>().apply {
        addAll(ProductRepository.getProducts())
    }
    val products: List<Product> = _products

    private val _searchText = mutableStateOf("")
    val searchText: State<String> = _searchText

    private val _filteredProducts = mutableStateListOf<Product>()
    val filteredProducts: List<Product> = _filteredProducts

    private val _selectedProduct = mutableStateOf<Product?>(null)
    val selectedProduct: State<Product?> = _selectedProduct

    private val _cartProducts = mutableStateListOf<Product>()
    val cartProducts: List<Product> = _cartProducts

    init {
        filterProducts()
    }

    fun onSearchTextChanged(text: String) {
        _searchText.value = text
        filterProducts()
    }

    private fun filterProducts() {
        _filteredProducts.clear()
        if (_searchText.value.isEmpty()) {
            _filteredProducts.addAll(_products)
        } else {
            _filteredProducts.addAll(
                _products.filter { product ->
                    product.nombre.contains(_searchText.value, ignoreCase = true) ||
                            product.categoria.contains(_searchText.value, ignoreCase = true)
                }
            )
        }
    }

    fun selectProduct(product: Product) {
        _selectedProduct.value = product
    }

    fun addProductToCart(product: Product) {
        if (!_cartProducts.contains(product)) {
            _cartProducts.add(product.copy(añadirCarta = true))
        }
    }

    fun removeProductFromCart(product: Product) {
        _cartProducts.remove(product)
    }
}