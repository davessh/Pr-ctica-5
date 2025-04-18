import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

public class MagoDeLasPalabras {
    private HashMap<String, Integer> puntuaciones;
    private HashSet<String> palabrasUsadas;
    private int numeroDeJugadores;
    private int dificultad;
    private Diccionario diccionario;

    public MagoDeLasPalabras() {
        this.puntuaciones = new HashMap<>();
        this.palabrasUsadas = new HashSet<>();
        this.diccionario = new Diccionario();
        diccionario.cargarDesdeArchivo("palabras.txt");
        jugar();
    }

    private void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMAGO DE LAS PALABRAS");

        do {
            System.out.print("Ingrese el número de jugadores (2 a 4): ");
            numeroDeJugadores = sc.nextInt();
        } while (numeroDeJugadores < 2 || numeroDeJugadores > 4);

        System.out.println("Seleccione la dificultad:");
        System.out.println("1) Normal");
        System.out.println("2) Experto");

        do {
            dificultad = sc.nextInt();
        } while (dificultad != 1 && dificultad != 2);
    }

    private void inicializarJugadores() {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= numeroDeJugadores; i++) {
            System.out.print("Nombre del jugador " + i + ": ");
            String nombre = sc.next();
            puntuaciones.put(nombre, 0); // nombre de los jugadores identificador, puntos contenido
        }
    }

    private void mostrarPalabrasGeneradas() {
        List<Character> letras = GeneradorLetras.generarLetras(10);
        System.out.print("Letras generadas: ");
        for (char letra : letras) {
            System.out.print(letra + " ");
        }
    }

    private void jugar() {
        mostrarMenu();
        inicializarJugadores();
        mostrarPalabrasGeneradas();
        System.out.println("\nSelecciona tu jugada:");
        System.out.println("1) Poner palabra");
        System.out.println("2) Pasar turno");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if (opcion == 1) {
            Scanner palabraScanner = new Scanner(System.in);
            for (String jugador : puntuaciones.keySet()) {
                System.out.print(jugador + ", ingresa una palabra: ");
                String palabra = palabraScanner.nextLine().toLowerCase();
                if (palabrasUsadas.contains(palabra)) {
                    System.out.println("Esa palabra ya fue usada. No se otorgan puntos.");
                } else if (diccionario.contienePalabra(palabra)) {
                    int puntos = diccionario.obtenerPuntaje(palabra);
                    System.out.println("Palabra valida");
                    int total = puntuaciones.get(jugador) + puntos;
                    puntuaciones.put(jugador, total);
                    palabrasUsadas.add(palabra);
                } else {
                    System.out.println("Palabra no encontrada en el diccionario"); //se deben de restar puntos pendiente
                }
            }
        }
    }
}




