import java.util.*

class Solution {
    private lateinit var diffsArr : IntArray
    private lateinit var timesArr : IntArray
    private var limitTime = 0L
    private var N = 0
    
    
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {        
        // 숙련도의 최솟값을 구하기.
        // 이분탐색
        diffsArr = diffs
        timesArr = times
        limitTime = limit
        N = diffsArr.size
        
        var min = 1
        var max = 100_000
        val ret = binarySearch(min, max) 
        
        return ret
    } // End of solution()
    
    fun binarySearch(low : Int, high : Int) : Int {
        if(low > high) {
            return -1
        }
        
        val mid = (low + high) / 2
        val ret = check(mid)        
        if(ret == -1L) {
            // 제한시간의 범위를 벗어났을 경우
            return binarySearch(mid + 1, high)
        } else {
            val temp = binarySearch(low, mid - 1)
                        
            return if(temp == -1) {
                mid
            } else {
                temp
            }
        }    
    } // End of binarySearch()    
    
    fun check(level : Int) : Long {
        var totalTime = 0L
        var previousTime = 0
        
        for(i in 0 until N) {
            if(level >= diffsArr[i]) {
                totalTime += timesArr[i]
            } else {
                val diff = diffsArr[i] - level
                totalTime += (diff * (timesArr[i] + previousTime)) + timesArr[i]
            }
            
            if(totalTime > limitTime) {
                return -1
            }
            previousTime = timesArr[i]
        }
        
        return totalTime
    } // End of check()
} // End of Solution class
