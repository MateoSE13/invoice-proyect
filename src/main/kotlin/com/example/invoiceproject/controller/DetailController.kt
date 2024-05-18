package com.example.invoiceproject.controller

import com.example.invoiceproject.entity.Detail
import com.example.invoiceproject.service.DetailService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/details")
class DetailController(private val detailService: DetailService) {

    @GetMapping
    fun getAllDetails(): ResponseEntity<List<Detail>> =
        ResponseEntity(detailService.findAll(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getDetailById(@PathVariable id: Long): ResponseEntity<Detail> =
        detailService.findById(id)?.let { ResponseEntity(it, HttpStatus.OK) }
            ?: ResponseEntity(HttpStatus.NOT_FOUND)

    @PostMapping
    fun createDetail(@RequestBody detail: Detail): ResponseEntity<Detail> =
        ResponseEntity(detailService.save(detail), HttpStatus.CREATED)

    @PutMapping("/{id}")
    fun updateDetail(@PathVariable id: Long, @RequestBody detail: Detail): ResponseEntity<Detail> =
        detailService.findById(id)?.let {
            ResponseEntity(detailService.save(detail.copy(id = it.id)), HttpStatus.OK)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)

    @DeleteMapping("/{id}")
    fun deleteDetail(@PathVariable id: Long): ResponseEntity<Void> =
        if (detailService.delete(id)) ResponseEntity(HttpStatus.NO_CONTENT) else ResponseEntity(HttpStatus.NOT_FOUND)
}
