package stg;

import java.awt.EventQueue; 
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class espacestg extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	private JScrollPane scrollPane;
	private JTextField cinField;
	private JTextField tel;
	private JTextField email;
	private JTextField nom;
	private JTextField prm;
	private JTextField spec;
	ResultSet resultat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					espacestg frame = new espacestg();
					frame.setLocationRelativeTo(null);
					frame.afficher();
					frame.setVisible(true);
					frame.updateTableModel();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public espacestg() {
		setTitle("Espace stagiaire");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1360, 721);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 253, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(684, 10, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 255, 682);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JButton btnParamtres = new JButton("Paramètres");
		btnParamtres.setHorizontalAlignment(SwingConstants.LEADING);
		btnParamtres.setFocusPainted(false);
		btnParamtres.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-paramètres-30.png"));
		btnParamtres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parametre pm= new parametre();
				pm.setVisible(true);
				dispose();
			}
		});
		btnParamtres.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnParamtres.setBackground(new Color(240, 240, 240));
		btnParamtres.setBounds(10, 467, 235, 40);
		panel_1.add(btnParamtres);
		JButton btnNewButton_1 = new JButton("Evaluation des Stages");
		
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\ok.png"));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBounds(10, 371, 235, 37);
		panel_1.add(btnNewButton_1);
		
		
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\b.png"));
		label.setBounds(76, 11, 100, 136);
		panel_1.add(label);
		
		JButton btnDeconnection = new JButton("Deconnection");
		btnDeconnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceuil ac=new acceuil();
				ac.setVisible(true);
				ac.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnDeconnection.setForeground(new Color(255, 255, 255));
		btnDeconnection.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeconnection.setBackground(new Color(245, 73, 73));
		btnDeconnection.setBounds(10, 631, 235, 40);
		panel_1.add(btnDeconnection);
		
		JButton btnNewButton_3 = new JButton("Espace des encadrants");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\bad.png"));
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3.setBackground(new Color(240, 240, 240));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				espacencadrant esp =new espacencadrant();
				esp.setVisible(true);
				esp.setLocationRelativeTo(null);
				dispose();
				esp.afficher();
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(10, 170, 235, 40);
		panel_1.add(btnNewButton_3);
		
		JButton btnGestionDesAbscences = new JButton("Gestion des abscences");
		btnGestionDesAbscences.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\abs.png"));
		btnGestionDesAbscences.setHorizontalAlignment(SwingConstants.LEADING);
		btnGestionDesAbscences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Abscence ab=new Abscence();
				ab.setVisible(true);
				ab.setLocationRelativeTo(null);
				dispose();
				ab.afficher();
			}
		});
		btnGestionDesAbscences.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGestionDesAbscences.setFocusPainted(false);
		btnGestionDesAbscences.setBackground(new Color(240, 240, 240));
		btnGestionDesAbscences.setBounds(10, 269, 235, 40);
		panel_1.add(btnGestionDesAbscences);
		
		JButton btnGestionDesStages = new JButton("Gestion des stages");
		btnGestionDesStages.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\fl.png"));
		btnGestionDesStages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stage st=new stage();
				st.setVisible(true);
				st.setLocationRelativeTo(null);
				dispose();
				st.afficher();
			}
		});
		btnGestionDesStages.setHorizontalAlignment(SwingConstants.LEADING);
		btnGestionDesStages.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGestionDesStages.setFocusPainted(false);
		btnGestionDesStages.setBackground(new Color(240, 240, 240));
		btnGestionDesStages.setBounds(10, 320, 235, 40);
		panel_1.add(btnGestionDesStages);
		
		JButton btnNewButton_1_1 = new JButton(" Espace stagiaires");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\G.png"));
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1_1.setBounds(10, 221, 235, 37);
		panel_1.add(btnNewButton_1_1);
		
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
		btnNewButton_1_1_2.setBounds(10, 419, 235, 37);
		panel_1.add(btnNewButton_1_1_2);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(253, 0, 1117, 98);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Stagiaires");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(204, 30, 382, 39);
		panel_2.add(lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(883, 47, 122, 22);
		panel_2.add(comboBox);
		comboBox.addItem("CIN");
		comboBox.addItem("Nom");
		comboBox.addItem("Prenom");
		comboBox.addItem("Telephone");
		comboBox.addItem("Email");
		
		
		
		JButton rechercher = new JButton("");
		rechercher.setToolTipText("    ");
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
					
					String query = "SELECT * FROM stagiaire WHERE " + selectedItem + " LIKE '" + searchValue.toLowerCase() + "%'";

					ResultSet rs = st.executeQuery(query);
					
					DefaultTableModel modele = (DefaultTableModel) table.getModel();
					modele.setRowCount(0);
					
					while (rs.next()) {
						String cn = rs.getString(1);
						String nm = rs.getString(2);
						String pm = rs.getString(3);
						String tl = rs.getString(4);
						String ml = rs.getString(5);
						String date = rs.getString(6);
						
						
						String[] row = {cn, nm, pm, tl, ml, date};
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
		rechercher.setBounds(1015, 47, 32, 22);
		panel_2.add(rechercher);
		
		JLabel lblNewLabel_2 = new JLabel("Rechercher Par :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(767, 48, 122, 18);
		panel_2.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(271, 114, 1052, 312);
		contentPane.add(scrollPane);
		model=new DefaultTableModel();
		final Object[] row=new Object[6];
		
		JPanel panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(null);
		table = new JTable();
		table.setBackground(new Color(249, 254, 180));
		table.setSurrendersFocusOnKeystroke(true);
		table.addMouseListener(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent e) {

			int i=table.getSelectedRow();
			if(i>=0) {
			cinField.setText(table.getValueAt(i, 0).toString());
			nom.setText(table.getValueAt(i, 1).toString());
			prm.setText(table.getValueAt(i, 2).toString());
			tel.setText(table.getValueAt(i, 3).toString());
			email.setText(table.getValueAt(i,4).toString());
			spec.setText(table.getValueAt(i, 5).toString());
			
			
			}
			}
			});
		scrollPane.setViewportView(table);
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Evaluationn ev=new Evaluationn();
		    	ev.setVisible(true);
		    	ev.setLocationRelativeTo(null);
		    	dispose(); 
		    	ev.affichage();
		    }
		});
		cinField = new JTextField();
		cinField.setColumns(3);
		cinField.setBounds(398, 476, 158, 20);
		contentPane.add(cinField);
		
		tel = new JTextField();
		tel.setColumns(3);
		tel.setBounds(775, 476, 158, 20);
		contentPane.add(tel);
		
		email = new JTextField();
		email.setColumns(3);
		email.setBounds(775, 520, 158, 20);
		contentPane.add(email);
		
		JLabel lblNewLabel_1 = new JLabel(" CIN :");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(287, 479, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("TELEPHONE :");
		lblNewLabel_1_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(647, 479, 95, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("EMAIL :");
		lblNewLabel_1_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(647, 523, 57, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOM :");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(1053, 478, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		nom = new JTextField();
		nom.setColumns(3);
		nom.setBounds(1133, 476, 158, 20);
		contentPane.add(nom);
		
		JLabel lblNewLabel_1_2 = new JLabel("PRENOM :");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(287, 523, 72, 14);
		contentPane.add(lblNewLabel_1_2);
		
		prm = new JTextField();
		prm.setColumns(3);
		prm.setBounds(398, 520, 158, 20);
		contentPane.add(prm);
		
		spec = new JTextField();
		spec.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spec.setForeground(new Color(169, 169, 169));
		spec.setText("  yyyy-mm-dd");
		spec.setColumns(3);
		spec.setBounds(1133, 520, 158, 20);
		contentPane.add(spec);
		
		JLabel lblNewLabel_1_5 = new JLabel("DATE DE NAISSANCE :");
		lblNewLabel_1_5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(960, 520, 148, 14);
		contentPane.add(lblNewLabel_1_5);
		
		JButton btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
			        if (selectedRow >= 0) {
			            String url = "jdbc:mysql://localhost:3306/stageonda";
			            try {
			                Class.forName("com.mysql.cj.jdbc.Driver");
			                try {
			                    Connection connection = DriverManager.getConnection(url, "root", "");
			                    String query = "UPDATE stagiaire SET nom=?, prenom=?, telephone=?, email=?,date_naissance=? WHERE cin=?";

			                    PreparedStatement statement = connection.prepareStatement(query);
			                    statement.setString(1, nom.getText());
			                    statement.setString(2, prm.getText());
			                    statement.setString(3, tel.getText());
			                    statement.setString(4, email.getText());
			                    statement.setString(5, spec.getText());
			                    
			                    statement.setString(6, cinField.getText());

			                    int rowsAffected = statement.executeUpdate();
			                    if (rowsAffected > 0) {
			                        JOptionPane.showMessageDialog(null, "Modifié avec Succès");
			                        // Mettre à jour les valeurs dans le modèle de table
			                        DefaultTableModel model = (DefaultTableModel) table.getModel();
			                        if (model.getRowCount() > 0) {
			                            model.setValueAt(cinField.getText(), selectedRow, 0);			                         
			                            model.setValueAt(nom.getText(), selectedRow, 1);
			                            model.setValueAt(prm.getText(), selectedRow, 2);
			                            model.setValueAt(tel.getText(), selectedRow, 3);
			                            model.setValueAt(email.getText(), selectedRow, 4);
			                            model.setValueAt(spec.getText(), selectedRow, 5);
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
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\UP.png"));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton_2.setBounds(795, 603, 138, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Supprimer");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
			        if (selectedRow >= 0) {
			            String url = "jdbc:mysql://localhost:3306/stageonda";
			            try {
			                Class.forName("com.mysql.cj.jdbc.Driver");
			                try {
			                    Connection connection = DriverManager.getConnection(url, "root", "");
			                    String query = "DELETE FROM stagiaire WHERE cin = ?";

			                    PreparedStatement statement = connection.prepareStatement(query);
			                    statement.setString(1, cinField.getText());

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
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\dd.png"));
		btnNewButton_2_1.setFocusPainted(false);
		
		btnNewButton_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton_2_1.setBounds(960, 603, 138, 34);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Effacer");
		btnNewButton_2_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\fr.png"));
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cinField.setText("");
				nom.setText("");
				prm.setText("");
				tel.setText("");
				email.setText("");
				spec.setText("");
				
			}
				
		});
		btnNewButton_2_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton_2_1_1.setFocusPainted(false);
		btnNewButton_2_1_1.setBounds(1121, 603, 122, 34);
		contentPane.add(btnNewButton_2_1_1);
		
		JButton ajouter = new JButton("Nouveau stagiaire");
		ajouter.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\h.png"));
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cinField.getText().equals("") || nom.getText().equals("") || prm.getText().equals("") || email.getText().equals("") || tel.getText().equals("")

						|| spec.getText().equals("")) {

						JOptionPane.showMessageDialog(null,"Veuillez Remplir Tout Les Champs");

						}

						else {

						row[0]=cinField.getText();
						row[1]=nom.getText();
						row[2]=prm.getText();
						row[3]=tel.getText();
						row[4]=email.getText();
						row[5]=spec.getText();
						
						model.addRow(row);

						String url = "jdbc:mysql://localhost:3306/stageonda";

						try {

						Class.forName("com.mysql.cj.jdbc.Driver");

						try {

						Connection connection=DriverManager.getConnection(url,"root","");

						String sql="INSERT INTO stagiaire(cin,nom,prenom,telephone,email,date_naissance)"

						+ " VALUES ('"+cinField.getText()+"','"+nom.getText()+"','"+prm.getText()+"','"+ tel.getText()+"','"+email.getText()+"','"+spec.getText()+"')";

						PreparedStatement stat=connection.prepareStatement(sql);

						stat.executeUpdate(sql);

						System.out.println("Connected");

						JOptionPane.showMessageDialog(null,"Enregistré Avec Succès");
						updateTableModel();
						stat.close();

						connection.close();

						}

						catch (Exception ex) {

						ex.printStackTrace();

						}

						}

						catch (Exception ex) {

						ex.printStackTrace();

						}

						//}

						}
			}
		});
		ajouter.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		ajouter.setFocusPainted(false);
		ajouter.setBounds(587, 603, 179, 34);
		contentPane.add(ajouter);
		
		JButton btnNewButton_2_2 = new JButton("Actualiser");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficher();
			}
		});
		btnNewButton_2_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\rt.png"));
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_2.setFocusPainted(false);
		btnNewButton_2_2.setBounds(380, 603, 179, 34);
		contentPane.add(btnNewButton_2_2);
		
		
		JButton btnNewButton = new JButton("Nouveau Stagiaire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				}
						});

				
			}
	
	  /*private String getEncadrantCIN(String nomEncadrant) {
		  String url = "jdbc:mysql://localhost:3306/stageonda";
		  Connection connection = null;
		try {
			connection = DriverManager.getConnection(url,"root","");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
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
	    }	*/
	
	// Méthode pour mettre à jour le modèle de tableau avec les données actualisées de la base de données
	  public void updateTableModel() {
	      String url = "jdbc:mysql://localhost:3306/stageonda";
	      try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection connection = DriverManager.getConnection(url, "root", "");

	          String query = "SELECT cin, nom, prenom, telephone, email,date_naissance  FROM stagiaire";
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
	  
	  public void afficher() {
		  String url = "jdbc:mysql://localhost:3306/stageonda";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(url, "root", "");

	            String query = "SELECT cin,nom,prenom,telephone,email,date_naissance FROM stagiaire ";  
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
