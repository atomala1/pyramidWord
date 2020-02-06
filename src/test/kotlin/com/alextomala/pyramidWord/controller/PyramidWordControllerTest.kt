package com.alextomala.pyramidWord.controller

import com.alextomala.pyramidWord.service.PyramidWordService
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content


@ExtendWith(SpringExtension::class)
@WebMvcTest(controllers = [PyramidWordController::class])
class PyramidWordControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var service: PyramidWordService

    @Test
    fun `Parameter is missing`() {
        mockMvc.get("/pyramid")
                .andExpect { status().isBadRequest }
                .andExpect { jsonPath("$.message", `is`("Parameter specified as non-null is null: method com.alextomala.pyramidWord.controller.PyramidWordController.testWord, parameter word")) }
    }

    @Test
    fun `Service Returns True`() {
        `when`(service.isPyramidWord("word"))
                .thenReturn(true)

        mockMvc.get("/pyramid?test=word")
                .andExpect { status().isOk }
                .andExpect { content().string("true") }
    }

    @Test
    fun `Service Returns False`() {
        `when`(service.isPyramidWord("word"))
                .thenReturn(false)

        mockMvc.get("/pyramid?test=word")
                .andExpect { status().isOk }
                .andExpect { content().string("false") }
    }
}