package `대회 부수기`

import java.util.*
import java.io.*


fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\대회 부수기\\res\\a.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    val N = br.readLine().toInt()
    val list = LinkedList<Int>()

    val st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        list.add(st.nextToken().toInt())
    }

    // 3번째로 작은 수를 가장 앞에 배치
    // 가장 큰수를 가장 뒤에 배치
    // 가장 작은 수를 N - 2 위치에 배치
    // 나머지는 오름차순으로 배치

    // 1, 2, 3, 4, 5, 6
    list.sort()

    val tempArr = IntArray(N)
    tempArr[0] = list.removeAt(N - 3)
    tempArr[N - 1] = list.removeAt((N - 1) - 1) // 가장 큰 수를 가장 뒤에 배치
    tempArr[N - 2] = list.removeAt(0) // 가장 작은 수를 N - 2위치에 배치

    for (i in 1 until N - 2) {
        tempArr[i] = list.pop()
    }

    var sum = tempArr[0]
    for (i in 1 until N) {
        val max = Math.max(0, tempArr[i] - tempArr[i - 1])
        sum += max
    }

    sb.append(sum)
    bw.write(sb.toString())
    bw.close()
} // End of main
