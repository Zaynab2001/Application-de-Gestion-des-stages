package stg;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;

public class parametre extends JFrame {

	private JPanel contentPane;
	private JLabel imageLabel;
	private JTextField nom;
	private JTextField pr;
	private JTextField email;
	private JComboBox combosexe;
	private JPasswordField pswd;
	private JPasswordField confpswd;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					parametre frame = new parametre();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public parametre() {
		setTitle("Paramètres");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(215, 215, 255));
		panel.setBounds(310, 140, 981, 499);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 pswd = new JPasswordField();
	        pswd.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
	        pswd.setBackground(new Color(215, 215, 255));
	        pswd.setBounds(660, 329, 196, 20);
	        panel.add(pswd);
	        
	        confpswd = new JPasswordField();
	        confpswd.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
	        confpswd.setBackground(new Color(215, 215, 255));
	        confpswd.setBounds(660, 378, 196, 20);
	        panel.add(confpswd);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 117));
		panel_2.setBounds(254, 0, 1090, 98);
		contentPane.add(panel_2);

		JLabel lblVosInformations = new JLabel("Paramètres du compte");
		lblVosInformations.setForeground(Color.WHITE);
		lblVosInformations.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblVosInformations.setBounds(389, 29, 391, 39);
		panel_2.add(lblVosInformations);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 117));
		panel_1.setBounds(0, 0, 255, 682);
		contentPane.add(panel_1);

		JButton btnNewButton_1 = new JButton("Evaluation des stages");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Evaluationn ev=new Evaluationn();
		    	ev.setVisible(true);
		    	ev.setLocationRelativeTo(null);
		    	dispose();
				ev.affichage();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\ok.png"));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setBounds(10, 374, 235, 37);
		panel_1.add(btnNewButton_1);

		JButton btnDeconnection = new JButton("Deconnection");
		btnDeconnection.setForeground(Color.WHITE);
		btnDeconnection.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeconnection.setBackground(new Color(245, 73, 73));
		btnDeconnection.setBounds(10, 631, 235, 40);
		panel_1.add(btnDeconnection);


		JButton btnNewButton_3 = new JButton("Espace des encadrants");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espacencadrant es=new espacencadrant();
				es.setVisible(true);
				es.setLocationRelativeTo(null);
				dispose();
				es.afficher();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\bad.png"));
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBackground(SystemColor.menu);
		btnNewButton_3.setBounds(10, 170, 235, 40);
		panel_1.add(btnNewButton_3);

		JButton btnGestionDesAbscences = new JButton("Gestion des absences");
		btnGestionDesAbscences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Abscence ab=new Abscence();
				ab.setVisible(true);
				ab.setLocationRelativeTo(null);
				dispose();
				ab.afficher();
			}
		});
		btnGestionDesAbscences.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\abs.png"));
		btnGestionDesAbscences.setHorizontalAlignment(SwingConstants.LEADING);
		btnGestionDesAbscences.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGestionDesAbscences.setFocusPainted(false);
		btnGestionDesAbscences.setBackground(SystemColor.menu);
		btnGestionDesAbscences.setBounds(10, 272, 235, 40);
		panel_1.add(btnGestionDesAbscences);

		imageLabel = new JLabel("");
		imageLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		imageLabel.setBackground(new Color(255, 255, 255));
		imageLabel.setBounds(94, 129, 145, 140);
		panel.add(imageLabel);
		chargerDerniereImage();

		JButton btnNewButton_3_1 = new JButton("Espace des stagiaires");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espacestg es=new espacestg();
				es.setVisible(true);
				es.setLocationRelativeTo(null);
				dispose();
				es.afficher();
			}
		});
		btnNewButton_3_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\G.png"));
		btnNewButton_3_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1.setFocusPainted(false);
		btnNewButton_3_1.setBackground(SystemColor.menu);
		btnNewButton_3_1.setBounds(10, 221, 235, 40);
		panel_1.add(btnNewButton_3_1);

		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\p.png"));
		lblNewLabel.setBounds(77, 32, 104, 108);
		panel_1.add(lblNewLabel);

		JButton btnParamtres = new JButton("Paramètres");
		btnParamtres.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-paramètres-30.png"));
		btnParamtres.setHorizontalAlignment(SwingConstants.LEADING);
		btnParamtres.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnParamtres.setFocusPainted(false);
		btnParamtres.setBackground(SystemColor.activeCaption);
		btnParamtres.setBounds(10, 470, 235, 40);
		panel_1.add(btnParamtres);
		
				JButton btnNewButton_3_1_1_1 = new JButton("Gestion des stages");
				btnNewButton_3_1_1_1.setBounds(10, 323, 235, 40);
				panel_1.add(btnNewButton_3_1_1_1);
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
				btnNewButton_3_1_1_1.setBackground(SystemColor.menu);
				
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
				btnNewButton_1_1_2.setBounds(10, 422, 235, 37);
				panel_1.add(btnNewButton_1_1_2);

				JButton importerPhoto = new JButton("Importer une photo");
				importerPhoto.setHorizontalAlignment(SwingConstants.LEADING);
				importerPhoto.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\hy.png"));
				importerPhoto.setForeground(new Color(255, 255, 255));
				importerPhoto.setBackground(new Color(202, 0, 0));
		        importerPhoto.setFocusPainted(false);
		        importerPhoto.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                // Créer une boîte de dialogue pour choisir un fichier
		                JFileChooser fileChooser = new JFileChooser();

		                // Filtre pour n'afficher que les fichiers d'images
		                fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
		                    public boolean accept(File file) {
		                        return file.getName().toLowerCase().endsWith(".jpg") || file.getName().toLowerCase().endsWith(".jpeg")
		                                || file.getName().toLowerCase().endsWith(".png") || file.isDirectory();
		                    }

		                    public String getDescription() {
		                        return "Images (*.jpg, *.jpeg, *.png)";
		                    }
		                });

		                int returnValue = fileChooser.showOpenDialog(parametre.this);
		                if (returnValue == JFileChooser.APPROVE_OPTION) {
		                    File selectedFile = fileChooser.getSelectedFile();
		                    System.out.println("Fichier sélectionné : " + selectedFile.getAbsolutePath());

		                    try (Connection connection = getConnection()) {
		                        // Lecture des données binaires du fichier image
		                        InputStream inputStream = new FileInputStream(selectedFile);

		                        // Requête SQL pour insérer l'image dans la base de données
		                        String sql = "INSERT INTO images (image) VALUES (?)";
		                        try (PreparedStatement statement = connection.prepareStatement(sql)) {
		                            statement.setBinaryStream(1, inputStream, selectedFile.length());

		                            // Exécution de la requête d'insertion
		                            int rowsInserted = statement.executeUpdate();
		                            if (rowsInserted > 0) {
		                                System.out.println("L'image a été enregistrée avec succès dans la base de données.");
		                            } else {
		                                System.out.println("Erreur lors de l'enregistrement de l'image dans la base de données.");
		                            }
		                        }
		                    } catch (Exception ex) {
		                        ex.printStackTrace();
		                    }
		                    chargerDerniereImage();
		                }
		            }
		        });

		        importerPhoto.setBounds(77, 280, 177, 31);
		        panel.add(importerPhoto);
		        
		        JLabel lblNewLabel_1 = new JLabel("Nom:");
		        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		        lblNewLabel_1.setBounds(547, 129, 43, 31);
		        panel.add(lblNewLabel_1);
		        
		        nom = new JTextField();		     
		        nom.setBackground(new Color(215, 215, 255));
		        nom.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		        nom.setBounds(660, 123, 196, 24);
		        panel.add(nom);
		        nom.setColumns(10);
		        
		        JLabel lblNewLabel_1_1 = new JLabel("Prenom:");
		        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		        lblNewLabel_1_1.setBounds(523, 171, 67, 31);
		        panel.add(lblNewLabel_1_1);
		        
		        pr = new JTextField();
		        pr.setBackground(new Color(215, 215, 255));
		        pr.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		        pr.setColumns(10);
		        pr.setBounds(660, 169, 196, 24);
		        panel.add(pr);
		        
		        JLabel lblNewLabel_1_1_1 = new JLabel("Email:");
		        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		        lblNewLabel_1_1_1.setBounds(547, 225, 51, 24);
		        panel.add(lblNewLabel_1_1_1);
		        
		        email = new JTextField();
		        email.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		        email.setBackground(new Color(215, 215, 255));
		        email.setColumns(10);
		        email.setBounds(660, 215, 196, 24);
		        panel.add(email);
		        
		        JLabel lblNewLabel_1_1_1_1 = new JLabel("Confirmer le mot de passe:");
		        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		        lblNewLabel_1_1_1_1.setBounds(401, 370, 196, 31);
		        panel.add(lblNewLabel_1_1_1_1);
		        
		        JLabel lblNewLabel_2 = new JLabel("Nouveau mot de passe:");
		        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		        lblNewLabel_2.setBounds(421, 322, 168, 28);
		        panel.add(lblNewLabel_2);
		        
		        combosexe = new JComboBox();
		        combosexe.setModel(new DefaultComboBoxModel(new String[] {"", "Homme", "Femme"}));
		        combosexe.setBounds(660, 280, 196, 22);
		        panel.add(combosexe);
		       
		        
		        JButton btnNewButton = new JButton("Modifier les informations");
		        btnNewButton.setFocusPainted(false);
		        btnNewButton.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\mo.png"));
		        btnNewButton.setForeground(new Color(255, 255, 255));
		        btnNewButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                String url = "jdbc:mysql://localhost:3306/stageonda";
		                try {
		                    Class.forName("com.mysql.cj.jdbc.Driver");
		                    try {
		                        Connection connection = DriverManager.getConnection(url, "root", "");
		                        PreparedStatement stat = connection.prepareStatement("UPDATE utilisateur SET nom=?, prenom=?, email=?, sexe=? WHERE email=?");
		                        stat.setString(1, nom.getText());
		                        stat.setString(2, pr.getText());
		                        stat.setString(3, email.getText());
		                        stat.setString(4, combosexe.getSelectedItem().toString());
		                        stat.setString(5, email.getText());
		                        System.out.println("Connected");
		                        stat.execute();
		                       
		                       
		                        // Vérifier si les mots de passe correspondent
		                        if (pswd.getText().equals(confpswd.getText())) {
		                            PreparedStatement statPswd = connection.prepareStatement("UPDATE utilisateur SET password=? WHERE email=?");
		                            statPswd.setString(1,pswd.getText());
		                            statPswd.setString(2, email.getText());
		                            statPswd.executeUpdate();
		                            JOptionPane.showMessageDialog(null, "Les informations sont modifiés avec succès");
		                        } else {
		                            JOptionPane.showMessageDialog(null, "vous avez saisis deux mot de passes incompatibles");
		                        }

		                        stat.close();
		                        connection.close();
		                    } catch (SQLException ex) {
		                        ex.printStackTrace();
		                    }
		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                }
		            }
		        });

		        btnNewButton.setBackground(new Color(202, 0, 0));
		        btnNewButton.setBounds(523, 435, 227, 39);
		        panel.add(btnNewButton);
		        
		        JLabel lblVosInformations_2 = new JLabel("Vos informations ");
		        lblVosInformations_2.setBackground(new Color(0, 0, 117));
		        lblVosInformations_2.setForeground(new Color(0, 0, 117));
		        lblVosInformations_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		        lblVosInformations_2.setBounds(388, 30, 243, 39);
		        panel.add(lblVosInformations_2);
		        
		        JLabel lblNewLabel_3 = new JLabel("Sexe:");
		        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		        lblNewLabel_3.setBounds(547, 282, 46, 14);
		        panel.add(lblNewLabel_3);
		        
		       
		        
		        chargerprenomDepuisBaseDeDonnees();
		        chargerNomDepuisBaseDeDonnees();
		        chargeremailDepuisBaseDeDonnees();
		        chargersexeDepuisBaseDeDonnees();
		        
		       
		    }

		    // Autres parties du code que vous avez fournies ...

		    private Connection getConnection() throws Exception {
		        String url = "jdbc:mysql://localhost:3306/stageonda";
		        String username = "root";
		        String password = "";
		        return DriverManager.getConnection(url, username, password);
		    }
		    
		 // Méthode pour charger la dernière image enregistrée dans l'interface
		    private void chargerDerniereImage() {
		        try (Connection connection = getConnection()) {
		            String sql = "SELECT image FROM images WHERE id = (SELECT MAX(id) FROM images)";
		            try (PreparedStatement statement = connection.prepareStatement(sql)) {
		                try (ResultSet resultSet = statement.executeQuery()) {
		                    if (resultSet.next()) {
		                        // Récupérer les données binaires de l'image depuis la base de données
		                        byte[] imageData = resultSet.getBytes("image");

		                        // Charger l'image et l'afficher dans le JLabel
		                        ImageIcon imageIcon = new ImageIcon(imageData);
		                        Image image = imageIcon.getImage();
		                        Image resizedImage = image.getScaledInstance(150, 140, Image.SCALE_SMOOTH);
		                        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
		                        imageLabel.setIcon(resizedImageIcon);
		                    }
		                }
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		    
		    private void chargerNomDepuisBaseDeDonnees() {
		        String url = "jdbc:mysql://localhost:3306/stageonda";
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection connection = DriverManager.getConnection(url, "root", "");

		            String query = "SELECT nom FROM utilisateur WHERE matricule = '1'";
		            PreparedStatement statement = connection.prepareStatement(query);
		            ResultSet resultSet = statement.executeQuery();
		            if (resultSet.next()) {
		                String nm = resultSet.getString("nom");
		                nom.setText(nm);
		            } else {
		                nom.setText("No result found");
		            }
		            resultSet.close();
		            statement.close();
		            connection.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }

		    
		    private void chargerprenomDepuisBaseDeDonnees() {
		        String url = "jdbc:mysql://localhost:3306/stageonda";
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection connection = DriverManager.getConnection(url, "root", "");

		            String query = "SELECT prenom FROM utilisateur WHERE matricule = '1'";
		            PreparedStatement statement = connection.prepareStatement(query);
		            ResultSet resultSet = statement.executeQuery();
		            if (resultSet.next()) {
		                String prenom = resultSet.getString("prenom");
		                pr.setText(prenom);
		            } else {
		                pr.setText("No result found");
		            }
		            resultSet.close();
		            statement.close();
		            connection.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		    
		    private void chargeremailDepuisBaseDeDonnees() {
		        String url = "jdbc:mysql://localhost:3306/stageonda";
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection connection = DriverManager.getConnection(url, "root", "");

		            String query = "SELECT email FROM utilisateur WHERE matricule = '1'";
		            PreparedStatement statement = connection.prepareStatement(query);
		            ResultSet resultSet = statement.executeQuery();
		            if (resultSet.next()) {
		                String ml = resultSet.getString("email");
		                email.setText(ml);
		            } else {
		                email.setText("No result found");
		            }
		            resultSet.close();
		            statement.close();
		            connection.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		    
		  
		    
		    private void chargersexeDepuisBaseDeDonnees() {
		        String url = "jdbc:mysql://localhost:3306/stageonda";
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection connection = DriverManager.getConnection(url, "root", "");

		            String query = "SELECT sexe FROM utilisateur WHERE matricule = '1'";
		            PreparedStatement statement = connection.prepareStatement(query);
		            ResultSet resultSet = statement.executeQuery();
		            if (resultSet.next()) {
		                String sexe = resultSet.getString("sexe");
		                combosexe.setSelectedItem(sexe);
		            } else {
		                // Gérer le cas où aucune donnée n'a été trouvée dans la base de données
		                combosexe.setSelectedItem(null); // ou combosexe.setSelectedIndex(-1) pour déselectionner tout
		            }
		            resultSet.close();
		            statement.close();
		            connection.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		}