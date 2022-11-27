import java.io.*;

private var result = 0
private lateinit var pi: Array<Int>
private var origin: String = ""
private var pattern: String = ""

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\문자열 부수기\\res\\16916.txt"
    val br = BufferedReader(File(path).bufferedReader())

    origin = br.readLine()
    pattern = br.readLine()
    pi = Array(pattern.length) { 0 }

    getPi()
    KMP()
    println(result)
} // End of main

private fun getPi() {
    var index = 0
    for (i in 1 until pi.size) {
        while (index > 0 && pattern[i] != pattern[index]) {
            index = pi[index - 1]
        }

        if (pattern[i] == pattern[index]) {
            index += 1
            pi[i] = index
        }
    }
} // End of getPi

private fun KMP() {
    var originLength = origin.length
    var patternLength = pattern.length

    var index = 0
    for (i in 0 until originLength) {
        while (index > 0 && origin[i] != pattern[index]) {
            index = pi[index - 1]
        }

        if (origin[i] == pattern[index]) {
            if (index == patternLength - 1) {
                result = 1
                return
            } else {
                index++
            }
        }
    }

    result = 0
} // End of KMP