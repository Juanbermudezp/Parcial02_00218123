package com.jfbplabo5.products.data.models

data class Product(
    val id: String,
    val nombre: String,
    val categoria: String,
    val precio: Double,
    val descripcion: String,
    val imagenURL: String,
    var añadirCarta: Boolean = false
)