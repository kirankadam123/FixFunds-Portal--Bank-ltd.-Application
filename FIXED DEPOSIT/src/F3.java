import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class F3 extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private JTextField t9;
	private JTextField t10;
	private JTextField t11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F3 frame = new F3();
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
	public F3() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("New Employee");
		l1.setFont(new Font("Tahoma", Font.BOLD, 17));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(198, 49, 246, 33);
		contentPane.add(l1);
		
		JLabel l4 = new JLabel("Last Name*");
		l4.setBounds(70, 192, 70, 14);
		contentPane.add(l4);
		
		JLabel l3 = new JLabel("Middle Name*");
		l3.setBounds(70, 158, 96, 14);
		contentPane.add(l3);
		
		JLabel l2 = new JLabel("First Name*");
		l2.setBounds(70, 120, 70, 14);
		contentPane.add(l2);
		
		JLabel l7 = new JLabel("Street Name*");
		l7.setBounds(356, 120, 86, 14);
		contentPane.add(l7);
		
		JLabel l6 = new JLabel("Designation*");
		l6.setBounds(70, 261, 86, 14);
		contentPane.add(l6);
		
		JLabel l5 = new JLabel("Emp-Id*");
		l5.setBounds(70, 226, 70, 14);
		contentPane.add(l5);
		
		JLabel l8 = new JLabel("City Name*");
		l8.setBounds(356, 158, 86, 14);
		contentPane.add(l8);
		
		JLabel l9 = new JLabel("State Name*");
		l9.setBounds(356, 192, 86, 14);
		contentPane.add(l9);
		
		JLabel l10 = new JLabel("Pincode*");
		l10.setBounds(356, 226, 86, 14);
		contentPane.add(l10);
		
		t1 = new JTextField();
		t1.setBounds(211, 117, 86, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(211, 155, 86, 20);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(211, 189, 86, 20);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(211, 223, 86, 20);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(211, 258, 86, 20);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(472, 117, 86, 20);
		contentPane.add(t6);
		
		t7 = new JTextField();
		t7.setColumns(10);
		t7.setBounds(472, 155, 86, 20);
		contentPane.add(t7);
		
		t8 = new JTextField();
		t8.setColumns(10);
		t8.setBounds(472, 189, 86, 20);
		contentPane.add(t8);
		
		t9 = new JTextField();
		t9.setColumns(10);
		t9.setBounds(472, 223, 86, 20);
		contentPane.add(t9);
		
		JButton b1 = new JButton("Register");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (t1.getText().trim().equals("") || t2.getText().trim().equals("") || t3.getText().trim().equals("") || t4.getText().trim().equals("") ||
						t5.getText().trim().equals("") || t6.getText().trim().equals("") || t7.getText().trim().equals("") || t8.getText().trim().equals("") ||
						t9.getText().trim().equals("") || t10.getText().trim().equals("") || t11.getText().trim().equals("") ) 
						{
						   JOptionPane.showMessageDialog(null, "Please fill mandatory(*) Details.");
						}
					else 
					    {
				Connection con = DBConnection.getConnection();
				String f=t1.getText();				
				String m=t2.getText();		
				String l=t3.getText();				
				String i=t4.getText();
				String d=t5.getText();				
				String str=t6.getText();				
				String c=t7.getText();				
				String st=t8.getText();
				int p=Integer.parseInt(t9.getText());
				Double cn=Double.parseDouble(t10.getText());
				Double s=Double.parseDouble(t11.getText());
				
				String insert="insert into employee values (?,?,?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement pst=con.prepareStatement(insert);
				pst.setString(1, i);
				pst.setString(2, f);
				pst.setString(3, m);
				pst.setString(4, l);
				pst.setString(5, str);
				pst.setString(6, c);
				pst.setString(7, st);
				pst.setInt(8, p);
				pst.setDouble(9, cn);
				pst.setString(10, d);
				pst.setDouble(11, s);
				
				pst.executeUpdate();
				
                JOptionPane.showMessageDialog(null, "New Employee registered successfully");
                t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");t7.setText("");t8.setText("");
			    t9.setText("");t10.setText("");t11.setText("");
			   
				}
				}
				catch(Exception e1){}
				
			}
		});
		b1.setBounds(375, 368, 89, 23);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Back");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new F2();
				dispose();
			}
		});
		b2.setBounds(233, 368, 89, 23);
		contentPane.add(b2);
		
		JLabel l11 = new JLabel("Salary*");
		l11.setBounds(70, 296, 86, 14);
		contentPane.add(l11);
		
		t10 = new JTextField();
		t10.setColumns(10);
		t10.setBounds(211, 293, 86, 20);
		contentPane.add(t10);
		
		JLabel l12 = new JLabel("Contact No.*");
		l12.setBounds(356, 261, 86, 14);
		contentPane.add(l12);
		
		t11 = new JTextField();
		t11.setColumns(10);
		t11.setBounds(472, 258, 86, 20);
		contentPane.add(t11);
		
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
