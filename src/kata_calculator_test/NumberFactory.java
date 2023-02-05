package kata_calculator_test;

public class NumberFactory {
    static Number getNumber(String number) {
        Number num;

        try {
            num = new ArabicNumber(number);
        } catch (NumberFormatException e) {
            num = new RomanNumber(number);
        }

        if (num.number < 1 || num.number > 10) {
            throw new RuntimeException("Неподходящее число");
        }

        return num;
    }

    static Number setNumber(int number, String type) {
        switch (type) {
            case "arabic":
                return new ArabicNumber(number);
            case "roman":
                return new RomanNumber(number);
            default:
                throw new RuntimeException("Неизвестный тип цифр");
        }
    }
}
