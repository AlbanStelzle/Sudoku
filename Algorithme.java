public class Algorithme {
	private int[][] g;

	public Algorithme(int[][] g) {
		this.g = g;

	}

	public boolean automatique() {

		for (int i = 0; i < 9; i++) {
			for (int y = 0; y < 9; y++) {

				if (this.g[i][y] == 0) { // Si la case est vide alors on essaye les possibilités

					for (int nb = 1; nb <= 9; nb++) {
						if (new Grille(this.g).verifTotale(i, y, nb)) { // On vérifie si ca respecte la règle du sodu

							this.g[i][y] = nb; // On écrit entre nb dans this.g[i][y]
							if (automatique()) { // On lance la récursivité

								return true;

							} else { // Si aucune solution trouvée alors on remet 0 pour réessayé

								this.g[i][y] = 0;
							}
						}
					}
					return false; // La grille n'est pas complètement remplie 
				}
			}
		}
		return true; // La grille est complétée, on renvoie true pour afficher la suite du programme.
	}

	public int[][] getGrid() { // Envoie la grille finale pour l'utilisateur.
		return this.g;

	}

}
