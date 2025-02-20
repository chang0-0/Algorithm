import java.util.*
import java.io.*

// 1분에 한 번씩 두 집을 선택해서 두 집 앞의 눈을 각각 1만큼 치우거나, 한 집을 선택해서 그 집앞의 눈을 1만큼 치울 수 있다.
// 모든 집 앞의 눈을 전부 치울 때 까지 걸리는 최소 시간은?
// 24시간 1440분이 넘게 걸릴 경우 -1을 출력한다.

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현 부수기\\res\\a.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val arr = IntArray(N)

    st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()

        if (arr[i] > 1440) {
            println(-1)
            return
        }
    }

    println(Arrays.stream(arr).max().asInt)
} // End of main