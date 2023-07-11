package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.AccountType
import com.okeicalm.simpleJournalEntry.usecase.account.AccountCreateUseCase
import com.okeicalm.simpleJournalEntry.usecase.account.AccountCreateUseCaseInput
import com.okeicalm.simpleJournalEntry.valueobject.AccountElementType
import org.springframework.stereotype.Component

data class CreateAccountInput(val code: String, val name: String, val elementType: AccountElementType)

@Component
class CreateAccountMutation(private val accountCreateUseCase: AccountCreateUseCase) : Mutation {
    fun createAccount(input: CreateAccountInput): AccountType {
        val useCaseInput = AccountCreateUseCaseInput(
            code = input.code,
            name = input.name,
            elementType = input.elementType,
        )
        val output = accountCreateUseCase.call(useCaseInput)
        return AccountType(output.account)
    }
}
