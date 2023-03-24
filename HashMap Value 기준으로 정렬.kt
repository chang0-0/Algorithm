import java.util.*
import kotlin.collections.LinkedHashMap

fun main() {
    val map = LinkedHashMap<Int, String>()
    map.put(31, "c")
    map.put(12, "b")
    map.put(77, "a")
    println(map)

    val sortdedMap = sortMapByValue(map)
    print(sortdedMap)
} // End of main

private fun sortMapByValue(map : Map<Int, String>) : LinkedHashMap<Int, String> {
    val ent = LinkedList(map.entries)
    ent.sortBy { it.value }

    val result = LinkedHashMap<Int, String>()
    for(e in ent) {
        result.put(e.key, e.value)
    }

    return result
} // End of sortMapByValue