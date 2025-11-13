import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que representa o ranking dos melhores jogadores do jogo.
 * @version 1.3 21/05/2024
 * @autor Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */
public class Ranking implements Serializable {

    private ArrayList<Jogador> melhoresJogadores;
    private String fileName;

    /**
     * Construtor da classe Ranking.
     * @param fileName O nome do arquivo onde o ranking será guardado.
     * @throws IOException Exceção de entrada e saída.
     */
    public Ranking(String fileName) throws IOException {
        verificaFicheiro(fileName);
        this.fileName = fileName;
        this.melhoresJogadores = new ArrayList<>();
        loadRanking();
    }

    /**
     * Método para verificar se o arquivo de ranking existe. Caso não exista, cria um novo.
     * @param fileName O nome do arquivo de ranking.
     * @throws IOException Exceção de entrada e saída.
     */
    public void verificaFicheiro(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    /**
     * Método para adicionar a pontuação de um novo jogador ao ranking.
     * @param novoJogador O jogador a ser adicionado.
     */
    public void addPontuacao(Jogador novoJogador) {
        melhoresJogadores.add(novoJogador);
        Collections.sort(melhoresJogadores, (j1, j2) -> j2.getPontos() - j1.getPontos());
        saveRanking();
    }

    /**
     * Método para carregar o ranking do arquivo.
     */
    public void loadRanking(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            melhoresJogadores = (ArrayList<Jogador>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de ranking não encontrado. Um novo será criado.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o ranking: " + e.getMessage());
        }

    }

    /**
     * Método para salvar o ranking atualizado no arquivo.
     */
    public void saveRanking(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(melhoresJogadores);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o ranking: " + e.getMessage());
        }
    }
    public ArrayList<Jogador> getMelhoresJogadores() {
        return melhoresJogadores;
    }



}
