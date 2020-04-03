import java.awt.event.*;
import javax.swing.JFrame;

public class SelectModeEvent implements ActionListener {
    private JFrame fenetre;
    private String nomFichier;
    private int[][] grille = new int[9][9];
    private int[][] grilleF = new int[9][9];

    public SelectModeEvent(JFrame fen, String filename) {
        this.fenetre = fen;
        this.nomFichier = filename;
    }

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
            this.grille= new LectureGrille(this.nomFichier).read();
            new Jeu(this.grille,this.nomFichier).Jouer();
        }
    }

}