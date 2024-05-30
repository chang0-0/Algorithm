package BOJ_31869

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*


// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private lateinit var seniorList: HashMap<String, Int>
private lateinit var arr: Array<Array<MutableList<People>>>

private data class People(var name: String, var value: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_31869\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var ans = 0
    var count = 0
    for (i in 1 until 11) {
        for (j in 0 until 7) {
            val promises = arr[i][j]
            var flag = false

            for (promise in promises) {
                if (seniorList[promise.name]!! >= promise.value) {
                    seniorList[promise.name] = seniorList[promise.name]!! - promise.value
                    flag = true
                    break
                }
            }

            if (flag) {
                count++
            } else {
                ans = ans.coerceAtLeast(count)
                count = 0
            }
        }
    }

    ans = ans.coerceAtLeast(count)
    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
    seniorList = HashMap()
    arr = Array(11) { Array(7) { ArrayList() } }

    var st: StringTokenizer
    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        val s = st.nextToken()
        val w = st.nextToken().toInt()
        val d = st.nextToken().toInt()
        val p = st.nextToken().toInt()

        arr[w][d].add(People(s, p))
    }


    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        val name = st.nextToken()
        val money = st.nextToken().toInt()
        seniorList[name] = money
    }
} // End of input()
