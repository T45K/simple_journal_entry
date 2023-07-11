package com.okeicalm.simpleJournalEntry.handler.query

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.extensions.getValueFromDataLoader
import com.expediagroup.graphql.server.extensions.getValuesFromDataLoader
import com.expediagroup.graphql.server.operations.Query
import com.okeicalm.simpleJournalEntry.handler.dataloader.CompanyDataLoader
import com.okeicalm.simpleJournalEntry.handler.type.CompanyType
import com.okeicalm.simpleJournalEntry.repository.CompanyRepository
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class CompanyQuery(
    private val companyRepository: CompanyRepository,
) : Query {
    fun allCompanies(): List<CompanyType> =
        companyRepository.findAll().map(::CompanyType)

    @GraphQLDescription("Get single company")
    fun company(id: ID, dataFetchingEnvironment: DataFetchingEnvironment): CompletableFuture<CompanyType?> =
        dataFetchingEnvironment.getValueFromDataLoader(CompanyDataLoader::class.simpleName!!, id)

    @GraphQLDescription("Get companies")
    fun companies(
        ids: List<ID>,
        dataFetchingEnvironment: DataFetchingEnvironment,
    ): CompletableFuture<List<CompanyType>> =
        dataFetchingEnvironment.getValuesFromDataLoader(CompanyDataLoader::class.simpleName!!, ids)
}
