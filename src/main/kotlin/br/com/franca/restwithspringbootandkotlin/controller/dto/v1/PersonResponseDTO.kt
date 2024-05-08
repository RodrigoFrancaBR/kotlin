package br.com.franca.restwithspringbootandkotlin.controller.dto.v1

data class PersonResponseDTO(
    var id: Long = 0,
    var firstName: String,
    var lastName: String,
    var address: String,
    var gender: String
) {
}