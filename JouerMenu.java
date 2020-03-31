import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class JouerMenu {

        public JouerMenu() {
                JFrame fenetre = new JFrame();
                JButton jouer = new JButton("JOUER SUR UNE MAP");
                JButton creer = new JButton("CREER UNE MAP");
                JButton retour = new JButton("RETOUR");
                JPanel panneau = new JPanel();
                JLabel titre = new JLabel("MENU PRINCIPAL");
                Font policeTitre = new Font("Arial", Font.BOLD, 20);
                JouerEvenement ctrl = new JouerEvenement(fenetre);
                panneau.setLayout(null);

                titre.setFont(policeTitre);
                titre.setHorizontalAlignment(JLabel.CENTER);

                titre.setLocation(150, 50);
                jouer.setLocation(150, 100);
                creer.setLocation(150, 200);
                retour.setLocation(150, 300);

                titre.setSize(200, 20);
                jouer.setSize(200, 20);
                creer.setSize(200, 20);
                retour.setSize(200, 20);

                jouer.addActionListener(ctrl);
                creer.addActionListener(ctrl);
                retour.addActionListener(ctrl);

                panneau.add(titre);
                panneau.add(jouer);
                panneau.add(creer);
                panneau.add(retour);
                panneau.setSize(fenetre.getWidth(), fenetre.getHeight());

                fenetre.add(panneau);
                fenetre.setSize(500, 500);
                fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fenetre.setVisible(true);

        }
}
