package br.com.franca.restwithspringbootandkotlin.mapper

import br.com.franca.restwithspringbootandkotlin.helper.CreatePersonRequestDTOHelper
import br.com.franca.restwithspringbootandkotlin.helper.PersonHelper
import br.com.franca.restwithspringbootandkotlin.helper.PersonResponseDTOHelper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers


class IPersonMapperTest {
    private var mapper: IPersonMapper = Mappers.getMapper(IPersonMapper::class.java)

    @Test
    fun `should map person to personResponseDTO`() {
        val person = PersonHelper.getDefaultPerson()
        val personResponseDTO = mapper.toPersonResponseDTO(person)
        assertEquals(person.id, personResponseDTO.id)
        assertEquals(person.firstName, personResponseDTO.firstName)
        assertEquals(person.lastName, personResponseDTO.lastName)
        assertEquals(person.address, personResponseDTO.address)
        assertEquals("Male", personResponseDTO.gender)
    }

    @Test
    fun `should map personResponseDTO to person`() {
        val personResponseDTO = PersonResponseDTOHelper.getDefaultPersonResponseDTO()
        val person = mapper.toPerson(personResponseDTO)
        assertEquals(personResponseDTO.id, person.id)
        assertEquals(personResponseDTO.firstName, person.firstName)
        assertEquals(personResponseDTO.lastName, person.lastName)
        assertEquals(personResponseDTO.address, person.address)
        assertEquals("Male", person.gender)
    }

    @Test
    fun `should map personList to personResponseDTOList`() {
        val personList = PersonHelper.getPersonList(5)
        val personDTOList = mapper.toPersonResponseDTOList(personList)
        for (index in personList.indices) {
            assertEquals(personList[index].id, personDTOList[index].id)
            assertEquals(personList[index].firstName, personDTOList[index].firstName)
            assertEquals(personList[index].lastName, personDTOList[index].lastName)
            assertEquals(personList[index].address, personDTOList[index].address)
            assertEquals("Male", personDTOList[index].gender)
        }
    }

    @Test
    fun `should map personResponseDTOList to personList`() {
        val personResponseDTOList = PersonResponseDTOHelper.getPersonResponseDTOList(5)
        val personList = mapper.personResponseDTOListToPersonList(personResponseDTOList)
        for (index in personResponseDTOList.indices) {
            assertEquals(personResponseDTOList[index].id, personList[index].id)
            assertEquals(personResponseDTOList[index].firstName, personList[index].firstName)
            assertEquals(personResponseDTOList[index].lastName, personList[index].lastName)
            assertEquals(personResponseDTOList[index].address, personList[index].address)
            assertEquals("Male", personList[index].gender)
        }
    }

//    @Test
//    fun `should map person to createPersonRequestDTO`() {
//        val person = PersonHelper.getDefaultPerson()
//        val createPersonRequestDTO = mapper.toCreatePersonRequestDTO(person)
//        assertEquals(person.firstName, createPersonRequestDTO.firstName)
//        assertEquals(person.lastName, createPersonRequestDTO.lastName)
//        assertEquals(person.address, createPersonRequestDTO.address)
//        assertEquals("Male", createPersonRequestDTO.gender)
//    }

//    @Test
//    fun `should map createPersonRequestDTO to person`() {
//        val createPersonRequestDTO = CreatePersonRequestDTOHelper.getDefaultCreatePersonRequestDTO()
//        val person = mapper.toPerson(createPersonRequestDTO)
//        assertEquals(createPersonRequestDTO.firstName, person.firstName)
//        assertEquals(createPersonRequestDTO.lastName, person.lastName)
//        assertEquals(createPersonRequestDTO.address, person.address)
//        assertEquals("Male", person.gender)
//    }

    @Test
    fun `should map personList to createPersonRequestDTOList`() {
        val personList = PersonHelper.getPersonList(5)
        val createPersonRequestDTOList = mapper.toCreatePersonRequestDTOList(personList)
        for (index in personList.indices) {
            assertEquals(personList[index].id, createPersonRequestDTOList[index].id)
            assertEquals(personList[index].firstName, createPersonRequestDTOList[index].firstName)
            assertEquals(personList[index].lastName, createPersonRequestDTOList[index].lastName)
            assertEquals(personList[index].address, createPersonRequestDTOList[index].address)
            assertEquals("Male", createPersonRequestDTOList[index].gender)
        }
    }

//    @Test
//    fun `should map createPersonRequestDTOList to personList`() {
//        val createPersonRequestDTOList = CreatePersonRequestDTOHelper.getCreatePersonRequestDTOList(5)
//        val personList = mapper.toPersonList(createPersonRequestDTOList)
//        for (index in createPersonRequestDTOList.indices) {
//            assertEquals(createPersonRequestDTOList[index].firstName, personList[index].firstName)
//            assertEquals(createPersonRequestDTOList[index].lastName, personList[index].lastName)
//            assertEquals(createPersonRequestDTOList[index].address, personList[index].address)
//            assertEquals("Male", personList[index].gender)
//        }
//    }

}