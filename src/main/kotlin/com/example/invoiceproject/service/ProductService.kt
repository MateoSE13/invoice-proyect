package com.example.invoiceproject.service

import com.example.invoiceproject.entity.Product
import com.example.invoiceproject.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun findAll(): List<Product> = productRepository.findAll()
    fun findById(id: Long): Product? = productRepository.findById(id).orElse(null)
    fun save(product: Product): Product = productRepository.save(product)
    fun update(id: Long, product: Product): Product {
        if (productRepository.existsById(id)) {
            return productRepository.save(product.copy(id = id))
        } else {
            throw RuntimeException("Product not found")
        }
    }
    fun delete(id: Long): Boolean {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id)
            return true
        }
        return false
    }
}