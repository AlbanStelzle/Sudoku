import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Font;

public class CreerGrille {

    public CreerGrille() {
        JFrame fenetre = new JFrame();
        GridBagLayout gestionnaire = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel panneau2 = new JPanel();
        JPanel panneau = new JPanel();

        JFormattedTextField[][] caseJ = new JFormattedTextField[9][9];
        JButton button = new JButton("Sauvegarder");

        CreerGrilleEvent event = new CreerGrilleEvent(caseJ, fenetre);

        Font policeGrille = new Font("Arial", Font.BOLD, 15);

        for (int i = 0; i < 9; i++) {
            for (int y = 0; y < 9; y++) {
                gbc.gridx = i;
                gbc.gridy = y;

                caseJ[i][y] = new JFormattedTextField(NumberFormat.getIntegerInstance());
                caseJ[i][y].setDocument(new JTextFieldLimit(1));
                caseJ[i][y].setPreferredSize(new Dimension(70, 70));
                caseJ[i][y].setHorizontalAlignment(JFormattedTextField.CENTER);
                caseJ[i][y].setFont(policeGrille);

                panneau.add(caseJ[i][y], gbc);
            }
        }

        panneau.setLayout(new GridLayout(9, 9));

        button.addActionListener(event);
        panneau2.setLayout(gestionnaire);
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panneau2.add(panneau, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panneau2.add(button, gbc);

        fenetre.add(panneau2);
        fenetre.setVisible(true);
        fenetre.setSize(800, 800);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
