package BOJ_29810

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    사일클일 경우 배신자를 쫓아내고 친구가된다.
    사이클이 아닐 경우 배신자가 있는 무리에서 배신자를 중심으로 파가 갈린다.
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0
private var X = 0
private var ans = 1
private lateinit var isVisited: BooleanArray

private lateinit var adjList: MutableList<MutableList<Int>>
private lateinit var friends: MutableList<Int>

private data class Friend(var num: Int, var know: Boolean)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_29810\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    /*
        배신자가 포함된 무리가 사이클이면 사이클에 연결된 애들은 전부 배신자를 안다고 처리해서
        배신자가 무리에서 제외된다.
     */
    println(adjList)
    for (i in 1..N) {
        if (isVisited[i]) continue
        DFS(i, i, 0, 0)
    }

    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun DFS(startNode: Int, node: Int, know: Int, cnt: Int) {
    println("DFS($startNode, $node, $know, $cnt)")
    isVisited[node] = true

    // 사이클
    if (cnt > 1 && node == startNode) {
        // 배신자가 무리에 포함됨
        if (know > 0 && startNode == X) {
            ans = ans.coerceAtLeast(know)
        } else {
            ans = ans.coerceAtLeast(cnt)
        }
        return
    }

    // 끝.
    if (adjList[node].isEmpty()) {
        if (cnt > 0) {
            // 배신자가 포함되고 친구관계가 마지막인 경우
            ans = ans.coerceAtLeast(cnt - know)
        } else {
            // 배신자가 포함되지 않고 무리가 끝난 경우
            ans = ans.coerceAtLeast(cnt)
        }
        return
    }

    for (nextNode in adjList[node]) {
        println("nextNode : $nextNode")

        // 배신자가 처음 발견됨.
        if (nextNode == X && know == 0) {
            DFS(startNode, nextNode, cnt + 1, 1)
        } else if (know != 0) {
            // 무리에 배신자 있음
            DFS(startNode, nextNode, know, cnt + 1)
        } else {
            // 무리에 배신자 없음
            DFS(startNode, nextNode, know, cnt + 1)
        }
    }
} // End of DFS

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt() // 동기의 수
        M = nextToken().toInt() // 친구 관계 정보의 수
    }

    adjList = ArrayList()
    repeat(N + 1) {
        adjList.add(ArrayList())
    }
    isVisited = BooleanArray(N + 1)
    friends = ArrayList()

    repeat(M) {
        StringTokenizer(br.readLine()).run {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            adjList[a].add(b)
        }
    }
    X = br.readLine().toInt()
} // End of input()
