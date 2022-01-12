/*
 * This file is generated by jOOQ.
 */
package com.okeicalm.simpleJournalEntry.tables.daos;


import com.okeicalm.simpleJournalEntry.tables.Journals;
import com.okeicalm.simpleJournalEntry.tables.records.JournalsRecord;

import java.time.LocalDate;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class JournalsDao extends DAOImpl<JournalsRecord, com.okeicalm.simpleJournalEntry.tables.pojos.Journals, Long> {

    /**
     * Create a new JournalsDao without any configuration
     */
    public JournalsDao() {
        super(Journals.JOURNALS, com.okeicalm.simpleJournalEntry.tables.pojos.Journals.class);
    }

    /**
     * Create a new JournalsDao with an attached configuration
     */
    @Autowired
    public JournalsDao(Configuration configuration) {
        super(Journals.JOURNALS, com.okeicalm.simpleJournalEntry.tables.pojos.Journals.class, configuration);
    }

    @Override
    public Long getId(com.okeicalm.simpleJournalEntry.tables.pojos.Journals object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.okeicalm.simpleJournalEntry.tables.pojos.Journals> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Journals.JOURNALS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.okeicalm.simpleJournalEntry.tables.pojos.Journals> fetchById(Long... values) {
        return fetch(Journals.JOURNALS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.okeicalm.simpleJournalEntry.tables.pojos.Journals fetchOneById(Long value) {
        return fetchOne(Journals.JOURNALS.ID, value);
    }

    /**
     * Fetch records that have <code>incurred_on BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.okeicalm.simpleJournalEntry.tables.pojos.Journals> fetchRangeOfIncurredOn(LocalDate lowerInclusive, LocalDate upperInclusive) {
        return fetchRange(Journals.JOURNALS.INCURRED_ON, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>incurred_on IN (values)</code>
     */
    public List<com.okeicalm.simpleJournalEntry.tables.pojos.Journals> fetchByIncurredOn(LocalDate... values) {
        return fetch(Journals.JOURNALS.INCURRED_ON, values);
    }
}
