import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuJouerPrincipal {

        public MenuJouerPrincipal() {
                JFrame fenetre = new JFrame();
                JLabel titre = new JLabel("MENU PRINCIPAL");
                Font policeTitre = new Font("Arial", Font.BOLD, 20);

                JButton jouer1 = new JButton("JOUER SUR UNE GRILLE");
                JButton creer = new JButton("CREER UNE GRILLE");
                JButton retour = new JButton("RETOUR");
                JPanel panneau = new JPanel();
                panneau.setLayout(null);

                titre.setFont(policeTitre);
                titre.setHorizontalAlignment(JLabel.CENTER);

                titre.setLocation(0, 50);
                jouer1.setLocation(150, 100);
                creer.setLocation(150, 200);
                retour.setLocation(150, 300);

                titre.setSize(500, 40);
                jouer1.setSize(200, 40);
                creer.setSize(200, 40);
                retour.setSize(200, 40);
                MenuJouerPrincipalEvent ctrl = new MenuJouerPrincipalEvent(fenetre);

                jouer1.addActionListener(ctrl);
                creer.addActionListener(ctrl);
                retour.addActionListener(ctrl);

                panneau.add(titre);
                panneau.add(jouer1);
                panneau.add(creer);
                panneau.add(retour);
                panneau.setSize(fenetre.getWidth(), fenetre.getHeight());

                fenetre.add(panneau);
                fenetre.setSize(500, 500);
                fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fenetre.setVisible(true);

        }
}
