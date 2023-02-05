package kata_calculator_test;

import java.util.TreeMap;

public class RomanNumber extends Number {
	private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        map.put(0, "0");
    }

    RomanNumber(String number) {
        if (number.matches("^(X|IX|IV|V?I{0,3})$")) {
            this.number = toArabic(number);
            type = "roman";
        } else {
            throw new RuntimeException("Неверное число");
        }
    }

    RomanNumber(int number) {
        this.number = number;
        type = "roman";
    }

    private static String toRoman(int number) {
        int l =  map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }

    private static int toArabic(String roman) {
        if (roman.isEmpty()) return 0;
        if (roman.startsWith("X")) return 10 + toArabic(roman.substring(1));
        if (roman.startsWith("IX")) return 9 + toArabic(roman.substring(2));
        if (roman.startsWith("V")) return 5 + toArabic(roman.substring(1));
        if (roman.startsWith("IV")) return 4 + toArabic(roman.substring(2));
        if (roman.startsWith("I")) return 1 + toArabic(roman.substring(1));
        throw new RuntimeException("Неверное значение");
    }

    @Override
    public String toString() { return toRoman(number); }
}
