package com.alextomala.pyramidWord.controller

import com.alextomala.pyramidWord.service.PyramidWordService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/pyramid")
class PyramidWordController(val pyramidWordService: PyramidWordService) {

    @GetMapping
    fun testWord(@PathParam("word") word: String): Boolean {
        println("Word is: $word")
        return pyramidWordService.isPyramidWord(word);
    }
}
