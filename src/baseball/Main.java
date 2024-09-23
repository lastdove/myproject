package baseball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt, chk;
        while(true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("1. 시작 2. 기록 3. 종료");
            chk = sc.nextInt();

            switch(chk) {
                case 1:
                    BaseballGame game = new BaseballGame();
                    cnt = game.play();
                    System.out.println("정답입니다! 도전횟수 : " + cnt);
                    break;
                case 2:
                    System.out.println("아직 준비중");
                    break;
                case 3:
                    System.out.println("종료합니다.");
                    break;
                default:
                    System.out.println("다시 입력해주세요.");
            }
            if (chk == 3) break;
        }
    }
}

