import java.awt.event.*;
import javax.swing.JFrame;

/**
 * La classe <code>SelectModeEvent</code> est utilisée pour gérer l'utilisation
 * des boutons et d'y utiliser un timer si le mode automatique est choisit
 * 
 * @version 1.1
 * @author Alban Stelzle, Marcus Antoine
 */
public class SelectModeEvent implements ActionListener {
    private JFrame fenetre;
    private String nomFichier;
    private int[][] grille = new int[9][9];
    private int[][] grilleF = new int[9][9];

    /**
     * Constructeur qui prend en paramètre la fenetre du joueur, et un nom de
     * fichier
     * 
     * @param fen
     * @param filename
     */
    public SelectModeEvent(JFrame fen, String filename) {
        this.fenetre = fen;
        this.nomFichier = filename;
    }

    /**
     * Récupère les actions sur la fenetre
     */
    public void actionPerformed(ActionEvent e) {
        String button;
        button = e.getActionCommand();
        if (button == "AUTOMATIQUE") {
            long t;
            long timeDepart = System.nanoTime();
            this.fenetre.dispose();
            this.grille = new LectureGrille(this.nomFichier).read();
            new Algorithme(this.grille).automatique();

            long timeFin = System.nanoTime();

            this.grilleF = new Algorithme(this.grille).getGrid();
            t = (timeFin - timeDepart);
            double tempstotal = t / Math.pow(10, 8);

            new Jeu(this.grilleF, this.nomFichier, tempstotal).Jouer();
        } else if (button == "MANUEL") {
            this.fenetre.dispose();
            this.grille = new LectureGrille(this.nomFichier).read();
            new Jeu(this.grille, this.nomFichier).Jouer();
        }
    }

}