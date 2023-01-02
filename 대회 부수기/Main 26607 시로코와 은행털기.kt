package `대회 부수기`

/*
    X가 200일 때,  1, 199 199, 1 조합 , 100, 100 조합 어디가 더 높을까

    2명을 뽑는다 가정.

    200 * 200 = 40000

    199 1

    199 1

    대충 생각해보니까, power의 차이와 intelligence의 차이가 가장 큰 조합이 최대값을 가질 수 있다.



    조합된 값들의 power합이 K이고,

    최댓값이 될 수 있는 첫번째 규칙은 선택한 값의 합이 power에서만 합이 X가 되도록하는 값이 최댓값

    즉, power하나의 합만이 X값에 가장 가깝게 되는 답이 정답이 된다.


 */


import java.util.*
import java.io.*

private var N = 0
private var K = 0
private var X = 0
private var result = 0

private val people = Array(81) { Person() }
private val repeople = Array(81) { ReversePerson() }
private lateinit var comb: IntArray
private var pque = PriorityQueue { o1: Person, o2: Person ->
    return@PriorityQueue if (o1.power > o2.power) {
        -1
    } else if (o1.power < o2.power) {
        1
    } else {
        if (o1.intelligence > o2.intelligence) {
            1
        } else if (o1.intelligence < o2.intelligence) {
            -1
        } else {
            0
        }
    }
}

private var pque2 = PriorityQueue { o1: ReversePerson, o2: ReversePerson ->
    return@PriorityQueue if (o1.power > o2.power) {
        -1
    } else if (o1.power < o2.power) {
        1
    } else {
        if (o1.intelligence > o2.intelligence) {
            1
        } else if (o1.intelligence < o2.intelligence) {
            -1
        } else {
            0
        }
    }
}


private data class Person(var power: Int = 0, var intelligence: Int = 0) // End of Person class
private data class ReversePerson(var intelligence: Int = 0, var power: Int = 0) // End of Person class

private val isVisited = IntArray(201)

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\대회 부수기\\res\\26607.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    K = st.nextToken().toInt() // 뽑을 인원
    X = st.nextToken().toInt() // 수치의 합
    comb = IntArray(K)

    val combList = LinkedList<Person>()

    // X로 만들 수 있는 모든 조합을 생각해보자.
    // 대각선 곱하기가 높은 순서대로 정렬한다면?


    var count = 0
    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        val tempPower = st.nextToken().toInt()
        val tempIntell = st.nextToken().toInt()

        repeople[i] = ReversePerson(tempIntell, tempPower)
        people[i] = Person(tempPower, tempIntell)
        pque.offer(people[i])
        pque2.offer(repeople[i])


        // 합쳐서 X가 될 수 있는 값이 있는지 미리 파악하는 것도 하나의 방법이 될 수 있지 않을까 하는 생각.
        if (isVisited[tempPower] == 0) {
            isVisited[tempPower]++
            isVisited[tempIntell]++
        } else if (isVisited[tempPower] >= 1 || isVisited[tempIntell] >= 1) {
            combList.add(Person(tempPower, tempIntell))
            combList.add(Person(tempIntell, tempPower))
            isVisited[tempPower]--
        }
    }

    var tempKCount = K
    var powerSum = 0
    var intellSum = 0
    while (!combList.isEmpty()) {
        val temp = combList.pollLast()

        powerSum += temp.power
        intellSum += temp.intelligence

        tempKCount--
        if (tempKCount == 0) {
            println(powerSum * intellSum)
            return
        }
    }

    println(result)
} // End of main
