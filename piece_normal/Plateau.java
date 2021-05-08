/**
 *  Classe Plateau pour créer un plateau de 9x9 cases (81 cases)
 */

public class Plateau {
    // [][] : représente les coordonnées x et y pour chaque case
    // "new Case [9][9]" : va créer un plateau de 81 cases (via new)
    private Case[][] plateau = new Case[9][9];
    
    // Constructeur :
    public Plateau() {
        /* initialisation du plateau (via boucles : 1 première pour les lignes
         puis une seconde pour les colonnes (qui se déclenche pour chaque i)) */
        for(int i = 0; i < plateau.length; i++) {
            for(int j = 0; j < plateau[i].length; j++) {
                plateau[i][j] = new Case(i, j); // créé un objet plateau à partir de Case
            }
        }

        // positionnement des pièces sur le plateau :
        // positionnement des pions sur le plateau
        for(int i = 0; i < 9; i++) {
            // [i] car i va parcourir toutes les colonnes de la ligne 2 et comme "i" s'incrémente de 0 à 9
            plateau[2][i].setP(Piece p); // à remplacer par "new Pion" par la suite
            plateau[6][i].setP(Piece p);
        }
        // positionnement des pièces Roi et Général de Jade :
        plateau[0][4].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[8][4].setP(Piece p); // à remplacer par "new ..." par la suite

        // positionnement des pièces Général d'Or :
        plateau[0][3].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[0][5].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[8][3].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[8][5].setP(Piece p); // à remplacer par "new ..." par la suite

        // positionnement des pièces Général d'Argent :
        plateau[0][2].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[0][6].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[8][2].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[8][6].setP(Piece p); // à remplacer par "new ..." par la suite

        // positionnement des pièces Cavalier :
        plateau[0][1].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[0][7].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[8][1].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[8][7].setP(Piece p); // à remplacer par "new ..." par la suite

        // positionnement des pièces Lancier :
        plateau[0][0].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[0][8].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[8][0].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[8][8].setP(Piece p); // à remplacer par "new ..." par la suite

        // positionnement des pièces Fou :
        plateau[1][7].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[7][1].setP(Piece p); // à remplacer par "new ..." par la suite

        // positionnement des pièces Tour :
        plateau[1][1].setP(Piece p); // à remplacer par "new ..." par la suite
        plateau[7][7].setP(Piece p); // à remplacer par "new ..." par la suite

        // déterminer une case du plateau (sélectionnée) :
        public Case getCase(int x, int y) {
            return plateau[x][y];
        }

        // Méthode pour déterminer le déplacement d'une pièce 
    }
}