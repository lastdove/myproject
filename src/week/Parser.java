package week;

import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator();

    public Parser parseFirstNum(String firstInput) throws Exception {
        if(!Pattern.matches(NUMBER_REG, firstInput)) {
            throw new BadInputException("정수값을 똑디 입력하세요");
        }
        calculator.setFirstNumber(Integer.parseInt(firstInput));
        return this;
    }

    public Parser parseSecondNum(String secondInput) throws Exception {
        if(!Pattern.matches(NUMBER_REG, secondInput)) {
            throw new BadInputException("정수값을 똑디 입력하세요");
        }
        calculator.setSecondNumber(Integer.parseInt(secondInput));
        return this;
    }

    public Parser parseOperator(String operationInput) throws Exception {
        if(!Pattern.matches(OPERATION_REG, operationInput)) {
            throw new BadInputException("연산기호를 똑디 입력하세요.");
        }

        switch(operationInput) {
            case "+" : calculator.setOperation(new AddOperation()); break;
            case "-" : calculator.setOperation(new SubstractOperation()); break;
            case "*" : calculator.setOperation(new MultiplyOperation()); break;
            case "/" : calculator.setOperation(new DivideOperation()); break;
        }
        return this;
    }

    public double executeCalculator() {
        return calculator.calculate();
    }
}