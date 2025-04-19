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
    private List<Character> letrasGeneradas;

    public MagoDeLasPalabras() {
        this.puntuaciones = new HashMap<>();
        this.palabrasUsadas = new HashSet<>();
        this.diccionario = new Diccionario();
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

    // Métodos de lógica del juego
    public void inicializarJugador(String nombre) {
        puntuaciones.put(nombre, 0);
    }

    public void generarLetras() {
        this.letrasGeneradas = GeneradorLetras.generarLetras(10);
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

    public void registrarPalabra(String jugador, String palabra) {
        if (!esPalabraUsada(palabra) && esPalabraValida(palabra)) {
            int puntos = obtenerPuntajePalabra(palabra);
            int totalActual = puntuaciones.get(jugador);
            puntuaciones.put(jugador, totalActual + puntos);
            palabrasUsadas.add(palabra);
        }
    }

    public void restarPuntos(String jugador, int puntos) {
        int totalActual = puntuaciones.get(jugador);
        puntuaciones.put(jugador, totalActual - puntos);
    }
}