package br.com.franca.restwithspringbootandkotlin.controller.dto.v1

data class CreatePersonRequestDTO
    (var firstName: String, var gender: String) {
    var lastName = ""
    var address = ""
}