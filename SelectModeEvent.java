import java.awt.event.*;
import javax.swing.JFrame;

public class SelectModeEvent implements ActionListener {
    private JFrame fenetre;

    public SelectModeEvent(JFrame fen) {
        this.fenetre = fen;
    }

    public void actionPerformed(ActionEvent e) {
        String button;
        button = e.getActionCommand();
        if (button == "AUTOMATIQUE") {


        } else if (button == "MANUEL") {

    }

}
}