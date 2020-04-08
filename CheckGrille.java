/**
 * La classe <code>CheckGrille</code> est utilisée pour vérifier si une grille remplie correctement les règles du sudoku en faisant appel à une méthode de la classe Grille
 * 
 * @version 1.1
 * @author Alban Stelzle, Marcus Antoine
 */
public class CheckGrille {
    private int[][] g;

    public CheckGrille(int[][] grille) {
        this.g = grille;
    }
/**
 * Méthode servant à corriger la grille en faisant appel à un autre classe Grille
 * @return un nombre, s'il est différent de 0 alors la grille est incorrecte.
 */
    public int Corriger() {
        int z = 0;
        Grille grille = new Grille(this.g);

        for (int nb = 1; nb <= 9; nb++) {
            for (int i = 0; i < 9; i++) {
                for (int y = 0; y < 9; y++) {
                    if (grille.verifTotale(i, y, nb)) {
                        z++;
                    }
                }
            }
        }
        return z;
    }
}