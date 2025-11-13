
/**    Classe que representa os settings do jogo.
 @version 1.2 19/05/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel GonÃ§alves
 */

public class Settings {

    private int dificuldade;
    private int tamanhoSnake;
    private MovimentoSnake movimentoSnake;
    private int tamanhoArena;

    /**
     * Construtor da classe Settings.
     * Inicializa as configurações com valores padrão.
     */
    public Settings(){
        this.dificuldade = 0;
        this.tamanhoSnake = 0;
        this.movimentoSnake = null;
        this.tamanhoArena = 0;
    }

    public int getDificuldade() {
        return this.dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getTamanhoSnake() {
        return this.tamanhoSnake;
    }

    public void setTamanhoSnake(int tamanhoSnake) {
        this.tamanhoSnake = tamanhoSnake;
    }

    public MovimentoSnake getMovimentoSnake() {
        return this.movimentoSnake;
    }

    public void setMovimentoSnake(MovimentoSnake movimentoSnake) {
        this.movimentoSnake = movimentoSnake;
    }

    public int getTamanhoArena() {
        return this.tamanhoArena;
    }

    public void setTamanhoArena(int tamanhoArena) {
        this.tamanhoArena = tamanhoArena;
    }
}