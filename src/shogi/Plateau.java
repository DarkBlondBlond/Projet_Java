package shogi;

import javax.swing.JOptionPane;

/**
 *  Classe Plateau pour creer un plateau de jeu
 */

public class Plateau {
	
    private Case[][] plateau = new Case[9][9];
    private Reserve[] reserveJoueur = {null, new Reserve(1), new Reserve(2)};
    
    /**
	 * Definit les attributs de la classe "Plateau" :
	 *  
	 * @param plateau plateau de jeu constitue comme un tableau a 2 dimensions de 9x9 objets de type "Case"
	 * 					(soit 100 cases : 10 cases (0-9) en abscisse, 10 cases en ordonnee)
	 * @param reserveJoueur objet de type "Reserve" qui constitue la reserve de chaque joueur
	 */
    
    // Constructeur
    public Plateau() {
        for(int i = 0; i < plateau.length; i++) {
            for(int j = 0; j < plateau[i].length; j++) {
                plateau[i][j] = new Case(i, j);
                
                /* Initialisation de l'objet "plateau" avec des objets de type "Case" via une premiere boucle 
                 * qui cree les lignes du plateau et une seconde boucle qui cree des colonnes au sein de 
                 * chacune de ces lignes */
            }
        }

        // Positionnement des differentes pieces sur le plateau :
        
        // Positionnement des pions sur le plateau
        for(int i = 0; i < 9; i++) {
            plateau[2][i].setP(new Pion(1)); 
            plateau[6][i].setP(new Pion(2));
            
            /* Position des pions joueur 1 : ligne 2
             * Position des pions joueur 2 : ligne 6 */
        }
        // Positionnement des pieces Roi et General de Jade
        plateau[0][4].setP(new Roi(1));
        plateau[8][4].setP(new Roi(2));
        
        /* Position du Roi joueur 1 : ligne 0, colonne 4
         * Position du General de Jade (equivalent Roi) joueur 2 : ligne 8, colonne 4 */

        // Positionnement des pieces General d'Or
        plateau[0][3].setP(new GeneralOr(1));
        plateau[0][5].setP(new GeneralOr(1));
        plateau[8][3].setP(new GeneralOr(2));
        plateau[8][5].setP(new GeneralOr(2));
        
        /* Position des Generaux d'Or joueur 1 : ligne 0, colonne 3 et ligne 0, colonne 5
         * Position des Generaux d'Or joueur 2 : ligne 8, colonne 3 et ligne 8, colonne 5 */

        // Positionnement des pieces General d'Argent
        plateau[0][2].setP(new GeneralArgent(1));
        plateau[0][6].setP(new GeneralArgent(1));
        plateau[8][2].setP(new GeneralArgent(2));
        plateau[8][6].setP(new GeneralArgent(2));
        
        /* Position des Generaux d'Argent joueur 1 : ligne 0, colonne 2 et ligne 0, colonne 6
         * Position des Generaux d'Argent 2 : ligne 8, colonne 2 et ligne 8, colonne 6 */

        // Positionnement des pieces Cavalier
        plateau[0][1].setP(new Cavalier(1));
        plateau[0][7].setP(new Cavalier(1));
        plateau[8][1].setP(new Cavalier(2));
        plateau[8][7].setP(new Cavalier(2));
        
        /* Position des Cavaliers joueur 1 : ligne 0, colonne 1 et ligne 0, colonne 7
         * Position des Cavaliers joueur 2 : ligne 8, colonne 1 et ligne 8, colonne 7 */

        // Positionnement des pieces Lancier
        plateau[0][0].setP(new Lancier(1));
        plateau[0][8].setP(new Lancier(1));
        plateau[8][0].setP(new Lancier(2));
        plateau[8][8].setP(new Lancier(2));
        
        /* Position des Lanciers joueur 1 : ligne 0, colonne 0 et ligne 0, colonne 8
         * Position des Lanciers joueur 2 : ligne 8, colonne 0 et ligne 8, colonne 8 */

        // Positionnement des pieces Fou
        plateau[1][7].setP(new Fou(1));
        plateau[7][1].setP(new Fou(2));
        
        /* Position du Fou joueur 1 : ligne 1, colonne 7
         * Position du Fou joueur 2 : ligne 7, colonne 1 */

        // Positionnement des pieces Tour
        plateau[1][1].setP(new Tour(1));
        plateau[7][7].setP(new Tour(2));
        
        /* Position de la Tour joueur 1 : ligne 1, colonne 1
         * Position de la Tour joueur 2 : ligne 7, colonne 7 */
    }

    // Retourne les coordonnees d'une case selectionnee
    public Case getCase(int x, int y) {
        return plateau[x][y];
    }

