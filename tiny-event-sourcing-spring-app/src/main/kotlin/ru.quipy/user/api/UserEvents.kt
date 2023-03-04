package ru.quipy.user.api


import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.*

const val USER_CREATED = "USER_CREATED_EVENT"

@DomainEvent(name = USER_CREATED)
data class UserCreatedEvent(
    val userId: UUID,
) : Event<UserAggregate>(
    name = USER_CREATED,
)