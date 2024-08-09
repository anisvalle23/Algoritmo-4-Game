
package Lab4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{
    JFrame juego = new JFrame();
     JButton ingresar = new JButton("Ingresar");
     JLabel titulo = new JLabel("Ahorcado Azar");
     JLabel label = new JLabel("Ingrese la palabra");
     JTextField palabraField = new JTextField();
     JTextArea campo = new JTextArea();
    private static ArrayList<String> palabrasDisponibles = new ArrayList<>();
    private Random random = new Random();
    private boolean mensajeMostrado = false;
    
    
    public JuegoAhorcadoAzar(){
        super();
        this.palabraSecreta = inicializarPalabraSecreta();
        this.palabraActual = "_".repeat(palabraSecreta.length());
        this.intentos = 5;
    }
    
    public String inicializarPalabraSecreta(){
        if (palabrasDisponibles.isEmpty()) {
            return "";
        }
        int indice = random.nextInt(palabrasDisponibles.size());
        return palabrasDisponibles.get(indice);
    }
    
     public void jugar(){
        juego.setTitle("Ahorcado Azar");
        juego.getContentPane().setLayout(null);
        juego.getContentPane().setBackground(Color.WHITE);
        juego.setBounds(400, 0, 100, 90);
        
        titulo.setBounds(70,40,200,30);
        titulo.setFont(new java.awt.Font("Trebuchet MS", 1, 24));
        titulo.setForeground(Color.PINK);
        label.setBounds(40,100,200,30);
        palabraField.setBounds(40,130,200,40);
        juego.add(titulo);
        juego.add(label);
        juego.add(palabraField);
        
        ingresar.setBounds(40,210,200,40);
        ingresar.addActionListener(e -> Ingresar());
        juego.add(ingresar);
        
        campo.setBounds(100,300,200,40);
        juego.add(campo);

       
        juego.setSize(300,400);
        juego.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        juego.setLocationRelativeTo(null);
        juego.setVisible(true); 
    }
    
    
    public void Ingresar(){
        if(palabraField.getText().length()<2){
                if(!palabraField.getText().isEmpty()){
                    if(verificarLetra(palabraField.getText().charAt(0))){
                        campo.setText(actualizarPalabraActual(palabraField.getText().charAt(0)));
                        JOptionPane.showMessageDialog(null, "has acertado");
                        if(hasGanado()){
                            JOptionPane.showMessageDialog(null, "Ganaste");
                            System.exit(0);

                        }
                        
                    }else{
                      JOptionPane.showMessageDialog(null, "has fallado, te quedan "+intentos+" intentos");
                      if(intentos==0){
                           JOptionPane.showMessageDialog(null, "perdiste");
                           System.exit(0);

                      }
                    }
                    actualizarPalabraActual(palabraField.getText().charAt(0));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "necesita ingresar una letra");
                }
            }else{
            JOptionPane.showMessageDialog(null, "Solo se puede ingresar una letra");
            }
    }
    
    
    public String actualizarPalabraActual(char letra) {
        StringBuilder nuevaPalabra = new StringBuilder(palabraActual);
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.toLowerCase().charAt(i) == letra) {
                nuevaPalabra.setCharAt(i, letra);
            }
        }
        palabraActual = nuevaPalabra.toString();
        return palabraActual;
    }
    
    public boolean verificarLetra(char letra) {
        boolean letraCorrecta = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.toLowerCase().charAt(i) == letra) {
                letraCorrecta = true;
            }
        }
        if (!letraCorrecta) {
            intentos--;
        }
        return letraCorrecta;
    }
    
    public boolean hasGanado() {
        return palabraSecreta.equals(palabraActual);
    }
    
    public static void agregarPalabras(String[] palabrasNuevas) {
        
        for (String palabra : palabrasNuevas) {
            palabrasDisponibles.add(palabra.trim());
            
            System.out.println("Palabra agregada: " + palabra); 
        }
    }
    
}
