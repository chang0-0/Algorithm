package `수학 부수기`

import java.util.*
import java.io.*

/*
    각 테스트 정확히 100개의 tc로 이루어져 있다. 각 tc에 대해, 표본의 관측값 n개가 한 줄에 하나씩 주어진다. 표본의 각 관측값은 반올림하여 소수점아래 4번째 자리까지 주어진다.
    모든 tc는 위에서 서술한 방법 중 하나를 통해 만들어졌으며, n = 5000이다. n의 값이 입력으로 주어지지 않음에 유의하라


    어떤 방법으로 만들어졌는지 알아내시오.
    - 방법 A : 균등 분포 U(0, 1)에서 크기 n의 표본을 뽑는다.
    - 방법 B: 정규 분포 N(0.5, 0.1)$에서 관측값 하나를 뽑고, 이 값이 0 이상 1 이하이면 표본에 넣는다. 이를 표본의 크기가 n이 될 때까지 반복한다. 이때, 0.1은 이 분포의 분산이다

 */

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\수학 부수기\\res\\26523.txt"
    val br = BufferedReader(File(path).bufferedReader())

    for (i in 0 until 100) {
        var count = 0

        for (j in 0 until 5000) {
            var temp: Double = br.readLine().toDouble()

            if (temp in 0.25..0.75) {
                count++
            }
        }

        if(count >= 3000) {
            println("B")
        } else {
            println("A")
        }
    }

} // End of main