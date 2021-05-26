package shogi;

/**
 * Interface graphique pour le jeu de shogi
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Cr�ation de la fen�tre qui va contenir le jeu
	static JFrame fenetre = new JFrame ();
	
	// Cr�ation d'un panneau comprenant le plateau
	static JPanel UIplateau = new JPanel (new GridLayout(9,9));
	
	// Cr�ation de panneaux comprenant les r�serves des 2 joueurs
	static JPanel[] UIreserve = {null, new JPanel(), new JPanel()};
	
	// Cr�ation d'un bouton pour chaque case du plateau
	static JButton[][] cases = new JButton[9][9];
	
	// Cr�ation de boutons pour les r�serves des joueurs
	public static JButton[] boutonReserve[] = {null, new JButton[38], new JButton[38]};
	
	// Cr�ation du plateau
	static Plateau p = new Plateau();
	
	// Cr�ation d'une variable pour stocker la case s�lectionn�e par le joueur pour le d�placement
	static Case caseSelectionnee = null;
	
	// Cr�ation d'une variable pour stocker le num�ro du tour de jeu
	public static int tour = 2;
	
	// Constructeur
	public Interface() {
		
		// Cr�ation de la fen�tre du jeu
		fenetre.setLayout(new BorderLayout());
		fenetre.setSize(1080, 972);
		fenetre.setTitle("Jeu de shogi");
		fenetre.add(UIplateau, BorderLayout.CENTER);
		fenetre.setResizable(false);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Ajouter les r�serves des 2 joueurs
		fenetre.add(UIreserve[1], BorderLayout.PAGE_START);
		fenetre.add(UIreserve[2], BorderLayout.PAGE_END);
		
		// Taille des diff�rents �l�ments de la fen�tre
		UIplateau.setSize(972, 972);
		UIreserve[1].setSize(1080, 54);
		UIreserve[2].setSize(1080, 54);
		
		// Ajout de boutons pour les pi�ces pr�sentes dans chaque r�serve
		for (int joueur = 1; joueur <= 2; joueur ++) {
			for (int i = 0; i < 38; i ++) {
				boutonReserve[joueur][i] = new JButton("");   
				boutonReserve[joueur][i].setOpaque(true);
				boutonReserve[joueur][i].setSize(108, 108);
				boutonReserve[joueur][i].setBorder(new LineBorder(Color.white));   // Bordures des boutons en blanc
				boutonReserve[joueur][i].setBackground(Color.white);   // Arri�re-plan du plateau en blanc
				final int finalJoueur = joueur;
				boutonReserve[joueur][i].addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e) {
						for (int n = 0; n < 38; n ++) {
							if (e.getSource() == boutonReserve[finalJoueur][n]) {
								if (p.getReserve(finalJoueur).getPiece(n).getJoueur() != tour) {
									// Cr�ation d'une case temporaire pour stocker les pi�ces en d�placement
									Case c = new Case (100, 100);
									Piece pi = p.getReserve(finalJoueur).getPiece(n);
									pi.setJoueur(p.getReserve(finalJoueur).getJoueur());
									c.setP(pi);
									caseSelectionnee = c;   // Ajout de la case s�lectionn�e dans la case "c" temporaire
									boutonReserve[finalJoueur][n].setVisible(false);   // Rend l'ic�ne de la pi�ce invisible
									p.getReserve(finalJoueur).setPiece(n, null);   // d�r�f�rencie la pi�ce de la r�serve
								}
							}
						}
					}
				});
				UIreserve[joueur].add(boutonReserve[joueur][i]);   // Ajouter chacun des boutons cr��s aux panneaux des r�serves
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
				cases[x][y].setBackground(Color.decode("#704a37"));
				cases[x][y].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int x = 0; x < 9; x ++) {
							for (int y = 0; y < 9; y ++) {
								if (e.getSource() == cases[x][y]) {
									int k = 0;
									
									// V�rifie si la case contient une pi�ce 
									try {
										k = p.getCase(x, y).getP().getJoueur();
									} catch (Exception e1) {}   // e1 car ActionEvent = e
									
									// V�rifie si la pi�ce � d�placer appartient bien au joueur qui joue et si la case temporaire est vide
									if (caseSelectionnee == null && k == tour) {
										if (p.getCase(x, y).getP() != null) {
											caseSelectionnee = p.getCase(x, y);
											
											// Indique les d�placements possibles pour la pi�ce s�lectionn�e avec un "."
											for (int a = 0 ; a < 9; a ++) {
												for (int o = 0; o < 9; o ++) {
													if (p.getCase(x, y).getP().peutSeDeplacer(p.getCase(x, y), p.getCase(a, o), p)) {
														cases[a][o].setText(cases[a][o].getText() + ".");
														cases[a][o].setBackground(Color.decode("#633a25"));
													}
												}
											}
										}
									} else {
										try {
											// Teste si le d�placement est possible
											p.deplacementPiece(caseSelectionnee, p.getCase(x, y), tour);
											cases[x][y].setForeground(Color.black);
											caseSelectionnee = null;
											if (tour == 1) {
												tour = 2;
											} else {
												tour = 1;
											}
											miseAJourPlateau();
										} catch (Exception e2) {
											// D�placement impossible
											e2.printStackTrace(System.out);
											System.out.println("Mouvement invalide");
											caseSelectionnee = null;
											miseAJourPlateau();
										}
									}
								}
							}
						}
					}
				});
				// Ajouter chaque case obtenue � UIplateau
				UIplateau.add(cases[x][y]);
			}
		}
		fenetre.setVisible(true);
		miseAJourPlateau();
	}
	
	public static void miseAJourPlateau() {

		// Actualisation du plateau apres chaque deplacement de piece
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				
				// Actualisation de la case si une piece est presente dessus
				if(p.getCase(x, y).getP() != null) {
					cases[x][y].setIcon(p.getCase(x, y).getP().getIcon());
					System.out.println(p.getCase(x, y).getP().getIcon());
					cases[x][y].setText("");
					cases[x][y].setBackground(Color.decode("#704a37"));
					
					/* La 1ere ligne permet de recuperer l'icone associee à la piece presente sur la case :
					 * 		- "p.getCase(x, y).getP().getIcon()" => receupere l'icone de la piece sur la case
					 * 		- "cases[x][y].setIcon" => associe cette icone a la case.
					 * La 2e ligne affiche l'icone recuperee dans la console.
					 * la 3e ligne est necessaire pour que les points indiquant les deplacements possibles ne
					 * restent pas affiches sur la piece deplacee.
					 * La 4e ligne definit la couleur de l'arriere-plan de la case. */
					
				} else {
					
					// Actualisation de la case s'il n'y a pas de piece presente dessus
					cases[x][y].setText("");
					cases[x][y].setIcon(null);
					cases[x][y].setForeground(Color.black);
					cases[x][y].setBackground(Color.decode("#704a37"));
					
					/* La 1ere ligne est necessaire pour que les points indiquant les deplacements possibles ne
					 * restent pas affiches sur les cases vides.
					 * La 2e ligne permet de pas afficher d'icone sur cette case.
					 * les 3e et 4e lignes definissent les couleurs d'avant et d'arriere-plan pour la case. */
					
				}
			}
		}

		// Actualisation des reserves des joueurs
		for(int j = 1; j <= 2; j++) {
			for(int i = 0; i < 8; i++) {
				
				// Actualisation de la case si une piece est presente dessus
				if(p.getReserve(j).getPiece(i) != null) {
					boutonReserve[j][i].setText(p.getReserve(j).getPiece(i).getNom());
					boutonReserve[j][i].setVisible(true);
				} else {

					// Actualisation de la case s'il n'y a pas de piece presente dessus
					boutonReserve[j][i].setVisible(false);
					
					/* Meme principe que pour l'actualisation du plateau ci-dessus, sauf que l'on n'affiche pas
					 * les icones des pieces (gain de place) mais juste leur nom */
				}
			}
		}
	}
}

