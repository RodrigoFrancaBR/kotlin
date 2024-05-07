package br.com.franca.restwithspringbootandkotlin.mapper

import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonDTO
import br.com.franca.restwithspringbootandkotlin.model.Person
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface IPersonMapper {

    fun toDTO(person: Person): PersonDTO
}