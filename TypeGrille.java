import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * La classe <code>TypeGrille</code> est utilisée pour afficher un menu et de choisir entre créer une grille Aleatoire ou une grille manuelle
 * 
 * @version 1.1
 * @author Alban Stelzle, Marcus Antoine
 */
public class TypeGrille {

    public TypeGrille() {
        JFrame fenetre = new JFrame();
        JButton alea = new JButton("GRILLE ALEATOIRE");
        JButton manuelle = new JButton("GRILLE MANUELLE");
        JButton retour = new JButton("RETOUR");
        JPanel panneau = new JPanel();
        TypeGrilleEvent ctrl = new TypeGrilleEvent(fenetre);
        panneau.setLayout(null);

        alea.setLocation(150, 100);
        manuelle.setLocation(150, 200);
        retour.setLocation(150, 300);

        alea.setSize(200, 40);
        manuelle.setSize(200, 40);
        retour.setSize(200, 40);

        alea.addActionListener(ctrl);
        manuelle.addActionListener(ctrl);
        retour.addActionListener(ctrl);

        panneau.add(alea);
        panneau.add(manuelle);
        panneau.add(retour);
        panneau.setSize(fenetre.getWidth(), fenetre.getHeight());

        fenetre.add(panneau);
        fenetre.setSize(500, 500);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);

    }
}
