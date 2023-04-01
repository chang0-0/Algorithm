package `정수론 & 조합론 부수기`

import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\중국인의 나머지 정리 부수기\\res\\J.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var N = br.readLine().toInt()
    var arr = IntArray(N-2)

    var st = StringTokenizer(br.readLine())
    for(i in 0 until N-2) { arr[i] = st.nextToken().toInt() }

    var num = arr[0]
    var result = 0
    var LCD = 0

    for(i in 1 until N-2) {
        num = arr[i-1]
        var num2 = arr[i]
        var GCD = gcd(num, num2)
        LCD = (num * num2) / GCD
    }

    println(LCD)
} // End of main

private fun gcd(num : Int, num2 : Int) : Int {
    if(num2 == 0) return num
    else return gcd(num2, num % num2)
} // End of gcd