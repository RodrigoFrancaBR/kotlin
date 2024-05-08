package br.com.franca.restwithspringbootandkotlin.controller.dto.v1

data class CreatePersonRequestDTO(
    var firstName: String,
    var lastName: String,
    var address: String,
    var gender: String
)