import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JouerMenu {

        public JouerMenu() {
                JFrame fenetre = new JFrame();
                JButton jouer1 = new JButton("JOUER SUR UNE MAP");
                JButton creer = new JButton("CREER UNE MAP");
                JButton retour = new JButton("RETOUR");
                JPanel panneau = new JPanel();
                JouerEvenement ctrl = new JouerEvenement(fenetre);
                panneau.setLayout(null);

                jouer1.setLocation(150, 100);
                creer.setLocation(150, 200);
                retour.setLocation(150, 300);

                jouer1.setSize(200, 20);
                creer.setSize(200, 20);
                retour.setSize(200, 20);

                jouer1.addActionListener(ctrl);
                creer.addActionListener(ctrl);
                retour.addActionListener(ctrl);

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
