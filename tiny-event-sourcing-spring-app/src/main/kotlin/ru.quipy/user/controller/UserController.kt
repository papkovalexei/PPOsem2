package ru.quipy.user.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*
import ru.quipy.core.EventSourcingService
import ru.quipy.user.JWTUtil.UserSecurity
import ru.quipy.user.api.UserAggregate
import ru.quipy.user.api.UserRegisterDTO
import ru.quipy.user.logic.User
import ru.quipy.user.service.UserMongo
import ru.quipy.user.service.UserRepository
import java.util.*

@RestController
@RequestMapping("/users")
class UserController (
    val userEsService: EventSourcingService<UUID, UserAggregate, User>,
    val usersRepository: UserRepository,
    val passwordEncoder: BCryptPasswordEncoder
) {
    @PostMapping("/check")
    fun createUser(): Any {
        val userLoggedId = (SecurityContextHolder.getContext().authentication.principal as UserSecurity).id
        val userLogged = usersRepository.findOneByEmail(userLoggedId)
        return userLogged
    }
}