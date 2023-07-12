package com.okeicalm.simpleJournalEntry.handler.type

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.scalars.ID
import com.okeicalm.simpleJournalEntry.entity.Journal
import java.time.LocalDate

private const val JOURNAL_TYPE_GRAPHQL_NAME = "Journal"

@GraphQLName(JOURNAL_TYPE_GRAPHQL_NAME)
data class JournalType(
    val id: ID,
    val incurredOn: LocalDate,
    val journalEntries: List<JournalEntryType>,
) {
    constructor(journal: Journal) : this(
        id = ID(journal.id.toString()),
        incurredOn = journal.incurredOn,
        journal.journalEntries.map { JournalEntryType(it) }
    )
}
