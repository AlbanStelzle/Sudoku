import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import java.awt.Color;

public class DesignCase {

    private JFormattedTextField[][] caseJ;

    public DesignCase(JFormattedTextField[][] grille) {
        this.caseJ = grille;
    }

    public void colorier() {
        for (int i = 0; i < 9; i++) {
            for (int y = 0; y < 9; y++) {
                if (i == 0 && y == 0) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(4, 4, 1, 1, Color.BLACK));
                }

                if (i == 0 && y == 8) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(4, 1, 1, 4, Color.BLACK));

                }
                if (i == 8 && y == 0) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 4, 4, 1, Color.BLACK));

                }
                if (i == 8 && y == 8) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 4, Color.BLACK));

                }
                if (i != 0 && y != 0 && y != 8) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

                }
                if (i == 0 && y != 0 && y != 8) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(4, 1, 1, 1, Color.BLACK));

                }
                if (i == 8 && y != 0 && y != 8) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 1, Color.BLACK));

                }
                if (i != 0 && y == 0 && i != 8) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 4, 1, 1, Color.BLACK));

                }
                if (i != 0 && y == 8 && y != 0 && i != 8) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 4, Color.BLACK));

                }
                if ((i == 2 || i == 5) && (y == 0)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 4, 2, 1, Color.BLACK));
                }
                if ((i == 3 || i == 6) && (y == 0)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(2, 4, 1, 1, Color.BLACK));
                }

                if ((i == 2 || i == 5) && (y == 3 || y == 6)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 2, 2, 1, Color.BLACK));
                }
                if ((i == 3 || i == 6) && (y == 3 || y == 6)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(2, 2, 1, 1, Color.BLACK));
                }

                if ((i == 2 || i == 5) && (y == 2 || y == 5)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK));
                }
                if ((i == 3 || i == 6) && (y == 2 || y == 5)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(2, 1, 1, 2, Color.BLACK));
                }

                if ((i == 2 || i == 5) && y == 8) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 1, 2, 4, Color.BLACK));
                }
                if ((i == 3 || i == 6) && y == 8) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(2, 1, 1, 4, Color.BLACK));
                }

                if ((i == 0) && (y == 2 || y == 5)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(4, 1, 1, 2, Color.BLACK));
                }
                if ((i == 0) && (y == 3 || y == 6)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(4, 2, 1, 1, Color.BLACK));
                }

                if ((i == 8) && (y == 2 || y == 5)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 2, Color.BLACK));
                }
                if ((i == 8) && (y == 3 || y == 6)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 2, 4, 1, Color.BLACK));
                }

                if ((i == 2 || i == 5) && (y == 1 || y == 4 || y == 7)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 1, 2, 1, Color.BLACK));
                }
                if ((i == 3 || i == 6) && (y == 1 || y == 4 || y == 7)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(2, 1, 1, 1, Color.BLACK));
                }

                if ((i == 1 || i == 4 || i == 7) && (y == 2 || y == 5)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 2, Color.BLACK));
                }
                if ((i == 1 || i == 4 || i == 7) && (y == 3 || y == 6)) {
                    caseJ[i][y].setBorder(BorderFactory.createMatteBorder(1, 2, 1, 1, Color.BLACK));
                }
            }
        }
    }
}