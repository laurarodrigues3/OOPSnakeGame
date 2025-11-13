import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Classe responsável pela gestão da música do jogo.
 * @version 1.0 21/05/2024
 * @autor Laura Rodrigues, Lucas Galheto, Daniel Gonçalves
 */
public class MusicaJogo {
    private Clip clip;

    /**
     * Construtor da classe MusicaJogo.
     * @param filePath O caminho do arquivo de áudio a ser reproduzido.
     */
    public MusicaJogo(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicia a reprodução da música.
     */
    public void play() {
        if (clip != null) {
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the music
        }
    }

}