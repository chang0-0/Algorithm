import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\solved ac CLASS1\\res\\2884.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val st = StringTokenizer(br.readLine())
    var H = st.nextToken().toInt()
    var M = st.nextToken().toInt()

    if(H == 0) H = 24
    var total = ((H * 60) + M) - 45
    H = total / 60
    M = total % 60
    if(H == 24) H = 0

    print("${H} ${M}")
} // End of main