package com.okeicalm.simpleJournalEntry.handler.type

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.extensions.getValueFromDataLoader
import com.okeicalm.simpleJournalEntry.entity.JournalEntry
import graphql.schema.DataFetchingEnvironment
import java.util.concurrent.CompletableFuture

private const val JOURNAL_ENTRY_GRAPHQL_NAME = "JournalEntry"

@GraphQLName(JOURNAL_ENTRY_GRAPHQL_NAME)
data class JournalEntryType(
    val id: ID,
    val side: Int,
    val value: Int,
    private val accountId: ID,
) {
    constructor(journalEntry: JournalEntry) : this(
        ID(journalEntry.id.toString()),
        journalEntry.side.toInt(),
        journalEntry.value,
        ID(journalEntry.accountId.toString()),
    )

    fun account(dataFetchingEnvironment: DataFetchingEnvironment): CompletableFuture<AccountType> {
        return dataFetchingEnvironment.getValueFromDataLoader("AccountDataLoader", accountId)
    }
}
