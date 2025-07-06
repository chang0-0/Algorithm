import java.io.*
import java.util.PriorityQueue

// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private lateinit var arr: Array<String>

private data class Number(val alp: Char, val rank: Double) : Comparable<Number> {
    override fun compareTo(o: Number): Int {
        return o.rank.compareTo(rank)
    }
} // End of Number class

fun main() {
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var hashMap = HashMap<Char, Double>()
    // 알파벳 기준 가장 높은 자리 수를 기준으로 하기
    // 자리 위치에 따른, 값 선택

    for (i in 0 until N) {
        val str = br.readLine()
        arr[i] = str
        val chArr = str.toCharArray()
        val len = chArr.size

        for (j in 0 until len) {
            if (!hashMap.contains(chArr[j])) {
                hashMap.put(chArr[j], Math.pow(10.0.toDouble(), (len - j).toDouble()))
            } else {
                val rank = hashMap[chArr[j]]!!
                hashMap[chArr[j]] = rank + Math.pow(10.0.toDouble(), (len - j).toDouble())
            }
        }
    }

    val pque = PriorityQueue<Number>()
    hashMap.forEach { k, v ->
        pque.offer(Number(k, v))
    }

    var num = 9
    val hashMap2 = HashMap<Char, Int>()
    while (pque.isNotEmpty()) {
        val cur = pque.poll()
        hashMap2[cur.alp] = num--
    }


    val retArr = IntArray(N)
    for (i in 0 until N) {
        val temp = arr[i]
        val len = temp.length

        val sb2 = StringBuilder()
        for (j in 0 until len) {
            sb2.append(hashMap2[temp[j]])
        }
        retArr[i] = sb2.toString().toInt()
    }

    var ans = 0
    retArr.forEach {
        ans += it
    }

    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
    arr = Array(N) { "" }
} // End of input()
