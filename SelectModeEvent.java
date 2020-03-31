import java.awt.event.*;
import javax.swing.JFrame;

public class SelectModeEvent implements ActionListener {
    private JFrame fenetre;
    private String nomFichier;

    public SelectModeEvent(JFrame fen, String filename) {
        this.fenetre = fen;
        this.nomFichier = filename;
    }

    public void actionPerformed(ActionEvent e) {
        String button;
        button = e.getActionCommand();
        if (button == "AUTOMATIQUE") {


        } else if (button == "MANUEL") {

    }

}
}