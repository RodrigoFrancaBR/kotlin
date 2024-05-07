package br.com.franca.restwithspringbootandkotlin.mapper

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonDTO
import br.com.franca.restwithspringbootandkotlin.helper.PersonDTOHelper
import br.com.franca.restwithspringbootandkotlin.helper.PersonHelper
import br.com.franca.restwithspringbootandkotlin.model.Person
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DozerMapperTest {

    @Test
    fun parseObject() {
        val person = PersonHelper.getDefaultPerson()
        val personDTO = DozerMapper.parseObject(person, PersonDTO::class.java)
        Assertions.assertEquals(0, personDTO.id)
        Assertions.assertEquals("Default first name", personDTO.firstName)
        Assertions.assertEquals("Default last name", personDTO.lastName)
        Assertions.assertEquals("Default address", personDTO.address)
        Assertions.assertEquals("Male", personDTO.gender)
    }

    @Test
    fun parseListObjects() {
        val personList = PersonHelper.getPersonList(5)
        val outputList = DozerMapper.parseListObjects(personList, PersonDTO::class.java)
        val personOne = outputList[0]

        Assertions.assertEquals(1, personOne.id)
        Assertions.assertEquals("First name_1", personOne.firstName)
        Assertions.assertEquals("Last name_1", personOne.lastName)
        Assertions.assertEquals("Address_1", personOne.address)
        Assertions.assertEquals("Male", personOne.gender)

        val personThree = outputList[2]
        Assertions.assertEquals(3, personThree.id)
        Assertions.assertEquals("First name_3", personThree.firstName)
        Assertions.assertEquals("Last name_3", personThree.lastName)
        Assertions.assertEquals("Address_3", personThree.address)
        Assertions.assertEquals("Male", personThree.gender)
    }

    @Test
    fun parseObjectDTO() {
        val personDTO = PersonDTOHelper.getDefaultPersonDTO()
        val person = DozerMapper.parseObject(personDTO, Person::class.java)
        Assertions.assertEquals(0, person.id)
        Assertions.assertEquals("Default first name", person.firstName)
        Assertions.assertEquals("Default last name", person.lastName)
        Assertions.assertEquals("Default address", person.address)
        Assertions.assertEquals("Male", person.gender)
    }

    @Test
    fun parseListObjectsDTO() {
        val personDTOList = PersonDTOHelper.getPersonDTOList(5)
        val outputList = DozerMapper.parseListObjects(personDTOList, Person::class.java)
        val personOne = outputList[0]

        Assertions.assertEquals(1, personOne.id)
        Assertions.assertEquals("First name_1", personOne.firstName)
        Assertions.assertEquals("Last name_1", personOne.lastName)
        Assertions.assertEquals("Address_1", personOne.address)
        Assertions.assertEquals("Male", personOne.gender)

        val personThree = outputList[2]
        Assertions.assertEquals(3, personThree.id)
        Assertions.assertEquals("First name_3", personThree.firstName)
        Assertions.assertEquals("Last name_3", personThree.lastName)
        Assertions.assertEquals("Address_3", personThree.address)
        Assertions.assertEquals("Male", personThree.gender)
    }

}