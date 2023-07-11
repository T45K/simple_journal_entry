package com.okeicalm.simpleJournalEntry.handler.dataloader

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.execution.KotlinDataLoader
import com.okeicalm.simpleJournalEntry.handler.type.CompanyType
import com.okeicalm.simpleJournalEntry.repository.CompanyRepository
import com.okeicalm.simpleJournalEntry.util.toLong
import org.dataloader.DataLoader
import org.dataloader.DataLoaderFactory
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class CompanyDataLoader(private val repository: CompanyRepository) : KotlinDataLoader<ID, CompanyType> {
    override val dataLoaderName = this::class.simpleName!!
    override fun getDataLoader(): DataLoader<ID, CompanyType> = DataLoaderFactory.newDataLoader { ids ->
        CompletableFuture.supplyAsync {
            repository
                .filterByIds(ids.map { it.toLong() })
                .map(::CompanyType)
        }
    }
}
