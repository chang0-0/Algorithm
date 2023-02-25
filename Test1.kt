import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\UCPC\\res\\1.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    var N = br.readLine().toInt()
    for(i in 0 until N / 4) { sb.append("long ") }
    sb.append("int")

    bw.write(sb.toString()); bw.flush(); bw.close()
} // End of main