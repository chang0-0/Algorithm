import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\ad hoc 부수기\\res\\10158.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var st = StringTokenizer(br.readLine())
    var w = st.nextToken().toInt()
    var h = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    var p = st.nextToken().toInt()
    var q = st.nextToken().toInt()
    var t = br.readLine().toInt()

    var x = w - Math.abs(w - ((p+t) % (2*w)))
    var y = h - Math.abs(h - ((q+t) % (2*h)))
    print("${x} ${y}")
} // End of main