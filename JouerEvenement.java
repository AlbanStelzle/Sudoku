import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class JouerEvenement implements ActionListener {

private JFrame fenetre;

public JouerEvenement(JFrame window){
        this.fenetre=window;
}

public void actionPerformed(ActionEvent e){
        String nomButton = e.getActionCommand();

        if(nomButton.equals("JOUER SUR UNE MAP")) {


        }else if(nomButton.equals("CREER UNE GRILLE")) {
                
        }
        else if(nomButton.equals("RETOUR")) {
                fenetre.dispose();
                new AccueilMenu();
        }
}
}
