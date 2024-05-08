package br.com.franca.restwithspringbootandkotlin.service

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.CreatePersonRequestDTO
import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonResponseDTO
import br.com.franca.restwithspringbootandkotlin.exceptions.ResourceNotFoundException
import br.com.franca.restwithspringbootandkotlin.mapper.IPersonMapper
import br.com.franca.restwithspringbootandkotlin.repository.PersonRepository
import org.slf4j.LoggerFactory.getLogger
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: IPersonMapper

    private val logger = getLogger(PersonService::class.java)
    fun findAll(): List<PersonResponseDTO> {
        logger.info("finding all people")
        return mapper.toPersonResponseDTOList(repository.findAll())
    }

    fun findById(id: Long): PersonResponseDTO {
        logger.info("finding one person id: {}", id)
        return repository.findById(id).map(mapper::toPersonResponseDTO)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

//        return repository.findById(id).map { entidadeA -> mapper.toDTO(entidadeA) }
//            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
    }

    fun create(createPersonRequest: CreatePersonRequestDTO): PersonResponseDTO {
        logger.info("Creating one person with name: {}", createPersonRequest.firstName)
        val person = mapper.toPerson(createPersonRequest)
        return mapper.toPersonResponseDTO(repository.save(person))
    }

    fun update(id: Long, createPersonRequest: CreatePersonRequestDTO): PersonResponseDTO {
        logger.info("Updating one person with ID: {}", id)
        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        BeanUtils.copyProperties(createPersonRequest, person)
        return mapper.toPersonResponseDTO(repository.save(person))
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}