package org.acme.property.resource

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.acme.property.model.PropertyEntity
import org.acme.property.repository.PropertyRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource

@ExtendWith(MockKExtension::class)
internal class PropertyResourceIntTest {

    @InjectMockKs
    lateinit var cut: PropertyResource

    @MockK
    lateinit var propertyRepository: PropertyRepository

    @ParameterizedTest(name = "test saying hello for property resource with {0} is successfully")
    @ValueSource(strings = ["default", "name1", "name2"])
    fun `test saying hello for property resource is successfully`(name: String) {
        every { propertyRepository.findByName("default") } returns PropertyEntity().apply { this.name = name }

        val response = cut.hello()

        Assertions.assertEquals("Hello Property Resource $name", response)
    }
}