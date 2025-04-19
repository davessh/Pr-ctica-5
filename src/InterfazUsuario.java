import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

public class InterfazUsuario {
    private Scanner scanner;
    private MagoDeLasPalabras juego;

    public InterfazUsuario() {
        this.scanner = new Scanner(System.in);
        this.juego = new MagoDeLasPalabras();
    }

    public void iniciar() {
        mostrarMenu();
        inicializarJugadores();
        mostrarPalabrasGeneradas();
        realizarJugadas();
    }

    private void mostrarMenu() {
        System.out.println("\nMAGO DE LAS PALABRAS");

        int numeroDeJugadores;
        do {
            System.out.print("Ingrese el número de jugadores (2 a 4): ");
            numeroDeJugadores = scanner.nextInt();
        } while (numeroDeJugadores < 2 || numeroDeJugadores > 4);
        juego.setNumeroDeJugadores(numeroDeJugadores);

        System.out.println("Seleccione la dificultad:");
        System.out.println("1) Normal");
        System.out.println("2) Experto");

        int dificultad;
        do {
            dificultad = scanner.nextInt();
        } while (dificultad != 1 && dificultad != 2);
        juego.setDificultad(dificultad);
    }

    private void inicializarJugadores() {
        scanner.nextLine(); // Limpiar buffer
        for (int i = 1; i <= juego.getNumeroDeJugadores(); i++) {
            System.out.print("Nombre del jugador " + i + ": ");
            String nombre = scanner.nextLine();
            juego.inicializarJugador(nombre);
        }
    }

    private void mostrarPalabrasGeneradas() {
        juego.generarLetras();
        List<Character> letras = juego.getLetrasGeneradas();

        System.out.print("Letras generadas: ");
        for (char letra : letras) {
            System.out.print(letra + " ");
        }
        System.out.println();
    }

    private void realizarJugadas() {
        System.out.println("\nSelecciona tu jugada:");
        System.out.println("1) Poner palabra");
        System.out.println("2) Pasar turno");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (opcion == 1) {
            for (String jugador : juego.getPuntuaciones().keySet()) {
                System.out.print(jugador + ", ingresa una palabra: ");
                String palabra = scanner.nextLine().toLowerCase();

                if (juego.esPalabraUsada(palabra)) {
                    System.out.println("Esa palabra ya fue usada. No se otorgan puntos.");
                } else if (juego.esPalabraValida(palabra)) {
                    int puntos = juego.obtenerPuntajePalabra(palabra);
                    System.out.println("Palabra válida. Puntos obtenidos: " + puntos);
                    juego.registrarPalabra(jugador, palabra);
                } else {
                    System.out.println("Palabra no encontrada en el diccionario. Se restan puntos.");
                    // Implementar lógica para restar puntos según dificultad
                    juego.restarPuntos(jugador, 1); // Ejemplo simple
                }
            }
        }

        // Mostrar resultados parciales
        mostrarPuntuaciones();
    }

    private void mostrarPuntuaciones() {
        System.out.println("\nPuntuaciones actuales:");
        for (String jugador : juego.getPuntuaciones().keySet()) {
            System.out.println(jugador + ": " + juego.getPuntuaciones().get(jugador) + " puntos");
        }
    }
}