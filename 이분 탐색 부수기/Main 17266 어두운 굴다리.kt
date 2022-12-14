import java.util.*
import java.io.*

private var N = 0
private var M = 0
private var streetlampArr = IntArray(100_001)

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\이분 탐색 부수기\\res\\17266.txt"
    val br = BufferedReader(File(path).bufferedReader())

    N = br.readLine().toInt()
    M = br.readLine().toInt()

    val min = streetlampArr[0]
    val max = streetlampArr[0] + N

    var st = StringTokenizer(br.readLine())
    for (i in 0 until M) {
        streetlampArr[i] = st.nextToken().toInt()
    }

    println(binarySearch(min, max))
} // End of main

private fun binarySearch(start: Int, end: Int): Int {

    if (start > end) {
        return -1
    }

    var mid = (start + end) / 2
    var _end = end
    var _start = start

    if (check((mid))) {
        _end = mid - 1
        var temp = binarySearch(_start, _end)

        if (temp == -1) {
            return mid
        } else {
            return temp
        }
    } else {
        _start = mid + 1
        return binarySearch(_start, _end)
    }

} // End of binarySearch

private fun check(height: Int): Boolean {
    var prev = 0

    for (i in 0 until M) {
        if (streetlampArr[i] - height <= prev) {
            prev = streetlampArr[i] + height
        } else {
            return false
        }
    }

    return N - prev <= 0
} // End of check