package com.example.invoiceproject.entity


import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "detail")
data class Detail(
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val quantity: Int,
    val price: Double,

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    val invoice: Invoice,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: Product
)