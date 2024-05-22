package br.com.franca.restwithspringbootandkotlin.config

import br.com.franca.restwithspringbootandkotlin.serilization.converter.YamlJacksonMessageConverter
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.APPLICATION_XML
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import br.com.franca.restwithspringbootandkotlin.util.MediaType as MediaTypeUtil

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun configureContentNegotiation(configurer: ContentNegotiationConfigurer) {
        configurer.favorParameter(true)
            .parameterName(MediaTypeUtil.MEDIA_TYPE)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(APPLICATION_JSON)
            .mediaType(APPLICATION_JSON.type, APPLICATION_JSON)
            .mediaType(APPLICATION_XML.type, APPLICATION_XML)
            .mediaType(
                MediaTypeUtil.X_YAML_MEDIA_TYPE, MediaType.valueOf(MediaTypeUtil.APPLICATION_X_YAML)
            )
    }

    override fun extendMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(YamlJacksonMessageConverter())
    }
}