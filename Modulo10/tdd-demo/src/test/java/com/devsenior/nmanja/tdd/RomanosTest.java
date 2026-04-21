package com.devsenior.nmanja.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RomanosTest {

    private RomanNumbers converter;


    @BeforeEach
    void setUp(){
        converter = new RomanNumbers();
    } 

    @Test
    @DisplayName("Retorno de numeros romanos del 1 al 3")
    public void TestReturnSimpleSymbols(){



        assertEquals("I", converter.GetRomanNumber(1));
        assertEquals("II", converter.GetRomanNumber(2));
        assertEquals("III", converter.GetRomanNumber(3));


    }

    @Test
    @DisplayName("Retorno de numeros romanos múltiplos de 5 o 10")
    public void TestReturnChangeSymbols(){




        assertEquals("V", converter.GetRomanNumber(5));
        assertEquals("X", converter.GetRomanNumber(10));
        assertEquals("L", converter.GetRomanNumber(50));
        assertEquals("C", converter.GetRomanNumber(100));
        assertEquals("D", converter.GetRomanNumber(500));
        assertEquals("M", converter.GetRomanNumber(1000));


    }

    @Test
    @DisplayName("Retorno de numeros romanos en casos de adición")
    public void TestReturnRomanNumberInAddCases(){


        assertEquals("VI", converter.GetRomanNumber(6));
        assertEquals("XV", converter.GetRomanNumber(15));
        assertEquals("MDL", converter.GetRomanNumber(1550));



    }

    @Test
    @DisplayName("Retorno de numeros romanos en casos de sustracción")
    public void TestReturnRomanNumberInSubtractionCases(){



        assertEquals("IV", converter.GetRomanNumber(4));
        assertEquals("IX", converter.GetRomanNumber(9));
        assertEquals("XL", converter.GetRomanNumber(40));
        assertEquals("XC", converter.GetRomanNumber(90));
        assertEquals("CD", converter.GetRomanNumber(400));
        assertEquals("CM", converter.GetRomanNumber(900));



    }

    @Test
    @DisplayName("Retorno de numeros romanos en casos complejos")
    public void TestReturnRomanNumberInComplexCases(){




        assertEquals("XIV", converter.GetRomanNumber(14));
        assertEquals("XLIV", converter.GetRomanNumber(44));
        assertEquals("XCIX", converter.GetRomanNumber(99));
        assertEquals("MCMXCIV", converter.GetRomanNumber(1994));
        assertEquals("MMMCMXCIX", converter.GetRomanNumber(3999));



    }
    @Test
    @DisplayName("Retorno de excepxion")
    public void TestReturnException(){





        assertThrows(IllegalArgumentException.class, () -> converter.GetRomanNumber(0));
        assertThrows(IllegalArgumentException.class, () -> converter.GetRomanNumber(-1));
        assertThrows(IllegalArgumentException.class, () -> converter.GetRomanNumber(4000));





    }
    
}
