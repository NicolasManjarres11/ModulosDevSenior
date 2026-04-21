package com.devsenior.nmanja.tdd;

public class RomanNumbers {

    public String GetRomanNumber(Integer number) {



        if (number <= 0 || number > 3999){
            throw new IllegalArgumentException("El numero");
        }

        int[] values =     {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        var result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                result.append(symbols[i]);
                number -= values[i];
            }
        }
        return result.toString();
            





        
    }

}


