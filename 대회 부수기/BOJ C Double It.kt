package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter


// input
private lateinit var br: BufferedReader

// variables
private const val fizz = "Fizz"
private const val buzz = "Buzz"
private const val fizzBuzz = "FizzBuzz"

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\c.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var first = br.readLine()
    var second = br.readLine()
    var third = br.readLine()
    var idx = 0
    var number = 0

    // 숫자인 친구를 찾아보자
    if (first[0] == 'B' || first[0] == 'F') {
        if (second[0] == 'B' || second[0] == 'F') {
            number = third.toInt()
            idx = 2
        } else {
            number = second.toInt()
            idx = 1
        }
    } else {
        number = first.toInt()
        idx = 0
    }

    for (i in idx until 3) {
        number++
    }

    var ans = ""
    if (number % 15 == 0) {
        ans = fizzBuzz
    } else if (number % 3 == 0) {
        ans = fizz
    } else if (number % 5 == 0) {
        ans = buzz
    } else {
        ans = number.toString()
    }

    sb.append(ans)
    return sb.toString()
} // End of solve()
