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
class UpdateCompanyMutationTest(
    private val graphQLTestTemplate: GraphQLTestTemplate,
) : FunSpec({

    val objectMapper = jacksonObjectMapper()
    init()

    test("updateCompany") {
        val response = graphQLTestTemplate.postForString(
            """
            mutation UpdateCompany {
                updateCompany(input: {id: "1", name: "Money Forward X"}) {
                    id
                    name
                }
            }
        """.trimIndent()
        )

        response.rawResponse.statusCode shouldBe HttpStatus.OK
        objectMapper.readMap(response.rawResponse.body!!) shouldBe mapOf(
            "data" to mapOf("updateCompany" to mapOf("id" to "1", "name" to "Money Forward X"))
        )
    }
})
