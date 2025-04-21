public class Jugador {
    private String nombre;
    private int puntos;

    /**
     * Constructor de la clase Jugador.
     * Inicializa el nombre del jugador y establece su puntaje en 0.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
    }

    // Métodos getter y setter para el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getter y setter para los puntos
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Suma una cantidad de puntos al total del jugador.
     */
    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }

    /**
     * Resta una cantidad de puntos del total del jugador.
     */
    public void quitarPuntos(int puntos) {
        this.puntos -= puntos;
    }
}

