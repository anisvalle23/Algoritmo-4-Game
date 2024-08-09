package algoritmo.pkg4.game;

public abstract class JuegoAhorcadoBase {

    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos;

    public abstract String actualizarPalabraActual(char letra);

    public abstract boolean verificarLetra(char letra);

    public abstract boolean hasGanado();
}
