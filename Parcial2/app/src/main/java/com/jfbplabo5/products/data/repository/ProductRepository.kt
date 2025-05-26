package com.jfbplabo5.products.data.repository

import com.jfbplabo5.products.data.models.Product

object ProductRepository {
    fun getProducts(): List<Product>{
        return listOf(
            Product(
                id = "1",
                nombre = "Laptop HP Pavilion AMD Rizen",
                categoria = "Laptop",
                precio = 1200.00,
                descripcion = "Buena Laptop para tareas y perfecta para Gamers",
                imagenURL = "https://siman.vtexassets.com/arquivos/ids/5501851-800-800?v=638508071863930000&width=800&height=800&aspect=true",
            ),
            Product(
                id = "2",
                nombre = "Laptop HP 15",
                categoria = "Laptop",
                precio = 1000.00,
                descripcion = "Buena Laptop para tareas y perfecta para Gamers",
                imagenURL = "https://walmartsv.vtexassets.com/arquivos/ids/707155/97028_01.jpg?v=638780889337300000",
            ),
            Product(
                id = "3",
                nombre = "Laptop HP 14",
                categoria = "Laptop",
                precio = 900.00,
                descripcion = "Buena Laptop para tareas y perfecta para Gamers",
                imagenURL = "https://id-media.apjonlinecdn.com/catalog/product/cache/b3b166914d87ce343d4dc5ec5117b502/7/L/7L9D0PA-1_T1730259085.png",
            ),
            Product(
                id = "4",
                nombre = "TCL Tablets-Pantalla HD-Octa-core-T-Pen-Tablets-TCL",
                categoria = "Tablet",
                precio = 120.00,
                descripcion = "Buena Tablet para las tareas",
                imagenURL = "https://aws-obg-image-lb-4.tcl.com/content/dam/brandsite/region/global/products/tablets/tcl-nxtpaper-14/id/1.png?t=1721272443153&w=800&webp=true&dpr=2.625&rendition=1068",
            ),
            Product(
                id = "5",
                nombre = "Lenovo's Huge Array of New Tablets Includes...a Huge Tablet | PCMag",
                categoria = "Tablet",
                precio = 1300.00,
                descripcion = "Buena Tablet para las tareas",
                imagenURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGaUKcYiREfIAH3Wv09WJ3lUwu9bKP6RG6Qw&s",
            ),
            Product(
                id = "6",
                nombre = "Tablet Onn 10.1 2G 32G Andr 2M2M Cam",
                categoria = "Tablet",
                precio = 600.00,
                descripcion = "Buena Tablet para las tareas",
                imagenURL = "https://walmartsv.vtexassets.com/arquivos/ids/297385/Tablet-Onn-10-1-2G-32G-Andr-2M2M-Cam-1-11758.jpg?v=638138325757430000",
            )
        )
    }
}