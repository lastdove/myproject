package spartajava;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);
        boolean checking = true;
        int num1;
        int num2;

        while (checking) {
            System.out.print("연산기호를 입력해주세요. : ");
            String str = sc.nextLine();

            System.out.print("첫 번째 값을 입력해주세요. : ");
            try {
                num1 = Integer.parseInt(sc.nextLine());
                if(num1 < 0) {
                    System.out.println("0 미만의 수는 입력할 수 없습니다.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("값을 다시 입력해주세요.");
                continue;
            }
            System.out.print("두 번째 값을 입력해주세요. : ");
            try {
                num2 = Integer.parseInt(sc.nextLine());
                if(num2 <= 0) {
                    System.out.println("0 이하의 수는 입력할 수 없습니다.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("값을 다시 입력해주세요.");
                continue;
            }

            calc.setcalc(str, num1, num2);

            System.out.println(calc.getResult());

            System.out.print("계속 진행(1) / 종료(2) / 삭제(3) 번호 입력 :");
            String check = sc.nextLine();

            switch (check) {
                case "1" :
                    continue;
                case "2" :
                    checking = false;
                    break;
                case "3" :
                    System.out.print("삭제할 값을 입력하세요 :");
                    double delnum = Double.parseDouble(sc.nextLine());

                    System.out.print("중복값 포함(1) / 미포함(2) 번호 입력 :");
                    int all = Integer.parseInt(sc.nextLine());

                    calc.delete(all, delnum);
                    break;
                default :
                    System.out.println("잘못입력하셨습니다. 처음으로 돌아갑니다.");
            }
        }
    }
}
