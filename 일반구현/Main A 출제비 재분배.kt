import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\문자열 부수기\\res\\a.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val sb = StringBuilder()
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val arr = IntArray(N)
    val result = IntArray(N + M)

    st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until N + M) {
            val temp = st.nextToken().toInt()

            if (j < N) {
                arr[i] -= temp
                arr[j] += temp
            } else if (j >= N) {
                result[j] += temp
                arr[i] -= temp
            }
        }
    }

    for (i in 0 until N + M) {
        if (i < N) {
            sb.append(arr[i].toString()).append(' ')
        } else {
            sb.append(result[i].toString()).append(' ')
        }
    }

    bw.write(sb.toString())
    bw.close()
} // End of main