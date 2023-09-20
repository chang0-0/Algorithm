package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*


// input
private lateinit var br: BufferedReader

// variables
private const val NOVA_COOL = 100
private const val ORIGIN_COOL = 360

private var N = 0
private var M = 0
private var max = 0

private lateinit var novas: IntArray
private lateinit var origins: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\b.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var cnt = 0
    var neverCnt = 0
    var idx = 0
    var endNovaTime = 0
    var endOriginTime = 0
    var lastNovaTime = 0
    var lastOriginTime = 0

    while (idx < max) {
        val nova = novas[idx]
        val origin = origins[idx]

        if (nova >= endNovaTime) {
            cnt++
            lastNovaTime = nova
            endNovaTime = lastNovaTime + NOVA_COOL
        }

        if (origin >= endOriginTime) {
            neverCnt++
            lastOriginTime = origin
            endOriginTime = lastOriginTime + ORIGIN_COOL
        }

        idx++
    }

    sb.append(cnt).append(' ').append(neverCnt)
    return sb.toString()
} // End of solve()


private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt() // 에르다 노바 사용 횟수
        M = nextToken().toInt() // 오리진 스킬 사용 횟수
    }

    max = Math.max(N, M)
    novas = IntArray(N + 1)
    origins = IntArray(N + 1)

    StringTokenizer(br.readLine()).run {
        repeat(N) { idx ->
            novas[idx] = nextToken().toInt()
        }
    }

    StringTokenizer(br.readLine()).run {
        repeat(M) { idx ->
            origins[idx] = nextToken().toInt()
        }
    }
    novas.sort()
    origins.sort()
} // End of input()
