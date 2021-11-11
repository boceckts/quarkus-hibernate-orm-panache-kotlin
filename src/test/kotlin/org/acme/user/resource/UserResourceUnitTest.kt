package org.acme.user.resource

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.acme.user.model.UserEntity
import org.acme.user.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@ExtendWith(MockKExtension::class)
internal class UserResourceUnitTest {

    @InjectMockKs
    lateinit var cut: UserResource

    @MockK
    lateinit var userRepository: UserRepository

    @ParameterizedTest(name = "test saying hello for user resource with {0} is successfully")
    @ValueSource(strings = ["default", "name1", "name2"])
    fun `test saying hello for property resource is successfully`(name: String) {
        every { userRepository.findByName("default") } returns UserEntity().apply { this.name = name }

        val response = cut.hello()

        Assertions.assertEquals("Hello User Resource $name", response)
    }
}