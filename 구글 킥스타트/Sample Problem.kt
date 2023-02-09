import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\구글 킥스타트\\res\\test1.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    val T = br.readLine().toInt()
    for(i in 0 until T) {
        sb.append("Case #").append(i+1).append(": ")
        var st = StringTokenizer(br.readLine())
        var N = st.nextToken().toInt()
        var M = st.nextToken().toInt()

        st = StringTokenizer(br.readLine())
        var total = 0
        for(i in 0 until N) {
            total += st.nextToken().toInt()
        }
        sb.append(total % M).append('\n')
    }

    bw.write(sb.toString()); bw.flush(); bw.close()
} // End of main