public class CheckGrille {
    private int[][] g;

    public CheckGrille(int[][] grille) {
        this.g = grille;
    }

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