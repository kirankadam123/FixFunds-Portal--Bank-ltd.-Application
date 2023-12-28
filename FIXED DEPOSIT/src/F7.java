import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class F7 extends JFrame {

	private JPanel contentPane;
	private JTextField t4;
	private JTextField t3;
	private JTextField t2;
	private JTextField t1;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F7 frame = new F7();
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
	public F7() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Fixed Deposit");
		l1.setFont(new Font("Tahoma", Font.BOLD, 16));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(246, 61, 151, 44);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("FD Id*");
		l2.setBounds(136, 145, 77, 14);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Cust Id*");
		l3.setBounds(136, 176, 77, 14);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Account No.*");
		l4.setBounds(136, 209, 96, 14);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Nominee Name*");
		l5.setBounds(136, 241, 99, 14);
		contentPane.add(l5);
		
		JLabel l6 = new JLabel("FD Type*");
		l6.setBounds(350, 145, 65, 14);
		contentPane.add(l6);
		
		JLabel l7 = new JLabel("Amount*");
		l7.setBounds(350, 176, 65, 14);
		contentPane.add(l7);
		
		JLabel l8 = new JLabel("FD Duration*");
		l8.setBounds(350, 209, 82, 14);
		contentPane.add(l8);
		
		t4 = new JTextField();
		t4.setBounds(237, 238, 86, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(237, 206, 86, 20);
		contentPane.add(t3);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(237, 173, 86, 20);
		contentPane.add(t2);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(237, 142, 86, 20);
		contentPane.add(t1);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(453, 142, 86, 20);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(453, 173, 86, 20);
		contentPane.add(t6);
		
		t7 = new JTextField();
		t7.setColumns(10);
		t7.setBounds(453, 206, 86, 20);
		contentPane.add(t7);
		
		JButton b2 = new JButton("Create");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(t1.getText().trim().equals("") || t2.getText().trim().equals("") || t3.getText().trim().equals("") || t4.getText().trim().equals("") ||
					   t5.getText().trim().equals("") || t6.getText().trim().equals("") || t7.getText().trim().equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Please fill mandatory(*) Details.");
					} 
					else 
					{	
				Connection co=DBConnection.getConnection();
				String i=t1.getText();
				String c=t2.getText();
				String a=t3.getText();
				String n=t4.getText();
				String t=t5.getText();
				Double am=Double.parseDouble(t6.getText());
				String d=t7.getText();
				
				String insert="insert into fixeddeposit values(?,?,?,?,?,?,?)";
				
				PreparedStatement pst=co.prepareStatement(insert);
				
				pst.setString(1, i);
				pst.setString(2, c);
				pst.setString(3, t);
				pst.setString(4, a);
				pst.setDouble(5, am);
				pst.setString(6, d);
				pst.setString(7, n);
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"FD Created Successfully.");
			    t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");t7.setText("");				}
				}
				catch(Exception e1) {
				}
			}
		});
		b2.setBounds(343, 302, 89, 23);
		contentPane.add(b2);
		
		JButton b1 = new JButton("Back");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new F4();
			}
		});
		b1.setBounds(224, 302, 89, 23);
		contentPane.add(b1);
		
		JLabel LogOut = new JLabel("LogOut");
		LogOut.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					new F1();
					dispose();
				}
			});
		LogOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		LogOut.setBounds(578, 0, 46, 23);
		contentPane.add(LogOut);
	}

}
