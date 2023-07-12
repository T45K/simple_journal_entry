package com.okeicalm.simpleJournalEntry.handler.query

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.graphql.spring.boot.test.GraphQLTestTemplate
import com.okeicalm.simpleJournalEntry.testutil.init
import com.okeicalm.simpleJournalEntry.testutil.readMap
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompanyQueryTest(
    private val graphQLTestTemplate: GraphQLTestTemplate,
) : FunSpec({

    val objectMapper = jacksonObjectMapper()
    init()

    test("allCompanies") {
        val response = graphQLTestTemplate.postForString(
            """
                query Company {
                    allCompanies {
                        id
                        name
                    }
                }
            """.trimIndent()
        )

        response.rawResponse.statusCode shouldBe HttpStatus.OK
        objectMapper.readMap(response.rawResponse.body!!) shouldBe mapOf(
            "data" to mapOf(
                "allCompanies" to listOf(
                    mapOf("id" to "1", "name" to "moneyforward"),
                    mapOf("id" to "2", "name" to "Rakuten"),
                    mapOf("id" to "3", "name" to "LINE"),
                    mapOf("id" to "4", "name" to "freee"),
                )
            )
        )
    }

    test("company") {
        val response = graphQLTestTemplate.postForString(
            """
                query Company {
                    company(id: "1") {
                        id
                        name
                    }
                }
            """.trimIndent()
        )

        response.rawResponse.statusCode shouldBe HttpStatus.OK
        objectMapper.readMap(response.rawResponse.body!!) shouldBe mapOf(
            "data" to mapOf("company" to mapOf("id" to "1", "name" to "moneyforward"))
        )
    }

    test("companies") {
        val response = graphQLTestTemplate.postForString(
            """
                query Company {
                    companies(ids: ["1", "3", "4"]) {
                        id
                        name
                    }
                }
            """.trimIndent()
        )

        response.rawResponse.statusCode shouldBe HttpStatus.OK
        objectMapper.readMap(response.rawResponse.body!!) shouldBe mapOf(
            "data" to mapOf(
                "companies" to listOf(
                    mapOf("id" to "1", "name" to "moneyforward"),
                    mapOf("id" to "3", "name" to "LINE"),
                    mapOf("id" to "4", "name" to "freee"),
                )
            )
        )
    }
})
