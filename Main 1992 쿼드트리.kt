import java.io.*

private var N = 0
private lateinit var arr : Array<CharArray>
private var sb = StringBuilder()

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\solved\\ac CLASS 3\\res\\1992.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    N = br.readLine().toInt()
    arr = Array(N){CharArray(N)}

    for(i in 0 until N) {
        var ch = br.readLine().toCharArray()
        for( j in 0 until N) arr[i][j] = ch[j]
    }

    solution(0, 0, N)
    bw.write(sb.toString());bw.flush();bw.close()
} // End of main

fun solution(x : Int , y : Int, size : Int) {
    if(checkPossibility(x, y, size)) {
        sb.append(arr[x][y])
        return
    }

    var newSize = size/2
    sb.append('(')

    solution(x, y, newSize)
    solution(x, y + newSize, newSize)
    solution(x + newSize, y, newSize)
    solution(x + newSize, y + newSize, newSize)
    sb.append(')')
} // End of solution

fun checkPossibility(x : Int, y : Int, size : Int) : Boolean {
    val value = arr[x][y]

    for(i in x until x+size) {
        for( j in y until y+size) {
            if( !value.equals(arr[i][j]) ) return false
        }
    }
    return true
} // End of checkPossibility