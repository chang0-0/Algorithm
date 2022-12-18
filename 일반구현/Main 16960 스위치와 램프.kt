import java.util.*
import java.io.*

/*
    상도는 N개의 스위치와 M개의 램프를 갖고 있다
    가장 처음에 램프는 모두 꺼져 있다.

    두 스위치가 연결되어 있는 경우에 한 스위치를 누르거나 두 스위치를 모두 누르면 램프는 켜져 있는 상태가 된다

    N개의 스위치를 모두 누르면 모든 램프가 꺼진다. N - 1개의 스위치를 눌러도 모든 램프가 켜지는지 궁금하다

    N - 1개의 스위치를 눌러서 모든 램프를 켤 수 있으면, 1을 없으면 0을 출력한다.

 */

private var N = 0
private var M = 0
private val lamps = IntArray(2001)

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현 부수기\\res\\16960.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt() // 스위치의 수
    M = st.nextToken().toInt() // 램프의 수

    st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        // 스위치에 대한 정보
        val temp = st.nextToken().toInt()

        for(j in 0 until temp) {

        }
    }


} // End of main