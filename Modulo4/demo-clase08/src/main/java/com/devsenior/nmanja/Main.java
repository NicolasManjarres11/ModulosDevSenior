package com.devsenior.nmanja;

import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {

        var logger = LoggerFactory.getLogger(Main.class);

        logger.debug("Iniciando la aplicacion");

        var recommendation = new RecomendationSystem();
        recommendation.loadMovies(getMovies());

        try (var sc = new Scanner(System.in)) {

            var exit = false;

            while (!exit) {

                System.out.println("""

                    ==================================
                    |  SISTEMA  DE  RECOMENCACIONES  |
                    =================================

                    1. Ver todas las peliculas por genero.
                    2. Calcular el total de votos por genero (pendiente)
                    3. Recomendar peliculas
                    0. Salir

                        """);


                var option = gerUserOption(sc, "Ingrese la opcion: ", 0, 3);
                
                switch (option) {

                    case 0:
                        exit = true;
                        break;
                    case 1:
                        logger.info("Iniciando la muestra de las peliculas por genero");
                        showMoviesByGenre(sc, recommendation);
                        break;
                    case 3:
                        logger.info("Iniciando la recomendacion de peliculas");
                        showMovieRecommendation(sc, recommendation);
                    default:
                        System.out.println("Opcion invalida");
                        logger.warn("Opcion invalida: {}", option);
                        waitEnter(sc);
                        break;
                }

            }

            System.out.println("¡¡Hasta la proximaaa!!");
            logger.debug("Saliendo de la aplicacion");

        }

    }

    private static void showMoviesByGenre(Scanner sc, RecomendationSystem recommendation) {
        
        //

        System.out.println("""
                =====================================
                |  Listado de peliculas por genero  |
                =====================================
                """);


        var genre = selectGenre(sc, recommendation);

        var movies = recommendation.getMoviesByGenre(genre);
        System.out.printf("\nLas peliculas de %s son:%n", genre);
        movies.forEach(System.out::println);

        
        waitEnter(sc);

    }

    public static String selectGenre(Scanner sc, RecomendationSystem recommendation){

        System.out.println("Seleccione el genero de su preferencia");
        var genres = recommendation.getGenres();
        for (int i = 0; i < genres.size(); i++) {
            System.out.println((i+1) + ". "+genres.get(i));
        }

        var option = gerUserOption(sc, "Seleccione el genero: ", 1, genres.size());
        return genres.get(--option);

    }

    private static void waitEnter(Scanner sc){
        System.out.println("\nPresiona ENTER para continuar.");
        sc.nextLine();
    }

    private static int gerUserOption(Scanner sc, String message, int min, int max){

       
        while(true){
        try {
            System.out.print(message);
            var option = Integer.valueOf(sc.nextLine());

            if(option <min || option > max){
                throw new InvalidOptionException();
            }

            return option;
        } catch (NumberFormatException | InvalidOptionException e) {
            System.out.println("Opcion invalida. Intenta de nuevo");
        }
    }
}

    private static void showMovieRecommendation(Scanner sc, RecomendationSystem recomendation){

        System.out.println("""
            ===========================
            |   Recomendar peliculas  |
            ===========================
            """);

        var genre = selectGenre(sc, recomendation);

        System.out.printf("\nLas recomendaciones para el genero %s es:%n", genre);

        recomendation.getRecommendationByGenre(genre)
                .forEach(System.out::println);

        waitEnter(sc);
    }



    private static Collection<Movie> getMovies() {

        return Set.of(
                new Movie("Extraction", "Acción", 4.1, 120),
                new Movie("Atomic Blonde", "Acción", 4.0, 180),
                new Movie("The Old Guard", "Acción", 3.9, 95),
                new Movie("Nobody", "Acción", 4.2, 140),
                new Movie("Rambo: Last Blood", "Acción", 3.8, 160),
                new Movie("Angel Has Fallen", "Acción", 4.0, 110),
                new Movie("6 Underground", "Acción", 3.7, 150),
                new Movie("Bloodshot", "Acción", 3.6, 130),
                new Movie("Peppermint", "Acción", 4.3, 200),
                new Movie("Hard Kill", "Acción", 3.5, 90),
                new Movie("Vacation Friends", "Comedia", 4.0, 180),
                new Movie("Game Over, Man!", "Comedia", 3.6, 95),
                new Movie("The Wrong Missy", "Comedia", 3.9, 120),
                new Movie("Murder Mystery", "Comedia", 4.2, 140),
                new Movie("Coffee & Kareem", "Comedia", 3.8, 160),
                new Movie("The Lovebirds", "Comedia", 4.1, 150),
                new Movie("Home Sweet Home Alone", "Comedia", 3.7, 100),
                new Movie("Superintelligence", "Comedia", 3.6, 110),
                new Movie("Jexi", "Comedia", 3.8, 200),
                new Movie("Bad Trip", "Comedia", 4.3, 140),
                new Movie("Pieces of a Woman", "Drama", 4.2, 170),
                new Movie("Hillbilly Elegy", "Drama", 4.1, 200),
                new Movie("The Last Letter from Your Lover", "Drama", 4.0, 140),
                new Movie("The Light Between Oceans", "Drama", 3.9, 150),
                new Movie("Penguin Bloom", "Drama", 4.1, 110),
                new Movie("The Dig", "Drama", 4.3, 190),
                new Movie("The Secret: Dare to Dream", "Drama", 3.8, 120),
                new Movie("Fatherhood", "Drama", 4.2, 200),
                new Movie("Finding You", "Drama", 3.7, 100),
                new Movie("Our Friend", "Drama", 4.0, 90),
                new Movie("Outside the Wire", "Ciencia Ficción", 4.1, 180),
                new Movie("Stowaway", "Ciencia Ficción", 4.0, 120),
                new Movie("Infinite", "Ciencia Ficción", 3.9, 150),
                new Movie("Code 8", "Ciencia Ficción", 4.2, 200),
                new Movie("Synchronic", "Ciencia Ficción", 3.8, 140),
                new Movie("Voyagers", "Ciencia Ficción", 3.7, 160),
                new Movie("Cosmic Sin", "Ciencia Ficción", 3.5, 110),
                new Movie("Archive", "Ciencia Ficción", 4.0, 100),
                new Movie("I Am Mother", "Ciencia Ficción", 4.3, 190),
                new Movie("The Midnight Sky", "Ciencia Ficción", 3.7, 130),
                new Movie("The Rental", "Terror", 4.0, 160),
                new Movie("Host", "Terror", 4.2, 110),
                new Movie("Relic", "Terror", 3.9, 95),
                new Movie("The Dark and the Wicked", "Terror", 4.1, 150),
                new Movie("Run", "Terror", 4.3, 190),
                new Movie("The Beach House", "Terror", 3.7, 100),
                new Movie("Come Play", "Terror", 4.0, 170),
                new Movie("No Escape", "Terror", 3.8, 140),
                new Movie("You Should Have Left", "Terror", 3.9, 200),
                new Movie("Amulet", "Terror", 3.6, 120));

    }

}
