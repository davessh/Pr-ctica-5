import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class MagoDeLasPalabras {
    private HashMap<String, Integer> puntuaciones;
    private HashSet<String> palabrasUsadas;
    private int numeroDeJugadores;
    private int dificultad;
    private int rondaActual;
    private static final int TOTAL_RONDAS = 3;
    private Diccionario diccionario;
    private List<Character> letrasGeneradas;
    private ArrayList<String> nombresJugadores;

    public MagoDeLasPalabras() {
        this.puntuaciones = new HashMap<>();
        this.palabrasUsadas = new HashSet<>();
        this.diccionario = new Diccionario();
        this.rondaActual = 1;
        this.nombresJugadores = new ArrayList<>();
        diccionario.cargarDesdeArchivo("palabras.txt");
    }

    // Getters y setters
    public void setNumeroDeJugadores(int numeroDeJugadores) {
        this.numeroDeJugadores = numeroDeJugadores;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getNumeroDeJugadores() {
        return numeroDeJugadores;
    }

    public int getDificultad() {
        return dificultad;
    }

    public HashMap<String, Integer> getPuntuaciones() {
        return puntuaciones;
    }

    public HashSet<String> getPalabrasUsadas() {
        return palabrasUsadas;
    }

    public List<Character> getLetrasGeneradas() {
        return letrasGeneradas;
    }

    public int getRondaActual() {
        return rondaActual;
    }

    public ArrayList<String> getNombresJugadores() {
        return nombresJugadores;
    }

    public boolean juegoTerminado() {
        return rondaActual > TOTAL_RONDAS;
    }

    public void inicializarJugador(String nombre) {
        puntuaciones.put(nombre, 0);
        nombresJugadores.add(nombre);
    }

    public void generarLetras(int dificultad) {
        this.letrasGeneradas = GeneradorLetras.generarLetras(10, dificultad);
    }

    public boolean esPalabraUsada(String palabra) {
        return palabrasUsadas.contains(palabra);
    }

    public boolean esPalabraValida(String palabra) {
        return diccionario.contienePalabra(palabra);
    }

    public int obtenerPuntajePalabra(String palabra) {
        return diccionario.obtenerPuntaje(palabra);
    }

    public boolean registrarPalabra(String jugador, String palabra) {
        if (!esPalabraUsada(palabra) && esPalabraValida(palabra)) {
            int puntos = obtenerPuntajePalabra(palabra);
            int totalActual = puntuaciones.get(jugador);
            puntuaciones.put(jugador, totalActual + puntos);
            palabrasUsadas.add(palabra);
            return true;
        }
        return false;
    }

    public void restarPuntos(String jugador, int puntos) {
        int totalActual = puntuaciones.get(jugador);
        puntuaciones.put(jugador, Math.max(0, totalActual - puntos));
    }

    public void iniciarNuevaRonda() {
        rondaActual++;
        palabrasUsadas.clear();
        generarLetras(dificultad);
    }

    public String determinarGanador() {
        if (puntuaciones.isEmpty()) {
            return "No hay jugadores";
        }

        int maxPuntuacion = puntuaciones.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        long cantidadGanadores = puntuaciones.values().stream()
                .filter(puntos -> puntos == maxPuntuacion)
                .count();

        if (cantidadGanadores > 1) {
            return "EMPATE";
        } else {
            return puntuaciones.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxPuntuacion)
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse("No hay ganador");
        }
    }
}
