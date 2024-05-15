package br.com.franca.restwithspringbootandkotlin.controller

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.CreatePersonRequestDTO
import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonResponseDTO
import br.com.franca.restwithspringbootandkotlin.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.hateoas.PagedModel
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    @GetMapping
    fun findAll(
        @PageableDefault(page = 0, size = 10, sort = ["id"], direction = Sort.Direction.ASC)
        pageable: Pageable,
    ): PagedModel<PersonResponseDTO> = service.findAll(pageable)

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