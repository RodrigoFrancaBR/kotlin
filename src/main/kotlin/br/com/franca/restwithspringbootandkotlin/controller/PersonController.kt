package br.com.franca.restwithspringbootandkotlin.controller

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.CreatePersonRequestDTO
import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonResponseDTO
import br.com.franca.restwithspringbootandkotlin.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.CollectionModel
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping
    fun findAll(): CollectionModel<PersonResponseDTO> = service.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long): PersonResponseDTO = service.findById(id)

    @ResponseStatus(CREATED)
    @PostMapping
    fun create(@RequestBody request: CreatePersonRequestDTO) = service.create(request)

    @ResponseStatus(OK)
    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody request: CreatePersonRequestDTO) = service.update(id, request)

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) = service.delete(id)
}