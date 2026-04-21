package com.devsenior.nmanja.tdd;

public class FizzBuzz {

    public String getValue(Integer i) {

        if (i <= 0) {
            return "Error";
        }

        var response = "";

/*         if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        } */
        if (i % 3 == 0) {
            response += "Fizz";
        }
        if (i % 5 == 0) {
            response += "Buzz";
        }

        if(!response.isBlank()){
            return response;
        }
        
        return i.toString();

    }
}
