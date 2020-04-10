import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * La classe <code>SauvegarderGrille</code> est utilisée pour sauvegarder une
 * grille dans un fichier .gri
 * 
 * @version 1.1
 * @author Alban Stelzle, Marcus Antoine
 */
public class SauvegarderGrille {

    /**
     * Constructeur qui récupère la grille et le nom de la grille
     * 
     * @param grille int[][]
     * @param nomG   String
     */
    public SauvegarderGrille(int[][] grille, String nomG) {

        int[] temp = new int[9];
        int temp2 = 0;

        try {
            File filename = new File("./grille/" + nomG + ".gri");
            File dossier = new File("./grille/");
            dossier.mkdir(); // si le dossier ./grille n'existe pas
            filename.createNewFile();
            /* écriture fichier */
            try {

                DataOutputStream file = new DataOutputStream(new FileOutputStream(filename));

                for (int i = 0; i < 9; i++) {
                    for (int y = 0; y < 9; y++) {
                        temp[y] = grille[i][y];

                    }
                    temp2 = Integer.parseInt(Arrays.toString(temp).replaceAll("\\[|\\]|,|\\s", ""));
                    file.writeInt(temp2);
                }
                file.close();
            } catch (FileNotFoundException e) {// si fichier n existe pas
                System.err.println("pas de fichier trouver : " + e.getMessage());
            } /* le reste */

        } catch (IOException e) {
            System.err.println(e.toString());
        }

    }
}