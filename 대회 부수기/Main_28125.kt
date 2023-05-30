package 문자열_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

fun main() {
    val path = "C:\\Users\\multicampus\\Desktop\\코틀린 알고리즘\\Kotlin_Algo\\src\\main\\kotlin\\문자열_부수기\\res\\28125.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    val N = br.readLine().toInt()
    for (i in 0 until N) {
        val chArr = br.readLine().toCharArray()

        var passordCount = 0
        var slashCount = 0

        val tempString = StringBuilder()
        chArr.forEach { ch ->

            if (ch == '@') {
                passordCount++;
                tempString.append('a');
            } else if (ch == '[') {
                passordCount++;
                tempString.append('c');
            } else if (ch == '!') {
                passordCount++;
                tempString.append('i');
            } else if (ch == ';') {
                passordCount++;
                tempString.append('j');
            } else if (ch == '^') {
                passordCount++;
                tempString.append('n');
            } else if (ch == '0') {
                passordCount++;
                tempString.append('o');
            } else if (ch == '7') {
                passordCount++;
                tempString.append('t');
            } else if (ch == '\\') {
                slashCount++;
            } else if (slashCount == 1 && ch == '\'') {
                slashCount = 0;
                passordCount++;
                tempString.append('v');
            } else if (slashCount == 1 && ch == '\\') {
                slashCount++;
            } else if (slashCount == 2 && ch == '\'') {
                slashCount = 0;
                passordCount++;
                tempString.append('w');
            } else {
                // 암호가 아닌 경우
                tempString.append(ch);
            }
        }

        var tempLen = tempString.length
        if (tempLen % 2 == 1) {
            tempLen++
        }

        if (tempLen / 2 <= passordCount) {
            sb.append("I don't understand").append('\n');
        } else {
            sb.append(tempString).append('\n');
        }
    }

    bw.write(sb.toString())
    bw.close()
} // End of main
