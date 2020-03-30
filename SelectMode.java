import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectMode{

    public SelectMode(String nomFichier){
        JFrame fenetre = new JFrame();
        JButton automatique = new JButton("AUTOMATIQUE");
        JButton manuel = new JButton("MANUEL");
        JPanel panneau = new JPanel();

        panneau.setLayout(null);

        automatique.setLocation(150, 100);
        manuel.setLocation(150, 300);

        automatique.setSize(200, 20);
        manuel.setSize(200, 20);
        automatique.addActionListener(ctrl);
        manuel.addActionListener(ctrl);

        panneau.add(automatique);
        panneau.add(manuel);
        panneau.setSize(fenetre.getWidth(), fenetre.getHeight());

        fenetre.add(panneau);
        fenetre.setSize(500, 500);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }
}