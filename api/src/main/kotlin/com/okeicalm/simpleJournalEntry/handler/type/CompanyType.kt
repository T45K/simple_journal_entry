package com.okeicalm.simpleJournalEntry.handler.type

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.scalars.ID
import com.okeicalm.simpleJournalEntry.entity.Company

@GraphQLName("Company")
data class CompanyType(
    val id: ID,
    val name: String,
) {
    constructor(company: Company) : this(
        ID(company.id.toString()),
        company.name,
    )
}
