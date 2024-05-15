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
import org.springframework.hateoas.CollectionModel
import org.springframework.stereotype.Service


@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: IPersonMapper // tem que converter dominio e entidade jpa
    @Autowired
    private lateinit var assembler: PersonResponseModelAssembler // converter para dto


    private val logger = getLogger(PersonService::class.java)
    fun findAll(): CollectionModel<PersonResponseDTO> {
        logger.info("finding all people")
        return assembler.toCollectionModel(repository.findAll())
////        val toPersonResponseDTOList = mapper.toPersonResponseDTOList(repository.findAll())
////        val collectionModel = CollectionModel<PersonResponseDTO>(toPersonResponseDTOList)
//        return collectionModel
    }

    fun findById(id: Long): PersonResponseDTO {
        logger.info("finding one person id: {}", id)
        return repository.findById(id).map(assembler::toModel)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
    }

    fun create(createPersonRequest: CreatePersonRequestDTO): PersonResponseDTO {
        logger.info("Creating one person with name: {}", createPersonRequest.firstName)
        val domainEntity: Person = mapper.toDomainEntity(createPersonRequest)
        // aplicar alguma regra de negócio nesse objeto, por exemplo validar a idade > 18 etc...
        val entity = mapper.toEntity(domainEntity)
        val save = repository.save(entity)
        return assembler.toModel(save)
    }

    fun update(id: Long, createPersonRequest: CreatePersonRequestDTO): PersonResponseDTO {
        logger.info("Updating one person with ID: {}", id)
        val person = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        BeanUtils.copyProperties(createPersonRequest, person)
        return assembler.toModel(repository.save(person))
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }
        repository.delete(entity)
    }
}