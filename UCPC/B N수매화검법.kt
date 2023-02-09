import java.util.*
import java.io.*

private lateinit var arr : Array<LongArray>
private lateinit var visit : BooleanArray
private lateinit var ans : IntArray
private var N = 0; private var max = Long.MAX_VALUE

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\UCPC\\res\\N수매화검법.txt"
    val br = BufferedReader(File(path).bufferedReader())
    N = br.readLine().toInt()
    arr = Array(N){LongArray(5)}
    visit = BooleanArray(N)
    ans = IntArray(N)

    for(i in 0 until N) {
        var st = StringTokenizer(br.readLine())
        for(j in 0 until 5) {
            arr[i][j] = st.nextToken().toLong()
        }
    }
    // 겹치는게 있는지 여부 파악 -> 처음 베기의 범위의 좌표에 속할 경우

} // End of main

fun solution(depth : Int) {
    if(depth == N) {
        var sum = 0L
        ans.forEach { sum += it }
        max = Math.min(max, sum);
    }

    for(i in 0 until N) {
        if(visit[i]) continue
        visit[i] = true

        calc(arr[i][0], arr[i][1], arr[i][2], arr[i][3])
        var weight = 1

        ans[depth] = weight
        solution(depth + 1)
        visit[i] = false
    }

} // End of solution

private fun calc(x1 : Long, y1 : Long, x2 : Long, y2 : Long) {


} // End of clac
