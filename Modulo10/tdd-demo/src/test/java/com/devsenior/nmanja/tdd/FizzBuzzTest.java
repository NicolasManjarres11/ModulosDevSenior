package com.devsenior.nmanja.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
    
    @Test
    @DisplayName("Retona FizzBuzz si es múltiplo de 3 y de 5")
    public void testReturnFizzBuzzIfFactor3And5(){

        var object = new FizzBuzz();

        var result1 = object.getValue(15);
        var result2 = object.getValue(30);

        assertEquals("FizzBuzz", result1);
        assertEquals("FizzBuzz", result2);

        

    }

    @Test
    @DisplayName("Retona Fizz si es múltiplo de 3")
    public void testReturnFizzIfFactor3(){

        var object = new FizzBuzz();

        var result1 = object.getValue(3);
        var result2 = object.getValue(6);

        assertEquals("Fizz", result1);
        assertEquals("Fizz", result2);

        

    }
    @Test
    @DisplayName("Retona Buzz si es múltiplo de 5")
    public void testReturnBuzzIfFactor5(){

        var object = new FizzBuzz();

        var result1 = object.getValue(5);
        var result2 = object.getValue(10);

        assertEquals("Buzz", result1);
        assertEquals("Buzz", result2);

        

    }
    @Test

    @DisplayName("Retona el número si no cumple ninguna condicion")
    public void testReturnNumberIfNotFactorOf3Or5(){

        var object = new FizzBuzz();

        var result1 = object.getValue(7);
        var result2 = object.getValue(13);

        assertEquals("7", result1);
        assertEquals("13", result2);

        

    }

    @Test

    @DisplayName("Retona 'Error' si el número es negativo")
    public void testReturnErrorIfNumberIsNegative(){

        var object = new FizzBuzz();

        var result1 = object.getValue(-7);
        var result2 = object.getValue(-13);

        assertEquals("Error", result1);
        assertEquals("Error", result2);

        

    }

}
