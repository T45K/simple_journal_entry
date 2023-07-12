package com.okeicalm.simpleJournalEntry.testutil

import com.fasterxml.jackson.databind.ObjectMapper
import com.graphql.spring.boot.test.GraphQLTestTemplate
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader

@Configuration
class GraphQLTestTemplateConfiguration(
    private val resourceLoader: ResourceLoader,
    private val testRestTemplate: TestRestTemplate,
    private val objectMapper: ObjectMapper,
) {

    @Bean
    fun graphQLTestTemplate(): GraphQLTestTemplate =
        GraphQLTestTemplate(
            resourceLoader,
            testRestTemplate,
            "/graphql",
            objectMapper
        )
}
