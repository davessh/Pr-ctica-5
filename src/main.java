public class main {
    public static void main(String[] args) {

        System.out.println("prueba"); //Prueba para ver si funciona el método
        Diccionario d = new Diccionario();
        String s= "hola";
        int a= d.calcularPuntajePalabra(s); //Deberia de calcular el valor de la palabra
        System.out.println(a);
    }
}
