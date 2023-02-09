import java.util.*
import java.io.*

// https://www.acmicpc.net/problem/23932
// 펠린드롬은 알파벳 개수를 세아려서 홀수인 알파벳이 2개 이상일 경우, 펠린드롬이 불가능하다.

private var arr : Array<IntArray> = Array(100100){IntArray(26)}
fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\구글 킥스타트\\res\\test3.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    var T = br.readLine().toInt()
    for(t in 0 until T) {
        var result = 0
        sb.append("Case #").append(t+1).append(": ")
        var st = StringTokenizer(br.readLine())
        var N = st.nextToken().toInt() // 전체 문자열 길이
        var Q = st.nextToken().toInt() // 질문의 수
        var chArr = br.readLine().toCharArray()

        for(i in 1..N) {
            for(j in 0 until 26) {
                if (chArr[i - 1] - 'A' == j) arr[i][j] = arr[i - 1][j] + 1
                else arr[i][j] = arr[i - 1][j]
            }
        }

        while(Q-->0) {
            st = StringTokenizer(br.readLine())
            if(checkPalindrome(st.nextToken().toInt(), st.nextToken().toInt())) result++
        }
        sb.append(result).append('\n')
    }
    bw.write(sb.toString()); bw.flush(); bw.close()
} // End of main

private fun checkPalindrome(L : Int, R : Int) : Boolean {
    var odd = 0 // 홀수의 개수
    for(i in 0 until 26) {
        odd += (arr[R][i] - arr[L-1][i]) % 2
    }

    if(odd < 2) return true
    return false
} // End of checkPalindrome