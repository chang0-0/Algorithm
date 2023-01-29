import java.util.*;
import java.io.*;

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\중국인의 나머지 정리 부수기\\res\\6064.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    // x값 찾기 -> M으로 나눈 나머지값이 x가 되면 N으로 나눈 나머지값이 y가 되는 값
    var T = br.readLine().toInt()
    while(T-->0) {
        val st = StringTokenizer(br.readLine())
        val M = st.nextToken().toInt()
        val N = st.nextToken().toInt()
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        val n = M * N
        val N1 = n/M; val N2 = n/N
        val x1 = find_mod(N1, M); val x2 = find_mod(N2, N)

        val total = (x*N1*x1) + (y*N2*x2)
        val result = total % n

        if(result != 0) println(result)
        else println(n)
    }
    
    bw.write(sb.toString()); bw.flush(); bw.close()
} // End of main

private fun find_mod(n : Int, n2 : Int) : Int {
    var result = 0
    for(i in 1..100) {
        if((n*i) % n2 == 1) {
            result = i
            break
        }
    }
    return result
} // End of find_mod
