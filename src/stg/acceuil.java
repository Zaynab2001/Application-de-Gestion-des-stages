package stg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTabbedPane;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class acceuil extends JFrame {

	private JPanel contentPane;
	private JTextField useremail;
	private JPasswordField userpassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acceuil frame = new acceuil();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public acceuil() {
		setTitle("Acceuil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1254, 680);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 680, 682);
		contentPane.add(tabbedPane);
		
		Panel panel1 = new Panel();
		panel1.setForeground(new Color(255, 255, 255));
		panel1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Acceuil", null, panel1, null);
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-2, 36, 192, 114);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\ondaa.png"));
		panel1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("L'OFFICE NATIONAL DES AEROPORTS ");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 21));
		lblNewLabel_1.setBounds(227, 59, 433, 45);
		panel1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description :");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(40, 177, 150, 31);
		panel1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("L’Office national des aéroports est un établissement public qui assure les missions suivantes :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(40, 219, 703, 31);
		panel1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("- La garantie de la sécurité de la navigation aérienne au niveau des aéroports et de  l’espace \r\n");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(40, 248, 703, 31);
		panel1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel(" aérien .");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(34, 276, 266, 31);
		panel1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("- L’aménagement, l’exploitation, l’entretien et le développement des aéroports civils de l’État.\r\n");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_2.setBounds(40, 305, 703, 31);
		panel1.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel(" - L’embarquement, le débarquement, le transit et l’acheminement à terre des voyageurs,");
		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_2_1.setBounds(34, 335, 703, 31);
		panel1.add(lblNewLabel_3_1_2_1);
		
		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("des marchandises et du courrier transportés par air, ainsi que tout service destiné à la ");
		lblNewLabel_3_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_2_1_1.setBounds(40, 364, 625, 31);
		panel1.add(lblNewLabel_3_1_2_1_1);
		
		JLabel lblNewLabel_3_1_2_1_1_1 = new JLabel("satisfaction des besoins des usagers et du public.");
		lblNewLabel_3_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_2_1_1_1.setBounds(40, 393, 703, 31);
		panel1.add(lblNewLabel_3_1_2_1_1_1);
		
		JLabel lblNewLabel_3_1_2_1_1_1_1 = new JLabel("-La liaison avec les organismes et les aéroports internationaux afin de répondre aux besoins ");
		lblNewLabel_3_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_2_1_1_1_1.setBounds(34, 422, 703, 31);
		panel1.add(lblNewLabel_3_1_2_1_1_1_1);
		
		JLabel lblNewLabel_3_1_2_1_1_1_1_1 = new JLabel("du trafic aérien.");
		lblNewLabel_3_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_2_1_1_1_1_1.setBounds(40, 450, 703, 31);
		panel1.add(lblNewLabel_3_1_2_1_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setBounds(0, 553, 687, 64);
		panel1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("<html><u>Tél : (+212) 05 22 43 78 63</u></html>");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(38, 11, 193, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("<html><u>Émail : communication@onda.ma</u></html>");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 try {
	                    Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/#inbox?compose=DmwnWrRqhkbtcGcRZnkHctgMGDvzFShZNLHFwXDtKvmdlWGJPVSdvmDZkSzRTWLnJvkwznmbkjDV"));
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
			}
		});
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(38, 36, 206, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("<html><u>Adresse : Aéroport Mohammed V, Nouaceur. B.P. : 52 Maroc</u></html>");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 try {
	                    Desktop.getDesktop().browse(new URI("https://www.google.com/maps/search/Aeroport+mohamed+5/@33.3837535,-7.5975127,14z/data=!3m1!4b1?entry=ttu"));
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
				
			}
		});
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(265, 11, 407, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1_1 = new JLabel("La Direction Des Systèmes d'Informations");
		lblNewLabel_1_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(258, 97, 364, 31);
		panel1.add(lblNewLabel_1_1);
		
		Panel panel2 = new Panel();
		panel2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("A propos", null, panel2, null);
		panel2.setLayout(null);
		
		JTextArea txtrCreAvecAmour = new JTextArea();
		txtrCreAvecAmour.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtrCreAvecAmour.setText("\r\n\r\nCette application est créée avec amour, qui met à profit mes connaissances en Java Swing acquises lors de mon première année en informatique et ingénierie des données au sein de l'ENSA Khouribga .\r\n\r\nElle facilite la gestion des stagiaires et des encadrants au sein de l'ONDA (Direction des Systèmes d'Information.) \r\n\r\nGrâce à son interface conviviale et intuitive, elle permet de suivre les activités des stagiaires, gérer les missions assignées et fournir un suivi régulier. \r\n\r\nElle intègre également un module d'évaluation des stages pour mesurer la performance des stagiaires .\r\n");
		txtrCreAvecAmour.setLineWrap(true);
		txtrCreAvecAmour.setWrapStyleWord(true);
		txtrCreAvecAmour.setRows(10);
		txtrCreAvecAmour.setBounds(26, 175, 623, 337);
		panel2.add(txtrCreAvecAmour);
		
		JLabel lblNewLabel_2_1 = new JLabel("A propos de cette Application:");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_2_1.setBounds(196, 133, 295, 31);
		panel2.add(lblNewLabel_2_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 0, 102));
		panel_1_1.setBounds(0, 547, 753, 71);
		panel2.add(panel_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("<html><u>Tél : (+212) 05 22 43 78 63</u></html>");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(38, 11, 193, 14);
		panel_1_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("<html><u>Émail : communication@onda.ma</u></html>");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_1.setBounds(38, 36, 206, 14);
		panel_1_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("<html><u>Adresse : Aéroport Mohammed V, Nouaceur. B.P. : 52 Maroc</u></html>");
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6_1.setBounds(274, 11, 397, 14);
		panel_1_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_9 = new JLabel("\r\n");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\by.png"));
		lblNewLabel_9.setBounds(290, 44, 95, 78);
		panel2.add(lblNewLabel_9);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(64, 0, 64));
		panel.setBounds(677, 22, 561, 619);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("  Connectez Vous !");
		lblNewLabel_7.setForeground(new Color(0, 0, 128));
		lblNewLabel_7.setBounds(191, 144, 223, 28);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel.add(lblNewLabel_7);
		
		useremail = new JTextField();
		useremail.setForeground(new Color(0, 0, 0));
		useremail.setFont(new Font("Calisto MT", Font.BOLD, 15));
		useremail.setColumns(10);
		useremail.setCaretColor(new Color(255, 255, 255));
		useremail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 128)));
		useremail.setBackground(new Color(240, 240, 240));
		useremail.setBounds(127, 256, 304, 33);
		panel.add(useremail);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(84, 37, 418, 532);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("\r\n");
		lblNewLabel_8.setBounds(169, 11, 104, 100);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\hj.png"));
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-email-24.png"));
		lblNewLabel_10.setBounds(350, 232, 32, 24);
		panel_2.add(lblNewLabel_10);
		
		JLabel labelemail = new JLabel("Email :");
		labelemail.setBounds(41, 196, 62, 25);
		panel_2.add(labelemail);
		labelemail.setForeground(new Color(51, 51, 102));
		labelemail.setFont(new Font("Calisto MT", Font.BOLD, 16));
		
		JLabel labelpassword = new JLabel("Password :");
		labelpassword.setBounds(41, 270, 106, 33);
		panel_2.add(labelpassword);
		labelpassword.setForeground(new Color(51, 51, 102));
		labelpassword.setFont(new Font("Calisto MT", Font.BOLD, 16));
		
		userpassword = new JPasswordField();
		userpassword.setBounds(41, 307, 305, 28);
		panel_2.add(userpassword);
		userpassword.setForeground(new Color(0, 0, 0));
		userpassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 128)));
		userpassword.setBackground(new Color(240, 240, 240));
		
		JLabel lblNewLabel_10_1 = new JLabel("");
		lblNewLabel_10_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-cadenas-24.png"));
		lblNewLabel_10_1.setBounds(350, 310, 32, 25);
		panel_2.add(lblNewLabel_10_1);
		
		final JCheckBox checkbox = new JCheckBox("show your password");
		checkbox.setBounds(39, 357, 144, 39);
		panel_2.add(checkbox);
		checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkbox.isSelected()) {
					userpassword.setEchoChar((char)0);
				}
				else {
					userpassword.setEchoChar('•');
				}
			}
		});
		checkbox.setBackground(new Color(0, 0, 0));
		checkbox.setOpaque(false);
		checkbox.setForeground(new Color(51, 51, 102));
		checkbox.setFocusable(false);
		
		JLabel labelforgetpassword = new JLabel("Forget password ?");
		labelforgetpassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Forgetpassword ps=new Forgetpassword();
				ps.setVisible(true);
				ps.setLocationRelativeTo(null);
			}
		});
		
		labelforgetpassword.setBounds(263, 362, 106, 28);
		panel_2.add(labelforgetpassword);
		labelforgetpassword.setBackground(new Color(0, 0, 0));
		labelforgetpassword.setForeground(new Color(51, 51, 102));
		
		JButton btnLogin = new JButton("Login ");
		btnLogin.setBounds(125, 443, 182, 28);
		panel_2.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CheckEmptyFields())
					JOptionPane.showConfirmDialog(null,"Veuillez Inserer votre email et votre mot de passe" ,"Manque d'informations !", JOptionPane.ERROR_MESSAGE);
				else {
					PreparedStatement ps;
					ResultSet rs ;
					String email=useremail.getText();
					String mot_de_passe=userpassword.getText();
					String query = "SELECT * FROM utilisateur WHERE email=? AND password=?;";
					try {
						
					ps=connectionDB.getConnection().prepareCall(query);
					ps.setString(1, email);
					ps.setString(2,mot_de_passe);
					rs=ps.executeQuery();
					
					//si il trouve les informations entrés dans la base de donnée
					if(rs.next()) {
						espacestg esp=new espacestg();
						esp.setLocationRelativeTo(null);
						esp.setVisible(true);
						dispose();
						esp.afficher();
						}
					else {
						JOptionPane.showMessageDialog(null, "utilisateur inconnu", "informations incorrectes", JOptionPane.ERROR_MESSAGE);
						}}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Connection with databsaefield");
				}
				}}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(215, 6, 6));
	}
	
	private boolean CheckEmptyFields() {
		return useremail.getText().equals("") || userpassword.getText().equals("");}
}
