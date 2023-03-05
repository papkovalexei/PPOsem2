package ru.quipy.cart.api

import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.*

const val CREATE_NEW_CART = "CREATE_NEW_CART"

@DomainEvent(name = CREATE_NEW_CART)
data class CartCreatedEvent(
    val cartId: UUID,
) : Event<CartAggregate>(
    name = CREATE_NEW_CART,
)