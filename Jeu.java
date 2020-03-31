import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Color;

import java.text.NumberFormat;

public class Jeu {
    private JButton button = new JButton();
    private int[][] g;
    private int statut;

    public Jeu(int[][] grille) {
        this.button.setText("Sauvegarder");
        this.g = grille;
        this.statut = 1;
    }

    public void Jouer() {
        JFrame fenetre = new JFrame();
        GridBagLayout gestionnaire = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel panneau2 = new JPanel();
        JPanel panneau = new JPanel();

        JFormattedTextField[][] caseJ = new JFormattedTextField[9][9];


        for (int i = 0; i < 9; i++) {
            for (int y = 0; y < 9; y++) {
                gbc.gridx = i;
                gbc.gridy = y;

                caseJ[i][y] = new JFormattedTextField(NumberFormat.getIntegerInstance());
                caseJ[i][y].setDocument(new JTextFieldLimit(1));

                if (this.g[i][y] == 0) {
                    caseJ[i][y].setText("");
                    caseJ[i][y].setForeground(Color.BLUE);

                } else {
                    caseJ[i][y].setText("" + this.g[i][y]);

                }
                caseJ[i][y].setPreferredSize(new Dimension(70, 70));
                caseJ[i][y].setHorizontalAlignment(JFormattedTextField.CENTER);

                if (this.g[i][y] != 0 ||( this.g[i][y] == 0 && (this.statut >0))) {
                    caseJ[i][y].setEditable(false);
                }

                panneau.add(caseJ[i][y], gbc);
            }
        }

        panneau.setLayout(new GridLayout(9, 9));
        JeuEvent event = new JeuEvent(caseJ, fenetre);

        this.button.addActionListener(event);
        panneau2.setLayout(gestionnaire);
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panneau2.add(panneau, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panneau2.add(this.button, gbc);

        fenetre.add(panneau2);
        fenetre.setVisible(true);
        fenetre.setSize(800, 800);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
