package com.okeicalm.simpleJournalEntry.handler.mutation

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.graphql.spring.boot.test.GraphQLTestTemplate
import com.okeicalm.simpleJournalEntry.testutil.init
import com.okeicalm.simpleJournalEntry.testutil.readMap
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateCompanyMutationTest(
    private val graphQLTestTemplate: GraphQLTestTemplate,
) : FunSpec({

    val objectMapper = jacksonObjectMapper()
    init()

    test("createCompany") {
        val response = graphQLTestTemplate.postForString(
            """
            mutation CreateCompany {
                createCompany(input: {name: "Money Forward X"}) {
                    id
                    name
                }
            }
        """.trimIndent()
        )

        response.rawResponse.statusCode shouldBe HttpStatus.OK
        objectMapper.readMap(response.rawResponse.body!!) shouldBe mapOf(
            "data" to mapOf("createCompany" to mapOf("id" to "5", "name" to "Money Forward X"))
        )
    }
})
