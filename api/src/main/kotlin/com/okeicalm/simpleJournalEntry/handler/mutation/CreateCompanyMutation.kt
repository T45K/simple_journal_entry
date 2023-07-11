package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.CompanyType
import org.springframework.stereotype.Component

data class CreateCompanyInput(val name: String)

@Component
class CreateCompanyMutation : Mutation {
    fun createCompany(input: CreateCompanyInput): CompanyType = TODO()
}
