package ru.quipy.cart.logic

import ru.quipy.cart.api.CartAggregate
import ru.quipy.cart.api.CartCreatedEvent
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import ru.quipy.user.api.UserCreatedEvent
import java.util.*

class Cart : AggregateState<UUID, CartAggregate> {
    private lateinit var cartId: UUID

    override fun getId() = cartId

    fun createNewCart(id: UUID = UUID.randomUUID()) : CartCreatedEvent {
        return CartCreatedEvent(id)
    }

    @StateTransitionFunc
    fun createNewCart(event: CartCreatedEvent) {
        cartId = event.cartId
    }
}