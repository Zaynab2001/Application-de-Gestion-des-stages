package stg;

import java.awt.EventQueue; 
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Statistics extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreDeStagiaire;
	private Timer refreshTimer;
	private JTextField txtNombreDesEncadrants;
	private JTextField txtStagiairesPfa;
	private JTextField txtStagiairesPfe;
	private JTextField txtStagiairesInitiation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Statistics() {
		setTitle("Les statistiques");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(251, 0, 1093, 98);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Les Statistiques");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(407, 31, 382, 39);
		panel_2.add(lblNewLabel);
		
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
		btnParamtres.setBackground(new Color(238, 238, 240));
		btnParamtres.setBounds(10, 470, 235, 40);
		panel_1.add(btnParamtres);
		
		JButton btnNewButton_1 = new JButton("Evaluation des Stages");
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
		btnNewButton_1.setBounds(10, 371, 235, 37);
		panel_1.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-statistic-100.png"));
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
		btnNewButton_3.setBackground(new Color(238, 238, 240));
		btnNewButton_3.setBounds(10, 170, 235, 40);
		panel_1.add(btnNewButton_3);
		
		JButton btnGestionDesAbscences = new JButton("Gestion des abscences");
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
		btnGestionDesAbscences.setBounds(10, 269, 235, 40);
		panel_1.add(btnGestionDesAbscences);
		
		JButton btnGestionDesStages = new JButton("Gestion des stages");
		btnGestionDesStages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stage st=new stage();
				st.setVisible(true);
				st.setLocationRelativeTo(null);
				dispose();
				st.afficher();
			}
		});
		btnGestionDesStages.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\fl.png"));
		btnGestionDesStages.setHorizontalAlignment(SwingConstants.LEADING);
		btnGestionDesStages.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGestionDesStages.setFocusPainted(false);
		btnGestionDesStages.setBackground(SystemColor.menu);
		btnGestionDesStages.setBounds(10, 320, 235, 40);
		panel_1.add(btnGestionDesStages);
		
		JButton btnNewButton_1_1 = new JButton(" Espace stagiaires");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				espacestg sp=new espacestg();
				sp.setVisible(true);
				sp.setLocationRelativeTo(null);
				dispose();
				sp.afficher();
			
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\G.png"));
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setBackground(new Color(238, 238, 240));
		btnNewButton_1_1.setBounds(10, 221, 235, 37);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnLesStatistiques = new JButton("Les statistiques");
		btnLesStatistiques.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\l.png"));
		btnLesStatistiques.setHorizontalAlignment(SwingConstants.LEADING);
		btnLesStatistiques.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLesStatistiques.setFocusPainted(false);
		btnLesStatistiques.setBackground(SystemColor.activeCaption);
		btnLesStatistiques.setBounds(10, 419, 235, 40);
		panel_1.add(btnLesStatistiques);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(336, 207, 265, 144);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtNombreDeStagiaire = new JTextField();
		txtNombreDeStagiaire.setBounds(0, 80, 265, 38);
		panel.add(txtNombreDeStagiaire);
		txtNombreDeStagiaire.setDropMode(DropMode.INSERT);
		txtNombreDeStagiaire.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreDeStagiaire.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		txtNombreDeStagiaire.setForeground(new Color(255, 255, 255));
		txtNombreDeStagiaire.setBackground(new Color(251, 9, 27));
		txtNombreDeStagiaire.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtNombreDeStagiaire.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(21, 11, 76, 64);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\hyi.png"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(72, 196, 183));
		panel_3.setBounds(660, 207, 280, 144);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		txtNombreDesEncadrants = new JTextField();
		txtNombreDesEncadrants.setBounds(10, 81, 265, 33);
		panel_3.add(txtNombreDesEncadrants);
		txtNombreDesEncadrants.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		txtNombreDesEncadrants.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreDesEncadrants.setForeground(Color.WHITE);
		txtNombreDesEncadrants.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtNombreDesEncadrants.setColumns(10);
		txtNombreDesEncadrants.setBackground(new Color(72, 196, 183));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\u.png"));
		lblNewLabel_2.setBounds(10, 4, 72, 66);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(34, 220, 29));
		panel_4.setBounds(1006, 207, 270, 142);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		txtStagiairesPfa = new JTextField();
		txtStagiairesPfa.setBounds(-15, 80, 241, 33);
		panel_4.add(txtStagiairesPfa);
		txtStagiairesPfa.setText("Stagiaires PFA :\r\n\r\n0");
		txtStagiairesPfa.setHorizontalAlignment(SwingConstants.CENTER);
		txtStagiairesPfa.setForeground(Color.WHITE);
		txtStagiairesPfa.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtStagiairesPfa.setColumns(10);
		txtStagiairesPfa.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		txtStagiairesPfa.setBackground(new Color(34, 220, 29));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\i.png"));
		lblNewLabel_3.setBounds(21, 11, 64, 70);
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(128, 128, 255));
		panel_5.setBounds(336, 416, 265, 144);
		contentPane.add(panel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\j.png"));
		lblNewLabel_1_1.setBounds(21, 11, 76, 64);
		panel_5.add(lblNewLabel_1_1);
		
		txtStagiairesPfe = new JTextField();
		txtStagiairesPfe.setBounds(0, 79, 217, 29);
		panel_5.add(txtStagiairesPfe);
		txtStagiairesPfe.setText("Stagiaires PFE:\r\n\r\n0");
		txtStagiairesPfe.setHorizontalAlignment(SwingConstants.CENTER);
		txtStagiairesPfe.setForeground(Color.WHITE);
		txtStagiairesPfe.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtStagiairesPfe.setColumns(10);
		txtStagiairesPfe.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		txtStagiairesPfe.setBackground(new Color(128, 128, 255));
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(192, 10, 142));
		panel_6.setBounds(655, 416, 285, 144);
		contentPane.add(panel_6);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\k.png"));
		lblNewLabel_1_2.setBounds(21, 11, 76, 64);
		panel_6.add(lblNewLabel_1_2);
		
		txtStagiairesInitiation = new JTextField();
		txtStagiairesInitiation.setBounds(-15, 86, 280, 22);
		panel_6.add(txtStagiairesInitiation);
		txtStagiairesInitiation.setText("Stagiaires Initiation:\r\n\r\n0");
		txtStagiairesInitiation.setHorizontalAlignment(SwingConstants.CENTER);
		txtStagiairesInitiation.setForeground(Color.WHITE);
		txtStagiairesInitiation.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtStagiairesInitiation.setColumns(10);
		txtStagiairesInitiation.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		txtStagiairesInitiation.setBackground(new Color(192, 10, 142));
		
		  // Lancez le rafraîchissement automatique à intervalles réguliers
        int refreshInterval = 5000; // Rafraîchissement toutes les 5 secondes (modifiable selon vos besoins)
        refreshTimer = new Timer();
        refreshTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateStagiairesCount();
                updateencadrantCount();
                updatepfaCount();
                updatepfeCount();
                updateinitCount();
            }
        }, 0, refreshInterval);

        updateencadrantCount();
		updateStagiairesCount();
		updatepfaCount();
		updatepfeCount();
		updateinitCount();
	}
	 private void updateStagiairesCount() {
	        try {
	            // Établissez la connexion avec la base de données (vous devrez modifier ces informations)
	            String url = "jdbc:mysql://localhost:3306/stageonda";
	            String username = "root";
	            String password = "";
	            Connection conn = DriverManager.getConnection(url, username, password);

	            // Créez la requête SQL pour compter le nombre de stagiaires
	            String query = "SELECT COUNT(*) AS count FROM stagiaire";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(query);

	            // Récupérez le nombre de stagiaires depuis le résultat de la requête
	            int stagiairesCount = 0;
	            if (rs.next()) {
	                stagiairesCount = rs.getInt("count");
	            }

	            // Mettez à jour le JTextField avec le nombre de stagiaires
	            txtNombreDeStagiaire.setText("Nombre de stagiaire :"+stagiairesCount);
	            
	            

	            // Fermez les ressources
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private void updateencadrantCount() {
	        try {
	            // Établissez la connexion avec la base de données (vous devrez modifier ces informations)
	            String url = "jdbc:mysql://localhost:3306/stageonda";
	            String username = "root";
	            String password = "";
	            Connection conn = DriverManager.getConnection(url, username, password);

	            // Créez la requête SQL pour compter le nombre de stagiaires
	            String query = "SELECT COUNT(*) AS count FROM encadrant";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(query);

	            // Récupérez le nombre de stagiaires depuis le résultat de la requête
	            int encCount = 0;
	            if (rs.next()) {
	            	encCount = rs.getInt("count");
	            }
	            // Mettez à jour le JTextField avec le nombre de stagiaires
	            txtNombreDesEncadrants.setText("Nombre des encadrants :\n"+ encCount);            
	            // Fermez les ressources
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private void updatepfaCount() {
	        try {
	            // Établissez la connexion avec la base de données (vous devrez modifier ces informations)
	            String url = "jdbc:mysql://localhost:3306/stageonda";
	            String username = "root";
	            String password = "";
	            Connection conn = DriverManager.getConnection(url, username, password);

	            // Créez la requête SQL pour compter le nombre de stagiaires
	            String query = "SELECT COUNT(*) AS count FROM stage WHERE Type=?";
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setString(1, "pfa");	            
	            ResultSet rs = stmt.executeQuery();

	            // Récupérez le nombre de stagiaires depuis le résultat de la requête
	            int stagiairesCount = 0;
	            if (rs.next()) {
	                stagiairesCount = rs.getInt("count");
	            }

	            // Mettez à jour le JTextField avec le nombre de stagiaires
	            txtStagiairesPfa.setText("Stagiaires PFA :\n\n"+ stagiairesCount);
	            

	            // Fermez les ressources
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private void updatepfeCount() {
	        try {
	            // Établissez la connexion avec la base de données (vous devrez modifier ces informations)
	            String url = "jdbc:mysql://localhost:3306/stageonda";
	            String username = "root";
	            String password = "";
	            Connection conn = DriverManager.getConnection(url, username, password);

	            // Créez la requête SQL pour compter le nombre de stagiaires
	            String query = "SELECT COUNT(*) AS count FROM stage WHERE Type=?";
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setString(1, "pfe");	            
	            ResultSet rs = stmt.executeQuery();

	            // Récupérez le nombre de stagiaires depuis le résultat de la requête
	            int stagiairesCount = 0;
	            if (rs.next()) {
	                stagiairesCount = rs.getInt("count");
	            }

	            // Mettez à jour le JTextField avec le nombre de stagiaires
	            txtStagiairesPfe.setText("Stagiaires PFE :\n\n"+ stagiairesCount);
	            

	            // Fermez les ressources
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  
	 private void updateinitCount() {
	        try {
	            // Établissez la connexion avec la base de données (vous devrez modifier ces informations)
	            String url = "jdbc:mysql://localhost:3306/stageonda";
	            String username = "root";
	            String password = "";
	            Connection conn = DriverManager.getConnection(url, username, password);

	            // Créez la requête SQL pour compter le nombre de stagiaires
	            String query = "SELECT COUNT(*) AS count FROM stage WHERE Type=?";
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setString(1, "initiation");	            
	            ResultSet rs = stmt.executeQuery();

	            // Récupérez le nombre de stagiaires depuis le résultat de la requête
	            int stagiairesCount = 0;
	            if (rs.next()) {
	                stagiairesCount = rs.getInt("count");
	            }

	            // Mettez à jour le JTextField avec le nombre de stagiaires
	            txtStagiairesInitiation.setText("Stagiaires Initiation :\n\n"+ stagiairesCount);
	            

	            // Fermez les ressources
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
