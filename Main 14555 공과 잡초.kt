import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\SW Academy\\res\\14555.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    val T = br.readLine().toInt()
    for(t in 1..T) {
        sb.append('#').append(t).append(' ')
        val ch = br.readLine().toCharArray()
        var temp = ch[0]
        var result = 0

        val len = ch.size
        for(i in 1 until len) {
            var str = temp.toString() + ch[i].toString()

            if(str.equals("(|") || str.equals("|)")) result++
            else if(str.equals("()")) result++

            temp = ch[i]
        }
        sb.append(result).append('\n')
    }

    bw.write(sb.toString()); bw.close();
} // End of main