/* ORIGINAUX :
		public static void miseAJourPlateau() {
		//For pieces in the 9x9 board
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				if(p.getCase(r, c).getP() != null) {
					//Set the piece text based on the piece symbol
					//cases[r][c].setText(p.getCase(r, c).getP().getNom());
					cases[r][c].setIcon(p.getCase(r, c).getP().getIcon());
					System.out.println(p.getCase(r,c).getP().getIcon());
					cases[r][c].setText("");
					cases[r][c].setBackground(Color.decode("#704a37"));
				} else {
					//If square is empty, clear text
					cases[r][c].setText("");
					cases[r][c].setIcon(null);
					cases[r][c].setForeground(Color.BLACK);
					cases[r][c].setBackground(Color.decode("#704a37"));
				}
			}
		}
		//For pieces in the players' hands
		for(int j = 1; j <= 2; j++) {
			for(int i=0;i<38;i++) {
				if(p.getReserve(j).getPiece(i) != null) {
					//Set the square text to the piece symbol
					boutonReserve[j][i].setText(p.getReserve(j).getPiece(i).getNom());
					//If there's a piece, make the button visible
					boutonReserve[j][i].setVisible(true);
				} else {
					//If there are no pieces in the hand button, hide it
					boutonReserve[j][i].setVisible(false);
				}
			}
		}
*/