import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SauvegarderGrille {
    

    public SauvegarderGrille(int[][] grille,String nomG) {

        int[] temp = new int[9];
        int temp2 = 0;
        
        try {
            File filename = new File("./grille/"+nomG+".gri");
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
            }catch (FileNotFoundException e) {// si fichier n existe pas 
                System.err.println("pas de fichier trouver : " + e.getMessage());
            } /* le reste */
            
        } catch (IOException e) {
            System.err.println(e.toString());
        }

    }
}