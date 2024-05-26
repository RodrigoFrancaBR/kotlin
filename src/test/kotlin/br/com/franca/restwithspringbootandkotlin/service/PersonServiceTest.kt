package br.com.franca.restwithspringbootandkotlin.service

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonResponseDTO
import br.com.franca.restwithspringbootandkotlin.helper.*
import br.com.franca.restwithspringbootandkotlin.mapper.PersonResponseModelAssembler
import br.com.franca.restwithspringbootandkotlin.repository.PersonRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.web.PagedResourcesAssembler
import java.util.*
import br.com.franca.restwithspringbootandkotlin.model.Person as PersonModelEntity

@ExtendWith(MockitoExtension::class)
class PersonServiceTest {

    @Mock
    private lateinit var repository: PersonRepository

    @Mock
    private lateinit var pagedAssembler: PagedResourcesAssembler<PersonModelEntity>

    @Mock
    private lateinit var modelAssembler: PersonResponseModelAssembler

    @InjectMocks
    private lateinit var personService: PersonService

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun findAll() {
        val pageable = PageableHelper.getDefaultPageable()
        var entities = PageableHelper.getDefaultPageImpl()
        Mockito.`when`(repository.findAll(pageable)).thenReturn(entities)

        val pagedModel = PageableHelper.getPagedModel(
            pageable.pageSize.toLong(),
            pageable.pageNumber.toLong(),
            entities.totalElements
        )

        Mockito.`when`(pagedAssembler.toModel(entities, modelAssembler)).thenReturn(pagedModel)
        val pagedModelPerson = personService.findAll(pageable)

        Assertions.assertEquals(pagedModelPerson.metadata?.number, pageable.pageNumber.toLong())
        Assertions.assertEquals(pagedModelPerson.metadata?.size, pageable.pageSize.toLong())
        Assertions.assertEquals(pagedModelPerson.metadata?.totalPages, entities.totalPages.toLong())
        Assertions.assertEquals(pagedModelPerson.metadata?.totalElements, entities.totalElements)

        val first = "http://localhost:8080/person?page=0&size=10&sort=id,asc"
        Assertions.assertEquals(pagedModelPerson.links.getLink("first").get().href, first)

        val personResponseDTO = pagedModelPerson.content.stream().filter { it: PersonResponseDTO? ->
            it?.id?.equals(1L) ?: false
        }.findAny().get()
        val self = "http://localhost:8080/person/1"
        Assertions.assertEquals(personResponseDTO.links.getLink("self").get().href, self)
    }


    @Test
    fun findById() {
    }

    @Test
    fun findByName() {
    }

    @Test
    fun create() {
    }

    @Test
    fun update() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun findByNameLike() {
    }
}