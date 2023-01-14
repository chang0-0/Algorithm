package `대회 부수기`

import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\대회 부수기\\res\\a.txt"
    val br = BufferedReader(File(path).bufferedReader())

    val N = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    var firstVal = st.nextToken().toInt()
    var min = firstVal
    var sum = 0
    for (i in 1 until N) {
        val temp = st.nextToken().toInt()

        if (temp - firstVal > 1) {
            sum += min
            min = temp
        }

        firstVal = temp
    }
    sum += min

    println(sum)
} // End of main