package com.example.invoiceproject.entity


import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val description: String,
    val brand: String,
    val price: Double,
    val stock: Int
)