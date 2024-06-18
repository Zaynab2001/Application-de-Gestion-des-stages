package stg;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

public class Forgetpassword extends JFrame {

	private JPanel contentPane;
	private JTextField txtemail;
	private JPasswordField passf;
	private JPasswordField passi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgetpassword frame = new Forgetpassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Forgetpassword() {
		setTitle("Forget password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 588);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(162, 244, 244));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mot de passe oublié ?");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Calisto MT", Font.BOLD, 25));
		lblNewLabel.setBounds(79, 119, 275, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Forgot your password ? Please Enter your Email ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setBounds(66, 157, 275, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" your new password to resetting your password  ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setBounds(66, 172, 288, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Email :");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Calisto MT", Font.BOLD, 16));
		lblNewLabel_4.setBounds(39, 217, 57, 25);
		contentPane.add(lblNewLabel_4);
		
		txtemail = new JTextField();
		txtemail.setBackground(new Color(255, 255, 255));
		txtemail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 128, 255)));
		txtemail.setBounds(39, 253, 288, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mot de passe :");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1.setFont(new Font("Calisto MT", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(39, 284, 104, 25);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Nouveau mot de passe :");
		lblNewLabel_4_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_1_1.setFont(new Font("Calisto MT", Font.BOLD, 16));
		lblNewLabel_4_1_1.setBounds(39, 351, 172, 25);
		contentPane.add(lblNewLabel_4_1_1);
		
		final JButton confirmer = new JButton("Confirmer");
		confirmer.setForeground(new Color(255, 255, 255));
		confirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/stageonda";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try {
					Connection connection=DriverManager.getConnection(url,"root","");
					PreparedStatement stat=connection.prepareStatement("UPDATE utilisateur SET password=? where email=?");
					stat.setString(1,passf.getText());
					stat.setString(2,txtemail.getText());
					System.out.println("Connected");
					if(passf.getText().equals(passi.getText())) {
						stat.executeUpdate();
						JOptionPane.showMessageDialog(null, "Le mot de passe est modifié avec succès");
					}
					else {
						JOptionPane.showMessageDialog(null, "Le mot de passe n'est pas modifié");
					}
			}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
		}});
		confirmer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmer.setBackground(new Color(153,226,76));
			}
		});
		confirmer.setFocusPainted(false);
		confirmer.setBackground(new Color(215, 6, 6));
		confirmer.setBounds(93, 483, 96, 35);
		contentPane.add(confirmer);
		
		final JButton btnRetour = new JButton("Annuler");
		btnRetour.setForeground(new Color(255, 255, 255));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRetour.setBackground(new Color(153,226,76));
			}
		});
		btnRetour.setFocusPainted(false);
		btnRetour.setBackground(new Color(215, 6, 6));
		btnRetour.setBounds(213, 483, 96, 35);
		contentPane.add(btnRetour);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\ref.png"));
		lblNewLabel_5_1.setBounds(335, 351, 31, 25);
		contentPane.add(lblNewLabel_5_1);
		
		passf = new JPasswordField();
		passf.setSelectionColor(new Color(0, 120, 215));
		passf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 120, 215)));
		passf.setBounds(39, 320, 286, 20);
		contentPane.add(passf);
		
		passi = new JPasswordField();
		passi.setSelectionColor(new Color(0, 120, 215));
		passi.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 120, 215)));
		passi.setBounds(39, 388, 286, 20);
		contentPane.add(passi);
		
		JLabel lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\forg.png"));
		lblNewLabel_3.setBounds(154, 24, 116, 84);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-email-24.png"));
		lblNewLabel_5.setBounds(346, 255, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-cadenas-24.png"));
		lblNewLabel_6.setBounds(346, 320, 46, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\YAM\\OneDrive\\Bureau\\icons8-cadenas-24.png"));
		lblNewLabel_7.setBounds(345, 387, 46, 21);
		contentPane.add(lblNewLabel_7);
	}
}
