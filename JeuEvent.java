import java.awt.event.*;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JeuEvent implements ActionListener {
    private int[][] gJ = new int[9][9];
    private JFormattedTextField[][] text = new JFormattedTextField[9][9];
    private JFrame fenetre;

    public JeuEvent(JFormattedTextField[][] grilleJ, JFrame fen) {
        this.text = grilleJ;
        this.fenetre=fen;
    }
    public void ConversionGrille(){
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
        button = e.getActionCommand();
        this.ConversionGrille();

        if (button == "Sauvegarder") {

            this.fenetre.dispose();
            new MenuJouerPrincipal();

        }
        if(button == "Go"){

        }
        if(button == "Retour au menu principal"){
            this.fenetre.dispose();
            new MenuJouerPrincipal();
        }

    }

}