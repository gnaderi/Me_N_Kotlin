package com.naderi.ghodrat.me_n_koltin.practice

class MyPlayground

fun main(args: Array<String>) {
    println("Convert this to camelcase".spaceToCamelCase())
}

private fun String.spaceToCamelCase(): String {
    val chars = this.toCharArray()
    val sb = StringBuffer()
    var start = false
    for (i in chars.indices) {
        if (chars[i] == ' ') {
            start = true
        } else if (start) {
            sb.append(chars[i].uppercaseChar())
            start = false
        } else {
            sb.append(chars[i])
        }
    }
    return sb.toString()
}