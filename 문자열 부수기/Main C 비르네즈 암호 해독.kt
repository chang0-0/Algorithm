import java.util.*
import java.io.*

/*
    비르네즈는 고전 암호의 일종으로, 대문자 알파벳으로만 이뤄진 평문에 키를 더하여 암호를 만드는 방법이다.
    구체적인 과정은 다음과 같다.

    1. 평문과 동일한 길이가 될 때까지 키를 반복하여 문자열을 만든다.
    2. 평문과 키의 각 알파벳을 1부터 26까지의 수에 순서대로 대응시켜 수열을 만든다. A = 1.. Z = 26
    3. 평문과 키 수열에서 동일한 위치에 있는 수들을 더하여 암호문을 만든다.
    4. 단 더했을 때, 25이 넘는 수의 경우 26만큼 뺀 결과를 사용한다.

    가능한 키 중 가장 짧은 키를 찾아보자.
 */


private var str = ""
private var vigenere = ""

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\문자열 부수기\\res\\c.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val sb = StringBuilder()

    str = br.readLine()
    vigenere = br.readLine()

    // 1. 평문과 동일한 길이가 될 때까지 키를 반복하여 문자열을 만든다.
    madeStr()

    //  2. 평문과 키의 각 알파벳을 1부터 26까지의 수에 순서대로 대응시켜 수열을 만든다.
    var count = 0

    while (true) {
        val strList: MutableList<Int> = ArrayList<Int>()
        val vigenereList: MutableList<Int> = ArrayList<Int>()

        val len = vigenere.length
        for (i in 0 until len) {
            strList.add(str[i].toInt() - 64)
            vigenereList.add(vigenere[i].toInt() - 64)
        }

        println(strList)
        println(vigenereList)

        val tempList: MutableList<Int> = ArrayList<Int>()
        for (i in 0 until len) {
            var temp = vigenereList[i] + strList[i]
            if (temp > 26) {
                temp -= 26
            }
            tempList.add(temp)
        }


        for (i in 0 until len) {
            sb.append((tempList[i] + 64).toChar())
        }

        println(sb.toString())

        count++
        if (count >= 10) {
            break
        }
    }


} // End of main

private fun madeStr() {
    for (i in 0 until (str.length / vigenere.length) - 1) {
        vigenere += vigenere
    }
} // End of madeStr