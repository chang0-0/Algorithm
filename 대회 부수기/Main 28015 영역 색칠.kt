package 대회_부수기

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
private var ans = 0

// 덧칠하면서 만난 다른 색깔
private var map = Array(101) { IntArray(101) }

/*
    그림을 똑같이 그리는데 최소 몇 번의 붓질이 필요한지 구해보자.
    덧칠을 해도 되는게 핵심 포인트임.
 */

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\28015.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()

    /*
        가로 방향으로만 칠할 수 있음
        0이 아니면 계속 칠해도됨.
        즉, 0을 만나지 않는 이상 1로 모두 칠해놓고, 2를 거기다 덧칠하는 방식으로 진행해도 되고,
        아니면, 2로 모두 칠하고, 1로 덧칠하는 방식으로 해도 됨
        각 가로로 색칠하면서 최소한의 횟수를 모두 합산하면 정답이 됨

        0이 아니면 일단 1이든, 2이든 색칠을 하고 덧칠을 하는 방향으로 진행
     */

    val list: MutableList<Int> = ArrayList()
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] != 0) {
                list.add(map[i][j])
            } else if (map[i][j] == 0 && list.isNotEmpty()) {
                // 리스트에서 1과 2가 모두 동시에 포함되어 있는지를 확인
                if (list.contains(2) && list.contains(1)) {
                    // 1과 2가 동시에 있다면, 어떤 걸로 칠하고 덧칠 했을 때, 가장 적은 횟수로 가능한지 확인해야됨
                    // 적은 횟수로 덧칠할 수 있는 색깔을 구하고, 처음 칠하는 색상을 위해 붓질 한번 더하기
                    ans += check(list) + 1
                } else {
                    // 1과 2가 동시에 있지 않다면, 굳이 최솟값을 구할 필요가 없다.
                    ans += 1
                }

                list.clear()
            }
        }

        // 0을 만나지 못하고 끝났을 경우 고려
        if (list.contains(2) && list.contains(1)) {
            ans += check(list) + 1
        } else if (list.isNotEmpty()) {
            // 1과 2가 동시에 있지 않다면, 굳이 최솟값을 구할 필요가 없다.
            ans += 1
        }

        list.clear()
    }

    sb.append(ans)
    bw.write(sb.toString())
    bw.close()
} // End of main

private fun check(list: MutableList<Int>): Int {
    var oneColor = 0
    var twoColor = 0

    var preColor = list[0]
    if (preColor == 1) {
        oneColor = 1
    } else {
        twoColor = 1
    }
    var nowColor = -1
    val size = list.size
    for (i in 1 until size) {
        nowColor = list[i]
        if (preColor != nowColor) {
            if (nowColor == 1) {
                oneColor++
            } else {
                twoColor++
            }
        } else continue
        preColor = nowColor
    }

    return Math.min(oneColor, twoColor)
} // End of check

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until M) {
            map[i][j] = st.nextToken().toInt()
        }
    }
} // End of input
