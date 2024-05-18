package com.example.invoiceproject.service


import com.example.invoiceproject.entity.Invoice
import com.example.invoiceproject.repository.InvoiceRepository
import org.springframework.stereotype.Service

@Service
class InvoiceService(private val invoiceRepository: InvoiceRepository) {
    fun findAll(): List<Invoice> = invoiceRepository.findAll()
    fun findById(id: Long): Invoice? = invoiceRepository.findById(id).orElse(null)
    fun save(invoice: Invoice): Invoice = invoiceRepository.save(invoice)
    fun update(id: Long, invoice: Invoice): Invoice {
        if (invoiceRepository.existsById(id)) {
            return invoiceRepository.save(invoice.copy(id = id))
        } else {
            throw RuntimeException("Invoice not found")
        }
    }
    fun delete(id: Long): Boolean {
        if (invoiceRepository.existsById(id)) {
            invoiceRepository.deleteById(id)
            return true
        }
        return false
    }
}
