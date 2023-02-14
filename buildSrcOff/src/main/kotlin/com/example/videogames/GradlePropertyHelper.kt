package com.example.videogames

import org.gradle.api.Project
import org.gradle.api.invocation.Gradle
import org.gradle.kotlin.dsl.extra
import java.io.FileInputStream
import java.io.File
import java.io.FileNotFoundException
import java.util.Properties

object GradlePropertyHelper {

    fun loadProperties(propsFile: File, mustExist: Boolean = true): Properties {
        val props = Properties()
        if(propsFile.exists()) {
            FileInputStream(propsFile).use { props.load(it) }
        } else if (mustExist) {
            throw FileNotFoundException("Properties file ${propsFile.absolutePath} does not exist")
        }
        return props
    }

    fun addPropertiesToProject(props: Properties, project: Project) {
        val replacements: Map<String, String> = mapOf(
            Pair("rootDir", project.rootDir.absolutePath),
        )
        props.forEach { (key: Any, value: Any) ->
            if(key is String && value is String && !isCliParameter(key, project.gradle)) {
                val replacedValue = replacePlaceholders(value, replacements)
                project.extra.set(key, replacedValue)
            }
        }
    }

    private fun isCliParameter(key: String, gradle: Gradle): Boolean {
        return gradle.startParameter.projectProperties.containsKey(key)
    }

    private fun replacePlaceholders(value: String, replacements: Map<String, String>): String {
        var replacedValue = value
        replacements.forEach { (key, replacement) ->
            replacedValue = replacedValue.replace("\${$key}", replacement)
        }
        return replacedValue
    }
}