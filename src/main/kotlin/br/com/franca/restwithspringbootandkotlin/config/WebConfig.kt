package br.com.franca.restwithspringbootandkotlin.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {
    private val MEDIA_TYPE: String = "mediaType"
    private val JSON_MEDIA_TYPE: String = "json"
    private val XML_MEDIA_TYPE: String = "xml"

    override fun configureContentNegotiation(configurer: ContentNegotiationConfigurer) {
        configurer.favorParameter(true)
            .parameterName(MEDIA_TYPE)
            .ignoreAcceptHeader(true)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType(JSON_MEDIA_TYPE, MediaType.APPLICATION_JSON)
            .mediaType(XML_MEDIA_TYPE, MediaType.APPLICATION_XML)
    }
}