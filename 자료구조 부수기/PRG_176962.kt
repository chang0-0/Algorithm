import java.util.*

class Solution {
    private var N = 0
    private data class Assignment(val name : String, val remainTime : Int)
    
    fun solution(plans: Array<Array<String>>): Array<String> {
        N = plans.size
        val ans = Array<String>(N) {""}
        val que = ArrayDeque<Assignment>()
        
        plans.sortWith(compareBy { it[1] })       
        
        var preAssignName = plans[0][0]
        var preAssignStartTime = convertTime(plans[0][1])
        var preRequireTime = plans[0][2].toInt()
        var idx = 0
        

        for(i in 1 until N) {
            val plan = plans[i]
            val name = plan[0]
            val time = convertTime(plan[1])
            val requireTime = plan[2].toInt()            
            var diff =  time - (preAssignStartTime + preRequireTime)   
            
            if(diff >= 0) {
                ans[idx++] = preAssignName
                while(que.isNotEmpty() && diff > 0) {         
                    
                    if(que.first().remainTime <= diff) {
                        diff -= que.first().remainTime
                        ans[idx++] = que.first().name
                        que.removeFirst()
                    } else if(que.peek().remainTime > diff) {
                        val temp = que.removeFirst()
                        que.addFirst(Assignment(temp.name, temp.remainTime - diff))
                        diff = 0
                    } 
                }
            } else {
                que.addFirst(Assignment(preAssignName, diff * -1 ))
            }
            
            preAssignStartTime = time
            preRequireTime = requireTime
            preAssignName = name
        }
        
        ans[idx++] = preAssignName   
        while(que.isNotEmpty()) {
            ans[idx++] = que.poll().name
        }
        
        return ans
    } // End of solution()
    
    fun convertTime(str : String) : Int {
        var time = 0
        StringTokenizer(str, ":").run {
            time += nextToken().toInt() * 60
            time += nextToken().toInt()
        }
        
        return time
    } // End of convertTime()
} // End of Solution class