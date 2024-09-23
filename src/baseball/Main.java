package baseball;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> count = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        Scanner sc = new Scanner(System.in);        // 사용자 입력을 위한 Scanner 생성
        int cnt, chk, digits = 3;       // cnt는 시도 횟수, chk는 사용자의 선택 담기, digits는 기본 자리수 설정값 - 3
        while(true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정(미설정 시 3자리) / 1. 시작 / 2. 기록 / 3. 종료");
            try {
                chk = sc.nextInt();     // 사용자가 선택한 메뉴 입력 받음
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력하세요.");
                sc.nextLine();      //  입력버퍼 초기화
                continue;
            }

            switch(chk) {
                case 0:
                    System.out.print("설정하려는 자리수를 입력하세요 : ");        // 사용자가 원하는 자리수 입력받기
                    digits = sc.nextInt();
                    System.out.println(digits + " 자리수 난이도로 설정되었습니다.");
                    chk = 1;        // 자리수값 설정 후에 break없이 바로 게임 진행
                case 1:
                    BaseballGame game = new BaseballGame(digits);     // 새로운 게임 객체 생성
                    System.out.println("< 게임을 시작합니다 >");
                    cnt = game.play(digits);      // 게임 실행 후 시도 횟수 반환
                    System.out.println("정답입니다! 도전횟수 : " + cnt);
                    count.add(cnt);
                    level.add(digits);
                    break;
                case 2:
                    System.out.println("< 게임 기록 보기 >");
                    if (count.isEmpty()) {      // 기록된 정보가 없을 시
                        System.out.println("기록 없음");
                    } else {        // 기록된 정보가 있다면 출력
                        for (int i = 0; i < count.size(); i++) {
                            System.out.println(i + 1 + "번째 게임 시도 횟수 : " + count.get(i) + "회 / 자리수 : " + level.get(i));
                        }
                    }
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

