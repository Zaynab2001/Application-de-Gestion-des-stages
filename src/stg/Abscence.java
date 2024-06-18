package stg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
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

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import java.awt.Choice;

public class Abscence extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField date;
	private JTextField just;
	private JTextField cin;
	private ResultSet resultat;
	private JComboBox combo;
	private JTextField countField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Abscence frame = new Abscence();
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
	
	public void remplircombobox() {
		
		String url = "jdbc:mysql://localhost:3306/stageonda";

		try {

		Class.forName("com.mysql.cj.jdbc.Driver");

		try {

		Connection connection=DriverManager.getConnection(url,"root","");
		String sql="select nom,prenom from stagiaire";
		PreparedStatement stat=connection.prepareStatement(sql);
		resultat =stat.executeQuery();
		
		while(resultat.next()) {
			String nom=resultat.getString("nom").toString();
			String prenom=resultat.getString("prenom").toString();
			combo.addItem(nom + " " + prenom);

		}
		 stat.close();
         connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Abscence() {
		setTitle("Gestion des abscences");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1360, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(255, 0, 1089, 98);
		contentPane.add(panel_2);
		
		JLabel lblGestionDesAbscences = new JLabel("Gestion Des Abscences");
		lblGestionDesAbscences.setForeground(Color.WHITE);
		lblGestionDesAbscences.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblGestionDesAbscences.setBounds(216, 30, 382, 39);
		panel_2.add(lblGestionDesAbscences);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(883, 47, 122, 22);
		panel_2.add(comboBox);
		
		
		comboBox.addItem("justification");
		comboBox.addItem("cin");
		comboBox.addItem("nom_stagiaire");
		
		countField = new JTextField();
		countField.setBounds(1080, 388, 95, 31);
		contentPane.add(countField);

		JButton rechercher = new JButton("");
		rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/stageonda";
				String selectedItem = comboBox.getSelectedItem().toString();
				String searchValue = JOptionPane.showInputDialog(null, "Entrez la valeur de recherche :", "Recherche", JOptionPane.QUESTION_MESSAGE);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection connection = DriverManager.getConnection(url,"root","");
					Statement st = connection.createStatement();
					
					String query = "SELECT date_abscence,justification,cin,nom_stagiaire FROM abscence WHERE " + selectedItem + " LIKE '" + searchValue.toLowerCase() + "%'";

					ResultSet rs = st.executeQuery(query);
					
					DefaultTableModel modele = (DefaultTableModel) table.getModel();
					modele.setRowCount(0);
					
					while (rs.next()) {
						String dat = rs.getString(1);
						String jus = rs.getString(2);					
						String cin = rs.getString(3);
						String nm = rs.getString(4);
						
						
						String[] row = {dat,jus,cin,nm};
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
		rechercher.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\RECH.png"));
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
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 255, 682);
		contentPane.add(panel_1);
		
		JButton btnParamtres = new JButton("Paramètres");
		btnParamtres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parametre esp =new parametre();
				esp.setVisible(true);
				esp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnParamtres.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-paramètres-30.png"));
		btnParamtres.setHorizontalAlignment(SwingConstants.LEADING);
		btnParamtres.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnParamtres.setFocusPainted(false);
		btnParamtres.setBackground(new Color(240, 240, 240));
		btnParamtres.setBounds(10, 469, 235, 40);
		panel_1.add(btnParamtres);
		
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
		btnDeconnection.setBounds(10, 631, 235, 40);
		panel_1.add(btnDeconnection);
		
		JButton btnNewButton_3_1 = new JButton("Espace des encadrants");
		btnNewButton_3_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\bad.png"));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espacencadrant es=new espacencadrant();
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
		btnNewButton_3_1.setBounds(10, 169, 235, 40);
		panel_1.add(btnNewButton_3_1);
		
	
		table = new JTable();
		table.setBackground(new Color(200, 255, 145));
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(302, 133, 587, 487);
		contentPane.add(scrollPane);
		model=new DefaultTableModel();
		final Object[] row=new Object[4];
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
				
				date.setText(table.getValueAt(i, 0).toString());
				just.setText(table.getValueAt(i, 1).toString());
				cin.setText(table.getValueAt(i, 2).toString());
				combo.setSelectedItem(table.getValueAt(i,3).toString());
			}
			}}
		);
		JButton btnNewButton_1 = new JButton("Evaluation des stages");
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
		
		JButton btnNewButton_3_1_1 = new JButton("Espace des stagiaires");
		btnNewButton_3_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\G.png"));
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espacestg es=new espacestg();
				es.setVisible(true);
				es.setLocationRelativeTo(null);
				dispose();
				es.afficher();
			}
		});
		btnNewButton_3_1_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1_1.setFocusPainted(false);
		btnNewButton_3_1_1.setBackground(new Color(240, 240, 240));
		btnNewButton_3_1_1.setBounds(10, 220, 235, 40);
		panel_1.add(btnNewButton_3_1_1);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-conférence-100.png"));
		lblNewLabel.setBounds(71, 24, 104, 137);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_3_1_1_1 = new JButton("Gestion des stages");
		btnNewButton_3_1_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\fl.png"));
		btnNewButton_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stage st=new stage();
				st.setVisible(true);
				st.setLocationRelativeTo(null);
				dispose();
				st.afficher();
			}
		});
		btnNewButton_3_1_1_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1_1_1.setFocusPainted(false);
		btnNewButton_3_1_1_1.setBackground(new Color(240, 240, 240));
		btnNewButton_3_1_1_1.setBounds(10, 322, 235, 40);
		panel_1.add(btnNewButton_3_1_1_1);
		
		JButton btnGestionDesAbscences = new JButton("Gestion des abscences");
		btnGestionDesAbscences.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\abs.png"));
		btnGestionDesAbscences.setHorizontalAlignment(SwingConstants.LEADING);
		btnGestionDesAbscences.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGestionDesAbscences.setFocusPainted(false);
		btnGestionDesAbscences.setBackground(SystemColor.activeCaption);
		btnGestionDesAbscences.setBounds(10, 271, 235, 40);
		panel_1.add(btnGestionDesAbscences);
		
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
		
		date = new JTextField();
		date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		date.setForeground(new Color(169, 169, 169));
		date.setText("  yyyy-mm-dd");
		date.setColumns(10);
		date.setBounds(1084, 179, 215, 31);
		contentPane.add(date);
		
		just = new JTextField();
		just.setColumns(10);
		just.setBounds(1084, 231, 215, 31);
		contentPane.add(just);
		
		cin = new JTextField();
		cin.setColumns(10);
		cin.setBounds(1084, 336, 215, 31);
		contentPane.add(cin);
		
		combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {""}));
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String selectedStagiaire = (String) combo.getSelectedItem();

	                // Récupérer le CIN correspondant à partir de la base de données
	                String cintxt = getStagiaireCIN(selectedStagiaire);

	                // Afficher le CIN dans le JTextField
	                cin.setText(cintxt);
			}
		});
		combo.setBounds(1084, 283, 215, 31);
		contentPane.add(combo);
		remplircombobox();
		
		Label label_1_1 = new Label("Date abscence :");
		label_1_1.setBounds(939, 188, 108, 22);
		contentPane.add(label_1_1);
		
		Label label_1_2 = new Label("Justification :");
		label_1_2.setBounds(939, 240, 108, 22);
		contentPane.add(label_1_2);
		
		Label label_1_3 = new Label("Cin stagiaire :");
		label_1_3.setBounds(939, 345, 108, 22);
		contentPane.add(label_1_3);
		
		Label label_1_4 = new Label("Nom stagiaire :");
		label_1_4.setBounds(939, 292, 108, 22);
		contentPane.add(label_1_4);
		
		Label label_1_4_1 = new Label("Nombre d'abscences :");
		label_1_4_1.setBounds(939, 397, 122, 22);
		contentPane.add(label_1_4_1);
		
		JButton countButton = new JButton("Compter");
		countButton.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\clc.png"));
		countButton.setFocusPainted(false);
		countButton.setBackground(new Color(225, 231, 253));
		countButton.setBounds(1185, 388, 121, 31);
		contentPane.add(countButton);
		countButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 String selectedPerson = combo.getSelectedItem().toString();
		         int count = 0;

		         for (int i = 0; i < table.getRowCount(); i++) {
		             String person = table.getValueAt(i, 3).toString();
		             if (person.equals(selectedPerson)) {
		                 count++;
		             }
		         }

		         countField.setText(Integer.toString(count));
		     
		    }
		});

		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\+.png"));
		btnNewButton.setBackground(new Color(225, 231, 253));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				row[0]=date.getText();
				row[1]=just.getText();
				row[2]=cin.getText();
				row[3]=combo.getSelectedItem().toString();
				
			
				model.addRow(row);

				String url = "jdbc:mysql://localhost:3306/stageonda";

				try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				try {

				Connection connection=DriverManager.getConnection(url,"root","");

				String sql="INSERT INTO abscence (date_abscence,justification,cin,nom_stagiaire)"

				+ " VALUES ('"+date.getText()+"','"+just.getText()+"','"+ cin.getText()+"','"+combo.getSelectedItem().toString()+"')";

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
		});
		btnNewButton.setBounds(1133, 480, 177, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\UP.png"));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	  int selectedRow = table.getSelectedRow();
		    	    if (selectedRow >= 0) {
		    	        String url = "jdbc:mysql://localhost:3306/stageonda";
		    	        try {
		    	            Class.forName("com.mysql.cj.jdbc.Driver");
		    	            try {
		    	                Connection connection = DriverManager.getConnection(url, "root", "");
		    	                String query = "UPDATE abscence SET date_abscence=?, justification=?, cin=?,nom_stagiaire=? WHERE cin=?";

		    	                PreparedStatement statement = connection.prepareStatement(query);
		    	                statement.setString(1, date.getText());
		    	                statement.setString(2, just.getText());
		    	                statement.setString(3, cin.getText());
		    	                statement.setString(4, cin.getText());
		    	                statement.setString(5, combo.getSelectedItem().toString());
		    	                

		    	                int rowsAffected = statement.executeUpdate();
		    	                if (rowsAffected > 0) {
		    	                    JOptionPane.showMessageDialog(null, "Modifié avec Succès");
		    	                    // Mettre à jour les valeurs dans le modèle de table
		    	                    DefaultTableModel model = (DefaultTableModel) table.getModel();
		    	                    if (model.getRowCount() > 0) {
		    	                       
		    	                        model.setValueAt(date.getText(), selectedRow, 0);
		    	                        model.setValueAt(just.getText(), selectedRow, 1);
		    	                        model.setValueAt(cin.getText(), selectedRow, 2);
		    	                        model.setValueAt(combo.getSelectedItem().toString(), selectedRow, 3);
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


		btnNewButton_2.setBackground(new Color(225, 231, 253));
		btnNewButton_2.setBounds(926, 480, 177, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Effacer");
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\fr.png"));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				date.setText("");
				just.setText("");
				combo.setSelectedItem("");
				cin.setText("");
				countField.setText("");
			}
		});
		btnNewButton_2_1.setFocusPainted(false);
		btnNewButton_2_1.setBackground(new Color(225, 231, 253));
		btnNewButton_2_1.setBounds(926, 530, 177, 39);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Supprimer");
		btnNewButton_2_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\dd.png"));
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = table.getSelectedRow();
			        if (selectedRow >= 0) {
			            String url = "jdbc:mysql://localhost:3306/stageonda";
			            try {
			                Class.forName("com.mysql.cj.jdbc.Driver");
			                try {
			                    Connection connection = DriverManager.getConnection(url, "root", "");
			                    String query = "DELETE FROM Abscence WHERE cin = ? and nom_stagiaire=? and justification=? and date_abscence=?";

			                    PreparedStatement statement = connection.prepareStatement(query);
			                    statement.setString(1, cin.getText());
			                    statement.setString(2, combo.getSelectedItem().toString());
			                    statement.setString(3, just.getText());
			                    statement.setString(4, date.getText());

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
		btnNewButton_2_1_1.setFocusPainted(false);
		btnNewButton_2_1_1.setBackground(new Color(225, 231, 253));
		btnNewButton_2_1_1.setBounds(1133, 530, 177, 39);
		contentPane.add(btnNewButton_2_1_1);
		
		Label label_1_5 = new Label("NB : le cin des stagiaires est  affiché automatiquement après la selection de leurs noms !");
		label_1_5.setForeground(Color.RED);
		label_1_5.setBounds(302, 634, 587, 22);
		contentPane.add(label_1_5);
		
		JButton btnNewButton_3 = new JButton("Actualiser");
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\rt.png"));
		btnNewButton_3.setBackground(new Color(225, 231, 253));
		btnNewButton_3.setBounds(926, 580, 177, 39);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Veuillez Saisir l'abscence :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(939, 130, 148, 22);
		contentPane.add(lblNewLabel_1);
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
	  
	  public void updateTableModel() {
		  model = (DefaultTableModel) table.getModel();
		    model.setRowCount(0); // Supprime toutes les lignes du modèle actuel

		    String url = "jdbc:mysql://localhost:3306/stageonda";
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        try {
		            Connection connection = DriverManager.getConnection(url, "root", "");
		            String query = "SELECT date_abscence, justification, cin, nom_stagiaire FROM abscence";
		            PreparedStatement statement = connection.prepareStatement(query);
		            ResultSet rs = statement.executeQuery();

		            while (rs.next()) {
		                
		                String date = rs.getString("date_abscence");
		                String justification = rs.getString("justification");
		                String cin = rs.getString("cin");
		                String nomStagiaire = rs.getString("nom_stagiaire");

		                Object[] rowData = {date, justification, cin, nomStagiaire};
		                model.addRow(rowData);
		                combo.addItem(nomStagiaire); // Ajouter le nom du stagiaire à la JComboBox
		            }

		            statement.close();
		            connection.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    } catch (ClassNotFoundException ex) {
		        ex.printStackTrace();
		    }}
	  
	  public void afficher() {
		  String url = "jdbc:mysql://localhost:3306/stageonda";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(url, "root", "");
	            String query = "SELECT date_abscence, justification, cin, nom_stagiaire FROM abscence";
	            PreparedStatement st = connection.prepareStatement(query);
	            ResultSet rs = st.executeQuery();
	            ResultSetMetaData rsmd = rs.getMetaData();
	            int cols = rsmd.getColumnCount();
	            String[] colName = new String[cols];

	            for (int i = 0; i < cols; i++) {
	                colName[i] = rsmd.getColumnName(i + 1);
	            }
	            
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