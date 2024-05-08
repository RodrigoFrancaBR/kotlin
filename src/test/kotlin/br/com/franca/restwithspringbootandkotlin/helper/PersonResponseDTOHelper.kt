package br.com.franca.restwithspringbootandkotlin.helper

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonResponseDTO

object PersonResponseDTOHelper : AbstractHelper() {
    fun getDefaultPersonResponseDTO(): PersonResponseDTO {
        val string = getDefaultPersonString()
        return getPersonResponseDTO(string)
    }

    private fun getPersonResponseDTO(string: String): PersonResponseDTO {
        val messageError = "Error writeStringAsObject someString: $string someClass: ${PersonResponseDTO::class.java}"
        return writeStringAsObjectOrElseThrow(string, PersonResponseDTO::class.java, messageError) as PersonResponseDTO
    }

    private fun getDefaultPersonString() =
        """{
    "id": 0,
    "firstName": "Default first name",
    "lastName": "Default last name",
    "address": "Default address",
    "gender": "Male"
    }"""

    fun getPersonResponseDTOList(elements: Int): List<PersonResponseDTO> {
        val persons = ArrayList<PersonResponseDTO>()
        for (i in 1..elements) {
            val string = getCustomizePersonString(i);
            persons.add(getPersonResponseDTO(string))
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