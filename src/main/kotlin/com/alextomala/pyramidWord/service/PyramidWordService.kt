package com.alextomala.pyramidWord.service

import org.springframework.stereotype.Service

@Service
class PyramidWordService {

    fun isPyramidWord(word: String): Boolean {
        validateWord(word)

        val charArray = word.toLowerCase().toCharArray().toList()

        // Get a sequence of frequency of letters, like [1, 2, 3]
        val countOfLetters = charArray
                .groupingBy { it }
                .eachCount()
                .values
                .sorted()
                .toList()

        // See if there are any duplicates.
        return if (countOfLetters != countOfLetters.distinct()) {
            false
        } else {
            // If there are no duplicates, find out if there are any gaps.
            (countOfLetters.last() - countOfLetters.first() + 1) == countOfLetters.size
        }
    }

    fun validateWord(word: String) {
        if (!"[a-zA-Z]+".toRegex().matches(word)) {
            throw IllegalArgumentException("Word must only contain letters [a-zA-Z]+")
        }
    }
}