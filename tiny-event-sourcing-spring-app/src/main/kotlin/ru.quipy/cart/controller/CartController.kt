package ru.quipy.cart.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.quipy.cart.api.CartAggregate
import ru.quipy.cart.logic.Cart
import ru.quipy.core.EventSourcingService
import ru.quipy.user.JWTUtil.UserSecurity
import ru.quipy.user.api.UserAggregate
import ru.quipy.user.logic.User
import ru.quipy.user.service.UserRepository
import java.util.*

@RestController
@RequestMapping("/users")
class CartController (
    val userEsService: EventSourcingService<UUID, UserAggregate, User>,
    val cartEsService: EventSourcingService<UUID, CartAggregate, Cart>,
    val usersRepository: UserRepository,
) {

    @PostMapping("/check")
    fun createUser(): User? {
        val userLoggedId = (SecurityContextHolder.getContext().authentication.principal as UserSecurity).id
        val userLogged = usersRepository.findOneByEmail(userLoggedId)
        userEsService.update(userLogged.aggregateId, {it.createNewCart(cartEsService.create { it.createNewCart() }.cartId)})
        return userEsService.getState(userLogged.aggregateId)
    }
}