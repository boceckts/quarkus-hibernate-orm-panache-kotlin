package org.acme.property.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.acme.user.model.UserEntity
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PropertyRepository: PanacheRepository<UserEntity>{

    fun findByName(name: String) = find("name", name).firstResult()

}