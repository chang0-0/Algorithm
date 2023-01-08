package `대회 부수기`

/*

    후라이드 치킨, 간장치킨, 양념치킨을 각각 N마리씩 주문했고, 1인당 한 마리씩 배부하고자 한다.
    최대한 많은 부대원에게 본인이 선호하는 종류의 치킨을 배부해주기 위해 으뜸병사는 부대원들의 치킨 종류 선호도를 조사했고, 세 가지 치킨 중 후라이드 치킨, 간장치킨, 양념치킨을 가장 선호하는
    인원의 수는 각각 A명 B명 C명이라는 것을 알아냈다.

    본인이 가장 선호하는 종류의 치킨을 받을 수 있는 인원수의 최댓값읠 구하여라

    본인이 가장 선호하는 종류의 치킨을 받을 수 있는 최대 인원수를 출력한다.
 */

import java.util.*
import java.io.*

private var N = 0

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\대회 부수기\\res\\a.txt"
    val br = BufferedReader(File(path).bufferedReader())

    N = br.readLine().toInt() // 각 종류의 치킨 마릿 수

    var sum = 0
    val st = StringTokenizer(br.readLine())
    for (i in 0 until 3) {
        val temp = st.nextToken().toInt()

        if(N < temp) {
            sum += N
        } else if(N >= temp) {
            sum += temp
        }
    }

    println(sum)
} // End of main