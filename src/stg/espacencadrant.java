package stg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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

import javax.swing.JTable;
import java.awt.Label;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class espacencadrant extends JFrame {

	private JPanel contentPane;
	private JTextField cin;
	private JTextField nom;
	private JTextField email;
	private JTextField tel;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					espacencadrant frame = new espacencadrant();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
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
	public espacencadrant() {
		setTitle("Espace encadrant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnParamtres.setHorizontalAlignment(SwingConstants.LEADING);
		btnParamtres.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-paramètres-30.png"));
		btnParamtres.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnParamtres.setBackground(new Color(240, 240, 240));
		btnParamtres.setBounds(10, 465, 235, 40);
		panel_1.add(btnParamtres);
		
		JButton btnNewButton_1 = new JButton(" Espace stagiaires");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\G.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				espacestg sp=new espacestg();
				sp.setVisible(true);
				sp.setLocationRelativeTo(null);
				dispose();
				sp.afficher();
			}
		});
		
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.setBounds(10, 221, 235, 37);
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
		btnDeconnection.setBackground(new Color(255, 0, 0));
		btnDeconnection.setBounds(10, 631, 231, 40);
		panel_1.add(btnDeconnection);
		
		JButton btnNewButton_1_1 = new JButton("Evaluation de Stage");
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\ok.png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Evaluationn ev=new Evaluationn();
		    	ev.setVisible(true);
		    	ev.setLocationRelativeTo(null);
		    	dispose();
		    	ev.affichage();
					
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1_1.setBounds(10, 368, 235, 37);
		panel_1.add(btnNewButton_1_1);
		
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
		
		JLabel lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\b.png"));
		lblNewLabel_3.setBounds(83, 11, 104, 135);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_1_1_1 = new JButton("Gestion des stages");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stage st=new stage();
				st.setVisible(true);
				st.setLocationRelativeTo(null);
				dispose();
				st.afficher();
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\fl.png"));
		btnNewButton_1_1_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1_1.setFocusPainted(false);
		btnNewButton_1_1_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1_1_1.setBounds(10, 320, 235, 37);
		panel_1.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_3_1 = new JButton("Espace des encadrants");
		btnNewButton_3_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\bad.png"));
		btnNewButton_3_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1.setFocusPainted(false);
		btnNewButton_3_1.setBackground(SystemColor.activeCaption);
		btnNewButton_3_1.setBounds(10, 170, 235, 40);
		panel_1.add(btnNewButton_3_1);
		
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
		btnNewButton_1_1_2.setBounds(10, 416, 235, 37);
		panel_1.add(btnNewButton_1_1_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(254, 0, 1089, 98);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Encadrants");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(178, 30, 382, 39);
		panel_2.add(lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(836, 47, 130, 22);
		panel_2.add(comboBox);
		comboBox.addItem("cin_encadrant");
		comboBox.addItem("Nom_complet");
		comboBox.addItem("Telephone");
		comboBox.addItem("Email");
		
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
					
					String query = "SELECT cin_encadrant, nom_complet, telephone, email FROM encadrant WHERE " + selectedItem + " LIKE '" + searchValue.toLowerCase() + "%'";

					ResultSet rs = st.executeQuery(query);
					
					DefaultTableModel modele = (DefaultTableModel) table.getModel();
					modele.setRowCount(0);
					
					while (rs.next()) {
						String cn = rs.getString(1);
						String nm = rs.getString(2);
						String tl = rs.getString(3);
						String ml = rs.getString(4);
						
						
						String[] row = {cn, nm, tl, ml};
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
		rechercher.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\RECH.png"));
		rechercher.setBounds(976, 47, 37, 22);
		panel_2.add(rechercher);
		
		JLabel lblNewLabel_2 = new JLabel("Rechercher Par :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(704, 48, 122, 18);
		panel_2.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(278, 117, 1045, 304);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setBackground(new Color(255, 228, 210));
		table.setSurrendersFocusOnKeystroke(true);
		table.addMouseListener(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					cin.setText(table.getValueAt(i, 0).toString());
					nom.setText(table.getValueAt(i, 1).toString());
					tel.setText(table.getValueAt(i, 2).toString());
					email.setText(table.getValueAt(i, 3).toString());
				}
			}
		});
		model=new DefaultTableModel();

		final Object[] row=new Object[4];

		table.setModel(model);

		scrollPane.setViewportView(table);
		cin = new JTextField();
		cin.setColumns(3);
		cin.setBounds(436, 455, 158, 20);
		contentPane.add(cin);
		
		nom = new JTextField();
		nom.setColumns(3);
		nom.setBounds(783, 455, 158, 20);
		contentPane.add(nom);
		
		email = new JTextField();
		email.setColumns(3);
		email.setBounds(1139, 455, 158, 20);
		contentPane.add(email);
		
		tel = new JTextField();
		tel.setColumns(3);
		tel.setBounds(783, 520, 158, 20);
		contentPane.add(tel);
		
		JButton btnNouvelEncadrant = new JButton("Nouvel encadrant");
		btnNouvelEncadrant.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\G.png"));
		btnNouvelEncadrant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if (cin.getText().equals("") || nom.getText().equals("") || tel.getText().equals("") || email.getText().equals("")) {
				        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
				    } else {
				        String cinValue = cin.getText();
				        String nomValue = nom.getText();
				        String telValue = tel.getText();
				        String emailValue = email.getText();

				        // Ajouter les autres champs si nécessaire

				        DefaultTableModel model = (DefaultTableModel) table.getModel();

				        // Ajouter la nouvelle ligne dans le tableau
				        Object[] rowData = {cinValue, nomValue, telValue, emailValue};
				        model.addRow(rowData);

				        String url = "jdbc:mysql://localhost:3306/stageonda";

				        try {
				            Class.forName("com.mysql.cj.jdbc.Driver");

				            try {
				                Connection connection = DriverManager.getConnection(url, "root", "");

				                // Préparer la requête SQL d'insertion
				                String sql = "INSERT INTO encadrant(cin_encadrant, nom_complet, telephone, email) VALUES (?, ?, ?, ?)";

				                PreparedStatement statement = connection.prepareStatement(sql);
				                statement.setString(1, cinValue);
				                statement.setString(2, nomValue);
				                statement.setString(3, telValue);
				                statement.setString(4, emailValue);

				                // Exécuter la requête d'insertion
				                int rowsAffected = statement.executeUpdate();
				                if (rowsAffected > 0) {
				                    JOptionPane.showMessageDialog(null, "Enregistré avec succès");
				                } else {
				                    JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement");
				                }

				                statement.close();
				                connection.close();

				            } catch (SQLException ex) {
				                ex.printStackTrace();
				            }
				        } catch (ClassNotFoundException ex) {
				            ex.printStackTrace();
				        }
				    }
		}});
		btnNouvelEncadrant.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNouvelEncadrant.setFocusPainted(false);
		btnNouvelEncadrant.setBounds(513, 597, 179, 34);
		contentPane.add(btnNouvelEncadrant);
		
		JButton btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\UP.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String nomValue = nom.getText();
		    	String telValue = tel.getText();
		    	String emailValue = email.getText();

		        int selectedRow = table.getSelectedRow();
		        if (selectedRow >= 0) {
		            
		            String url = "jdbc:mysql://localhost:3306/stageonda";
		            try {
		                Class.forName("com.mysql.cj.jdbc.Driver");
		                try {
		                    Connection connection = DriverManager.getConnection(url, "root", "");
		                    PreparedStatement stat = connection.prepareStatement("UPDATE encadrant SET nom_complet=?,telephone=?,email=? where cin_encadrant='" + cin.getText() + "';");

		                    stat.setString(1, nom.getText());
		                    stat.setString(2,  tel.getText());
		                    stat.setString(3, email.getText());

		                    int rowsUpdated = stat.executeUpdate();
		                    if (rowsUpdated > 0) {
		                        JOptionPane.showMessageDialog(null, "Modifié avec Succès");
		                        // Mettre à jour les valeurs dans le tableau
		                        
		                        table.setValueAt(nomValue, selectedRow, 1);
		                        table.setValueAt(telValue, selectedRow, 2);
		                        table.setValueAt(emailValue, selectedRow, 3);

		                    } else {
		                        JOptionPane.showMessageDialog(null, "Erreur lors de la modification des données");
		                    }
		                    stat.close();
		                    connection.close();
		                } catch (SQLDataException ex) {
		                    ex.printStackTrace();
		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                }
		            } catch (ClassNotFoundException ex) {
		                ex.printStackTrace();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne dans le tableau pour effectuer la modification");
		        }
		    }
		});

		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBounds(714, 597, 179, 34);
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
		    	                String query = "DELETE FROM encadrant WHERE cin_encadrant = ?";

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


		btnNewButton_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton_2_1.setFocusPainted(false);
		btnNewButton_2_1.setBounds(919, 597, 179, 34);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Effacer");
		btnNewButton_2_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\fr.png"));
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cin.setText("");
				nom.setText("");				
				tel.setText("");
				email.setText("");
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnNewButton_2_1_1.setFocusPainted(false);
		btnNewButton_2_1_1.setBounds(1118, 597, 179, 34);
		contentPane.add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Matricule :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(341, 461, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Nom :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(714, 461, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(1070, 457, 59, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telephone : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(676, 522, 84, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_2_2 = new JButton("Actualiser");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficher();
			}
		});
		btnNewButton_2_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\rt.png"));
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2_2.setFocusPainted(false);
		btnNewButton_2_2.setBounds(325, 597, 161, 32);
		contentPane.add(btnNewButton_2_2);
	}
	private void updateTableModel() {
	    String url = "jdbc:mysql://localhost:3306/stageonda";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection connection = DriverManager.getConnection(url, "root", "");
	        Statement st = connection.createStatement();

	        String query = "SELECT cin_encadrant, nom_complet, telephone, email FROM encadrant";

	        ResultSet rs = st.executeQuery(query);
	        ResultSetMetaData rsmd = rs.getMetaData();

	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);

	        int cols = rsmd.getColumnCount();
	        while (rs.next()) {
	            Object[] row = new Object[cols];
	            for (int i = 0; i < cols; i++) {
	                row[i] = rs.getString(i + 1);
	            }
	            model.addRow(row);
	        }

	        st.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public void afficher() {
		String url = "jdbc:mysql://localhost:3306/stageonda";

		try {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection=DriverManager.getConnection(url,"root","");
		String query ="Select distinct cin_encadrant,nom_complet,telephone,email from encadrant";
		PreparedStatement st = connection.prepareStatement(query);
		ResultSet rs = st.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		DefaultTableModel modele=(DefaultTableModel) table.getModel();
		 int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];

            for (int i = 0; i < cols; i++) {
                colName[i] = rsmd.getColumnName(i + 1);
            }
        modele = new DefaultTableModel(colName, 0);

		while(rs.next()) {	
			 Object[] row = new Object[cols];
                for (int i = 0; i < cols; i++) {
                    row[i] = rs.getString(i + 1);
                }
                modele.addRow(row);
		}
		table.setModel(modele);
		st.close();
		connection.close();
		}
		catch (SQLException e1) {
		e1.printStackTrace();
		}

		catch (ClassNotFoundException e1) {

		e1.printStackTrace();

		}
		
	}

}
