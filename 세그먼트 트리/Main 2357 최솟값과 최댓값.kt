package BOJ_2357

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0

private val arr = IntArray(100_001)

private lateinit var minTree: IntArray
private lateinit var maxTree: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2357\\res\\2357.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()

    makeTree(minTree, 1, 1, N, "min")
    makeTree(maxTree, 1, 1, N, "max")


    while (M-- > 0) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        sb.append(findVal(minTree, 1, 1, N, a, b, "min")).append(' ').append(findVal(maxTree, 1, 1, N, a, b, "max"))
            .append('\n')
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun makeTree(tree: IntArray, node: Int, start: Int, end: Int, mode: String): Int {
    if (start == end) return arr[start]

    val mid = (start + end) / 2
    val left = makeTree(tree, node * 2, start, mid, mode)
    val right = makeTree(tree, node * 2 + 1, mid + 1, end, mode)

    if (mode == "min") {
        tree[node] = Math.min(left, right)
    } else {
        tree[node] = Math.max(left, right)
    }

    return tree[node]
} // End of makeTree

private fun findVal(tree: IntArray, node: Int, start: Int, end: Int, left: Int, right: Int, mode: String): Int {
    if (end < left || start > right) {
        if (mode == "min") {
            return Int.MAX_VALUE
        } else {
            return 0
        }
    }

    if (left <= start && end <= right) return tree[node]

    val mid = (start + end) / 2
    val leftVal = findVal(tree, node * 2, start, mid, left, right, mode)
    val rightVal = findVal(tree, node * 2 + 1, mid + 1, end, left, right, mode)

    if (mode == "min") {
        return Math.min(leftVal, rightVal)
    } else {
        return Math.max(leftVal, rightVal)
    }
} // End of findVal

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    for (i in 1..N) {
        arr[i] = br.readLine().toInt()
    }

    minTree = IntArray(N * 4)
    maxTree = IntArray(N * 4)
} // End of input
