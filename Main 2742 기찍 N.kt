import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\2742.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    var N = br.readLine().toInt()

    for(i in N downTo 1) {
        sb.append(i).append('\n')
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
} // End of main