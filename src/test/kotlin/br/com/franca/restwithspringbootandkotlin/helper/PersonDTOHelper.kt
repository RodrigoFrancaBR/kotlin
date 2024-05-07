package br.com.franca.restwithspringbootandkotlin.helper

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonDTO

object PersonDTOHelper : AbstractHelper() {

    fun getDefaultPersonDTO(): PersonDTO {
        val string = getDefaultPersonString()
        return getPersonDTO(string)
    }

    private fun getDefaultPersonString() =
        """{
    "id": 0,
    "firstName": "Default first name",
    "lastName": "Default last name",
    "address": "Default address",
    "gender": "Male"
    }"""

    private fun getPersonDTO(string: String): PersonDTO {
        val messageError = "Error writeStringAsObject someString: $string someClass: ${PersonDTO::class.java}"
        return writeStringAsObjectOrElseThrow(string, PersonDTO::class.java, messageError) as PersonDTO
    }

    fun getPersonDTOList(elements: Int): ArrayList<PersonDTO> {
        val persons = ArrayList<PersonDTO>()
        for (i in 1..elements) {
            val string = getCustomizePersonString(i);
            persons.add(getPersonDTO(string))
        }
        return persons;
    }

    private fun getCustomizePersonString(number: Int): String {
        return """{
    "id": $number,
    "firstName": "First name_$number",
    "lastName": "Last name_$number",
    "address": "Address_$number",
    "gender": "Male"
    }"""
    }
}