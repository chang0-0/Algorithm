import java.util.*;
import java.io.*;

private var N = 0; private var reuslt = 0
private lateinit var chArr : ArrayList<Char>

// 곰곰이가 연속으로 치킨을 먹는 날의 최댓값을 가장 작게 만들려고 한다.


fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\문자열 부수기\\res\\25193.txt"
    val br = BufferedReader(File(path).bufferedReader())

    N = br.readLine().toInt()
    chArr = ArrayList<Char>(N)
    println(chArr)


} // End of main