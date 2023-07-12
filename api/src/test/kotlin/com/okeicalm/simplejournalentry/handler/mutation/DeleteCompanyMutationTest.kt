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
class DeleteCompanyMutationTest(
    private val graphQLTestTemplate: GraphQLTestTemplate,
) : FunSpec({

    val objectMapper = jacksonObjectMapper()
    init()

    test("deleteCompany") {
        val response = graphQLTestTemplate.postForString(
            """
            mutation DeleteCompany {
                deleteCompany(input: {id: "2"}) {
                    id
                    name
                }
            }
        """.trimIndent()
        )

        response.rawResponse.statusCode shouldBe HttpStatus.OK
        objectMapper.readMap(response.rawResponse.body!!) shouldBe mapOf(
            "data" to mapOf("deleteCompany" to mapOf("id" to "2", "name" to "Rakuten"))
        )
    }
})
