//package br.com.franca.restwithspringbootandkotlin.helper
//
//import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.CreatePersonRequestDTO
//
//object PersonDTOHelper : AbstractHelper() {
//
//    fun getDefaultPersonDTO(): CreatePersonRequestDTO {
//        val string = getDefaultPersonString()
//        return getPersonDTO(string)
//    }
//
//    private fun getDefaultPersonString() =
//        """{
//    "id": 0,
//    "firstName": "Default first name",
//    "lastName": "Default last name",
//    "address": "Default address",
//    "gender": "Male"
//    }"""
//
//    private fun getPersonDTO(string: String): CreatePersonRequestDTO {
//        val messageError =
//            "Error writeStringAsObject someString: $string someClass: ${CreatePersonRequestDTO::class.java}"
//        return writeStringAsObjectOrElseThrow(
//            string,
//            CreatePersonRequestDTO::class.java,
//            messageError
//        ) as CreatePersonRequestDTO
//    }
//
//    fun getPersonDTOList(elements: Int): ArrayList<CreatePersonRequestDTO> {
//        val persons = ArrayList<CreatePersonRequestDTO>()
//        for (i in 1..elements) {
//            val string = getCustomizePersonString(i);
//            persons.add(getPersonDTO(string))
//        }
//        return persons;
//    }
//
//    private fun getCustomizePersonString(number: Int): String {
//        return """{
//    "id": $number,
//    "firstName": "First name_$number",
//    "lastName": "Last name_$number",
//    "address": "Address_$number",
//    "gender": "Male"
//    }"""
//    }
//}