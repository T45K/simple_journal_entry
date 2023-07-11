package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Company
import com.okeicalm.simpleJournalEntry.infra.db.tables.Companies
import org.jooq.DSLContext
import org.jooq.Field
import org.springframework.stereotype.Repository

interface CompanyRepository {
    fun findAll(): List<Company>
    fun findById(id: Long): Company?
    fun create(company: Company): Company
    fun update(company: Company): Company?
    fun delete(id: Long): Company?
}

@Repository
class CompanyRepositoryImpl(private val dslContext: DSLContext) : CompanyRepository {
    override fun findAll(): List<Company> = dslContext.select()
        .from(Companies.COMPANIES)
        .fetch()
        .into(Company::class.java)

    override fun findById(id: Long): Company? = dslContext
        .fetchOne(Companies.COMPANIES, Companies.COMPANIES.ID eq id)
        ?.into(Company::class.java)

    override fun create(company: Company): Company {
        TODO("Not yet implemented")
    }

    override fun update(company: Company): Company? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long): Company? {
        TODO("Not yet implemented")
    }

    private infix fun <T> Field<T>.eq(value: T) = this.eq(value)
}
