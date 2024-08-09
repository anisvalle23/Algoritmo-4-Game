
package Lab4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class AdminPalabrasSecretas implements ActionListener{
    private List<String> palabrasSecretas;
    JFrame juego = new JFrame();
    JLabel titulo = new JLabel("Administrador de Palabras");
    JButton agregar = new JButton ("Agregar Palabra");
    JButton cambiar = new JButton ("Cambiar Palabra Fija");
    JButton regresar = new JButton ("Regresar");
    String palabra = "gatito";
           
            
    public void jugar(){
        juego.setTitle("Administrar Palabras Secretas");
        juego.getContentPane().setLayout(null);
        juego.getContentPane().setBackground(Color.WHITE);
        juego.setBounds(400, 0, 100, 90);
        
        titulo.setBounds(25,40,250,20);
        titulo.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        juego.add(titulo);
        
        agregar.setBounds(50,100,200,40);
        agregar.setFont(new java.awt.Font("Trebuchet MS", 1, 15));
        agregar.setBackground(Color.pink);
        agregar.setForeground(Color.white);
        agregar.addActionListener(this);
        juego.add(agregar);

        
        cambiar.setBounds(50,200,200,40);
        cambiar.setFont(new java.awt.Font("Trebuchet MS", 1, 15));
        cambiar.setBackground(Color.pink);
        cambiar.setForeground(Color.white);
        cambiar.addActionListener(this);
        juego.add(cambiar);
        
        regresar.setBounds(50,300,200,40);
        regresar.addActionListener(this);
        juego.add(regresar);
        
        palabrasSecretas.add("pantalla"); 
        palabrasSecretas.add("perrito"); 
        palabrasSecretas.add("sistema"); 
        palabrasSecretas.add("ganador"); 
        palabrasSecretas.add("hola"); 
        
        juego.setSize(300,400);
        juego.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        juego.setLocationRelativeTo(null);
        juego.setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent evt){
         if (agregar==evt.getSource()){
            String palabraNueva = JOptionPane.showInputDialog(null, "Ingrese una palabra:");
            agregarPalabra(palabraNueva);
         }
         
         if (cambiar==evt.getSource()){
            String palabraFijaNueva = JOptionPane.showInputDialog(null, "Ingrese una palabra:"); 
            
         }
         if (regresar==evt.getSource()){
            MainJuego frame = new MainJuego(); 
           
         }
    }
    
    public AdminPalabrasSecretas() {
        palabrasSecretas = new ArrayList<>();
    }

    public void agregarPalabra(String palabra) {
        palabrasSecretas.add(palabra);
    }

    public String seleccionarPalabraAzar() {
        if (palabrasSecretas.isEmpty()) {
            System.out.println("No hay palabras secretas disponibles.");
            return "";
        }
        Random random = new Random();
        int indice = random.nextInt(palabrasSecretas.size());
        return palabrasSecretas.get(indice);
    }
}

