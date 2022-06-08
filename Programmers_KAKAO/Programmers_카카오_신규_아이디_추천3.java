public class Programmers_카카오_신규_아이디_추천3 {

    // ⭐정규 표현식 사용 ⭐//

    public String solution(String new_id) {
        String answer = "";

        // 1 단계: new_id 소문자로 치환
        new_id = new_id.toLowerCase();
        
        // 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        // replaceAll(op1, op2) -> op1에 해당하는 문자가 있으면 op2의 문자로 모두 변경
        //[^]은 []안의 a-z0-9-_. 가 아닌 것 모두를 의미함
        answer = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        answer = answer.replaceAll("\\.+", ".");

        // 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        answer = answer.replaceAll("^[.]|[.]$", "");

        // 5단계: 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(answer.isEmpty()) {
            answer = "a";
        }

        // 6단계: 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(answer.length() > 15) {
            answer = answer.substring(0, 15);
            // [.]$ -> .으로 끝나는 문자열을 ""로 바꾼다. []바깥에 $는 '[]안의 내용으로 끝나면' 이라는 뜻
            answer = answer.replaceAll("[.]$", "");
        }

         // 7단계: 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
    public static void main(String[] args) {
        Programmers_카카오_신규_아이디_추천3 s = new Programmers_카카오_신규_아이디_추천3();
        String new_id = "...!@BaT#*..y.abcdefghijklm";

        System.out.println(s.solution(new_id));
    }
}
