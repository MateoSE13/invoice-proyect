package com.example.invoiceproject.controller

import com.example.invoiceproject.entity.Invoice
import com.example.invoiceproject.service.InvoiceService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoices")
class InvoiceController(private val invoiceService: InvoiceService) {

    @GetMapping
    fun getAllInvoices(): ResponseEntity<List<Invoice>> =
        ResponseEntity(invoiceService.findAll(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getInvoiceById(@PathVariable id: Long): ResponseEntity<Invoice> =
        invoiceService.findById(id)?.let { ResponseEntity(it, HttpStatus.OK) }
            ?: ResponseEntity(HttpStatus.NOT_FOUND)

    @PostMapping
    fun createInvoice(@RequestBody invoice: Invoice): ResponseEntity<Invoice> =
        ResponseEntity(invoiceService.save(invoice), HttpStatus.CREATED)
    @PutMapping("/{id}")
    fun updateInvoice(@PathVariable id: Long, @RequestBody invoice: Invoice): ResponseEntity<Invoice> =
        invoiceService.findById(id)?.let {
            ResponseEntity(invoiceService.save(invoice.copy(id = it.id)), HttpStatus.OK)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)

    @DeleteMapping("/{id}")
    fun deleteInvoice(@PathVariable id: Long): ResponseEntity<Void> =
        if (invoiceService.delete(id)) ResponseEntity(HttpStatus.NO_CONTENT) else ResponseEntity(HttpStatus.NOT_FOUND)
}
