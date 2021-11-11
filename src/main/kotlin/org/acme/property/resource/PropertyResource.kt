package org.acme.property.resource

import org.acme.property.repository.PropertyRepository
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/property")
class PropertyResource(
        private val propertyRepository: PropertyRepository
) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello Property Resource ${propertyRepository.findByName("default")?.name}"
}