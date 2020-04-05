import java.awt.event.*;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JeuEvent implements ActionListener {
    private int[][] gJ = new int[9][9];
    private JFormattedTextField[][] text = new JFormattedTextField[9][9];
    private JFrame fenetre;
    private int statut;

    public JeuEvent(JFormattedTextField[][] grilleJ, JFrame fen ,int s) {
        this.text = grilleJ;
        this.fenetre = fen;
        this.statut = s;
    }

    public void ConversionGrille() {
        for (int i = 0; i < 9; i++) {
            for (int y = 0; y < 9; y++) {
                if (this.text[i][y].getText().equals("")) { // si la grille est pas rempli alors rempli par 0 les cases
                                                            // vides
                    this.gJ[i][y] = 0;

                } else {
                    this.gJ[i][y] = Integer.parseInt(this.text[i][y].getText());

                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        String button;
        int z = 0;
        button = e.getActionCommand();
        this.ConversionGrille();
        String[] difficulte = { "Facile", "Moyen", "Difficile" };

        if (button == "Sauvegarder" && this.statut == 1) {

            String nomGrille = JOptionPane.showInputDialog(null, "Veuillez donner un nom à votre grille.",
                    "Nommez votre grille", JOptionPane.QUESTION_MESSAGE);
            new SauvegarderGrille(this.gJ, nomGrille);
            JOptionPane.showMessageDialog(null, "Sauvegarde terminée ! Retour au menu principal.",
                    "Sauvegarde terminée !", JOptionPane.QUESTION_MESSAGE);
            this.fenetre.dispose();
            new MenuJouerPrincipal();

        }else if(button == "Sauvegarder" && this.statut == 2){
            

            z= new CheckGrille(this.gJ).Corriger();

            if (z != 0) {
                JOptionPane.showMessageDialog(null, "Votre grille est incorrecte.Veuillez la modifier", "Erreur",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {

                new Grille(this.gJ).supprCase();

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
                new Grille(this.gJ,nbCaseVide).supprCase();
                new SauvegarderGrille(this.gJ, nomGrille);

                JOptionPane.showMessageDialog(null, "Sauvegarde terminée ! Retour au menu principal.",
                        "Sauvegarde terminée !", JOptionPane.QUESTION_MESSAGE);

                this.fenetre.dispose();
                new MenuJouerPrincipal();
            }
        }
        
        if (button == "Go") {
            z = new CheckGrille(this.gJ).Corriger();
            if (z != 0) {
                JOptionPane.showMessageDialog(null, "Votre grille est incorrecte, corrigez la !", "Incorrect",
                        JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null,
                        "Félicitation vous avez réussi cette grille, retour au menu principal", "Bravo !",
                        JOptionPane.PLAIN_MESSAGE);
                this.fenetre.dispose();
                new MenuJouerPrincipal();
            }
        }
        if (button == "Retour au menu principal") {
            this.fenetre.dispose();
            new MenuJouerPrincipal();
        }

    }

}