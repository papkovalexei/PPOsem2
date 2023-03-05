package ru.quipy.user.api


import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.*

const val USER_CREATED = "USER_CREATED_EVENT"
const val USER_CREATED_CART = "USER_CREATED_CART"

@DomainEvent(name = USER_CREATED)
data class UserCreatedEvent(
    val userId: UUID,
) : Event<UserAggregate>(
    name = USER_CREATED,
)

@DomainEvent(name = USER_CREATED_CART)
data class UserCreatedCartEvent(
    val cartId: UUID
) : Event<UserAggregate>(
    name = USER_CREATED_CART,
)
