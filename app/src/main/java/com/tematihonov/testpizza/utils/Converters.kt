package com.tematihonov.testpizza.utils

import com.tematihonov.testpizza.data.local.ProductEntity
import com.tematihonov.testpizza.domain.models.responseProducts.Product

fun entityToDto(productEntity: ProductEntity): Product {
    return Product(
        category = productEntity.category,
        description = productEntity.description,
        id = productEntity.id,
        img = productEntity.img,
        name = productEntity.name,
        price = productEntity.price
    )
}

fun dtoToEntity(product: Product): ProductEntity {
    return ProductEntity(
        category = product.category,
        description = product.description,
        id = product.id,
        img = product.img,
        name = product.name,
        price = product.price
    )
}