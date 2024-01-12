import java.util.*;

class Solution {
    public static int[][] fatigues = {
        { 1, 1, 1 },
        { 5, 1, 1 },
        { 25, 5, 1 }
    };
    
    public static class Mineral implements Comparable<Mineral> {
        int d, r, s;

        public Mineral(int d, int r, int s) {
            this.d = d;
            this.r = r;
            this.s = s;
        }

        @Override
        public int compareTo(Mineral o) {
            if(d == o.d) {
                if(r == o.r) {
                    return s - o.s;
                }
                return r - o.r;
            }
            return d - o.d;
        }
    }
    
    public static int solution(int[] picks, String[] minerals) {
        List<Mineral> mineralList = new ArrayList<>();
        int N = minerals.length;
        int M = picks[0] + picks[1] + picks[2];


        for (int i = 0; i < N && mineralList.size() < M; i += 5) {
            int d = 0, r = 0, s = 0;
            for (int j = i; j < Math.min(i + 5, N); j++) {
                char mineralType = minerals[j].charAt(0);
                if (mineralType == 'd') d++;
                else if (mineralType == 'i') r++;
                else s++;
            }
            mineralList.add(new Mineral(d, r, s));
        }

        // 다이아, 철, 돌이 많은순으로 정렬 -> picks에서 다이아몬드 곡괭이, 철 곡괭이 순으로 나오기 때문에
        Collections.sort(mineralList, Collections.reverseOrder());
        
        int ans = 0;
        int l = 0;
        for (Mineral m : mineralList) {
            while (l < 3 && picks[l] == 0) {
                l++; // 곡괭이 하나씩 소모 
            }
            if (l == 3) {
                break; // 곡괭이 다쓰면 종료    
            }
            
            ans += m.d * fatigues[l][0] + m.r * fatigues[l][1] + m.s * fatigues[l][2];
            picks[l]--;
        }

        return ans;
    }
} // End of Solution class