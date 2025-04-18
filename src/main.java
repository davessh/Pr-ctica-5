public class main {
    public static void main(String[] args) {
        probarPalabras();
        }

        public static void probarPalabras(){
        Diccionario diccionario = new Diccionario();
        diccionario.cargarDesdeArchivo("palabras.txt");
        //diccionario.contienePalabra("david");
        String palabra = "palabra";
        if (diccionario.contienePalabra(palabra)) {
            int puntaje = diccionario.obtenerPuntaje(palabra);
            System.out.println("Palabra válida" + ": " + puntaje);
        } else {
            System.out.println("Palabra no encontrada");
        }
    }
}
