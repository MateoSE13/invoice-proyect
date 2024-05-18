package com.example.invoiceproject.controller

import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.service.ClientService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clients")
class ClientController(private val clientService: ClientService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Client>> = ResponseEntity.ok(clientService.findAll())

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Client> {
        val client = clientService.findById(id)
        return if (client != null) ResponseEntity.ok(client) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun save(@RequestBody client: Client): ResponseEntity<Client> = ResponseEntity.ok(clientService.save(client))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody client: Client): ResponseEntity<Client> = ResponseEntity.ok(clientService.update(id, client))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (clientService.delete(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    }
}
