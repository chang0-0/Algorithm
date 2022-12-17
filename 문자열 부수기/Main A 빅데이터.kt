import java.io.*

/*
문자열은 bigdata 또는 security로만 구성되어 있으며, 띄어쓰기 등의 다른 문자가 포함되어 있지 않다
 */

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\문자열 부수기\\res\\a.txt"
    val br = BufferedReader(File(path).bufferedReader())

    val N = br.readLine().toInt()
    val temp = br.readLine()

    var securityCount = 0
    var size = 0

    temp.split("security").forEach {
        if (it == "") {
            securityCount++
        }
        size++
    }

    securityCount = size - 1
    val bigdataCount = N - securityCount

    println(if (bigdataCount < securityCount) "security!" else if (bigdataCount > securityCount) "bigdata?" else "bigdata? security!")
} // End of main