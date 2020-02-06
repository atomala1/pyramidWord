package com.alextomala.pyramidWord.service

import org.springframework.stereotype.Service
import java.util.stream.IntStream.range

@Service
class PyramidWordService {

    fun isPyramidWord(word: String): Boolean {
        validateWord(word)

        val charArray = word.toLowerCase().toCharArray().toList()

        val countOfLetters = charArray
                .groupingBy { it }
                .eachCount()
                .values
                .sorted()
                .toList()

        return if (countOfLetters != countOfLetters.distinct()) {
            false
        } else {
            range(countOfLetters.first(), countOfLetters.last())
                    .allMatch { countOfLetters.contains(it) }
        }
    }

    fun validateWord(word: String) {
        if (!"[a-zA-Z]+".toRegex().matches(word)) {
            throw IllegalArgumentException("Word must only contain letters [a-zA-Z]+")
        }
    }
}