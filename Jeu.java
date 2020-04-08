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

/**
 * La classe <code>Jeu</code> est utilisée pour jouer ou créer une grille
 * 
 * @version 1.1
 * @author Alban Stelzle, Marcus Antoine
 */
public class Jeu {
    private String nomG;
    private JButton button = new JButton();
    double t = 0;
    private int[][] g;
    private int statut;

    /**
     * Constructeur prenant qu'une grille
     * 
     * @param grille int[][]
     *
     */
    public Jeu(int[][] grille) {
        this.button.setText("Sauvegarder");
        this.g = grille;
        this.statut = 1;
    }

    /**
     * Constructeur prenant qu'une grille et un nom de grille
     * 
     * @param grille   int[][]
     * @param filename nom de grille
     */
    public Jeu(int[][] grille, String filename) {
        this.nomG = filename;
        this.button.setText("Go");
        this.g = grille;
        this.statut = 0;

    }

    /**
     * Constructeur prenant qu'une grille, un nom de grille et un double pour
     * afficher le timer
     * 
     * @param grille   int[][]
     * @param filename string
     * @param time     double
     */
    public Jeu(int[][] grille, String filename, double time) {
        this.nomG = filename;
        this.button.setText("Retour au menu principal");
        this.g = grille;
        this.statut = 0;
        this.t = time;

    }

    /**
     * Constructeur prenant qu'un nom de mode de jeu (manuel ou automatique)
     * 
     * @param mode
     */
    public Jeu(String mode) {
        this.statut = 2;
        this.g = new int[9][9];

        this.button.setText("Sauvegarder");

    }

    /**
     * Méthode qui affiche la grille au joueur, et en fonction du constructeur
     * utilisée, permet de jouer ou de créer une grille
     */
    public void Jouer() {
        JFrame fenetre = new JFrame();
        GridBagLayout gestionnaire = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel panneau2 = new JPanel();
        JPanel panneau = new JPanel();
        JPanel info = new JPanel();

        JFormattedTextField[][] caseJ = new JFormattedTextField[9][9];

        JLabel nomGrille = new JLabel(this.nomG);
        JLabel timer = new JLabel("Temps pour résoudre la grille : " + this.t + " seconde.");
        Font policeTitre = new Font("Arial", Font.BOLD, 20);
        Font policeGrille = new Font("Arial", Font.BOLD, 15);

        nomGrille.setFont(policeTitre);
        nomGrille.setHorizontalAlignment(JLabel.CENTER);
        info.add(nomGrille);

        if (this.t != 0) {
            info.add(timer);
        }

        fenetre.add(info, BorderLayout.NORTH);

        for (int i = 0; i < 9; i++) {
            for (int y = 0; y < 9; y++) {
                gbc.gridx = i;
                gbc.gridy = y;

                caseJ[i][y] = new JFormattedTextField(NumberFormat.getIntegerInstance());
                caseJ[i][y].setDocument(new JTextFieldLimit(1));
                caseJ[i][y].setFont(policeGrille);

                if (this.g[i][y] == 0) {
                    caseJ[i][y].setText("");
                    caseJ[i][y].setForeground(Color.BLUE);

                } else {
                    caseJ[i][y].setText("" + this.g[i][y]);

                }
                caseJ[i][y].setPreferredSize(new Dimension(70, 70));
                caseJ[i][y].setHorizontalAlignment(JFormattedTextField.CENTER);

                if (this.g[i][y] != 0 || (this.g[i][y] == 0 && this.statut == 1)) {
                    caseJ[i][y].setEditable(false);
                }

                panneau.add(caseJ[i][y], gbc);
            }
        }

        panneau.setLayout(new GridLayout(9, 9));
        DesignCase design = new DesignCase(caseJ);
        design.colorier();
        JeuEvent event = new JeuEvent(caseJ, fenetre, this.statut);

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
