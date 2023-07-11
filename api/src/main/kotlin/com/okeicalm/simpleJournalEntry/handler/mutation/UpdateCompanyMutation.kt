package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.CompanyType
import org.springframework.stereotype.Component

data class UpdateCompanyInput(val id: ID, val name: String)

@Component
class UpdateCompanyMutation : Mutation {
    fun updateCompany(input: UpdateCompanyInput): CompanyType = TODO()
}
