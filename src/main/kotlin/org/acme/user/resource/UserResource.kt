package org.acme.user.resource

import org.acme.user.repository.UserRepository
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/user")
class UserResource(
        private val userRepository: UserRepository
) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello User Resource ${userRepository.findByName("default")}"
}