package com.example.invoiceproject.service

import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class ClientService(private val clientRepository: ClientRepository) {
    fun findAll(): List<Client> = clientRepository.findAll()
    fun findById(id: Long): Client? = clientRepository.findById(id).orElse(null)
    fun save(client: Client): Client = clientRepository.save(client)
    fun update(id: Long, client: Client): Client {
        if (clientRepository.existsById(id)) {
            return clientRepository.save(client.copy(id = id))
        } else {
            throw RuntimeException("Client not found")
        }
    }
    fun delete(id: Long): Boolean {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id)
            return true
        }
        return false
    }
}