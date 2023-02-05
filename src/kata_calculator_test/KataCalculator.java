package kata_calculator_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KataCalculator {
	private static Number calculate(Number firstNumber, String operationType, Number secondNumber) {
        if (firstNumber.type.equals(secondNumber.type)) {
            switch (operationType) {
                case "+":
                    return firstNumber.add(secondNumber);
                case "-":
                    return firstNumber.sub(secondNumber);
                case "*":
                    return firstNumber.mul(secondNumber);
                case "/":
                    return firstNumber.div(secondNumber);
                default:
                    throw new RuntimeException("Неизвестная операция");
            }
        } else {
            throw new RuntimeException("Разные типы цифр");
        }
    }

    public static void main(String[] args) {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        while (true) {
            try {
            	userInput = bufferReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("Неверный ввод");
            }

            String[] expression = userInput.split("\\s+");

            if (expression.length != 3) {
                throw new RuntimeException("Неверный формат выражения");
            }

            Number firstNumber = NumberFactory.getNumber(expression[0]);
            String operationType = expression[1];
            Number secondNumber = NumberFactory.getNumber(expression[2]);

            Number calculationResult = calculate(firstNumber, operationType, secondNumber);

            System.out.println(calculationResult);
        }
    }
}
