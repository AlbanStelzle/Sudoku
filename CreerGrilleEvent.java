import java.awt.event.*;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreerGrilleEvent implements ActionListener {
    private  int[][] g = new int[9][9];
    private JFormattedTextField[][] text = new JFormattedTextField[9][9];
    private JFrame fenetre;

    public CreerGrilleEvent( JFormattedTextField[][] grille,  JFrame fen) {
        this.text = grille;
        this.fenetre = fen;
    }

    public void actionPerformed( ActionEvent e) {
        String button;
        String[] difficulte = { "Facile", "Moyen", "Difficile" };

        int z = 0;
        button = e.getActionCommand();

        if (button == "Sauvegarder") {
            for (int i = 0; i < 9; i++) {
                for (int y = 0; y < 9; y++) {
                    if (this.text[i][y].getText().equals("")) { // si la grille est pas rempli alors rempli par 0 les
                                                                // cases vides
                        this.g[i][y] = 0;

                    } else {
                        this.g[i][y] = Integer.parseInt(this.text[i][y].getText());

                    }
                }
            }

            z= new CheckGrille(this.g).Corriger();

            if (z != 0) {
                JOptionPane.showMessageDialog(null, "Votre grille est incorrecte.Veuillez la modifier", "Erreur",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {

                new Grille(this.g).supprCase();

                String nomGrille = JOptionPane.showInputDialog(null, "Veuillez donner un nom à votre grille.",
                        "Nommez votre grille", JOptionPane.QUESTION_MESSAGE);

                int choixPopup = JOptionPane.showOptionDialog(null, "Choisissez une difficulté", " Difficulté",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, difficulte,
                        difficulte[2]);
                int nbCaseVide=0;

                if(choixPopup==0){
                    nbCaseVide=40;
                }else if(choixPopup==1){
                    nbCaseVide=50;
                }else if(choixPopup==2){
                    nbCaseVide=60;
                }
                new Grille(this.g,nbCaseVide).supprCase();
                new SauvegarderGrille(this.g, nomGrille);

                JOptionPane.showMessageDialog(null, "Sauvegarde terminée ! Retour au menu principal.",
                        "Sauvegarde terminée !", JOptionPane.QUESTION_MESSAGE);

                this.fenetre.dispose();

                new MenuJouerPrincipal();
            }
        }

    }

}