import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * La classe <code>JeuEvent</code> est utilisée pour gérer l'utilisation des boutons de la classe MenuJouerPrincipal
 * 
 * @version 1.1
 * @author Alban Stelzle, Marcus Antoine
 */
public class MenuJouerPrincipalEvent implements ActionListener {

        private JFrame fenetre;

/**
 * Constructeur qui récupère la fenêtre
 * @param window JFrame
 */
        public MenuJouerPrincipalEvent(JFrame window) {
                this.fenetre = window;
        }
        /**
         * Méthode qui gère les évènements en fonction du texte du bouton utilisé
         */
        public void actionPerformed(ActionEvent e) {
                String nomButton = e.getActionCommand();

                if (nomButton.equals("JOUER SUR UNE GRILLE")) {
                        JFileChooser choix = new JFileChooser("./grille");
                        choix.setDialogTitle("Choisis ta grille");

                        choix.setAcceptAllFileFilterUsed(false);
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier grille (*.gri)", "gri");
                        choix.setFileFilter(filter);
                        int retour = choix.showOpenDialog(null);
                        if (retour == JFileChooser.APPROVE_OPTION) {
                                // un fichier a été choisi (sortie par OK)
                                String nomG = choix.getSelectedFile().getName();
                                nomG = nomG.substring(0, nomG.lastIndexOf('.'));
                                fenetre.dispose();
                                new SelectMode(nomG);
                        }

                } else if (nomButton.equals("CREER UNE GRILLE")) {
                        fenetre.dispose();
                        new TypeGrille();
                } else if (nomButton.equals("RETOUR")) {
                        fenetre.dispose();
                        new AccueilMenu();
                }
        }
}
