package com.alextomala.pyramidWord.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.mock.mockito.MockBean

@ExtendWith(MockitoExtension::class)
class PyramidWordServiceTest {

    @MockBean
    val service: PyramidWordService = PyramidWordService()

    @Test
    fun `Pyramid Word`() {
        assertTrue(service.isPyramidWord("banana"))
    }

    @Test
    fun `Pyramid Word - Out Of Order`() {
        assertTrue(service.isPyramidWord("cccabbdddd"))
    }

    @Test
    fun `Pyramid Word - Single Letter`() {
        assertTrue(service.isPyramidWord("a"))
    }

    @Test
    fun `Non-pyramid Word`() {
        assertFalse(service.isPyramidWord("bandana"))
    }

    @Test
    fun `Non-pyramid - Gap`() {
        assertFalse(service.isPyramidWord("abbcccc"))
    }

    @Test
    fun `Invalid String Passed In`() {
        assertThrows(IllegalArgumentException::class.java) {
            service.isPyramidWord("1234")
        }
    }

    @Test
    fun `Empty String Passed In`() {
        assertThrows(IllegalArgumentException::class.java) {
            service.isPyramidWord("")
        }
    }
}