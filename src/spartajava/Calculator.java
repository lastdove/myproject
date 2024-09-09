package spartajava;

import java.util.*;

public class Calculator {
    private final ArrayList<Double> result = new ArrayList<>();
    private String operation;
    private int num1;
    private int num2;
    private double sum;
    public int error;

    public double getResult() {
        int lastindex = result.size() - 1;
        if(lastindex < 0 || error == 1) {
            return 0;
        } else {
            return result.get(lastindex);
        }
    }

    public void setcalc(String operation, int num1, int num2) {
        this.operation = operation;
        this.num1 = num1;
        this.num2 = num2;
        calculate();
    }

    public void delete(int set, double num) {
        boolean chk;

        if(!result.contains(num)){
            System.out.println("해당 값은 존재하지 않습니다.");
        } else {
            if (set == 1) {
                chk = result.removeAll(Arrays.asList(Double.valueOf(num)));
                if (chk) System.out.println("정상적으로 삭제되었습니다." + record());
            } else if (set == 2) {
                chk = result.remove(Double.valueOf(num));
                if (chk) System.out.println("정상적으로 삭제되었습니다." + record());
            }
        }
    }

    public ArrayList<Double> record() {
        return result;
    }

    public void calculate() {
        error = 0;
        switch (operation) {
            case "+" :
                sum = num1 + num2;
                result.add(sum);
                break;
            case "-" :
                sum = num1 - num2;
                result.add(sum);
                break;
            case "*" :
                sum = num1 * num2;
                result.add(sum);
                break;
            case "/" :
                sum = num1 / num2;
                result.add(sum);
                break;
            default :
                System.out.println("해당 연산기호는 사용이 불가능합니다.");
                error = 1;
        }
    }
}
