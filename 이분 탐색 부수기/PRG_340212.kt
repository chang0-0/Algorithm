import java.util.*

class Solution {
    private lateinit var diffArr : IntArray
    private lateinit var timeArr : IntArray
    private var timeLimit : Long = 0    
    
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        var answer: Int = 0
        diffArr = diffs
        timeArr = times
        timeLimit = limit
        
        val low = 1
        val high = diffs.maxOrNull() ?: 1
        val ans = binarySearch(low, high)
        
        return ans
    } // End of solution()
    
    fun binarySearch(low : Int, high : Int) : Int {        
        if(low > high) {
            return -1
        }
        
        val mid = (low + high) / 2
        val ret : Long = calc(mid)
        
        if(ret == -2L) {
            // 제한시간을 벗어났으므로, 레벨을 높인다.
            return binarySearch(mid + 1, high)
        } else {
            // 제한시간안에 들어왔으므로, 시간을 줄인다.
            val temp = binarySearch(low, mid - 1)
            if(temp != -1) return temp
            return mid
        }
    } // End of binarySearch()
    
    fun calc(level : Int) : Long {
        var sum : Long = 0
        
        diffArr.forEachIndexed { i, it ->
            if(it <= level) {
                sum += timeArr[i]
            } else {
                val levelDiff = it - level
                val preTime = if(i == 0) 0 else timeArr[i - 1]
                
                val temp = ((preTime + timeArr[i]) * levelDiff) + timeArr[i]
                sum += temp
            }
            
            if(sum > timeLimit) return -2
        }

        
        return sum
    } // End of calc()
} // End of Solution class