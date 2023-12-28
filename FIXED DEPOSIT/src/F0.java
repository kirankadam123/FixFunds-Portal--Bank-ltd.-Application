import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class F0 extends JFrame {

	private JPanel contentPane;
	private JLabel l1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F0 frame = new F0();
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
	public F0() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		l1 = new JLabel("WELCOME TO FIXEDFUNDS PORTAL!");
		l1.setFont(new Font("Tahoma", Font.BOLD, 15));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setPreferredSize(new Dimension(180, 24));
		l1.setMaximumSize(new Dimension(180, 24));
		l1.setBounds(192, 291, 285, 47);
		contentPane.add(l1);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {	
			new F1();
			dispose();
			}
			catch (Exception ex) {
			}   
	        }
		});
		login.setBounds(291, 349, 89, 23);
		contentPane.add(login);
		
		JLabel lblNewLabel = new JLabel("BANK OF MATHEMATICS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(140, 30));
		lblNewLabel.setBounds(171, 248, 328, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\download (8).jpg"));
		lblNewLabel_1.setPreferredSize(new Dimension(140, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(65, -34, 517, 338);
		contentPane.add(lblNewLabel_1);
	}
}
