import javax.swing.JFrame;
import java.awt.event.*;

/**
 * La classe <code>AccueilEvenement</code> est utilisée pour savoir si l'utilisateur clique sur jouer ou quitte le logiciel
 * 
 * @version 1.1
 * @author Alban Stelzle, Marcus Antoine
 */
public class AccueilEvenement implements ActionListener {


private JFrame fenetre;
/**
 * Constructeur récupérant la fenetre pour pouvoir la fermer
 * @param window
 */
public AccueilEvenement(JFrame window){
        this.fenetre=window;
}
/**
 * récupère les actions et fais en fonction du texte du bouton
 */
public void actionPerformed(ActionEvent e){
        String nomButton = e.getActionCommand();

        if(nomButton.equals("JOUER")) {
                fenetre.dispose();
                new MenuJouerPrincipal();

        }else if(nomButton.equals("QUITTER")) {
                System.exit(0);

        }
}
}
