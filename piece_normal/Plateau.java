import javax.swing.JOptionPane;

/**
 *  Classe Plateau pour créer un plateau de 9x9 cases (81 cases)
 */

public class Plateau {
    // [][] : représente les coordonnées x et y pour chaque case
    // "new Case [9][9]" : va créer un plateau de 100 cases (via new) : 10 cases (0-9) en abscisse, et 10 en ordonnée
    private Case[][] plateau = new Case[9][9];
    private Reserve[] reserveJoueur = {null, new Reserve(1), new Reserve(2)};
    
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
            plateau[2][i].setP(new Pion(1)); // à remplacer par "new Pion" par la suite
            plateau[6][i].setP(new Pion(2));
        }
        // positionnement des pièces Roi et Général de Jade :
        plateau[0][4].setP(new Roi(1));
        plateau[8][4].setP(new Roi(2));

        // positionnement des pièces Général d'Or :
        plateau[0][3].setP(new GeneralOr(1));
        plateau[0][5].setP(new GeneralOr(1));
        plateau[8][3].setP(new GeneralOr(2));
        plateau[8][5].setP(new GeneralOr(2));

        // positionnement des pièces Général d'Argent :
        plateau[0][2].setP(new GeneralArgent(1));
        plateau[0][6].setP(new GeneralArgent(1));
        plateau[8][2].setP(new GeneralArgent(2));
        plateau[8][6].setP(new GeneralArgent(2));

        // positionnement des pièces Cavalier :
        plateau[0][1].setP(new Cavalier(1));
        plateau[0][7].setP(new Cavalier(1));
        plateau[8][1].setP(new Cavalier(2));
        plateau[8][7].setP(new Cavalier(2));

        // positionnement des pièces Lancier :
        plateau[0][0].setP(new Lancier(1));
        plateau[0][8].setP(new Lancier(1));
        plateau[8][0].setP(new Lancier(2));
        plateau[8][8].setP(new Lancier(2));

        // positionnement des pièces Fou :
        plateau[1][7].setP(new Fou(1));
        plateau[7][1].setP(new Fou(2));

        // positionnement des pièces Tour :
        plateau[1][1].setP(new Tour(1));
        plateau[7][7].setP(new Tour(2));
    }

    // déterminer une case du plateau (sélectionnée) :
    public Case getCase(int x, int y) {
        return plateau[x][y];
    }

    // Retourne la réserve du joueur 1 ou du joueur 2
    public Reserve getReserve(int i) {
        return reserveJoueur[i];
    }

    public void deplacementPiece(Case posDepart, Case posArrivee, int tour) throws Exception {
        Piece pieceDepart = posDepart.getP();
        // Vérifie que le joueur ne va déplacer que ses propres pièces durant son tour (et qu'il effectue bien un déplacement)
        if (pieceDepart.getJoueur() == tour && (posDepart.getY() != posArrivee.getY() || posDepart.getX() != posArrivee.getX())) {
            if (pieceDepart.peutSeDeplacer(posDepart, posArrivee, this)) {
                try {
                    // Vérifie si le joueur 1 déplace une de ses pièces dans sa zone de promotion (cases 6, 7, 8)
                    if (posArrivee.getX() >= 6 && posDepart.getP().getJoueur() == 1) {
                        posDepart.getP().estPromue();
                    }

                    // Vérifie si le joueur 2 déplace une de ses pièces dans sa zone de promotion (cases 0, 1, 2)
                    if (posArrivee.getX() <= 2 && posDepart.getP().getJoueur() == 2) {
                        posdepart.getP().estPromue();
                    }
                } catch(Exception e) {}

                /* Vérifie si la case sur laquelle va se déplacer le joueur contient une pièce, et, le cas échéant, l'ajoute dans la 
                réserve du joueur */
                if (posArrivee.getP() != null) {
                    if (posDepart.getP().getJoueur() != posArrivee.getP().getJoueur()) {
                        reserveJoueur[posDepart.getP().getJoueur()].ajouterPiece(posArrivee.getP()); 
                    }

                    // Vérifie si la case sur laquelle va se déplacer le joueur contient le roi adverse
                    if (posArrivee.getP().getNom().equals("Roi")) {
                        JOptionPane.showMessageDialog(null, "Joueur" + posDepart.getP().getJoueur() + "gagne !", "Fin de partie", 
                        JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }

            // Vide les cases de départ et d'arrivée, avant de placer la pièce déplacée sur la case d'arrivée
            posDepart.setP(null);
            posArrivee.setP(null);
            posArrivee.setP(pieceDepart);
            }

            else if (posDepart.getY() == ) {}
        } 

        
    }
}