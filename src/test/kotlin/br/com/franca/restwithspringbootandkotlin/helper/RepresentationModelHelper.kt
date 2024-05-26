package br.com.franca.restwithspringbootandkotlin.helper

import org.springframework.hateoas.RepresentationModel

object RepresentationModelHelper : AbstractHelper() {

    fun getDefaultRepresentationModel(): RepresentationModel<*> {
        val string = getDefaultRepresentationModelString()
        return getRepresentationModel(string)
    }

    private fun getDefaultRepresentationModelString() =
        """{"links":[{"rel":"first","href":"http://localhost:8080/person?page=0&size=10&sort=id,asc"},{"rel":"self","href":"http://localhost:8080/person?page=0&size=10&sort=id,asc"},{"rel":"next","href":"http://localhost:8080/person?page=1&size=10&sort=id,asc"},{"rel":"last","href":"http://localhost:8080/person?page=101&size=10&sort=id,asc"}],"content":[{"id":1,"firstName":"Ayrton","lastName":"Senna","address":"São Paulo","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/1"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":2,"firstName":"Leonardo","lastName":"da Vinci","address":"Anchiano - Italy","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/2"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":4,"firstName":"Indira","lastName":"Gandhi","address":"Porbandar - India","gender":"Female","links":[{"rel":"self","href":"http://localhost:8080/person/4"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":5,"firstName":"Mahatma","lastName":"Gandhi","address":"Porbandar - India","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/5"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":7,"firstName":"Muhammad","lastName":"Ali","address":"Kentucky - United States","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/7"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":9,"firstName":"Nelson","lastName":"Mandela","address":"Mvezo - South Africa","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/9"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":10,"firstName":"Nikola","lastName":"Tesla","address":"Smiljan - Croatia","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/10"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":11,"firstName":"Caprice","lastName":"Bachelor","address":"1387 Gateway Road","gender":"Female","links":[{"rel":"self","href":"http://localhost:8080/person/11"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":12,"firstName":"Vasilis","lastName":"Gilffillan","address":"6 Reindahl Plaza","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/12"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]},{"id":13,"firstName":"Orbadiah","lastName":"Verdy","address":"5 Linden Lane","gender":"Male","links":[{"rel":"self","href":"http://localhost:8080/person/13"},{"rel":"Persons","href":"http://localhost:8080/person{?page,size,sort,direction}"}]}],"page":{"size":10,"totalElements":1012,"totalPages":102,"number":0}}"""

    private fun getRepresentationModel(string: String): RepresentationModel<*> {
        val messageError = "Error writeStringAsObject someString: $string someClass: ${RepresentationModel::class.java}"
        return writeStringAsObjectOrElseThrow(
            string,
            RepresentationModel::class.java,
            messageError
        ) as RepresentationModel<*>
    }
}