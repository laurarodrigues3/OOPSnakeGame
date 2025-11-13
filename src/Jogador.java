import java.io.Serializable;

/**    Classe que representa um jogador.
 @version 1.1 10/05/2024
 @author Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */

public class Jogador implements Serializable {

    private String nomeJogador;
    private int pontos;

    /**
     * Construtor para definir o nome do jogador.
     * @param nomeJogador O nome do jogador.
     */
    public Jogador(String nomeJogador) {
        this.nomeJogador=nomeJogador;
        this.pontos=0;

    }

    public int getPontos(){
        return this.pontos;
    }

    public void atualizaPontos(){
        this.pontos = pontos + 1;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }
}