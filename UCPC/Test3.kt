//import java.util.*
//import java.io.*
//
//private class form(var x : Long, var y : Long, var depth : Long)
//private lateinit var list : MutableList<form>
//
//fun main() {
//    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\UCPC\\res\\3.txt"
//    val br = BufferedReader(File(path).bufferedReader())
//    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
//    val sb = StringBuilder()
//    var N = br.readLine().toInt()
//
//    while(N-->0) {
//        var st = StringTokenizer(br.readLine())
//        var num1 = st.nextToken().toLong()
//        list = ArrayList<form>()
//        var coef = 1L
//
//        if(num1 == 1L) {
//            var a = st.nextToken().toLong()
//            var b = st.nextToken().toLong()
//
//            list.add(form(a, b, 1))
//            if(list.size >=2) calc()
//        }
//        else if(num1 == 2L) {
//            var C = st.nextToken().toLong()
//            sb.append(check(C)).append('\n')
//        }
//
//    }
//
//    bw.write(sb.toString()); bw.flush(); bw.close()
//} // End of main
//
//private fun check(C : Long) : String {
//
//    return "re"
//} // End of check
//
//private fun calc() {
//
//
//}
//
