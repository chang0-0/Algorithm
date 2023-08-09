package PRG_92344

// variables
private var N = 0
private var M = 0

private lateinit var arr: Array<IntArray>

fun main() {
    val board = arrayOf(
        intArrayOf(5, 5, 5, 5, 5),
        intArrayOf(5, 5, 5, 5, 5),
        intArrayOf(5, 5, 5, 5, 5),
        intArrayOf(5, 5, 5, 5, 5),
    )

    val skill = arrayOf(
        intArrayOf(1, 0, 0, 3, 4, 4),
        intArrayOf(1, 2, 0, 2, 3, 2),
        intArrayOf(2, 1, 0, 3, 1, 2),
        intArrayOf(1, 0, 1, 3, 3, 1),
    )

    println(solution(board, skill))
} // End of main

private fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
    var ans = 0

    N = board.size
    M = board[0].size
    arr = Array(N + 1) { IntArray(M + 1) }

    skill.forEach {
        solve(it[0], it[1], it[2], it[3], it[4], it[5])
    }

    arr.forEach {
        println(it.contentToString())
    }

    for (i in 0 until N) {
        for (j in 1 until M) {
            arr[i][j] += arr[i][j - 1]
        }
    }

    for (i in 1 until N) {
        for (j in 0 until M) {
            arr[i][j] += arr[i - 1][j]
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (board[i][j] + arr[i][j] > 0) {
                ans++
            }
        }
    }

    println("===================================================================")
    println("===============================arr=================================")
    arr.forEach {
        println(it.contentToString())
    }

    println("===============================board=============================")
    board.forEach {
        println(it.contentToString())
    }

    return ans
} // End of solve

private fun solve(type: Int, r1: Int, c1: Int, r2: Int, c2: Int, degree: Int) {
    var temp = degree
    if (type == 1) {
        temp *= -1
    }

    arr[r1][c1] += temp
    arr[r1][c2 + 1] -= temp
    arr[r2 + 1][c1] -= temp
    arr[r2 + 1][c2 + 1] += temp

    /*
        Ex)
        skill => [1,0,0,3,4,4]

        (0, 0) , -> -4
        (0, 5) , -> 4
        (1, 0) , -> 4
        (4, 5)  -> -4


     */
} // End of solve
