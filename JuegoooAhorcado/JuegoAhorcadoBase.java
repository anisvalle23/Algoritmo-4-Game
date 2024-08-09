
package Lab4;

abstract class JuegoAhorcadoBase implements JuegoAhorcado {

    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos;
    
    public abstract String actualizarPalabraActual(char letra);
    
    public abstract boolean verificarLetra(char letra);
    
    public abstract boolean hasGanado();
}
    
    
