package stg;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTree;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Label;
import javax.swing.ImageIcon;

public class stage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JTextField cinstg;
	private JTextField sjt;
	private JTextField db;
	private JTextField fin;
	private JTextField cinenc;
	DefaultTableModel model;
	private JComboBox combosout ;
	private JComboBox combotype;
	private JComboBox comboenc;
	private ResultSet resultat;
	private JTextField etab;
	private JComboBox combostg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stage frame = new stage();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.afficher();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public stage() {
		setTitle("Gestion des stages");
		final Object[] row=new Object[11];
		model=new DefaultTableModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 117));
		panel_2.setBounds(254, 0, 1090, 98);
		contentPane.add(panel_2);

		JLabel lblEspaceDesStages = new JLabel("Espace Des Stages");
		lblEspaceDesStages.setForeground(Color.WHITE);
		lblEspaceDesStages.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblEspaceDesStages.setBounds(232, 30, 382, 39);
		panel_2.add(lblEspaceDesStages);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(883, 47, 122, 22);
		panel_2.add(comboBox);
		comboBox.addItem("Cin");
		comboBox.addItem("Nom_stagiaire");
		comboBox.addItem("Etablissement");
		comboBox.addItem("Type");
		comboBox.addItem("Sujet");
		comboBox.addItem("soutenance_orale");
		comboBox.addItem("Nom_encadrant");

		JButton rechercher = new JButton("");
		rechercher.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\RECH.png"));
		rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/stageonda";
				String selectedItem = comboBox.getSelectedItem().toString();
				String searchValue = JOptionPane.showInputDialog(null, "Entrez la valeur de recherche :", "Recherche", JOptionPane.QUESTION_MESSAGE);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection connection = DriverManager.getConnection(url,"root","");
					Statement st = connection.createStatement();
					
					String query = "SELECT nom_stagiaire,cin,etablissement,type,sujet,date_debut,date_fin,soutenance_orale,nom_encadrant,cin_encadrant  FROM stage WHERE " + selectedItem + " LIKE '" + searchValue.toLowerCase() + "%'";

					ResultSet rs = st.executeQuery(query);
					
					DefaultTableModel modele = (DefaultTableModel) table.getModel();
					modele.setRowCount(0);
					
					while (rs.next()) {
						
						String nm = rs.getString(1);
						String cn = rs.getString(2);
						String et = rs.getString(3);
						String tp = rs.getString(4);
						String sj = rs.getString(5);
						String db = rs.getString(6);
						String fn = rs.getString(7);
						String sot = rs.getString(8);
						String n = rs.getString(9);
						String cin = rs.getString(10);
						
						String[] row = {nm,cn,et,tp,sj,db,fn,sot,n,cin};
						modele.addRow(row);
					}
					
					st.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
			
				
				
			}
		});
		rechercher.setToolTipText("    ");
		rechercher.setBounds(1015, 47, 32, 22);
		panel_2.add(rechercher);

		JLabel lblNewLabel_2 = new JLabel("Rechercher Par :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(767, 48, 122, 18);
		panel_2.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 117));
		panel_1.setBounds(0, 0, 255, 682);
		contentPane.add(panel_1);

		JButton btnParamtres = new JButton("Paramètres");
		btnParamtres.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-paramètres-30.png"));
		btnParamtres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parametre esp =new parametre();
				esp.setVisible(true);
				esp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnParamtres.setHorizontalAlignment(SwingConstants.LEADING);
		btnParamtres.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnParamtres.setFocusPainted(false);
		btnParamtres.setBackground(new Color(240, 240, 240));
		btnParamtres.setBounds(10, 471, 235, 40);
		panel_1.add(btnParamtres);

		JButton btnNewButton_1 = new JButton("Evaluation des stages ");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\ok.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Evaluationn ev=new Evaluationn();
		    	ev.setVisible(true);
		    	ev.setLocationRelativeTo(null);
		    	dispose();
		    	ev.affichage();
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.setBounds(10, 373, 235, 37);
		panel_1.add(btnNewButton_1);
		
		JButton btnDeconnection = new JButton("Deconnection");
		btnDeconnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceuil ac=new acceuil();
				ac.setVisible(true);
				ac.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnDeconnection.setForeground(Color.WHITE);
		btnDeconnection.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeconnection.setBackground(new Color(245, 73, 73));
		btnDeconnection.setBounds(22, 631, 203, 40);
		panel_1.add(btnDeconnection);
		
		JButton btnNewButton_3 = new JButton("Espace des encadrants");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\bad.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espacencadrant es=new espacencadrant();
				es.setVisible(true);
				es.setLocationRelativeTo(null);
				dispose();
				es.afficher();
			}
		});
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBackground(new Color(240, 240, 240));
		btnNewButton_3.setBounds(10, 170, 235, 40);
		panel_1.add(btnNewButton_3);
		
		JButton btnGestionDesAbscences = new JButton("Gestion des abscences");
		btnGestionDesAbscences.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\abs.png"));
		btnGestionDesAbscences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Abscence ab=new Abscence();
				ab.setVisible(true);
				ab.setLocationRelativeTo(null);
				dispose();
				ab.afficher();
			}
		});
		btnGestionDesAbscences.setHorizontalAlignment(SwingConstants.LEADING);
		btnGestionDesAbscences.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGestionDesAbscences.setFocusPainted(false);
		btnGestionDesAbscences.setBackground(new Color(240, 240, 240));
		btnGestionDesAbscences.setBounds(10, 272, 235, 40);
		panel_1.add(btnGestionDesAbscences);
		
		JButton btnNewButton_3_1 = new JButton("Espace des stagiaires");
		btnNewButton_3_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\G.png"));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espacestg es=new espacestg();
				es.setVisible(true);
				es.setLocationRelativeTo(null);
				dispose();
				es.afficher();
			}
		});
		btnNewButton_3_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1.setFocusPainted(false);
		btnNewButton_3_1.setBackground(new Color(240, 240, 240));
		btnNewButton_3_1.setBounds(10, 221, 235, 40);
		panel_1.add(btnNewButton_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-utilisateur-100.png"));
		lblNewLabel_3.setBounds(77, 37, 120, 106);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_3_1_1_1 = new JButton("Gestion des stages");
		btnNewButton_3_1_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\fl.png"));
		btnNewButton_3_1_1_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1_1_1.setFocusPainted(false);
		btnNewButton_3_1_1_1.setBackground(SystemColor.activeCaption);
		btnNewButton_3_1_1_1.setBounds(10, 323, 235, 40);
		panel_1.add(btnNewButton_3_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Les statistiques");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistics st=new Statistics();
				st.setVisible(true);
				st.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1_1_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\l.png"));
		btnNewButton_1_1_2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1_2.setFocusPainted(false);
		btnNewButton_1_1_2.setBackground(new Color(240, 240, 240));
		btnNewButton_1_1_2.setBounds(10, 421, 235, 37);
		panel_1.add(btnNewButton_1_1_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(264, 104, 1070, 239);
		contentPane.add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1070, 239);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
				
				combostg.setSelectedItem(table.getValueAt(i, 0).toString());
				cinstg.setText(table.getValueAt(i, 1).toString());
				etab.setText(table.getValueAt(i, 2).toString());
				combotype.setSelectedItem(table.getValueAt(i, 3).toString());
				sjt.setText(table.getValueAt(i,4).toString());
				db.setText(table.getValueAt(i, 5).toString());
				fin.setText(table.getValueAt(i, 6).toString());				
				combosout.setSelectedItem(table.getValueAt(i, 7).toString());
				comboenc.setSelectedItem(table.getValueAt(i, 8).toString());
				cinenc.setText(table.getValueAt(i, 9).toString());
			}
		}});
		scrollPane.setViewportView(table);
		
		cinstg = new JTextField();
		cinstg.setBackground(new Color(223, 239, 255));
		cinstg.setColumns(10);
		cinstg.setBounds(454, 452, 115, 20);
		contentPane.add(cinstg);
		
		sjt = new JTextField();
		sjt.setColumns(10);
		sjt.setBounds(784, 406, 122, 20);
		contentPane.add(sjt);
		
		db = new JTextField();
		db.setFont(new Font("Tahoma", Font.PLAIN, 12));
		db.setForeground(new Color(169, 169, 169));
		db.setText("  yyyy-mm-dd");
		db.setColumns(10);
		db.setBounds(784, 452, 122, 20);
		contentPane.add(db);
		
		fin = new JTextField();
		fin.setForeground(new Color(169, 169, 169));
		fin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fin.setText("  yyyy-mm-dd");
		fin.setColumns(10);
		fin.setBounds(784, 499, 122, 20);
		contentPane.add(fin);
		
		cinenc = new JTextField();
		cinenc.setBackground(new Color(223, 239, 255));
		cinenc.setColumns(10);
		cinenc.setBounds(1194, 499, 122, 20);
		contentPane.add(cinenc);
		
		JLabel lblNomComplet = new JLabel("Nom Stagiaire:");
		lblNomComplet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomComplet.setBounds(326, 406, 92, 18);
		contentPane.add(lblNomComplet);
		
		JLabel lblCin = new JLabel("Cin Stagiaire :");
		lblCin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCin.setBounds(326, 453, 86, 17);
		contentPane.add(lblCin);
		
		JLabel lblSujet = new JLabel("Sujet :");
		lblSujet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSujet.setBounds(697, 408, 46, 14);
		contentPane.add(lblSujet);
		
		JLabel lblDateDbut = new JLabel("Date début :");
		lblDateDbut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateDbut.setBounds(668, 454, 86, 14);
		contentPane.add(lblDateDbut);
		
		JLabel lblDateFin = new JLabel("Date fin :");
		lblDateFin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateFin.setBounds(683, 501, 62, 14);
		contentPane.add(lblDateFin);
		
		JLabel lblSoutenance = new JLabel("Soutenance :");
		lblSoutenance.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoutenance.setBounds(1057, 407, 98, 17);
		contentPane.add(lblSoutenance);
		
		JLabel lblIdeval = new JLabel("Nom de l'encadrant :");
		lblIdeval.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdeval.setBounds(1013, 454, 127, 14);
		contentPane.add(lblIdeval);
		
		JLabel lblCinencadrant = new JLabel("cin_encadrant :");
		lblCinencadrant.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCinencadrant.setBounds(1042, 501, 98, 14);
		contentPane.add(lblCinencadrant);
		
		combotype = new JComboBox();
		combotype.setModel(new DefaultComboBoxModel(new String[] {"", "pfa", "pfe", "initiation"}));
		combotype.setBounds(454, 498, 115, 22);
		contentPane.add(combotype);
		
		combosout = new JComboBox();
		combosout.setModel(new DefaultComboBoxModel(new String[] {"", "oui", "non"}));
		combosout.setBounds(1194, 405, 122, 22);
		contentPane.add(combosout);
		
		combostg = new JComboBox();
		combostg.setModel(new DefaultComboBoxModel(new String[] {""}));
		remplircombobox2();
		combostg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedStagiaire = (String) combostg.getSelectedItem();

                // Récupérer le CIN correspondant à partir de la base de données
                String cintxt = getStagiaireCIN(selectedStagiaire);

                // Afficher le CIN dans le JTextField
                cinstg.setText(cintxt);
			}
		});
		combostg.setBounds(454, 405, 118, 22);
		contentPane.add(combostg);
		
		JButton ajouter = new JButton("Nouveau stage");
		ajouter.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\+.png"));
		ajouter.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       

		        String url = "jdbc:mysql://localhost:3306/stageonda";

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            try {
		                Connection connection = DriverManager.getConnection(url, "root", "");

		                // Vérification si le stagiaire existe déjà
		                String existingStagiaireQuery = "SELECT * FROM stage WHERE nom_stagiaire=?";
		                PreparedStatement existingStagiaireStat = connection.prepareStatement(existingStagiaireQuery);
		                existingStagiaireStat.setString(1, combostg.getSelectedItem().toString());
		                ResultSet existingStagiaireResult = existingStagiaireStat.executeQuery();

		                if (existingStagiaireResult.next()) {
		                    // Le stagiaire existe déjà, afficher un message d'erreur
		                    JOptionPane.showMessageDialog(null, "Ce stagiaire existe déjà !");
		                } else {
		                    // Le stagiaire n'existe pas encore, procéder à l'insertion
		                	String sql="INSERT INTO stage(nom_stagiaire,cin,etablissement,type,sujet,date_debut,date_fin,soutenance_orale,nom_encadrant,cin_encadrant)"

						+ " VALUES ('"+combostg.getSelectedItem()+"','"+cinstg.getText()+"','"+etab.getText()+"','"+ combotype.getSelectedItem()+"','"+sjt.getText()+"','"+db.getText()+"','"+fin.getText()+"','"+combosout.getSelectedItem()+"','"+comboenc.getSelectedItem()+"','"+cinenc.getText()+"')";

						PreparedStatement stat=connection.prepareStatement(sql);

						stat.executeUpdate(sql);

						System.out.println("Connected");

						JOptionPane.showMessageDialog(null,"Enregistré Avec Succès");
						updateTableModel();
						stat.close();
						connection.close();
		                updateTableModel();
		                }

		                existingStagiaireStat.close();
		                connection.close();

		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});

				
			
		ajouter.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		ajouter.setFocusPainted(false);
		ajouter.setBounds(518, 621, 161, 34);
		contentPane.add(ajouter);
		
		JButton btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\UP.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
			        if (selectedRow >= 0) {
			            String url = "jdbc:mysql://localhost:3306/stageonda";
			            try {
			                Class.forName("com.mysql.cj.jdbc.Driver");
			                try {
			                    Connection connection = DriverManager.getConnection(url, "root", "");
			                    String query = "UPDATE stage SET nom_stagiaire=?,cin=?,etablissement=?,Type=?,sujet=?,date_debut=?,date_fin=?,soutenance_orale=?,nom_encadrant=?,cin_encadrant=? WHERE cin=?";
			                    PreparedStatement statement = connection.prepareStatement(query);
			                    statement.setString(1, combostg.getSelectedItem().toString());
			                    statement.setString(2, cinstg.getText());
			                    statement.setString(3, etab.getText());
			                    statement.setString(4, combotype.getSelectedItem().toString());
			                    statement.setString(5, sjt.getText());
			                    statement.setString(6, db.getText());
			                    statement.setString(7, fin.getText());
			                    statement.setString(8, combosout.getSelectedItem().toString());
			                    statement.setString(9, comboenc.getSelectedItem().toString());
			                    statement.setString(10, cinenc.getText());
			                    statement.setString(11, cinstg.getText());
			                    
			                    

			                    int rowsAffected = statement.executeUpdate();
			                    if (rowsAffected > 0) {
			                        JOptionPane.showMessageDialog(null, "Modifié avec Succès");
			                        // Mettre à jour les valeurs dans le modèle de table
			                        DefaultTableModel model = (DefaultTableModel) table.getModel();
			                        if (model.getRowCount() > 0) {
			                           		                         
			                            model.setValueAt(combostg.getSelectedItem(), selectedRow, 0);
			                            model.setValueAt(cinstg.getText(), selectedRow, 1);
			                            model.setValueAt(etab.getText(), selectedRow, 2);
			                            model.setValueAt(combotype.getSelectedItem(), selectedRow, 3);
			                            model.setValueAt(sjt.getText(), selectedRow, 4);
			                            model.setValueAt(db.getText(), selectedRow, 5);
			                            model.setValueAt(fin.getText(), selectedRow, 6);
			                            model.setValueAt(combosout.getSelectedItem(), selectedRow, 7);
			                            model.setValueAt(comboenc.getSelectedItem(), selectedRow, 8);
			                            model.setValueAt(cinenc.getText(), selectedRow, 9);
			                           
			                        }
			                        statement.close();
			                        connection.close();
			                        updateTableModel();
			                    } else {
			                        JOptionPane.showMessageDialog(null, "Aucune modification effectuée");
			                    }
			                } catch (SQLException ex) {
			                    ex.printStackTrace();
			                }
			            } catch (ClassNotFoundException ex) {
			                ex.printStackTrace();
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne pour effectuer la modification");
			        }
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBounds(709, 621, 169, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Supprimer");
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\dd.png"));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
			        if (selectedRow >= 0) {
			            String url = "jdbc:mysql://localhost:3306/stageonda";
			            try {
			                Class.forName("com.mysql.cj.jdbc.Driver");
			                try {
			                    Connection connection = DriverManager.getConnection(url, "root", "");
			                    String query = "DELETE FROM stage WHERE cin = ?";

			                    PreparedStatement statement = connection.prepareStatement(query);
			                    statement.setString(1, cinstg.getText());

			                    int rowsAffected = statement.executeUpdate();
			                    if (rowsAffected > 0) {
			                        JOptionPane.showMessageDialog(null, "Supprimé avec Succès");
			                        DefaultTableModel model = (DefaultTableModel) table.getModel();
			                        if (model.getRowCount() > 0) {
			                            model.removeRow(selectedRow);
			                        }
			                    } else {
			                        JOptionPane.showMessageDialog(null, "Aucune suppression effectuée");
			                    }
			                    updateTableModel();
			                    statement.close();
			                    connection.close();
			                } catch (SQLException ex) {
			                    ex.printStackTrace();
			                }
			            } catch (ClassNotFoundException ex) {
			                ex.printStackTrace();
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne pour effectuer la suppression");
			        }

			}
		});
		btnNewButton_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton_2_1.setFocusPainted(false);
		btnNewButton_2_1.setBounds(910, 621, 173, 34);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Effacer");
		btnNewButton_2_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\fr.png"));
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cinstg.setText("");
				combostg.setSelectedItem("");
				combotype.setSelectedItem("");
				comboenc.setSelectedItem("");
				cinenc.setText("");
				
				combosout.setSelectedItem("");
				db.setText("");
				fin.setText("");
				sjt.setText("");
				etab.setText("");
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton_2_1_1.setFocusPainted(false);
		btnNewButton_2_1_1.setBounds(1116, 621, 161, 34);
		contentPane.add(btnNewButton_2_1_1);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Type de stage :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(326, 500, 92, 17);
		contentPane.add(lblNewLabel_1);
		
		comboenc = new JComboBox();
		comboenc.setModel(new DefaultComboBoxModel(new String[] {""}));
		remplircombobox();
		comboenc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String selectedEncadrant = (String) comboenc.getSelectedItem();
	                // Récupérer le CIN correspondant à partir de la base de données
	                String cin = getEncadrantCIN(selectedEncadrant);
	                // Afficher le CIN dans le JTextField
	                cinenc.setText(cin);
			}
		});
		comboenc.setBounds(1194, 451, 122, 22);
		contentPane.add(comboenc);
		
		JLabel lblEtablissement = new JLabel("Etablissement :");
		lblEtablissement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEtablissement.setBounds(326, 546, 95, 14);
		contentPane.add(lblEtablissement);
		
		etab = new JTextField();
		etab.setColumns(10);
		etab.setBounds(454, 544, 122, 20);
		contentPane.add(etab);
		
		Label label_1 = new Label("NB : le cin des stagiaires et des encadrants seront affichés automatiquement après la selection de leurs noms !");
		label_1.setForeground(new Color(255, 0, 0));
		label_1.setBounds(274, 356, 624, 22);
		contentPane.add(label_1);
		
		JButton btnNewButton_2_2 = new JButton("Actualiser");
		btnNewButton_2_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\rt.png"));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficher();
			}
		});
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_2.setFocusPainted(false);
		btnNewButton_2_2.setBounds(326, 622, 161, 32);
		contentPane.add(btnNewButton_2_2);
		
		
		
		
	}
	
	 public void updateTableModel() {
	      String url = "jdbc:mysql://localhost:3306/stageonda";
	      try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection connection = DriverManager.getConnection(url, "root", "");

	          String query = "SELECT nom_stagiaire,cin,etablissement,type,sujet,date_debut,date_fin,soutenance_orale,nom_encadrant,cin_encadrant FROM stage";
	          PreparedStatement statement = connection.prepareStatement(query);

	          ResultSet rs = statement.executeQuery();
	          ResultSetMetaData rsmd = rs.getMetaData();

	          int cols = rsmd.getColumnCount();
	          String[] colName = new String[cols];

	          for (int i = 0; i < cols; i++)
	              colName[i] = rsmd.getColumnName(i + 1);

	          DefaultTableModel modele = new DefaultTableModel(colName, 0);

	          while (rs.next()) {
	              Object[] row = new Object[cols];
	              for (int i = 0; i < cols; i++) {
	                  row[i] = rs.getString(i + 1);
	              }
	              modele.addRow(row);
	          }

	          table.setModel(modele);

	          rs.close();
	          statement.close();
	          connection.close();
	      } catch (SQLException | ClassNotFoundException e) {
	          e.printStackTrace();
	      }
	  }
	 
	  private String getEncadrantCIN(String nomEncadrant) {
		  String url = "jdbc:mysql://localhost:3306/stageonda";
		  Connection connection = null;
		try {
			connection = DriverManager.getConnection(url,"root","");
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	        String cin = "";
	        String query = "SELECT cin_encadrant FROM encadrant WHERE nom_complet = ?";
	       
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, nomEncadrant);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                cin = resultSet.getString("cin_encadrant");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return cin;
	    }	
	  
		public void remplircombobox() {
			String url = "jdbc:mysql://localhost:3306/stageonda";

			try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			try {

			Connection connection=DriverManager.getConnection(url,"root","");
			String sql="select nom_complet from encadrant";
			PreparedStatement stat=connection.prepareStatement(sql);
			resultat =stat.executeQuery();
			while(resultat.next()) {
				String nom=resultat.getString("nom_complet").toString();
				comboenc.addItem(nom);
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		  private String getStagiaireCIN(String nomStagiaire) {
			  String url = "jdbc:mysql://localhost:3306/stageonda";
			  Connection connection = null;
			try {
				connection = DriverManager.getConnection(url,"root","");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        String cin = "";
		        String query = "SELECT cin FROM Stagiaire WHERE CONCAT(nom, ' ', prenom) = ?";

		        try (PreparedStatement statement = connection.prepareStatement(query)) {
		            statement.setString(1, nomStagiaire);
		            ResultSet resultSet = statement.executeQuery();
		            if (resultSet.next()) {
		                cin = resultSet.getString("cin");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return cin;
		    }	
		  
		  public void remplircombobox2() {
			    String url = "jdbc:mysql://localhost:3306/stageonda";

			    try {
			        Class.forName("com.mysql.cj.jdbc.Driver");

			        try {
			            Connection connection = DriverManager.getConnection(url, "root", "");
			            String sql = "SELECT nom, prenom FROM stagiaire";
			            PreparedStatement stat = connection.prepareStatement(sql);
			            ResultSet resultat = stat.executeQuery();

			            while (resultat.next()) {
			                String nom = resultat.getString("nom");
			                String prenom = resultat.getString("prenom");
			                combostg.addItem(nom + " " + prenom);
			            }

			            stat.close();
			            connection.close();
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    } catch (ClassNotFoundException e) {
			        e.printStackTrace();
			    }
			}
		  
		  public void afficher() {
			  String url = "jdbc:mysql://localhost:3306/stageonda";

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection connection = DriverManager.getConnection(url, "root", "");

		            String query = "SELECT nom_stagiaire,cin,etablissement,type,sujet,date_debut,date_fin,soutenance_orale,nom_encadrant,cin_encadrant from stage ";
		            PreparedStatement st = connection.prepareStatement(query);

		            ResultSet rs = st.executeQuery();
		            ResultSetMetaData rsmd = rs.getMetaData();

		            int cols = rsmd.getColumnCount();
		            String[] colName = new String[cols];

		            for (int i = 0; i < cols; i++)
		                colName[i] = rsmd.getColumnName(i + 1);

		            DefaultTableModel modele = new DefaultTableModel(colName, 0);

		            while (rs.next()) {
		            	 Object[] row = new Object[cols];
			                for (int i = 0; i < cols; i++) {
			                    row[i] = rs.getString(i + 1);

		            }
			                
			                modele.addRow(row);
		            }
		            table.setModel(modele);
		            st.close();
		            connection.close();
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        } catch (ClassNotFoundException e1) {
		            e1.printStackTrace();
		        }
		  }
}

	
