import javax.swing.JFrame;
import java.awt.event.*;

public class AccueilEvenement implements ActionListener {


private JFrame fenetre;

public AccueilEvenement(JFrame window){
        this.fenetre=window;
}

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
