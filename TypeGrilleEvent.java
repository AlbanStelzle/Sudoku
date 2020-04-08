import javax.swing.JFrame;
import java.awt.event.*;

/**
 * La classe <code>TypeGrilleEvent</code> est utilisée pour gérer l'utilisation
 * des boutons et d'envoyer sur la classe jeu en fonction du choix du joueur
 * 
 * @version 1.1
 * @author Alban Stelzle, Marcus Antoine
 */
public class TypeGrilleEvent implements ActionListener {
    private JFrame fenetre;

    /**
     * Constructeur
     * 
     * @param fen
     */
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