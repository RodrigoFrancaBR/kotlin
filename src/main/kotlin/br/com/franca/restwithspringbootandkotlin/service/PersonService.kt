package br.com.franca.restwithspringbootandkotlin.service

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.CreatePersonRequestDTO
import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonResponseDTO
import br.com.franca.restwithspringbootandkotlin.domain.entity.Person
import br.com.franca.restwithspringbootandkotlin.exceptions.ResourceNotFoundException
import br.com.franca.restwithspringbootandkotlin.mapper.IPersonMapper
import br.com.franca.restwithspringbootandkotlin.mapper.PersonResponseModelAssembler
import br.com.franca.restwithspringbootandkotlin.repository.PersonRepository
import org.slf4j.LoggerFactory.getLogger
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.PagedModel
import org.springframework.stereotype.Service
import java.util.*


@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: IPersonMapper // tem que converter dominio e entidade jpa

    @Autowired
    private lateinit var modelAssembler: PersonResponseModelAssembler // converter para dto

    @Autowired
    private lateinit var pagedAssembler: PagedResourcesAssembler<br.com.franca.restwithspringbootandkotlin.model.Person>


    private val logger = getLogger(PersonService::class.java)

    fun findAll(pageable: Pageable): PagedModel<PersonResponseDTO> {
        logger.info("finding all people")
        val entities = repository.findAll(pageable)
        return pagedAssembler.toModel(entities, modelAssembler)
    }

    fun findById(id: Long): PersonResponseDTO {
        logger.info("finding one person id: {}", id)
        return repository.findById(id).map(modelAssembler::toModel)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
    }

    fun findByName(pageable: Pageable, firstName: String): PagedModel<PersonResponseDTO> {
        logger.info("finding one person firstName: {}", firstName)

        val findByFirstName = repository.findByFirstName(pageable, firstName)
        return Optional.ofNullable(findByFirstName)
            .map { e -> pagedAssembler.toModel(e, modelAssembler) }
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
    }

    fun create(createPersonRequest: CreatePersonRequestDTO): PersonResponseDTO {
        logger.info("Creating one person with name: {}", createPersonRequest.firstName)
        val domainEntity: Person = mapper.toDomainEntity(createPersonRequest)
        val entity = mapper.toEntity(domainEntity)
        val save = repository.save(entity)
        return modelAssembler.toModel(save)
    }

    fun update(id: Long, createPersonRequest: CreatePersonRequestDTO): PersonResponseDTO {
        logger.info("Updating one person with ID: {}", id)
        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        BeanUtils.copyProperties(createPersonRequest, person)
        return modelAssembler.toModel(repository.save(person))
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }

    fun findByNameLike(pageable: Pageable, letter: String): PagedModel<PersonResponseDTO> {
        logger.info("finding one person firstName: {}", letter)
        val findByFirstName = repository.findByFirstNameContaining(pageable, letter)
        return Optional.ofNullable(findByFirstName)
            .map { e -> pagedAssembler.toModel(e, modelAssembler) }
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
    }
}