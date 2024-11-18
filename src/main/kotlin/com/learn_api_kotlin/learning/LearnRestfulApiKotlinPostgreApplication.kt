package com.learn_api_kotlin.learning

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LearnRestfulApiKotlinPostgreApplication

fun main(args: Array<String>) {
	runApplication<LearnRestfulApiKotlinPostgreApplication>(*args)
}
