package BOJ_20920

import java.io.*
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/20920
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private lateinit var hashMap: HashMap<String, Int>

private data class Word(var count: Int = 0, var len: Int = 0, var word: String = "") : Comparable<Word> {

    override fun compareTo(o: Word): Int {
        val countDiff = o.count - count

        if (countDiff == 0) {
            val lendDiff = o.len - len
            if (lendDiff == 0) {
                return word.compareTo(o.word)
            }
            return lendDiff
        }

        return countDiff
    }
} // End of Word class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_20920\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var size = hashMap.size
    val words = Array<Word>(size) {
        Word()
    }

    var idx = 0
    hashMap.forEach {
        words[idx++] = Word(it.value, it.key.length, it.key)
    }

    words.sort()
    words.forEach {
        sb.append(it.word).append('\n')
    }

    return sb.toString()
} // End of solve()

private fun input() {
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    hashMap = HashMap()

    repeat(N) {
        val temp = br.readLine()
        if (temp.length >= M) {
            hashMap[temp] = hashMap.getOrDefault(temp, 0) + 1
        }
    }
} // End of input()
