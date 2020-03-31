import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class JTextFieldLimit extends PlainDocument {

    private int limite;

    public JTextFieldLimit(int limit ) { // on définie la limite
        super();
        this.limite = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (getLength() + str.length() <= this.limite) {
            super.insertString(offset, str.substring(0,1), attr);
        }
    }
}