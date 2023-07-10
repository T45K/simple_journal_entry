package com.okeicalm.simpleJournalEntry.util

import com.expediagroup.graphql.generator.scalars.ID

fun ID.toLong(): Long = this.value.toLong()
