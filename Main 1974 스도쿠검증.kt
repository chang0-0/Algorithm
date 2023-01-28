import java.util.*
import java.io.*

private var arr = Array(9){IntArray(9)}
fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\SW Academy\\res\\1974.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    var st:StringTokenizer

    val T = br.readLine().toInt()
    for(t in 1..T) {
        sb.append('#').append(t).append(' ')

        for(i in 0 until 9) {
            st = StringTokenizer(br.readLine())
            for(j in 0 until 9) arr[i][j] = st.nextToken().toInt()
        }

        var bol = true
        // 가로 체크
        for(i in 0 until 9) {
            var sum = 0
            for(j in 0 until 9) sum += arr[i][j]

            if(sum != 45) bol = false
        }
        if(!bol) {
            sb.append(0).append('\n'); continue
        }
        
        // 세로 체크
        for(i in 0 until 9) {
            var sum = 0
            for(j in 0 until 9) sum += arr[j][i]
            if(sum != 45) bol = false
        }
        if(!bol) {
            sb.append(0).append('\n'); continue
        }

        // 3x3 배열 체크
        for(i in 0 until 9 step 3) {
            for(j in 0 until 9 step 3) {
                var x = i; var y = j
                var sum = 0

                for(k in x until x+3) {
                    for(l in y until y+3) sum += arr[k][l]
                }

                if(sum != 45) {
                    bol = false
                    break
                }
            }
        }

        if(!bol) sb.append(0).append('\n')
        else sb.append(1).append('\n')
    }

    bw.write(sb.toString()); bw.flush(); bw.close()
} // End of main

