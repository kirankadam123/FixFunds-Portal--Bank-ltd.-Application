import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class F9 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F9 frame = new F9();
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
	public F9() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(148, 26, 172, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblUserid = new JLabel("Enter UserId");
		lblUserid.setBounds(115, 95, 125, 14);
		contentPane.add(lblUserid);
		
		JLabel lblNewPassword = new JLabel("Enter New Password");
		lblNewPassword.setBounds(115, 135, 125, 14);
		contentPane.add(lblNewPassword);
		
		textField = new JTextField();
		textField.setBounds(250, 92, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(250, 132, 86, 20);
		contentPane.add(textField1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField.getText().equals("") || textField1.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Enter userid or password.");
					}
					else
					{
					Connection con=DBConnection.getConnection();
					String q="update employee set Emp_fname=? where Emp_id=?";
					PreparedStatement pst=con.prepareStatement(q);
					pst.setString(1,textField1.getText());
					pst.setString(2,textField.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Password Updated Successfully.");
					new F1();
					dispose();
					}
				}catch(Exception e1) {}
			}
		});
		btnNewButton.setBounds(180, 185, 89, 23);
		contentPane.add(btnNewButton);
	}
}
