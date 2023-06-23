package 오일러_경로_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    오일러 회로 경로를 출력하는 것이다.
    인접행렬의 값은 두 정점 사이의 간선 개수를 의미하며, 0보다 크거나 같고, 10보다 작거나 같은 정수이다.

    어느 점에서 출발하여 그래프 상에 있는 모든 간선을 지나되 한번 지난 간선은 다시 지나지 않고 출발점에 돌아오는 회로를 오일러 회로라고 한다.
    그래프는 양방향 그래프가 주어진다.
    오일러회로의 경로를 출력하라.
 */

// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables
private var N = 0
private lateinit var adjList: MutableList<MutableList<Node>>

private data class Node(var num: Int, var cnt: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\오일러_경로_부수기\\1199.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    sb = StringBuilder()

    if (!input()) {
        sb.append(-1)
        bw.write(sb.toString())
        bw.close()
        return
    }

    euler(1)

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun euler(node: Int) {

    var idx = 0
    while (adjList[node].isNotEmpty()) {
        val nextNode = adjList[node][idx].num

        var idx2 = 0
        while (adjList[nextNode].isNotEmpty()) {
            if (adjList[nextNode][idx2].num == node) {
                adjList[nextNode][idx2].cnt--
                if (adjList[nextNode][idx2].cnt == 0) {
                    adjList[nextNode].removeAt(idx2)
                }
                break
            }
            idx2++
        }

        adjList[node][idx].cnt--
        if (adjList[node][idx].cnt == 0) {
            adjList[node].removeAt(idx--)
        }

        euler(nextNode)
        idx++
    }

    sb.append(node).append(' ')
} // End of DFS

private fun input(): Boolean {
    N = br.readLine().toInt()

    adjList = ArrayList()
    repeat(N + 1) {
        adjList.add(ArrayList())
    }

    for (i in 1..N) {
        val st = StringTokenizer(br.readLine())
        var sum = 0
        for (j in 1..N) {
            val temp = st.nextToken().toInt()

            if (i < j && temp > 0) {
                adjList[i].add(Node(j, temp))
                adjList[j].add(Node(i, temp))
            }
            sum += temp
        }

        // 그래프의 한 노드에서 차수가 하나라도 홀수 일 경우 오일러회로가 불가능하다.
        // 모든 정점의 차수가 짝수가 되어야 함 하나라도 짝수가 되지 않으면 오일러 회로가 불가능하다.
        // 두개 이상의 컴포넌트로 분리가 되면 안된다.
        if (sum % 2 != 0) {
            return false
        }
    }

    return true
} // End of input
