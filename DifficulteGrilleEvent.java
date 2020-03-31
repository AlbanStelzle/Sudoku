import javax.swing.JFrame;
import java.awt.event.*;

public class DifficulteGrilleEvent implements ActionListener {
    private JFrame fenetre;
    private int[][] g;

    public DifficulteGrilleEvent(JFrame fen) {
        this.fenetre = fen;
        this.g = new int[9][9];
    }

    public void actionPerformed(ActionEvent e) {
        String nomButton = e.getActionCommand();
        if (nomButton.equals("FACILE")) {
            Grille grille = new Grille(40);

            fenetre.dispose();
            grille.remplissageGrille();
            this.g = grille.envoieTableauJ();
            new Jeu(this.g).Jouer();
        } else if (nomButton.equals("MOYEN")) {
            Grille grille = new Grille(50);

            fenetre.dispose();
            grille.remplissageGrille();

            this.g = grille.envoieTableauJ();
            new Jeu(this.g).Jouer();

        } else if (nomButton.equals("DIFFICILE")) {
            Grille grille = new Grille(60);

            fenetre.dispose();
            grille.remplissageGrille();

            this.g = grille.envoieTableauJ();
            new Jeu(this.g).Jouer();
        } else if (nomButton.equals("RETOUR")) {
            fenetre.dispose();
            new TypeGrille();
        }
    }
}