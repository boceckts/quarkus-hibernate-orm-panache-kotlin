package org.acme.user.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "userentity")
class UserEntity : PanacheEntity() {

    @Column(name = "name")
    lateinit var name: String

}