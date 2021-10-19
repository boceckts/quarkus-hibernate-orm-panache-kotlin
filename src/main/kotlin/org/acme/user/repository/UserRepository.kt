package org.acme.user.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.acme.user.model.UserEntity
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository: PanacheRepository<UserEntity>{

    fun findByName(name: String) = find("name", name).firstResult()

}