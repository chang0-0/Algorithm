import java.util.*
import java.io.*
import java.lang.StringBuilder

/*
    문제 : 멘토를 기준으로 정렬하되, 멘토가 같은 순서쌍들에 대해선 멘티의 역순으로 정렬하자
 */

/*
    ⭐처음에 PriorityQueue로 구현을 했는데 원하는 정답이 나오지 않음
    왜 그런지 이유를 모르겠음,
    그냥 list에 모든 값을 받은 후에 Collections.sort의 Compartor를 재정의해서 출력하니 정답이 나옴
*/

private var mentoQue = PriorityQueue { o1: Mento, o2: Mento ->
    return@PriorityQueue if (o1.mento > o2.mento) {
        1
    } else if (o1.mento < o2.mento) {
        -1
    } else {
        if (o1.menti > o2.menti) {
            -1
        } else if (o1.menti < o2.menti) {
            1
        } else {
            0
        }
    }
}

private var N = 0
private var mentoList = LinkedList<Mento>()

private data class Mento(var mento: String = "", var menti: String = "") // End of Mento class

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\문자열 부수기\\res\\b.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    N = br.readLine().toInt()
//    for (i in 0 until N) {
//        val st = StringTokenizer(br.readLine())
//        mentoList.offer(Mento(st.nextToken(), st.nextToken()))
//    }

    //원래 처음 풀려고했던 방식인데 틀린 코드

    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine())
        mentoQue.offer(Mento(st.nextToken(), st.nextToken()))
    }

//    mentoQue.forEach {
//        println(it)
//    }

    /*
     8
    6 7
    도 올바른 힙이고

     8
    7 6
    도 올바른 힙 구조에요

    왜 pque에서는 결과가 다르게 나오는가?
    부모 > 자식인 성질만 유지가 되서 그렇다.


    heap의 삭제
    - 루트 노드를 삭제한다.
    - 제일 마지막에 추가된 노드를 루트 자리로 이동한다.
    - 그 후 삽입처럼 크기에 맞게 정렬 과정을 진행한다.




     */
    while (!mentoQue.isEmpty()) {
        println(mentoQue.poll())
    }


    //정답 코드.
    Collections.sort(mentoList, kotlin.Comparator { o1, o2 ->
        return@Comparator if (o1.mento > o2.mento) {
            1
        } else if (o1.mento < o2.mento) {
            -1
        } else {
            if (o1.menti > o2.menti) {
                -1
            } else if (o1.menti < o2.menti) {
                1
            } else {
                0
            }
        }
    })

//    mentoList.forEach {
//        println(it)
//    }

//    mentoList.forEach {
//        sb.append(it.mento).append(' ').append(it.menti).append('\n')
//    }
//
//    bw.write(sb.toString())
//    bw.close()
} // End of main