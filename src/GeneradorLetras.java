import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorLetras {

    private static final char[] LETRAS = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public static List<Character> generarLetras(int cantidad) {
        List<Character> letrasGeneradas = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            char letra = LETRAS[random.nextInt(LETRAS.length)];
            letrasGeneradas.add(letra);

        }
        return letrasGeneradas;
    }
}