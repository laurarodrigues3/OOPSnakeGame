import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] Args) throws IOException {

        MusicaJogo musica = new MusicaJogo("Snake3Music.wav");
        musica.play();

        SwingUtilities.invokeLater(() -> {
            Menu menu = null;
            try {
                menu = new Menu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            menu.mostrarMenu();
        });
    }
}
