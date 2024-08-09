package Lab4;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MainJuego {

    private List<String> palabras;
    private JuegoAhorcadoAzar juegoAzar;
    public static String nuevaPala = "";

    public MainJuego(List<String> palabras, JuegoAhorcadoAzar juegoAzar, String nuevaPala) {
        this.palabras = palabras;
        this.juegoAzar = juegoAzar;
        this.nuevaPala = nuevaPala;
        mostrarMenu();
    }

    private void mostrarMenu() {

        for (String palabra : palabras) {
            if (!palabras.contains("perrito")) {
                palabras.add("perrito");
            }
            if (!palabras.contains("amore")) {
                palabras.add("amore");
            }
            if (!palabras.contains("software")) {
                palabras.add("software");
            }
            if (!palabras.contains("amapolas")) {
                palabras.add("amapolas");
            }
            if (!palabras.contains("saturno")) {
                palabras.add("saturno");
            }
        }

        if (!nuevaPala.trim().isEmpty()) {
            juegoAzar = new JuegoAhorcadoAzar(palabras, nuevaPala);
        } else {
            juegoAzar = new JuegoAhorcadoAzar(palabras, "gatito");
        }
        AdminPalabrasSecretas admin = new AdminPalabrasSecretas(juegoAzar, palabras);

        Object[] options = {"Administrar Palabra", "Ahorcado Fijo", "Ahorcado Azar"};
        int opcion = JOptionPane.showOptionDialog(null, "Escoja una opcion", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (opcion == 0) {
            admin.jugar();
        } else if (opcion == 1) {

            if (!nuevaPala.trim().isEmpty()) {
                JuegoAhorcadoFijo fijo = new JuegoAhorcadoFijo(nuevaPala, palabras);
                fijo.jugar();
            } else {
                JuegoAhorcadoFijo fijo = new JuegoAhorcadoFijo("gatito", palabras);
                fijo.jugar();
            }

        } else if (opcion == 2) {
            juegoAzar.jugar();
        }
    }

    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>();
        palabras.add("perrito");
        palabras.add("amore");
        palabras.add("software");
        palabras.add("amapolas");
        palabras.add("saturno");

        if (!nuevaPala.trim().isEmpty()) {
            JuegoAhorcadoAzar juegoAzar = new JuegoAhorcadoAzar(palabras, nuevaPala);
            new MainJuego(palabras, juegoAzar, nuevaPala);
        } else {
            JuegoAhorcadoAzar juegoAzar = new JuegoAhorcadoAzar(palabras, "gatito");
            new MainJuego(palabras, juegoAzar, "gatito");
        }

    }
}
