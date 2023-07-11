package com.okeicalm.simpleJournalEntry.handler.query

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import com.okeicalm.simpleJournalEntry.handler.type.CompanyType
import org.springframework.stereotype.Component

@Component
class CompanyQuery : Query {
    fun allCompanies(): List<CompanyType> = TODO()
    fun company(id: ID): CompanyType? = TODO()
}
