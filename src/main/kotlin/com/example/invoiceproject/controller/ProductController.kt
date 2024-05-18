package com.example.invoiceproject.controller

import com.example.invoiceproject.entity.Product
import com.example.invoiceproject.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Product>> = ResponseEntity.ok(productService.findAll())

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Product> {
        val product = productService.findById(id)
        return if (product != null) ResponseEntity.ok(product) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun save(@RequestBody product: Product): ResponseEntity<Product> = ResponseEntity.ok(productService.save(product))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Product> = ResponseEntity.ok(productService.update(id, product))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (productService.delete(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    }
}
