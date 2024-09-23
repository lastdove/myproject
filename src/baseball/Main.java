package baseball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        // 사용자 입력을 위한 Scanner 생성
        int cnt, chk;       // cnt는 시도 횟수, chk는 사용자의 선택 담기
        while(true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("1. 시작 2. 기록 3. 종료");
            chk = sc.nextInt();     // 사용자가 선택한 메뉴 입력 받음

            switch(chk) {
                case 1:
                    BaseballGame game = new BaseballGame();     // 새로운 게임 객체 생성
                    cnt = game.play();      // 게임 실행 후 시도 횟수 반환
                    System.out.println("정답입니다! 도전횟수 : " + cnt);
                    break;
                case 2:
                    System.out.println("아직 준비중");       // 기록 기능은 아직 미구현
                    break;
                case 3:
                    System.out.println("종료합니다.");       // 프로그램 종료 메시지
                    break;
                default:
                    System.out.println("다시 입력해주세요.");       // 잘못된 입력 처리
            }
            if (chk == 3) break;        // 종료를 선택하면 반복문 탈출
        }
    }
}

