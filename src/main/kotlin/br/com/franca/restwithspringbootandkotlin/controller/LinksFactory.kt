package br.com.franca.restwithspringbootandkotlin.controller


import org.springframework.hateoas.Link
import org.springframework.hateoas.TemplateVariable
import org.springframework.hateoas.TemplateVariable.VariableType
import org.springframework.hateoas.TemplateVariables
import org.springframework.hateoas.UriTemplate
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.stereotype.Component

@Component
class LinksFactory {

    private val defaultTemplateVariables = TemplateVariables(
        TemplateVariable("page", VariableType.REQUEST_PARAM),
        TemplateVariable("size", VariableType.REQUEST_PARAM),
        TemplateVariable("sort", VariableType.REQUEST_PARAM),
        TemplateVariable("direction", VariableType.REQUEST_PARAM)
    )

    fun linkToPersons(): Link {
        val uriTemplate = UriTemplate.of(getUrl(PersonController::class.java), defaultTemplateVariables)
        return Link.of(uriTemplate, "Persons")
    }

    private fun getUrl(controllerClass: Class<*>): String {
        return WebMvcLinkBuilder.linkTo(controllerClass).toUri().toString()
    }

    /**
     * Se meu obter persons tiver algum filtro eu poderia usar esse método
     */

//    private fun buildFilterTemplateVariables(): TemplateVariables? {
//        return TemplateVariables(
//            TemplateVariable("userType", VariableType.REQUEST_PARAM),
//            TemplateVariable("email", VariableType.REQUEST_PARAM),
//            TemplateVariable("courseId", VariableType.REQUEST_PARAM),
//            TemplateVariable("userStatus", VariableType.REQUEST_PARAM)
//        )
//    }

    fun buildUriLocation(id: Long): String? {
        return WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PersonController::class.java).findById(id)).toUri()
            .toString()
    }
}