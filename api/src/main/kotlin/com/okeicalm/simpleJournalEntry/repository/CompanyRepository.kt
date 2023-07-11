package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Company

interface CompanyRepository {
    fun findAll(): List<Company>
    fun findById(id: Long): Company?
    fun create(company: Company): Company
    fun update(company: Company): Company?
    fun delete(id: Long): Company?
}
