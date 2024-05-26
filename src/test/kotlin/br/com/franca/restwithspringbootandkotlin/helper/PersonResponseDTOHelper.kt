package br.com.franca.restwithspringbootandkotlin.helper

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonResponseDTO

object PersonResponseDTOHelper : AbstractHelper() {

    fun get(): String =
        """{"pageNumber":0,"pageSize":10,"sort":{"empty":false,"unsorted":false,"sorted":true},"offset":0,"paged":true,"unpaged":false}"""

    fun get1() =
        """{"content":[{"id":1,"firstName":"Ayrton","lastName":"Senna","address":"São Paulo","gender":"Male"},{"id":2,"firstName":"Leonardo","lastName":"da Vinci","address":"Anchiano - Italy","gender":"Male"},{"id":4,"firstName":"Indira","lastName":"Gandhi","address":"Porbandar - India","gender":"Female"},{"id":5,"firstName":"Mahatma","lastName":"Gandhi","address":"Porbandar - India","gender":"Male"},{"id":7,"firstName":"Muhammad","lastName":"Ali","address":"Kentucky - United States","gender":"Male"},{"id":9,"firstName":"Nelson","lastName":"Mandela","address":"Mvezo - South Africa","gender":"Male"},{"id":10,"firstName":"Nikola","lastName":"Tesla","address":"Smiljan - Croatia","gender":"Male"},{"id":11,"firstName":"Caprice","lastName":"Bachelor","address":"1387 Gateway Road","gender":"Female"},{"id":12,"firstName":"Vasilis","lastName":"Gilffillan","address":"6 Reindahl Plaza","gender":"Male"},{"id":13,"firstName":"Orbadiah","lastName":"Verdy","address":"5 Linden Lane","gender":"Male"}],"pageable":{"pageNumber":0,"pageSize":10,"sort":{"empty":false,"unsorted":false,"sorted":true},"offset":0,"paged":true,"unpaged":false},"totalPages":102,"totalElements":1012,"last":false,"size":10,"number":0,"sort":{"empty":false,"unsorted":false,"sorted":true},"numberOfElements":10,"first":true,"empty":false}"""

    fun get2() =
        """{"links":[{"rel":"first","href":"http://localhost:8080/person?page=0&size=10&sort=id,asc"},{"rel":"self","href":"http://localhost:8080/person?page=0&size=10&sort=id,asc"},{"rel":"next","href":"http://localhost:8080/person?page=1&size=10&sort=id,asc"},{"rel":"last","href":"http://localhost:8080/person?page=101&size=10&sort=id,asc"}],"content":[{"id":1,"firstName":"Ayrton","lastName":"Senna","address":"São Paulo","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/1"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":2,"firstName":"Leonardo","lastName":"da Vinci","address":"Anchiano - Italy","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/2"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":4,"firstName":"Indira","lastName":"Gandhi","address":"Porbandar - India","gender":"Female","links":[{"rel":"self","href":"http://localhost:8080/person/4"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":5,"firstName":"Mahatma","lastName":"Gandhi","address":"Porbandar - India","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/5"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":7,"firstName":"Muhammad","lastName":"Ali","address":"Kentucky - United States","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/7"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":9,"firstName":"Nelson","lastName":"Mandela","address":"Mvezo - South Africa","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/9"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":10,"firstName":"Nikola","lastName":"Tesla","address":"Smiljan - Croatia","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/10"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":11,"firstName":"Caprice","lastName":"Bachelor","address":"1387 Gateway Road","gender":"Female","links":[{"rel":"self","href":"http://localhost:8080/person/11"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":12,"firstName":"Vasilis","lastName":"Gilffillan","address":"6 Reindahl Plaza","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/12"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":13,"firstName":"Orbadiah","lastName":"Verdy","address":"5 Linden Lane","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/13"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]}],"page":{"size":10,"totalElements":1012,"totalPages":102,"number":0}}"""

    fun getDefaultPersonResponseDTO(): PersonResponseDTO {
        val string = getDefaultPersonResponseDTOString()
        return getPersonResponseDTO(string)
    }

    private fun getDefaultPersonResponseDTOString() =
        """{
    "id": 0,
    "firstName": "Default first name",
    "lastName": "Default last name",
    "address": "Default address",
    "gender": "Male"
    }"""


    private fun getPersonResponseDTO(string: String): PersonResponseDTO {
        val messageError = "Error writeStringAsObject someString: $string someClass: ${PersonResponseDTO::class.java}"
        return writeStringAsObjectOrElseThrow(string, PersonResponseDTO::class.java, messageError) as PersonResponseDTO
    }

    fun getDefaultPersonResponseDTOList(elements: Int): ArrayList<PersonResponseDTO> {
        val persons = ArrayList<PersonResponseDTO>()
        for (i in 1..elements) {
            val string = PersonResponseDTOHelper.getCustomizePersonResponseDTOString(i);
            persons.add(PersonResponseDTOHelper.getPersonResponseDTO(string))
        }
        return persons;
    }

    private fun getCustomizePersonResponseDTOString(number: Int): String {
        return """{
    "id": $number,
    "firstName": "First name_$number",
    "lastName": "Last name_$number",
    "address": "Address_$number",
    "gender": "Male"
    }"""
    }

//    fun getPersonList(elements: Int): ArrayList<Person> {
//        val persons = ArrayList<Person>()
//        for (i in 1..elements) {
//            val string = getCustomizePersonString(i);
//            persons.add(getPerson(string))
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
}