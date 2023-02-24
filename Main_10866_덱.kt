import java.io.*;
import java.util.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\res\\input_bj_10866.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val deque : Deque<Int> = LinkedList()
    var sb = StringBuilder();

    var num = br.readLine().toInt()
    while(num-->0) {
        var st = StringTokenizer(br.readLine());
        var function = st.nextToken();

        // push 일 때,
        while( st.hasMoreTokens() ) {

            // push_back
            if(function[5].equals('b')) {
                deque.addLast(st.nextToken().toInt())
            }
            // push_front
            else {
                deque.addFirst(st.nextToken().toInt())
            }
            continue;
        }

        when(function) {
            "front" -> if(deque.isEmpty()) sb.append(-1).append('\n') else sb.append(deque.first).append('\n');
            "back" -> if(deque.isEmpty()) sb.append(-1).append('\n') else sb.append(deque.last).append('\n');
            "size" -> sb.append(deque.size).append('\n');
            "empty" -> if(deque.isEmpty()) sb.append(1).append('\n'); else sb.append(0).append('\n');
            "pop_front" -> if(deque.isEmpty()) sb.append(-1).append('\n'); else sb.append(deque.pollFirst()).append('\n');
            "pop_back" -> if(deque.isEmpty()) sb.append(-1).append('\n'); else sb.append(deque.pollLast()).append('\n');
        }
    }

    println(sb)

} // End of main