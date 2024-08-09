package Lab4;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class JuegoAhorcadoAzar extends JuegoAhorcadoBase {

    JFrame juego = new JFrame();
    JButton ingresar = new JButton("Ingresar");
    JButton regresar = new JButton("Regresar");
    JLabel titulo = new JLabel("Ahorcado Azar");
    JLabel label = new JLabel("Ingrese la palabra");
    JTextField palabraField = new JTextField();
    JTextArea campo = new JTextArea();
    private List<String> palabrasDisponibles;
    private Random random = new Random();
    public static String nuevaPala;

    public JuegoAhorcadoAzar(List<String> palabrasSecretas, String nuevaPala) {
        super();
        this.palabrasDisponibles = palabrasSecretas;
        this.nuevaPala = nuevaPala;

        // Imprime todas las palabras disponibles en la lista
        System.out.println("Palabras disponibles para jugar al azar:");
        for (String palabra : palabrasDisponibles) {
            System.out.println(palabra);
        }

        this.palabraSecreta = inicializarPalabraSecreta();
        if (this.palabraSecreta == null || this.palabraSecreta.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna palabra para jugar.");
            regresarAlMenuPrincipal();
        } else {
            System.out.println("Palabra seleccionada al azar: " + this.palabraSecreta);
        }

        this.palabraActual = "_".repeat(palabraSecreta.length());
        this.intentos = 5;
    }

    public String inicializarPalabraSecreta() {
        if (palabrasDisponibles.isEmpty()) {
            return "";
        }
        int indice = random.nextInt(palabrasDisponibles.size());
        return palabrasDisponibles.get(indice);
    }

    public void agregarPalabra(String palabra) {
        if (!palabrasDisponibles.contains(palabra)) {
            palabrasDisponibles.add(palabra);
        }
        System.out.println("Palabras disponibles para jugar al azar: " + palabrasDisponibles);
    }

    public List<String> getPalabrasDisponibles() {
        return palabrasDisponibles;
    }

    public void jugar() {
        juego.setTitle("Ahorcado Azar");
        juego.getContentPane().setLayout(null);
        juego.getContentPane().setBackground(Color.WHITE);
        juego.setBounds(400, 0, 100, 90);

        titulo.setBounds(70, 40, 200, 30);
        titulo.setFont(new java.awt.Font("Trebuchet MS", 1, 24));
        titulo.setForeground(Color.PINK);
        label.setBounds(40, 100, 200, 30);
        palabraField.setBounds(40, 130, 200, 40);
        juego.add(titulo);
        juego.add(label);
        juego.add(palabraField);

        ingresar.setBounds(40, 210, 200, 40);
        ingresar.addActionListener(e -> Ingresar());
        juego.add(ingresar);

        regresar.setBounds(40, 270, 200, 40);
        regresar.addActionListener(e -> regresarAlMenuPrincipal());
        juego.add(regresar);

        campo.setBounds(40, 330, 200, 40);
        campo.setEditable(false);
        juego.add(campo);

        juego.setSize(300, 450);
        juego.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        juego.setLocationRelativeTo(null);
        juego.setVisible(true);
    }

    public void Ingresar() {
        if (palabraField.getText().length() < 2) {
            if (!palabraField.getText().isEmpty()) {
                if (verificarLetra(palabraField.getText().charAt(0))) {
                    campo.setText(actualizarPalabraActual(palabraField.getText().charAt(0)));
                    JOptionPane.showMessageDialog(null, "has acertado");
                    if (hasGanado()) {
                        JOptionPane.showMessageDialog(null, "Ganaste");
                        regresarAlMenuPrincipal();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "has fallado, te quedan " + intentos + " intentos");
                    if (intentos == 0) {
                        JOptionPane.showMessageDialog(null, "perdiste");
                        regresarAlMenuPrincipal();
                    }
                }
                actualizarPalabraActual(palabraField.getText().charAt(0));

            } else {
                JOptionPane.showMessageDialog(null, "necesita ingresar una letra");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo se puede ingresar una letra");
        }
        palabraField.setText("");
    }

    public String actualizarPalabraActual(char letra) {
        StringBuilder nuevaPalabra = new StringBuilder(palabraActual);
        char letraMinuscula = Character.toLowerCase(letra);
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (Character.toLowerCase(palabraSecreta.charAt(i)) == letraMinuscula) {
                nuevaPalabra.setCharAt(i, palabraSecreta.charAt(i));
            }
        }
        palabraActual = nuevaPalabra.toString();
        return palabraActual;
    }

    public boolean verificarLetra(char letra) {
        boolean letraCorrecta = false;
        char letraMinuscula = Character.toLowerCase(letra);
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (Character.toLowerCase(palabraSecreta.charAt(i)) == letraMinuscula) {
                letraCorrecta = true;
            }
        }
        if (!letraCorrecta) {
            intentos--;
        }
        return letraCorrecta;
    }

    public void setNuevaPalabraSecreta(String nuevaPalabra) {
        this.palabraSecreta = nuevaPalabra;
        this.palabraActual = "_".repeat(nuevaPalabra.length());
    }

    public boolean hasGanado() {
        return palabraSecreta.equalsIgnoreCase(palabraActual);
    }

    private void regresarAlMenuPrincipal() {
        juego.dispose();
        new MainJuego(palabrasDisponibles, this, nuevaPala);
    }
}
