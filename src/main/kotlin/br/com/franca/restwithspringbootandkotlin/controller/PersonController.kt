package br.com.franca.restwithspringbootandkotlin.controller

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonDTO
import br.com.franca.restwithspringbootandkotlin.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService

    // se não informar o produces, por default produces é json
//    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
//    fun findAll(): List<PersonDTO> {
//        return service.findAll()
//    }
//
//    @GetMapping(
//        "/{id}",
//        produces = [MediaType.APPLICATION_JSON_VALUE]
//    )
//    fun findById(@PathVariable("id") id: Long): PersonDTO {
//        return service.findById(id)
//    }
//
//    @PostMapping(
//        consumes = [MediaType.APPLICATION_JSON_VALUE],
//        produces = [MediaType.APPLICATION_JSON_VALUE]
//    )
//    fun create(@RequestBody person: PersonDTO): PersonDTO {
//        return service.create(person)
//
//    }
//
//    @PutMapping(
//        consumes = [MediaType.APPLICATION_JSON_VALUE],
//        produces = [MediaType.APPLICATION_JSON_VALUE]
//    )
//    fun update(@RequestBody person: PersonDTO): PersonDTO {
//        return service.update(person)
//    }
//
//    @DeleteMapping(
//        "/{id}",
//        produces = [MediaType.APPLICATION_JSON_VALUE]
//    )
//    fun delete(@PathVariable("id") id: Long): ResponseEntity<*> {
//        service.delete(id)
//        return ResponseEntity.noContent().build<Any>()
//    }
}