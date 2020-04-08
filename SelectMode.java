import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

/**
 * La classe <code>SelectMode</code> est utilisée pour proposer au joueur le
 * mode qu'il veut pour la résolution de la grille
 * 
 * @version 1.1
 * @author Alban Stelzle, Marcus Antoine
 */
public class SelectMode {
    /**
     * Constructeur prenant un nom de Fichier
     * 
     * @param nomFichier String
     */
    public SelectMode(String nomFichier) {
        JFrame fenetre = new JFrame();
        JButton automatique = new JButton("AUTOMATIQUE");
        JButton manuel = new JButton("MANUEL");
        JPanel panneau = new JPanel();
        JLabel titre = new JLabel("SELECTIONNEZ UN MODE");
        Font policeTitre = new Font("Arial", Font.BOLD, 20);
        SelectModeEvent ctrl = new SelectModeEvent(fenetre, nomFichier);
        panneau.setLayout(null);

        titre.setFont(policeTitre);
        titre.setHorizontalAlignment(JLabel.CENTER);

        titre.setLocation(0, 50);
        automatique.setLocation(150, 150);
        manuel.setLocation(150, 300);

        titre.setSize(500, 40);
        automatique.setSize(200, 40);
        manuel.setSize(200, 40);

        automatique.addActionListener(ctrl);
        manuel.addActionListener(ctrl);

        panneau.add(titre);
        panneau.add(automatique);
        panneau.add(manuel);
        panneau.setSize(fenetre.getWidth(), fenetre.getHeight());

        fenetre.add(panneau);
        fenetre.setSize(500, 500);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }
}