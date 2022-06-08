public class Programmers_내적 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i=0; i<a.length; i++) {
           answer += a[i] * b[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int a[] = {-1,0,1};
        int b[] = {1,0,-1};

        Programmers_내적 s = new Programmers_내적();

        System.out.println(s.solution(a, b));
    }
}
