import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\일반구현\\res\\2562.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    var count = 0
    var max = Integer.MIN_VALUE
    for(i in 1..9) {
        var num = br.readLine().toInt()
        if(num > max) {
            count = i
            max = num
        }
    }

    sb.append(max).append('\n').append(count)
    bw.write(sb.toString())
    bw.flush()
    bw.close()
} // End of main