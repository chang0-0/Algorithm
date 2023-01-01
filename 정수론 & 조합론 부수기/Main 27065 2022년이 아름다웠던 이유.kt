package `일반구현 부수기`

/*
    2022는 아름다운 수이다.
    자신을 제외한 약수의 합이 자기 자신보다 작은 수를 부족수, 자신보다 큰 수를 과잉수, 자신과 같은 수를 완전수라고 한다.

    2022는 과잉수이면서 2022의 자기자신을 제외한 모든 약수는 모든 부족수이거나 완전수이다.

    과잉과 부족의 조화라니.. 다음에 이런 년도가 오려면 2044년이되어야 한다.

    N이 과잉수이면서, N을 제외한 N의 모든 약수가 부족수이거나 완전수라면 Good Bye를 출력

    N 자신만 과잉수이면서, 나머지는 부족수 OR 완전수인 값을 찾아라.
    첫번째 조건, N이 과잉수인지 확인해라 -> N의 약수 에서 N을 제외한 모든 합이 N을 넘는지를 확인
 */

import java.util.*
import java.io.*
import java.lang.StringBuilder

private val memo = IntArray(5_001)
// memo[i]를 통해서 해당 값이 어떤 상태의 값인지를 저장함.
// memo[i] 의 값이 1일 경우, 과잉수
// 2일 경우 부족수
// 3일 경우 완전수

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현 부수기\\res\\27065.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    memo[1] = 2
    memo[2] = 2
    memo[3] = 3

    val T = br.readLine().toInt()
    for (i in 0 until T) {
        var temp = br.readLine().toInt()
        var arr = divisor(temp)


        // 1. N이 과잉수인지 판별.
        if (memo[temp] != 0 && memo[temp] != 1) {
            // memo[temp]의 값이 0이 아니면서, 1이 아닌 경우에는 과잉수가 아닌게 확실함
            sb.append("BOJ 2022").append('\n')
            continue
        } else if (memo[temp] == 0 && !isAbundantNumber(temp, arr)) {
            // memo[temp]가 0이면, 판별 해야되고, 판별한 값이 false일 경우,
            sb.append("BOJ 2022").append('\n')
            continue
        }
        // 해당 조건을 통과했을 경우, 일단 N은 과잉수가 맞음

        // 2. N을 제외한 N의 모든 약수가 부족수이거나 완전수인지를 체크
        val size = arr.size
        var flag = true
        for (j in 0 until size) {
            if (arr[j] == temp) continue // 자신은 통과

            // 다시 arr[i]의 값이 과잉수 인지 아닌지를 체크함
            // 하나라도 arr[i]의 값이 과잉수가 된다면 Good Bye를 출력할 수 없다.
            if (memo[arr[j]] == 1) {
                sb.append("BOJ 2022").append('\n')
                flag = false
                break
            }

            if (memo[arr[j]] == 2 || memo[arr[j]] == 3) {
                continue
            }

            // 과잉수일 경우 BOJ 출력
            if (isAbundantNumber(arr[j], divisor(arr[j]))) {
                sb.append("BOJ 2022").append('\n')
                flag = false
                break
            }
        }

        // 모든 조건을 통과 했을 때,
        if (flag) {
            sb.append("Good Bye").append('\n')
        }
    } // End of for(T)
    
    bw.write(sb.toString())
    bw.close()
} // End of main

private fun divisor(targetNum: Int): ArrayList<Int> { // 약수를 구하는 메소드
    val arr = ArrayList<Int>()
    val sqrt = Math.sqrt(targetNum.toDouble()).toInt()
    for (i in 1..sqrt) {
        if (targetNum % i == 0) {
            if (i * i == targetNum) {
                arr.add(i)
            } else {
                arr.add(i)
                arr.add(targetNum / i)
            }
        }
    }

    return arr
} // End of divisor

private fun isAbundantNumber(targetNum: Int, arr: ArrayList<Int>): Boolean {
    // 해당 값의 약수 배열을 새로 가져와야됨.
    val size = arr.size
    var sum = 0
    for (i in 0 until size) {
        if (arr[i] == targetNum) continue
        sum += arr[i]
    }

    if (sum > targetNum) {
        // 과잉수이면 true를 return
        memo[targetNum] = 1
        return true
    }

    if (sum == targetNum) {
        memo[targetNum] = 3 // 완전수
    } else {
        memo[targetNum] = 2 // 부족수
    }

    return false
} // End of isAbundantNumber