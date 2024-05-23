package br.com.franca.restwithspringbootandkotlin.mapper

import br.com.franca.restwithspringbootandkotlin.helper.PersonModelEntityHelper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers


class PersonResponseModelAssemblerTest {

    private var mapper: PersonResponseModelAssembler = Mappers.getMapper(PersonResponseModelAssembler::class.java)

    @Test
    fun `should map PersonModelEntity to PersonResponseDTO`() {
        val modelEntity = PersonModelEntityHelper.getDefaultPerson()
        val personResponseDTO = mapper.toModel(modelEntity)

        assertEquals(modelEntity.id, personResponseDTO.id)
        assertEquals(modelEntity.firstName, personResponseDTO.firstName)
        assertEquals(modelEntity.lastName, personResponseDTO.lastName)
        assertEquals(modelEntity.address, personResponseDTO.address)
        assertEquals("Male", personResponseDTO.gender)
    }
}