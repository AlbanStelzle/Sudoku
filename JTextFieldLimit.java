import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

/**
 * La classe <code>JTextFieldLimit</code> est utilisée pour limiter les JTextField de la grille visuel, pour le joueur, en la limitant avec un nombre donné possible 
 * 
 * @version 1.1
 * @author Alban Stelzle, Marcus Antoine
 */
public class JTextFieldLimit extends PlainDocument {

    private int limite;
/**
 * Constructeur qui récupère un nombre qui définira la limite
 * @param limit int
*/
    public JTextFieldLimit(int limit ) { // on définie la limite
        super();
        this.limite = limit;
    }

/**
 * Méthode qui réécrit sur le JTextField si on écrit trop de nombre dedans
 * 
 * @param offset int
 * @param str    String
 * @param attr  AttributeSet
 */
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (getLength() + str.length() <= this.limite) {
            super.insertString(offset, str.substring(0,1), attr);
        }
    }
}