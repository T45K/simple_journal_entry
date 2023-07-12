package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.AccountType
import com.okeicalm.simpleJournalEntry.usecase.account.AccountDeleteUseCase
import com.okeicalm.simpleJournalEntry.usecase.account.AccountDeleteUseCaseInput
import com.okeicalm.simpleJournalEntry.util.toLong
import org.springframework.stereotype.Component

data class DeleteAccountInput(val id: ID)

data class DeleteAccountPayload(val deletedAccount: AccountType?)

@Component
class DeleteAccountMutation(private val accountDeletionUseCase: AccountDeleteUseCase) : Mutation {
    fun deleteAccount(input: DeleteAccountInput): DeleteAccountPayload {
        val output = accountDeletionUseCase.call(AccountDeleteUseCaseInput(id = input.id.toLong()))
        val deleteAccountType = output.account?.let(::AccountType)

        return DeleteAccountPayload(deleteAccountType)
    }
}
