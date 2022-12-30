package `일반구현 부수기`

import java.io.*

/*
    성장의 비약 선택권을 사용하면 네 가지의 성장 비약 중 한 가지를 선택하여 적힌 개수만큼 얻을 수 있다.
    캐릭터의 현재 레벨을 포함하는 구간의 성장의 비약을 사용하면 캐릭터의 레벨이 정확히 1만큼 오른다.

    태풍 성장의 비약은 200 ~ 239레벨의 캐릭터를 정확히 1레벨 올려준다.
    모든 성장의 비약은 한번에 한 개씩 사용할 수 있고, 캐릭터의 현재 레벨을 포함하지 않는 구간의 성장의 비약은 사용하지 못한다.

    N = 200 ~ 239

    지훈이가 어떤 성장의 비약을 선택해야 가장 높은 레벨에 도달할 수 있는지 알려주자
    만약 가장 높은 레벨에 도달 할 수 있는 성장의 비약 종류가 둘 이상이라면, 사진상 더 아래에 있는 성장의 비약을 선택한다.

 */

private var maxLevel = 0
private var N = 0
private var ans = 0

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현 부수기\\res\\a.txt"
    val br = BufferedReader(File(path).bufferedReader())

    N = br.readLine().toInt()
    if (N >= 229) {
        println(4)
        return
    }

    DFS(0, 0)
    println(ans)
} // End of main

// 1을 선택했을 때는 최대 몇 까지 갈 수 있나
// 2를 선택했을 때는 최대 몇 까지 갈 수 있나
// 3을 선택했을 때는 최대 몇 까지 갈 수 있나
private fun DFS(index: Int, step: Int) {

    if (step < 3) {
        if (N <= 209 && step + 1 == 1) {
            val temp = N + 8
            var level = 0
            if (temp > 210) {
                level = N + (210 - N)
            } else {
                level = temp
            }

            if (maxLevel < level) {
                maxLevel = level
                ans = Math.max(ans, 1)
            }
        } else if (N <= 219 && step + 1 == 2) {
            val temp = N + 4
            var level = 0
            if (temp > 220) {
                level = N + (220 - N)
            } else {
                level = temp
            }

            if (maxLevel <= level) {
                maxLevel = level
                ans = Math.max(ans, 2)
            }
        } else if (N <= 229 && step + 1 == 3) {
            val temp = N + 2
            var level = 0
            if (temp > 230) {
                level = N + (230 - N)
            } else {
                level = temp
            }

            if (maxLevel <= level) {
                maxLevel = level
                ans = Math.max(ans, 3)
            }
        }
    } else {
        return
    }

    for (i in index until 3) {
        DFS(i + 1, step + 1)
    }
} // End of solution