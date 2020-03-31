import java.util.Random;

public class Grille {
    public int[][] tab;
    private int[][] tabResult;
    private int nbCaseVide; // nombre de case vide voulue

    public Grille(int nbCaseVide) {
        this.nbCaseVide = nbCaseVide;

        // Calcule la racine

        this.tab = new int[9][9];
        this.tabResult = new int[9][9];
    }

    public Grille(int[][] g) {


        this.tab = g;

    }
    
    public Grille(int[][] g,int nbCaseVide) {


        this.tab = g;

        this.nbCaseVide = nbCaseVide;

    }


    public int generateurAlea(int nb) { // génère un nombre aléatoire entre 0 et nb
        return (new Random().nextInt(nb));
    }

    public void remplissageGrille() { // génère la grille
            remplissageDiagonale();

            remplirCaseRestante(0, 3);

            supprCase();

        
    }

    public boolean verifTotale(int i, int y, int nb) { // vérifie si c'est possible de remplir la cellule
       
    return (verifLigne(i, nb) && verifCol(y, nb) && verifBox(i - i % 3, y - y % 3, nb)); // renvoie le booleen 
    }

    public void remplissageDiagonale() { // rempli la diagonale

        for (int i = 0; i < 9; i += 3) {

            // pour la diagonale avec des box, i->y
            remplirBox(i, i);
        }
    }

    public boolean verifBox(int ligneB, int colB, int nb) { // retourne faux si une boite contient nb
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                if (this.tab[ligneB + i][colB + y] == nb) {
                    return false;
                }
            }

        }
        return true; // retourne vrai s'il manque nb dans la box
    }

    public boolean verifLigne(int i, int nb) { // retourne faux si une ligne contient nb
        for (int y = 0; y < 9; y++) {
            if (this.tab[i][y] == nb) {
                return false;
            }

        }
        return true; // retourne vrai s'il manque nb dans la ligne
    }

    public boolean verifCol(int y, int nb) { // retourne faux si une colonne contient nb
        for (int i = 0; i < 9; i++) {
            if (this.tab[i][y] == nb) {
                return false;
            }

        }
        return true; // retourne vrai s'il manque nb dans la colone
    }

    public boolean remplirCaseRestante(int i, int y) { // rempli récursivement le reste des cases
        if (y >= 9 && i < 9 - 1) { // si y>=9 (colonne) alors on change de ligne
            y = 0;

            i = i + 1;

        }
        if (i >= 9 && y >= 9) {
            return true; 
        }

        if (i < 3) {
            if (y < 3) {
                y = 3;
            }
        } else if (i < 9 - 3) {
            if (y == (int) (i / 3) * 3) {

                y = y + 3;

            }
        } else {
            if (y == 9 - 3) {
                y = 0;

                i = i + 1;

                if (i >= 9) {
                    return true;
                }
            }
        }

        for (int nb = 1; nb <= 9; nb++) {
            if (verifTotale(i, y, nb)) { // vérifie si les lignes, colonnes et box respectent les règles
                this.tab[i][y] = nb;
                this.tabResult[i][y] = nb;
                if (remplirCaseRestante(i, y + 1)) {
                    return true;
                }

                this.tab[i][y] = 0;
                this.tabResult[i][y] = 0;
            }
        }
        return false; // fini de remplir les cases
    }

    public void remplirBox(int ligne, int col) { // rempli une case 3*3
        int nb;
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                do {
                    nb = generateurAlea(9) + 1; // +1 sinon ca fait de 0 à 8, voir supprCase()
                } while (!verifBox(ligne, col, nb));

                this.tab[ligne + i][col + y] = nb; // rempli la case de la grille du joueur
                this.tabResult[ligne + i][col + y] = nb; // rempli la case de la grille fini
            }
        }
    }

    public void supprCase() { // supprime les cases en fonction de la demande du programme (difficulté du jeu )
        int compt = this.nbCaseVide;
        int i = 0;
        int y = 0;
        while (compt != 0) {

            // prend les coord. de (i,y)
            i = generateurAlea(9); // génère les coord de 0 à 8
            y = generateurAlea(9);

            if (this.tab[i][y] != 0) {
                compt--;
                this.tab[i][y] = 0;
            }
        }
    }

    public int[][] envoieTableauJ() {
        return this.tab;
    }

    public int[][] envoieTableau() {
        return this.tabResult;
    }
}
