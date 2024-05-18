package com.example.invoiceproject.service

import com.example.invoiceproject.entity.Detail
import com.example.invoiceproject.repository.DetailRepository
import org.springframework.stereotype.Service

@Service
class DetailService(private val detailRepository: DetailRepository) {
    fun findAll(): List<Detail> = detailRepository.findAll()
    fun findById(id: Long): Detail? = detailRepository.findById(id).orElse(null)
    fun save(detail: Detail): Detail = detailRepository.save(detail)
    fun update(id: Long, detail: Detail): Detail {
        if (detailRepository.existsById(id)) {
            return detailRepository.save(detail.copy(id = id))
        } else {
            throw RuntimeException("Detail not found")
        }
    }
    fun delete(id: Long): Boolean {
        if (detailRepository.existsById(id)) {
            detailRepository.deleteById(id)
            return true
        }
        return false
    }
}
