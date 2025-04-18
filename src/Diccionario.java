import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Diccionario {
    private HashMap<String, Integer> palabras;
    public Diccionario() {
        palabras = new HashMap<>();
    }

    public void cargarDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim().toLowerCase();
                if (!linea.isEmpty()) {
                    palabras.put(linea, calcularPuntajePalabra(linea));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
        }
    }


    public int calcularPuntajePalabra(String palabra){
        int puntos = 0;
        String vocales = "aeiouAEIOU";
        return palabra.chars()
                .filter(Character::isLetter)
                .map(c -> vocales.indexOf(c) != -1 ? 5 : 3)
                .sum();
    }

    public boolean contienePalabra(String palabra) {
        return palabras.containsKey(palabra.toLowerCase());
    }

    public int obtenerPuntaje(String palabra) {
        return palabras.getOrDefault(palabra.toLowerCase(), 0);//si no encuentra la palabra devuelve 0
    }
}
