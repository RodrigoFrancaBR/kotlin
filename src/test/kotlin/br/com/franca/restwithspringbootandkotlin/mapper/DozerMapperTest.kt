package br.com.franca.restwithspringbootandkotlin.mapper

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonDTO
import br.com.franca.restwithspringbootandkotlin.helper.PersonHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DozerMapperTest {

    @Test
    fun parseObject() {
        val person = PersonHelper.getDefaultPerson()
        val output = DozerMapper.parseObject(person, PersonDTO::class.java)
        Assertions.assertEquals(0, output.id)
        Assertions.assertEquals("Default first name", output.firstName)
        Assertions.assertEquals("Default last name", output.lastName)
        Assertions.assertEquals("Default address", output.address)
        Assertions.assertEquals("Male", output.gender)
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

//
//    @Test
//    fun parseVOToEntityTest() {
//
//        val output: Person = DozerMapper.parseObject(inputObject!!.mockVO(), Person::class.java)
//
//        Assertions.assertEquals(0, output.id)
//        Assertions.assertEquals("First Name Test0", output.firstName)
//        Assertions.assertEquals("Last Name Test0", output.lastName)
//        Assertions.assertEquals("Address Test0", output.address)
//        Assertions.assertEquals("Male", output.gender)
//    }
//
//    @Test
//    fun parserVOListToEntityListTest() {
//
//        val outputList: ArrayList<Person> = DozerMapper.parseListObjects(inputObject!!.mockVOList(), Person::class.java)
//
//        val outputZero: Person = outputList[0]
//        Assertions.assertEquals(0, outputZero.id)
//        Assertions.assertEquals("First Name Test0", outputZero.firstName)
//        Assertions.assertEquals("Last Name Test0", outputZero.lastName)
//        Assertions.assertEquals("Address Test0", outputZero.address)
//        Assertions.assertEquals("Male", outputZero.gender)
//
//        val outputSeven: Person = outputList[7]
//        Assertions.assertEquals(7, outputSeven.id)
//        Assertions.assertEquals("First Name Test7", outputSeven.firstName)
//        Assertions.assertEquals("Last Name Test7", outputSeven.lastName)
//        Assertions.assertEquals("Address Test7", outputSeven.address)
//        Assertions.assertEquals("Female", outputSeven.gender)
//
//        val outputTwelve: Person = outputList[12]
//        Assertions.assertEquals(12, outputTwelve.id)
//        Assertions.assertEquals("First Name Test12", outputTwelve.firstName)
//        Assertions.assertEquals("Last Name Test12", outputTwelve.lastName)
//        Assertions.assertEquals("Address Test12", outputTwelve.address)
//        Assertions.assertEquals("Male", outputTwelve.gender)
//    }
}