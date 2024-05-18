package com.example.invoiceproject.entity


import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "invoice")
data class Invoice(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true)
    val code: String,

    @Column(name = "create_at")
    val total: Double,

    @ManyToOne
    @JoinColumn(name = "client_id")
    val client: Client
)