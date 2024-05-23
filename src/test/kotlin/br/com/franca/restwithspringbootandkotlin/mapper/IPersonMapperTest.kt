package br.com.franca.restwithspringbootandkotlin.mapper

import br.com.franca.restwithspringbootandkotlin.helper.CreatePersonRequestDTOHelper
import br.com.franca.restwithspringbootandkotlin.helper.PersonDomainEntityHelper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers


class IPersonMapperTest {

    private var mapper: IPersonMapper = Mappers.getMapper(IPersonMapper::class.java)

    @Test
    fun `should map CreatePersonRequestDTO to PersonDomainEntity`() {
        val createPersonRequestDTO = CreatePersonRequestDTOHelper.getDefaultCreatePersonRequestDTO()
        val person = mapper.toDomainEntity(createPersonRequestDTO)
        assertEquals(createPersonRequestDTO.firstName, person.firstName)
        assertEquals(createPersonRequestDTO.lastName, person.lastName)
        assertEquals(createPersonRequestDTO.address, person.address)
        assertEquals("Male", person.gender)
    }

    @Test
    fun `should map PersonDomainEntity to PersonModelEntity`() {
        val domainEntity = PersonDomainEntityHelper.getDefaultPerson()
        val modelEntity = mapper.toEntity(domainEntity)
        assertEquals(domainEntity.firstName, modelEntity.firstName)
        assertEquals(domainEntity.lastName, modelEntity.lastName)
        assertEquals(domainEntity.address, modelEntity.address)
        assertEquals("Male", modelEntity.gender)
    }
}