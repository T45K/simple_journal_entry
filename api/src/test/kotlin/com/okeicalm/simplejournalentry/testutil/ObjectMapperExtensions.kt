package com.okeicalm.simpleJournalEntry.testutil

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

fun ObjectMapper.readMap(content: String): LinkedHashMap<String, Any> =
    this.readValue<LinkedHashMap<String, Any>>(content)
