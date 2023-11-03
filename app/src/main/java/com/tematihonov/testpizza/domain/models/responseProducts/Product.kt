package com.tematihonov.testpizza.domain.models.responseProducts

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val img: String,
    val name: String,
    val price: Int
)