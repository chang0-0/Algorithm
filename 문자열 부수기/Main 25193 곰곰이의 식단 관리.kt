import java.io.*;
import kotlin.math.ceil

// ⭐문제 :  곰곰이가 연속으로 치킨을 먹는 날의 최댓값의 최솟값을 구하라
// "CCCCA" 의 경우 연속된 C의 값을 최소화 시킬 수 있는 방법은 "CCACC" 처럼 A로 나누는 방법이 있다.

/*
"CCCCCAB"와 같은 경우에는 C를 그 이외의 음식으로 잘게 나누어야 한다.

C의 개수를 C가 아닌 것들의 개수로 나누면 될 것임을 알 수 있다.
C가 아닌 것을 A라고 한다면 다음과 같은 식을 계산하면 된다.

+ 1을 하는 이유는 벽을 하나 세우면 공간이 2개가 되기 때문이다.
올림을 하는 이유는 5 / 2는 2.5인데 int를 답으로 할 때는 소수점을 올리기 때문에 올림을 해줘야 한다.

이 때 항상 코드를 짤 때는 오차의 위험을 막기 위해 어쩔 수 없는 경우를 제외하고는 double을 사용하지 않는게 더 좋다.
따라서 올림 처리는 'C%(A+1)'가 0이 아니라면 +1을 해주는 것으로 대신할 수 있다.
 */

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\문자열 부수기\\res\\25193.txt"
    val br = BufferedReader(File(path).bufferedReader())

    val N = br.readLine().toInt()
    val str = br.readLine()
    val len = str.length

    var count = 0
    for (i in 0 until len) {
        if (str[i] != 'C') {
            count++
        }
    }

    var result = (N - count) / (count + 1)
    if ((N - count) % (count + 1) != 0) {
        result++
    }
    println(result)
} // End of main