    // Retourne la reserve du joueur 1 ou du joueur 2
    public Reserve getReserve(int i) {
        return reserveJoueur[i];
    }

    // Effectue le deplacement d'une piece
    public void deplacementPiece(Case posDepart, Case posArrivee, int tour) throws Exception {
        Piece pieceDepart = posDepart.getP();
        
        // Verifie que la piece a deplacer appartient bien au joueur actif et qu'un deplacement a bien lieu
        if (pieceDepart.getJoueur() == tour && (posDepart.getY() != posArrivee.getY() || posDepart.getX() != posArrivee.getX())) {
            if (pieceDepart.peutSeDeplacer(posDepart, posArrivee, this)) {
                try {
                	
                    // Verifie si le joueur 1 deplace une de ses pieces dans sa zone de promotion (cases 6, 7, 8)
                    if (posArrivee.getX() >= 6 && posDepart.getP().getJoueur() == 1) {
                        posDepart.getP().estPromue();
                    }

                    // Verifie si le joueur 2 deplace une de ses pieces dans sa zone de promotion (cases 0, 1, 2)
                    if (posArrivee.getX() <= 2 && posDepart.getP().getJoueur() == 2) {
                        posDepart.getP().estPromue();
                    }
                } catch(Exception e) {}

                // Verifie, si la case d'arrivee n'est pas vide, que la piece sur cette case n'appartient pas au joueur actif
                // et l'ajoute ensuite a sa reserve
                if (posArrivee.getP() != null) {
                    if (posDepart.getP().getJoueur() != posArrivee.getP().getJoueur()) {
                        reserveJoueur[posDepart.getP().getJoueur()].ajouterPiece(posArrivee.getP()); 
                    }

                    // Verifie si la case sur laquelle va se deplacer le joueur contient le roi adverse
                    if (posArrivee.getP().getNom().equals("Roi")) {
                        JOptionPane.showMessageDialog(null, "Le joueur " + posDepart.getP().getJoueur() + " gagne !", "Fin de partie", 
                        JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }

            // Vide les cases de depart et d'arrivee, avant de placer la piece deplacee sur la case d'arrivee
            posDepart.setP(null);
            posArrivee.setP(null);
            posArrivee.setP(pieceDepart);
            }

            else if (posDepart.getY() == 100 && posDepart.getX() == 100) {

                // Verifie que la case sur laquelle va etre parachutee la piece est vide
                if (posArrivee.getP() == null) {

                    // Verifie que, si la piece a parachuter est un pion, il n'y ait pas d'autre pion du meme joueur dans la colonne de parachutage
                    if (posDepart.getP().getNom().equals("Pion")) {
                        for (int i = 0; i < 9; i ++) {   // Boucle pour parcourir la colonne et verifier la presence d'un autre pion du joueur dedans 
                            if (plateau[i][posArrivee.getY()].getP() != null) {   // Si la colonne contient un pion
                                if (plateau[i][posArrivee.getY()].getP().getNom().equals("Pion") && plateau[i][posArrivee.getY()].getP().getJoueur() == posDepart.getP().getJoueur()) {
                                    Piece p = posDepart.getP();
                                    int j = p.getJoueur();
                                    if (pieceDepart.getJoueur() == 1) {
                                        p.setJoueur(2);
                                    }
                                    else {
                                        p.setJoueur(1);
                                    }
                                    reserveJoueur[j].ajouterPiece(p);
                                    throw new Exception();
                                }
                            }
                        }
                    }
                    // Parachutage d'une piece sur une case vide :
                    pieceDepart.retrograde();
                    posDepart.setP(null);
                    posArrivee.setP(null);
                    posArrivee.setP(pieceDepart);
                    
                    // Parachutage sur une case occupee (mouvement non valide, renvoie la piece qui va etre parachutee dans la reserve)
                } else {
                        Piece p = posDepart.getP();
                        int j = p.getJoueur();
                        if (pieceDepart.getJoueur() == 1) {
                            p.setJoueur(2);
                        }
                        else {
                            p.setJoueur(1);
                        }
                        reserveJoueur[j].ajouterPiece(p);
                        throw new Exception();
                }
            }
            // Si le parachutage n'est pas possible :
            else {
                throw new Exception();
            }
        }
        // Si le joueur joue en dehors de son tour :
        else {
            throw new Exception();
        } 
    }
    
    // Methode pour connaitre l'occupation du plateau
    public String toString() {
        String chaine = "";
        for (int x = 0; x < plateau.length; x ++) {
            for (int y = 0; y < plateau[x].length; y ++) {
                if (plateau[x][y].getP() == null) {
                    chaine += " + ";
                }
                else {
                    chaine += " " + plateau[x][y].getP().getNom() + " ";
                }
            }
            chaine += "\n";
        }
        return chaine;
    }
}