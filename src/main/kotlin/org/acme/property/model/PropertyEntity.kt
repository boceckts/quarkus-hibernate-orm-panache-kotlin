package org.acme.property.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import javax.persistence.Column
import javax.persistence.Entity


@Entity(name = "propertyentity")
class PropertyEntity : PanacheEntity() {

    @Column(name = "name")
    lateinit var name: String

}