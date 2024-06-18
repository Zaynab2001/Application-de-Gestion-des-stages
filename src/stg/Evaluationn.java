package stg;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import stg.Calculatrice;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.SystemColor;
public class Evaluationn extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Calculatrice calculatrice;
	private JTextField cin;
	private JTextField date;
	private JTextField note;
	private JComboBox combonom;
	final Object[] row=new Object[7];
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Evaluationn frame = new Evaluationn();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.affichage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Evaluationn() {
		setTitle("Evaluation des stagiaires");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1360, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 255, 682);
		contentPane.add(panel_1);
		

		final JComboBox comborapport = new JComboBox();
		comborapport.setBackground(new Color(237, 255, 225));
		comborapport.setForeground(new Color(0, 0, 0));
		comborapport.setModel(new DefaultComboBoxModel(new String[] {"", "Remis", "Non Remis"}));
		comborapport.setBounds(1158, 459, 125, 22);
		contentPane.add(comborapport);
		
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
		btnParamtres.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnParamtres.setBackground(new Color(240, 240, 240));
		btnParamtres.setBounds(10, 510, 235, 40);
		panel_1.add(btnParamtres);
		
		JButton btnNewButton_1 = new JButton(" Espace stagiaires");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\G.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espacestg esp =new espacestg();
				esp.setVisible(true);
				esp.setLocationRelativeTo(null);
				dispose();
				esp.afficher();
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.setBounds(10, 218, 235, 37);
		panel_1.add(btnNewButton_1);
		model=new DefaultTableModel();
		
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
		btnDeconnection.setBackground(Color.RED);
		btnDeconnection.setBounds(10, 631, 235, 40);
		panel_1.add(btnDeconnection);
		
		JButton btnGestionDesAbscences = new JButton("Gestion des abscences");
		btnGestionDesAbscences.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\abs.png"));
		btnGestionDesAbscences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Abscence esp =new Abscence();
				esp.setVisible(true);
				esp.setLocationRelativeTo(null);
				dispose();
				esp.afficher();
			}
		});
		btnGestionDesAbscences.setHorizontalAlignment(SwingConstants.LEADING);
		btnGestionDesAbscences.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGestionDesAbscences.setFocusPainted(false);
		btnGestionDesAbscences.setBackground(new Color(240, 240, 240));
		btnGestionDesAbscences.setBounds(10, 266, 235, 40);
		panel_1.add(btnGestionDesAbscences);
		
		JButton btnNewButton_1_1_1 = new JButton("Gestion des stages");
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\fl.png"));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stage esp =new stage();
				esp.setVisible(true);
				esp.setLocationRelativeTo(null);
				dispose();
				esp.afficher();
			}
		});
		btnNewButton_1_1_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1_1.setFocusPainted(false);
		btnNewButton_1_1_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1_1_1.setBounds(10, 317, 235, 37);
		panel_1.add(btnNewButton_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(254, 0, 1090, 98);
		contentPane.add(panel_2);
		
		JLabel lblEvaluationsDesStages = new JLabel("Evaluation des stagiaires");
		lblEvaluationsDesStages.setForeground(Color.WHITE);
		lblEvaluationsDesStages.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblEvaluationsDesStages.setBounds(154, 30, 438, 39);
		panel_2.add(lblEvaluationsDesStages);
		
		final JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(836, 47, 130, 22);
		panel_2.add(comboBox);
		comboBox.addItem("CIN");
		comboBox.addItem("nom_complet");
		comboBox.addItem("Mention_jury");
		comboBox.addItem("Rapport");
		
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
					
					String query = "SELECT nom_complet,date_soutenance,Mention_jury,note,cin,rapport FROM evaluation WHERE " + selectedItem + " LIKE '" + searchValue.toLowerCase() + "%'";

					ResultSet rs = st.executeQuery(query);
					
					DefaultTableModel modele = (DefaultTableModel) table.getModel();
					modele.setRowCount(0);
					
					while (rs.next()) {
						String nm = rs.getString(1);
						String dt = rs.getString(2);
						String mn = rs.getString(3);
						String nt = rs.getString(4);
						String cn = rs.getString(5);
						String rp = rs.getString(6);
						
						
						String[] row = {nm,dt,mn,nt,cn,rp};
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
		rechercher.setBounds(976, 47, 37, 22);
		panel_2.add(rechercher);
		
		JButton btnCalculatrice = new JButton("Calculatrice");
		btnCalculatrice.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\clc.png"));
		btnCalculatrice.setFocusPainted(false);
		btnCalculatrice.setBackground(new Color(240, 240, 240));
		btnCalculatrice.setHorizontalAlignment(SwingConstants.LEADING);
		btnCalculatrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCalculatrice.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        showCalculatrice();
		    }
		});
		btnCalculatrice.setBounds(10, 414, 235, 37);
		panel_1.add(btnCalculatrice);
		
		JButton btnNewButton_1_1 = new JButton(" Espace Encadrant");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\bad.png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espacencadrant esp =new espacencadrant();
				esp.setVisible(true);
				esp.setLocationRelativeTo(null);
				dispose();
				esp.afficher();
			}
		});
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1_1.setBounds(10, 170, 235, 37);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Evaluation de Stage");
		btnNewButton_1_1_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\ok.png"));
		btnNewButton_1_1_2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1_2.setFocusPainted(false);
		btnNewButton_1_1_2.setBackground(new Color(153, 180, 209));
		btnNewButton_1_1_2.setBounds(10, 366, 235, 37);
		panel_1.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_1_2_1 = new JButton("Les statistiques");
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistics st=new Statistics();
				st.setVisible(true);
				st.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1_1_2_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\l.png"));
		btnNewButton_1_1_2_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1_2_1.setFocusPainted(false);
		btnNewButton_1_1_2_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1_1_2_1.setBounds(10, 462, 235, 37);
		panel_1.add(btnNewButton_1_1_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rechercher Par :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(704, 48, 122, 18);
		panel_2.add(lblNewLabel_2);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(289, 109, 1045, 216);
		contentPane.add(scrollPane1);
		
		final JComboBox combojury = new JComboBox();
		combojury.setBackground(new Color(237, 255, 225));
		combojury.setModel(new DefaultComboBoxModel(new String[] {"", "Passable", "A-Bien", "Bien ", "Très Bien", "Excellent"}));
		combojury.setBounds(792, 459, 127, 22);
		contentPane.add(combojury);
		
		
		table = new JTable();
		table.setBackground(new Color(225, 225, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  int i = table.getSelectedRow();
				  
			        if (i >= 0) {
			        	
			            combonom.setSelectedItem(table.getValueAt(i, 0).toString());
			            note.setText(table.getValueAt(i, 3).toString());
			            date.setText(table.getValueAt(i, 1).toString());
			            combojury.setSelectedItem(table.getValueAt(i, 2).toString());
			            cin.setText(table.getValueAt(i, 4).toString());
			            comborapport.setSelectedItem(table.getValueAt(i, 5).toString());
			        }
			    }
			
			
		});
		scrollPane1.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Nom complet :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(324, 391, 103, 27);
		contentPane.add(lblNewLabel);
		
		combonom = new JComboBox();
		combonom.setBackground(new Color(237, 255, 225));
		combonom.setModel(new DefaultComboBoxModel(new String[] {""}));
		remplircombobox();
		combonom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedStagiaire = (String) combonom.getSelectedItem();

                // Récupérer le CIN correspondant à partir de la base de données
                String cintxt = getStagiaireCIN(selectedStagiaire);

                // Afficher le CIN dans le JTextField
                cin.setText(cintxt);
			}
		});
		combonom.setBounds(419, 394, 125, 22);
		contentPane.add(combonom);
		
		JLabel lblNewLabel_1 = new JLabel("CIN :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(734, 397, 40, 14);
		contentPane.add(lblNewLabel_1);
		
		cin = new JTextField();
		cin.setBounds(792, 395, 125, 20);
		contentPane.add(cin);
		cin.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Date de soutenance :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(1023, 398, 125, 20);
		contentPane.add(lblNewLabel_4);
		
		date = new JTextField();
		date.setForeground(new Color(169, 169, 169));
		date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		date.setText("  yyyy-mm-dd");
		date.setColumns(10);
		date.setBounds(1158, 395, 125, 20);
		contentPane.add(date);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mention du jury :");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(668, 459, 106, 20);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("La note finale :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(324, 456, 91, 27);
		contentPane.add(lblNewLabel_5);
		
		note = new JTextField();
		note.setColumns(10);
		note.setBounds(419, 460, 125, 20);
		contentPane.add(note);
		
		JLabel lblNewLabel_6 = new JLabel("Rapport :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(1087, 458, 54, 22);
		contentPane.add(lblNewLabel_6);
		

	
		JButton btnNewButton = new JButton("Enregistrer ");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\+.png"));
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (combonom.getSelectedItem().equals("") || note.getText().equals("") || date.getText().equals("")
		                || combojury.getSelectedItem().equals("") || cin.getText().equals("")) {
		            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
		        } else {
		           
		            row[0] = combonom.getSelectedItem();
		            row[1] = date.getText();
		            row[2] = combojury.getSelectedItem();
		            row[3] = note.getText();
		            row[4] = cin.getText();
		            row[5] = comborapport.getSelectedItem();

		            model.addRow(row);

		            String url = "jdbc:mysql://localhost:3306/stageonda";

		            try {
		                Class.forName("com.mysql.cj.jdbc.Driver");

		                try {
		                    Connection connection = DriverManager.getConnection(url, "root", "");

		                    // Vérification si l'évaluation existe déjà
		                    String existingEvaluationQuery = "SELECT nom_complet,date_soutenance,Mention_jury,note,cin,rapport FROM evaluation WHERE cin=?";
		                    PreparedStatement existingEvaluationStat = connection.prepareStatement(existingEvaluationQuery);
		                    existingEvaluationStat.setString(1, cin.getText());
		                    ResultSet existingEvaluationResult = existingEvaluationStat.executeQuery();

		                    if (existingEvaluationResult.next()) {
		                        // L'évaluation existe déjà, afficher un message d'erreur
		                        JOptionPane.showMessageDialog(null, "Vous avez déjà évaluer cette personne !");
		                    } else {
		                        // L'évaluation n'existe pas encore, procéder à l'insertion
		                        String insertQuery = "INSERT INTO evaluation(nom_complet,date_soutenance,Mention_jury,note,cin,rapport) VALUES (?, ?, ?, ?, ?, ?)";
		                        PreparedStatement insertStat = connection.prepareStatement(insertQuery);
		                       
		                        insertStat.setString(1, (String) combonom.getSelectedItem());
		                        insertStat.setString(2, date.getText());
		                        insertStat.setString(3, (String) combojury.getSelectedItem());
		                        insertStat.setString(4, note.getText());
		                        insertStat.setString(5, cin.getText());
		                        insertStat.setString(6, (String) comborapport.getSelectedItem());

		                        insertStat.executeUpdate();

		                        System.out.println("Connected");
		                        JOptionPane.showMessageDialog(null, "Enregistré avec succès");
		                        updateTableModel();

		                        insertStat.close();
		                    }

		                    existingEvaluationStat.close();
		                    connection.close();
		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                }
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(528, 594, 173, 34);
		contentPane.add(btnNewButton);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\UP.png"));
		btnModifier.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   	 int selectedRow = table.getSelectedRow();
		        if (selectedRow >= 0) {
		            String url = "jdbc:mysql://localhost:3306/stageonda";
		            try {
		                Class.forName("com.mysql.cj.jdbc.Driver");
		                try {
		                    Connection connection = DriverManager.getConnection(url, "root", "");
		                    String query = "UPDATE evaluation SET nom_complet=?, date_soutenance=?, Mention_jury=?, note=?, cin=?, rapport=? WHERE cin=?";

		                    PreparedStatement statement = connection.prepareStatement(query);
		                    
		                    statement.setString(1, combonom.getSelectedItem().toString());
		                    statement.setString(2, date.getText());
		                    statement.setString(3, combojury.getSelectedItem().toString());
		                    statement.setString(4, note.getText());	                 
		                    statement.setString(5, cin.getText());
		                    statement.setString(6, comborapport.getSelectedItem().toString());
		                    statement.setString(7, cin.getText());

		                    int rowsAffected = statement.executeUpdate();
		                    if (rowsAffected > 0) {
		                        JOptionPane.showMessageDialog(null, "Modifié avec Succès");
		                        // Mettre à jour les valeurs dans le modèle de table
		                        DefaultTableModel model = (DefaultTableModel) table.getModel();
		                        if (model.getRowCount() > 0) {
		                          		                         
		                            model.setValueAt(combonom.getSelectedItem(), selectedRow, 0);
		                            model.setValueAt(date.getText(), selectedRow, 1);
		                            model.setValueAt(combojury.getSelectedItem(), selectedRow, 2);
		                            model.setValueAt(note.getText(), selectedRow, 3);
		                            model.setValueAt(cin.getText(), selectedRow, 4);
		                            model.setValueAt(comborapport.getSelectedItem(), selectedRow, 5);
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

		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModifier.setBounds(722, 594, 173, 34);
		contentPane.add(btnModifier);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\fr.png"));
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cin.setText("");
				combonom.setSelectedItem("");
			
				combojury.setSelectedItem("");
				comborapport.setSelectedItem("");
				date.setText("");
				note.setText("");
			}
		});
		btnEffacer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEffacer.setBounds(918, 594, 173, 34);
		contentPane.add(btnEffacer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\dd.png"));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
		    	    if (selectedRow >= 0) {
		    	        String url = "jdbc:mysql://localhost:3306/stageonda";
		    	        try {
		    	            Class.forName("com.mysql.cj.jdbc.Driver");
		    	            try {
		    	                Connection connection = DriverManager.getConnection(url, "root", "");
		    	                String query = "DELETE FROM evaluation WHERE cin = ?";

		    	                PreparedStatement statement = connection.prepareStatement(query);
		    	                statement.setString(1, cin.getText());

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
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSupprimer.setBounds(1112, 594, 155, 34);
		contentPane.add(btnSupprimer);
		
		JButton btnNewButton_2 = new JButton("Actualiser");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichage();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\rt.png"));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBounds(335, 595, 173, 32);
		contentPane.add(btnNewButton_2);
		
		Label label_1 = new Label("NB : le cin des stagiaires est affiché automatiquement après la selection de leurs noms !");
		label_1.setForeground(Color.RED);
		label_1.setBounds(289, 337, 624, 22);
		contentPane.add(label_1);
		
	}
	
	public void affichage() {
		 String url = "jdbc:mysql://localhost:3306/stageonda";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(url, "root", "");

	            String query = "SELECT nom_complet,date_soutenance,Mention_jury,note,cin,rapport FROM evaluation ";  
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
	
	private void showCalculatrice() {
	    if (calculatrice == null) {
	        calculatrice = new Calculatrice();
	        calculatrice.setLocationRelativeTo(this);
	        calculatrice.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    }
	    calculatrice.setVisible(true);
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
	  
	 
	  public void remplircombobox() {
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
		                combonom.addItem(nom + " " + prenom);
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
	  
	  private void updateTableModel() {
		    String url = "jdbc:mysql://localhost:3306/stageonda";

		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection connection = DriverManager.getConnection(url, "root", "");

		        String query = "SELECT nom_complet,date_soutenance,Mention_jury,note,cin,rapport FROM evaluation ";
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
