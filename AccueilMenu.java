import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccueilMenu {

public AccueilMenu(){
        JFrame fenetre = new JFrame();
        JButton jouer = new JButton("JOUER");
        JButton quitter = new JButton("QUITTER");
        JPanel panneau = new JPanel();
        AccueilEvenement ctrl = new AccueilEvenement(fenetre);
        panneau.setLayout(null);

        jouer.setLocation(150,100);
        quitter.setLocation(150,300);

        jouer.setSize(200,20);
        quitter.setSize(200,20);

        jouer.addActionListener(ctrl);
        quitter.addActionListener(ctrl);

        panneau.add(jouer);
        panneau.add(quitter);
        panneau.setSize(fenetre.getWidth(),fenetre.getHeight());

        fenetre.add(panneau);
        fenetre.setSize(500,500);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);

}
}
