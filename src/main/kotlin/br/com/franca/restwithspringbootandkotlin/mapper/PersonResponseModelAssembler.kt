package br.com.franca.restwithspringbootandkotlin.mapper

import br.com.franca.restwithspringbootandkotlin.controller.LinksFactory
import br.com.franca.restwithspringbootandkotlin.controller.PersonController
import br.com.franca.restwithspringbootandkotlin.controller.dto.v1.PersonResponseDTO
import br.com.franca.restwithspringbootandkotlin.model.Person
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class PersonResponseModelAssembler
    :
    RepresentationModelAssemblerSupport<Person, PersonResponseDTO>(
        PersonController::class.java,
        PersonResponseDTO::class.java
    ) {

    @Autowired
    private lateinit var factory: LinksFactory

    override fun toModel(person: Person): PersonResponseDTO {
        val createModelWithId = createModelWithId(person.id, person)
        createModelWithId.add(factory.linkToPersons())
        BeanUtils.copyProperties(person, createModelWithId)
        return createModelWithId
    }
}