package shogi;

import javax.swing.JOptionPane;

/**
 *  Classe Plateau pour cr�er un plateau de jeu
 */

public class Plateau {
    // [][] : repr�sente les coordonn�es x et y pour chaque case
    // "new Case [9][9]" : va cr�er un plateau de 100 cases (via new) : 10 cases (0-9) en abscisse, et 10 en ordonn�e
    private Case[][] plateau = new Case[9][9];
    private Reserve[] reserveJoueur = {null, new Reserve(1), new Reserve(2)};
    
    // Constructeur :
    public Plateau() {
        /* initialisation du plateau (via boucles : 1 premi�re pour les lignes
         puis une seconde pour les colonnes (qui se d�clenche pour chaque i)) */
        for(int i = 0; i < plateau.length; i++) {
            for(int j = 0; j < plateau[i].length; j++) {
                plateau[i][j] = new Case(i, j); // cr�� un objet plateau � partir de Case
            }
        }

        // positionnement des pi�ces sur le plateau :
        // positionnement des pions sur le plateau
        for(int i = 0; i < 9; i++) {
            // [i] car i va parcourir toutes les colonnes de la ligne 2 et comme "i" s'incr�mente de 0 � 9
            plateau[2][i].setP(new Pion(1)); 
            plateau[6][i].setP(new Pion(2));
        }
        // positionnement des pi�ces Roi et G�n�ral de Jade :
        plateau[0][4].setP(new Roi(1));
        plateau[8][4].setP(new Roi(2));

        // positionnement des pi�ces G�n�ral d'Or :
        plateau[0][3].setP(new GeneralOr(1));
        plateau[0][5].setP(new GeneralOr(1));
        plateau[8][3].setP(new GeneralOr(2));
        plateau[8][5].setP(new GeneralOr(2));

        // positionnement des pi�ces G�n�ral d'Argent :
        plateau[0][2].setP(new GeneralArgent(1));
        plateau[0][6].setP(new GeneralArgent(1));
        plateau[8][2].setP(new GeneralArgent(2));
        plateau[8][6].setP(new GeneralArgent(2));

        // positionnement des pi�ces Cavalier :
        plateau[0][1].setP(new Cavalier(1));
        plateau[0][7].setP(new Cavalier(1));
        plateau[8][1].setP(new Cavalier(2));
        plateau[8][7].setP(new Cavalier(2));

        // positionnement des pi�ces Lancier :
        plateau[0][0].setP(new Lancier(1));
        plateau[0][8].setP(new Lancier(1));
        plateau[8][0].setP(new Lancier(2));
        plateau[8][8].setP(new Lancier(2));

        // positionnement des pi�ces Fou :
        plateau[1][7].setP(new Fou(1));
        plateau[7][1].setP(new Fou(2));

        // positionnement des pi�ces Tour :
        plateau[1][1].setP(new Tour(1));
        plateau[7][7].setP(new Tour(2));
    }

    // d�terminer une case du plateau (s�lectionn�e) :
    public Case getCase(int x, int y) {
        return plateau[x][y];
    }

    // Retourne la r�serve du joueur 1 ou du joueur 2
    public Reserve getReserve(int i) {
        return reserveJoueur[i];
    }

    public void deplacementPiece(Case posDepart, Case posArrivee, int tour) throws Exception {
        Piece pieceDepart = posDepart.getP();
        // V�rifie que le joueur ne va d�placer que ses propres pi�ces durant son tour (et qu'il effectue bien un d�placement)
        if (pieceDepart.getJoueur() == tour && (posDepart.getY() != posArrivee.getY() || posDepart.getX() != posArrivee.getX())) {
            if (pieceDepart.peutSeDeplacer(posDepart, posArrivee, this)) {
                try {
                    // V�rifie si le joueur 1 d�place une de ses pi�ces dans sa zone de promotion (cases 6, 7, 8)
                    if (posArrivee.getX() >= 6 && posDepart.getP().getJoueur() == 1) {
                        posDepart.getP().estPromue();
                    }

                    // V�rifie si le joueur 2 d�place une de ses pi�ces dans sa zone de promotion (cases 0, 1, 2)
                    if (posArrivee.getX() <= 2 && posDepart.getP().getJoueur() == 2) {
                        posDepart.getP().estPromue();
                    }
                } catch(Exception e) {}

                /* V�rifie si la case sur laquelle va se d�placer le joueur contient une pi�ce, et, le cas �ch�ant, l'ajoute dans la 
                r�serve du joueur */
                if (posArrivee.getP() != null) {
                    if (posDepart.getP().getJoueur() != posArrivee.getP().getJoueur()) {
                        reserveJoueur[posDepart.getP().getJoueur()].ajouterPiece(posArrivee.getP()); 
                    }

                    // V�rifie si la case sur laquelle va se d�placer le joueur contient le roi adverse
                    if (posArrivee.getP().getNom().equals("Roi")) {
                        JOptionPane.showMessageDialog(null, "Joueur" + posDepart.getP().getJoueur() + "gagne !", "Fin de partie", 
                        JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                }

            // Vide les cases de d�part et d'arriv�e, avant de placer la pi�ce d�plac�e sur la case d'arriv�e
            posDepart.setP(null);
            posArrivee.setP(null);
            posArrivee.setP(pieceDepart);
            }

            else if (posDepart.getY() == 100 && posDepart.getX() == 100) {

                // V�rifie que la case sur laquelle va �tre parachut�e la pi�ce est vide
                if (posArrivee.getP() == null) {

                    // V�rifie que, si la pi�ce � parachuter est un pion, il n'y ait pas d'autre pion du m�me joueur dans la colonne de parachutage
                    if (posDepart.getP().getNom().equals("Pion")) {
                        for (int i = 0; i < 9; i ++) {   // Boucle pour parcourir la colonne et v�rifier la pr�sence d'un autre pion du joueur dedans 
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
                    // Parachutage d'une pi�ce sur une case vide :
                    posDepart.setP(null);
                    posArrivee.setP(null);
                    // Si la pi�ce parachut�e �tait un fou promu
                    if (pieceDepart.getNom().equals("FouPromu")) {
                        posArrivee.setP(new Fou(pieceDepart.getJoueur()));
                    }
                    // Si la pi�ce parachut�e �tait une tour promue
                    if (pieceDepart.getNom().equals("TourPromue")) {
                        posArrivee.setP(new Tour(pieceDepart.getJoueur()));
                    }
                    // Si la pi�ce parachut�e �tait un pion promu
                    if (pieceDepart.getNom().equals("PionPromu")) {
                        posArrivee.setP(new Pion(pieceDepart.getJoueur()));
                    }
                    // Si la pi�ce parachut�e �tait un G�n�ral d'Argent promu
                    if (pieceDepart.getNom().equals("GeneralArgentPromu")) {
                        posArrivee.setP(new GeneralArgent(pieceDepart.getJoueur()));
                    }
                    // Si la pi�ce parachut�e �tait un Cavalier promu
                    if (pieceDepart.getNom().equals("CavalierPromu")) {
                        posArrivee.setP(new Cavalier(pieceDepart.getJoueur()));
                    }
                    // Si la pi�ce parachut�e �tait un Lancier promu
                    if (pieceDepart.getNom().equals("LancierPromu")) {
                        posArrivee.setP(new Lancier(pieceDepart.getJoueur()));
                    }
                    
                    // Parachutage sur une case occup�e (mouvement non valide, renvoie la pi�ce qui va �tre parachut�e dans la r�serve)
                    else {
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
    
    // M�thode pour connaitre l'occupation du plateau
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