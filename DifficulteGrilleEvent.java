import javax.swing.JFrame;
import java.awt.event.*;

/**
 * La classe <code>DifficulteGrilleEvent</code> est utilisée pour récupérer les infos des boutons de la classe DifficulteGrille
 * 
 * @version 1.1
 * @author Alban Stelzle, Marcus Antoine
 */
public class DifficulteGrilleEvent implements ActionListener {
    private JFrame fenetre;
    private int[][] g;

    public DifficulteGrilleEvent(JFrame fen) {
        this.fenetre = fen;
        this.g = new int[9][9];
    }
/**
 * Récupère le texte d'un bouton est envoie une information différente en fonction de la difficulté dans la classe Grille 
 */
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