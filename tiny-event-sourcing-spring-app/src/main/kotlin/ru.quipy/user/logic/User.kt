package ru.quipy.user.logic

import ru.quipy.bankDemo.transfers.logic.TransferTransaction
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import ru.quipy.user.api.UserAggregate
import ru.quipy.user.api.UserCreatedCartEvent
import ru.quipy.user.api.UserCreatedEvent
import java.math.BigDecimal
import java.util.*

class User : AggregateState<UUID, UserAggregate> {
    private lateinit var userId: UUID
    private lateinit var cartId: UUID

    override fun getId() = userId

    fun createNewUser(id: UUID = UUID.randomUUID()) : UserCreatedEvent {
        return UserCreatedEvent(id)
    }

    fun createNewCart(id: UUID): UserCreatedCartEvent {
        return UserCreatedCartEvent(id)
    }

    @StateTransitionFunc
    fun createNewUser(event: UserCreatedEvent) {
        userId = event.userId
    }

    @StateTransitionFunc
    fun createNewCart(event: UserCreatedCartEvent) {
        cartId = event.cartId
    }
}