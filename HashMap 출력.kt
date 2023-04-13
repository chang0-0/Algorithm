fun main() {
    val map = LinkedHashMap<Int, String>()
    map.put(31, "c")
    map.put(12, "b")
    map.put(77, "a")
    println(map) // map의 key value 전체 출력
    
    // key만 출력
    map.forEach {println(it.key)}

    // value만 출력
    map.forEach{ println(it.value)}

    // 모두 출력
    map.forEach{ println("${it.key}, ${it.value}")}

    // entries 를 사용한 출력
    val ent = map.entries
    println(ent)

    
    // Iterator를 통한 출력
    // value를 통해 key를 찾을 때 OR Key값을 통해 value를 찾을 때 유용
    val iter : Iterator<Map.Entry<Int, String>> = map.entries.iterator()
    while(iter.hasNext()) {
        var entrySet = iter.next()
        if(entrySet.value.equals("c")) println(entrySet.key)
    }


} // End of main