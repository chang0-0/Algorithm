import java.io.*
import java.security.KeyStore
import java.util.*

fun main() {
    var path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\res\\input_bj_1159.txt"
    var br = BufferedReader(File(path).bufferedReader())
    var sb = StringBuilder();

    var num = Integer.parseInt(br.readLine())
    var map : HashMap<Char, Int> = HashMap<Char, Int>();

    // 들어오는 이름의 첫 글자를 분리해서 집어넣어야함.
    while(num-->0) {
        var name = br.readLine()[0]
        map.put(name, map.getOrDefault(name, 0) + 1);
    }

    for((key, value) in map) {
        if(value >= 5) {
            sb.append(key);
        }
    }

    var it : Iterator<Map.Entry<Char, Int>> = map.entries.iterator();
    while(it.hasNext()) {
        var entrySet : Map.Entry<Char, Int> = it.next();

        if(entrySet.value >= 5) {
            sb.append(entrySet.key);
        }
    }

    if(sb.length == 0) {
        print("PREDAJA")
    }
    else {
        print(sb)
    }

} // End of main

