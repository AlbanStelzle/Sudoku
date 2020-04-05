import javax.swing.JFrame;
import java.awt.event.*;

public class TypeGrilleEvent implements ActionListener {
    private JFrame fenetre;

    public TypeGrilleEvent(JFrame fen) {
        this.fenetre = fen;
    }

    public void actionPerformed(ActionEvent e) {
        String nomButton = e.getActionCommand();

        if (nomButton.equals("GRILLE ALEATOIRE")) {
            fenetre.dispose();

            new DifficulteGrille();

        } else if (nomButton.equals("GRILLE MANUELLE")) {
            fenetre.dispose();
            new Jeu("Manuel").Jouer();

        } else if (nomButton.equals("RETOUR")) {
            fenetre.dispose();
            new MenuJouerPrincipal();
        }
    }
}