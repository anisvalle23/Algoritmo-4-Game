
package Lab4;

import javax.swing.JOptionPane;


public class MainJuego {

    public MainJuego(){
        
        Object[] options = {"Administrar Palabra","Ahorcado Fijo","Ahorcado Azar"};
        int opcion = JOptionPane.showOptionDialog(null, "Escoja una opcion", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (opcion == 0){
            System.out.println("Administrar Palabras");
        } else if (opcion == 1) {
              JuegoAhorcadoFijo fijo = new JuegoAhorcadoFijo("Gatito");
                fijo.jugar();
        } else if (opcion == 2) {
                JuegoAhorcadoAzar azar = new JuegoAhorcadoAzar();
                azar.jugar();
            }
    }
    
   
    public static void main(String[] args) {
        MainJuego inicio = new MainJuego();
    }
    
}
