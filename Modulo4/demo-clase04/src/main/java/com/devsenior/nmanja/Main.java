package com.devsenior.nmanja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        exercise08Stream();
    }

    //Clase interna

    private static class Empleado{

        private String nombre;
        private Integer salario;
        public Empleado(String nombre, Integer salario) {
            this.nombre = nombre;
            this.salario = salario;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public Integer getSalario() {
            return salario;
        }
        public void setSalario(Integer salario) {
            this.salario = salario;
        }

        

    }

    public static void exercise01() {

        /*     Tienes una lista de números enteros. Filtra los 
    números que son múltiplos de 3, 
    ordénalos en orden descendente 
    y multiplica cada número por 5. 
    Finalmente, recoge los resultados 
    en una lista y muéstralos por pantalla. */
        var numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        var multiplos3 = new ArrayList<Integer>();

        for (var n : numbers) {

            if (n % 3 == 0) {
                multiplos3.add(n);
            }

        }

        var ordenadosDesc = new ArrayList<Integer>();

        for (var n : multiplos3) {

            if (ordenadosDesc.isEmpty()) {
                ordenadosDesc.add(n);
            } else {
                for (int i = 0; i < ordenadosDesc.size(); i++) {
                    Integer valor = ordenadosDesc.get(i);
                    if (n > valor) {
                        ordenadosDesc.add(i, n);
                        break;
                    }
                    if (i == ordenadosDesc.size() - 1) {
                        ordenadosDesc.add(n);
                    }
                }
            }
        }

        var multiplicados5 = new ArrayList<Integer>();

        for (var n : ordenadosDesc) {
            multiplicados5.add(n * 5);
        }

        for (var n : multiplicados5) {
            System.out.println(n);
        }

    }

    public static void exercise01Stream(){

        var numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

/*         var stream = numbers.stream();

        var stream2 = stream.filter(n -> n % 3== 0);

        var stream3 = stream2.sorted(Comparator.reverseOrder()); //sorted ordena los elementos de un collector

        var stream4 = stream3.map(n -> n*5); //map coje cada elemento de una colección y le aplica la funcion que le especifiquemos

        stream4.forEach(n -> System.out.println(n));  */

        numbers.stream()
            .filter(n -> n % 3 == 0)
            .sorted(Comparator.reverseOrder())
            .map( n -> n*5)
            .forEach(n -> System.out.println(n));

    }

    public static void exercise02Stream(){

        var empleados = Arrays.asList(
        new Empleado("Juan", 60000),
        new Empleado("Ana", 50000),
        new Empleado("Carlos", 70000),
        new Empleado("Luis", 80000),
        new Empleado("Maria", 40000));

        var total = empleados.stream() //Se inicia flujo
            .filter(e -> e.getSalario() > 60000)
            .peek(e -> System.out.println(e))
            .count()
            ;
        
        System.out.println("El total de empleados que ganan mas de 60mil son : " +total);

    }

    public static void exercise03Stream(){

        var words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "kiwi");

        var groups = words.stream()
                                .collect(Collectors.groupingBy(String::length));
        groups.forEach((k,v) -> System.out.printf("Length: %d%n\t %s%n",
            k, 
            v.stream().collect(Collectors.joining(", ")))); 
            //joining junta los elementos colectados y los delimita con el parametro que se le coloque

    }

    public static void exercise04Stream(){

        /*Tienes una lista de números enteros. Calcula el 
        promedio de estos números utilizando Streams y muestra 
        el resultado por pantalla. Asegúrate de manejar el caso 
        donde la lista pueda estar vacía.*/

        var numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers2 = Arrays.asList();

/*         var stream = numbers.stream();
        var stream2 = stream.mapToInt(Integer::intValue).average().orElse(0.0);

        System.out.println(stream2); */

        var media = numbers.stream()
                .mapToInt(Integer::intValue) //Convierte de tipo Integer al tipo primitivo int al elemento dentro de la lista
                .average() //Saca el promedio
                /* .orElse(0.0) */; //Si no hay elementos en la lista, retorna este valor

                if(media.isPresent()){

                    System.out.println("El promedio de los numeros es: "+ media.getAsDouble());
                } else {
                    System.out.println("La lista esta vacia");
                }

                
        var media2 = numbers.stream()
                .collect(Collectors //Recoge todos los elementos de la lista
                        .averagingInt(Integer::intValue)); //Hace el promedio, validando que todo elemento de tipo integer dentro de la lista, ahora sea de tipo primitivo int

        var mediaEmpty = numbers2.stream()
                .mapToInt(Integer::intValue)
                .average();

                
        var mediaEmpty2 = numbers2.stream()
                .collect(Collectors
                        .averagingInt(Integer::intValue));

        if(mediaEmpty.isPresent()){

            System.out.println("El promedio de los numeros es: "+ mediaEmpty.getAsDouble());
        } else {
            System.out.println("La lista esta vacia");
        }


        System.out.println("Media 1: "+ media);
        System.out.println("Media 2: "+ media2);
        System.out.println("Media 1: "+ mediaEmpty);
        System.out.println("Media 2: "+ mediaEmpty2);
        

    }

    public static void exercise05Stream(){

        var words = Arrays.asList("Java", "Streams", "are", "powerful");

        var result = words.stream()
        .collect(Collectors.joining(" "));

        System.out.println(result);
    }

    private static class Venta{

        private String producto;
        private Integer cantidad;
        private Double precioUnidad;

        

        public Venta(String producto, Integer cantidad, Double precioUnidad) {
            this.producto = producto;
            this.cantidad = cantidad;
            this.precioUnidad = precioUnidad;
        }

        public String getProducto() {
            return producto;
        }

        public void setProducto(String producto) {
            this.producto = producto;
        }

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }

        public Double getPrecioUnidad() {
            return precioUnidad;
        }

        public void setPrecioUnidad(Double precioUnidad) {
            this.precioUnidad = precioUnidad;
        }



    }


    public static void exercise06Stream(){

        var ventas = Arrays.asList(
        new Venta("ProductoA", 10, 12.5),
        new Venta("ProductoB", 5, 25d),
        new Venta("ProductoA", 7, 15d),
        new Venta("ProductoC", 20, 4d),
        new Venta("ProductoB", 2, 30d));

        var result = ventas.stream()
            .filter(v -> v.getCantidad() * v.precioUnidad > 100)
            .collect(
                Collectors.groupingBy(
                    Venta::getProducto, 
                Collectors.summingDouble(v -> v.getCantidad() * v.getPrecioUnidad())));

        result.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(e -> System.out.println("Producto:" +e.getKey() + " Cantidad: "+e.getValue()));
    }

    public static void exercise07Stream(){

    }

    public static void exercise08Stream(){


        var texto = """
        Dado un párrafo de texto convierte el texto en una lista de palabras y elimina las palabras repetidas. 
        Luego agrupa las palabras por su longitud y muestra cada grupo de palabras junto con la cantidad de palabras en ese grupo.
        Finalmente encuentra la palabra más larga en el texto y muéstrala por pantalla.
        """;

        var palabrasUnicas = Stream.of(texto.replaceAll("\n", " ")
                .replace('.', '\0')
                .split(" "))
                .collect(Collectors.toSet());
        
        var palabrasPorLongitud = palabrasUnicas.stream()
                .collect(Collectors.groupingBy(String::length));

        palabrasPorLongitud.forEach((l,p) -> {
            System.out.printf("Longitud: %d, Palabras: %d %n",l,p.size());
        });

        var palabraMasLarga = palabrasPorLongitud.entrySet().stream()
                .sorted(Map.Entry.<Integer, List<String>>comparingByKey().reversed())
                .findFirst();

                if(palabraMasLarga.isPresent()){
                    palabraMasLarga.get().getValue().stream()
                    .findFirst()
                    .ifPresent(System.out::println);
                }

        

    }




}
