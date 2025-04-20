import java.util.*;

public class GeneradorLetras {
    //static y final debido a que no se modificara el contenido de estos arreglos
    private static final List<Character> LETRAS_NORMALES = Arrays.asList(
            'A', 'E', 'I', 'O', 'U', 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L',
            'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'
    );

    private static final List<Character> LETRAS_EXPERTAS = Arrays.asList(
            'Á','A', 'É','E', 'Í','I', 'Ó','O', 'Ú','U', 'Ñ','N', 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K',
            'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'
    );

    public static List<Character> generarLetras(int cantidad, int experto) {
        Random random = new Random();
        List<Character> letrasGeneradas = new ArrayList<>();
        List<Character> fuente = new ArrayList<>();
        if (experto == 1){
            fuente = LETRAS_NORMALES;
        }
        else if (experto == 2){
            fuente = LETRAS_EXPERTAS;
        }

        for (int i = 0; i < cantidad; i++) {
            letrasGeneradas.add(fuente.get(random.nextInt(fuente.size())));
        }

        return letrasGeneradas;
    }
}