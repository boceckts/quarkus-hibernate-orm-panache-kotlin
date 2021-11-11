package org.acme.property.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.acme.property.model.PropertyEntity
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PropertyRepository: PanacheRepository<PropertyEntity>{

    fun findByName(name: String) = find("name", name).firstResult()

}