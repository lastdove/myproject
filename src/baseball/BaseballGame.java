package baseball;

import java.util.*;

public class BaseballGame {
    BaseballGameDisplay display;        //  힌트 출력을 위한 디스플레이 객체
    Scanner sc = new Scanner(System.in);        // 사용자 입력을 받기 위한 Scanner
    HashSet<Integer> test = new HashSet<>();        // 랜덤 숫자의 중복을 방지하는 HashSet
    private Random rand = new Random();     // 랜덤 숫자 생성을 위한 Random 객체
    private String inputnum;        // 사용자 입력을 저장할 변수
    String answer = "";     // 정답을 저장할 변수
    int count = 0;      // 시도 횟수
    int strike;     // 스트라이크 개수
    int ball;       // 볼 개수


    public BaseballGame() {
        display = new BaseballGameDisplay();        // 디스플레이 객체 초기화
        StringBuilder sb = new StringBuilder();
        // 정답 숫자를 랜덤으로 생성하고 중복되지 않도록 HashSet에 저장
        while (sb.length() < 3) {
            int digit = rand.nextInt(9) + 1;        // 1~9 사이의 랜덤 숫자 생성
            if (test.add(digit)) {      // 중복이 아니면 숫자를 추가
                sb.append(digit);
            }
        }
        answer = sb.toString();     // 정답을 문자열로 저장
    }

    public int play() {


        while (true) {
            // 사용자에게 입력값을 받음
            System.out.print("숫자를 입력하세요:");     /// 입력 및 출력 개선
            inputnum = sc.nextLine();

            // 입력값이 올바른지 검증
            if (!validateInput(inputnum)) {
                System.out.println("제대로 입력해주세요. 중복x 이상한 문자x");
                continue;
            }
            count++;        // 시도 횟수 증가
            strike = countStrike(inputnum);     // 스트라이크 개수 계산

            // 스트라이크 3개 맞추면 종료
            if (strike == 3) {
                break;
            }

            ball = countBall(inputnum);     // 볼 개수 계산
            display.displayHint(strike, ball);      // 힌트 출력
        }
        return count;       // 시도 횟수 반환
    }

    // 입력값 검증 메소드
    protected boolean validateInput(String input) {
        if (input.length() != 3 || !input.matches("[1-9]{3}")) {        // 1~9 사이의 숫자이고 3자리인지 확인
            return false;
        }

        HashSet<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!set.add(c)) {      // 중복이 없으면 true
                return false;
            }
        }
        return true;
    }

    // 스트라이크 개수 계산 메소드
    private int countStrike(String input) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) {      // 숫자와 위치가 모두 맞으면 스트라이크
                result++;
            }
        }
        return result;
    }

    // 볼 개수 계산 메소드
    private int countBall(String input) {
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != answer.charAt(i) && answer.contains(String.valueOf(input.charAt(i)))) {      // 숫자는 맞고 위치가 틀리면 볼
                result++;
            }
        }
        return result;
    }
}