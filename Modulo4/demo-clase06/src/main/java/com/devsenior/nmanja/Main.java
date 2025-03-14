package com.devsenior.nmanja;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        exercsie03();
    }

    /*      """
            Descripción: Dado un archivo CSV con información de ventas, 
            procesa los datos para calcular las ventas totales por región.

            Pasos:

            Lee el archivo línea por línea usando Files.lines.
            Usa filter para eliminar líneas vacías o incorrectas.
            Divide los datos con split para acceder a las columnas necesarias.
            Usa map y collect para agrupar las ventas por región y calcular totales.
                """
                */

    private static void exercsie01(){

        try {
            var lines =Files.lines(Paths.get("ventas.csv"));

            var response = lines.filter(l -> !l.isEmpty()) //Strings
                    .skip(1)
                    .map(l -> l.split(",")) //Strings array
                    .collect(Collectors.groupingBy(

                    data -> data[0],
                    Collectors.summingInt(data -> Integer.parseInt(data[2]))

                    ));

                    response.forEach((region, total) -> System.out.println(region+": "+total));

        } catch (IOException e) {

            System.out.println("Error al procesar el archivo: "+e);

        }

    }

/*     Descripción: Dado un texto, utiliza Streams para contar las palabras 
    únicas y ordenar los resultados alfabéticamente.

Pasos:

Convierte el texto en una lista de palabras usando split.
Usa un Stream para eliminar caracteres especiales y normalizar las palabras (pasar a minúsculas).
Usa distinct para encontrar palabras únicas.
Colecciona las palabras en una lista ordenada.
Ejemplo:

Texto: "Java Streams son poderosos. Streams en Java son eficientes."
Resultado: [eficientes, en, java, poderosos, son, streams] */

    private static void exercsie02(){

        var text="Java Streams son poderosos. Streams en Java son eficientes.";

        var sortedWords = Arrays.stream(text.split(" "))
                .map(word -> word.replace('.','\0'))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedWords);

    }

/*     Descripción: Dada una lista de números enteros (de 1 a 10,000,000), usa Parallel Streams para encontrar todos los números primos.

Pasos:

Genera la lista con IntStream.range.
Filtra los números primos usando un método auxiliar.
Usa parallelStream para paralelizar la operación.
Guarda los números primos en una lista.
 */

    private static void exercsie03(){

        IntStream.rangeClosed(1, 10_000_000)
                        .map(Integer::valueOf)
                        .parallel()
                        .filter(Main::isPrime)
                        .forEach(System.out::println);

        
    }

    private static boolean isPrime(int number){

        if(number <=1){
            return false;
        }

        for (int i = 2; i < Math.sqrt(number); i++) {
            if(number % i == 0){
                return false;
            }
        }

        return true;
    }

    }
