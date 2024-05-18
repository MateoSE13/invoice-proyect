package com.example.invoiceproject.repository

import com.example.invoiceproject.entity.Detail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository : JpaRepository<Detail, Long?> {
    fun findById (id: Long?): Detail?

}