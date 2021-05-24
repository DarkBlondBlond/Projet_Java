package shogi;

import java.awt.BorderLayout;
import java.awt.Color;

/**
 * Interface graphique pour le jeu de shogi
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Création de la fenètre qui va contenir le jeu
	static JFrame fenetre = new JFrame ();
	
	// Création d'un panneau comprenant le plateau
	static JPanel UIplateau = new JPanel (new GridLayout(9,9));
	
	// Création de panneaux comprenant les réserves des 2 joueurs
	static JPanel[] UIreserve = {null, new JPanel(), new JPanel()};
	
	// Création d'un bouton pour chaque case du plateau
	static JButton[][] cases = new JButton[9][9];
	
	// Création de boutons pour les réserves des joueurs
	public static JButton[] boutonReserve[] = {null, new JButton[38], new JButton[38]};
	
	// Création du plateau
	static Plateau p = new Plateau();
	
	// Création d'une variable pour stocker la case sélectionnée par le joueur pour le déplacement
	static Case caseSelectionnee = null;
	
	// Création d'une variable pour stocker le numéro du tour de jeu
	public static int tour = 2;
	
	// Constructeur
	public Interface() {
		
		// Création de la fenêtre du jeu
		fenetre.setLayout(new BorderLayout());
		fenetre.setSize(972,1200);
		fenetre.setTitle("Jeu de shogi");
		fenetre.add(UIplateau, BorderLayout.CENTER);
		fenetre.setResizable(false);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Ajouter les réserves des 2 joueurs
		fenetre.add(UIreserve[1], BorderLayout.PAGE_START);
		fenetre.add(UIreserve[2], BorderLayout.PAGE_END);
		
		// Taille des différents éléments de la fenêtre
		UIplateau.setSize(972, 972);
		UIreserve[1].setSize(972, 114);
		UIreserve[2].setSize(972, 114);
		
		// Ajout de boutons pour les pièces présentes dans chaque réserve
		for (int joueur = 1; joueur <= 2; joueur ++) {
			for (int i = 0; i < 38; i ++) {
				boutonReserve[joueur][i] = new JButton("");   
				boutonReserve[joueur][i].setOpaque(true);
				boutonReserve[joueur][i].setSize(108, 108);
				boutonReserve[joueur][i].setBorder(new LineBorder(Color.white));   // Bordures des boutons en blanc
				boutonReserve[joueur][i].setBackground(Color.white);   // Arrière-plan du plateau en blanc
				final int finalJoueur = joueur;
				boutonReserve[joueur][i].addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e) {
						for (int n = 0; n < 38; n ++) {
							if (e.getSource() == boutonReserve[finalJoueur][n]) {
								if (p.getReserve(finalJoueur).getPiece(n).getJoueur() != tour) {
									// Création d'une case temporaire pour stocker les pièces en déplacement
									Case c = new Case (100, 100);
									Piece pi = p.getReserve(finalJoueur).getPiece(n);
									pi.setJoueur(p.getReserve(finalJoueur).getJoueur());
									c.setP(pi);
									caseSelectionnee = c;   // Ajout de la case sélectionnée dans la case "c" temporaire
									boutonReserve[finalJoueur][n].setText("") ;   // Supprime l'icône de la pièce associée à cette case
									boutonReserve[finalJoueur][n].setVisible(false);   // Rend l'icône de la pièce invisible
									p.getReserve(finalJoueur).setPiece(n, null);   // déréférencie la pièce de la réserve
								}
							}
						}
					}
				});
				UIreserve[joueur].add(boutonReserve[joueur][i]);   // Ajouter chacun des boutons créés aux panneaux des réserves
			}
		}
		
		// Ajouter un bouton pour chaque case du plateau
		// Ajouter un bouton dans chaque ligne du plateau
		for (int x = 0; x < 9; x ++) {
			
			// Ajouter un bouton pour chaque colonne de cette ligne
			for (int y = 0; y < 9; y ++) {
				cases[x][y] = new JButton();
				cases[x][y].setOpaque(true);
				cases[x][y].setSize(108, 108);
				cases[x][y].setBorder(new LineBorder(Color.black));
				cases[x][y].setBackground(Color.decode("704a37"));
				cases[x][y].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int x = 0; x < 9; x ++) {
							for (int y = 0; y < 9; y ++) {
								if (e.getSource() == cases[x][y]) {
									int k = 0;
									
									// Vérifie si la case contient une pièce 
									try {
										k = p.getCase(x, y).getP().getJoueur();
									} catch (Exception e1) {}   // e1 car ActionEvent = e
									
									// Vérifie si la pièce à déplacer appartient bien au joueur qui joue et si la case temporaire est vide
									if (caseSelectionnee == null && k == tour) {
										if (p.getCase(x, y).getP() != null) {
											caseSelectionnee = p.getCase(x, y);
											
											// Indique les déplacements possibles pour la pièce sélectionnée avec un "."
											for (int a = 0 ; a < 9; a ++) {
												for (int o = 0; o < 9; o ++) {
													if (p.getCase(x, y).getP().peutSeDeplacer(p.getCase(x, y), p.getCase(a, o), p)) {
														cases[a][o].setText(cases[a][o].getText() + ".");
													}
												}
											}
										}
									} else {
										try {
											// Teste si le déplacement est possible
											p.deplacementPiece(caseSelectionnee, p.getCase(x, y), tour);
											cases[x][y].setForeground(Color.black);
											caseSelectionnee = null;
											if (tour == 1) {
												tour = 2;
											} else {
												tour = 1;
											}
											actuPlateau();
										} catch (Exception e2) {
											// Déplacement impossible
											e2.printStackTrace(System.out);
											System.out.println("Mouvement invalide");
											caseSelectionnee = null;
											actuPlateau();
										}
									}
								}
							}
						}
						
					}
					
				});
				// Ajouter chaque case obtenue à UIplateau
				UIplateau.add(cases[x][y]);
			}
		}
		
		// Mise à jour de UIplateau avec les nouvelles positions de pièces
		actuPlateau();
		fenetre.setVisible(true);
		fenetre.revalidate();
		fenetre.repaint();
	}
	
	public static void actuPlateau() {
		
	}
	
}

