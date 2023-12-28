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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class F6 extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F6 frame = new F6();
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
	public F6() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("New Account");
		l1.setFont(new Font("Tahoma", Font.BOLD, 18));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(262, 35, 145, 64);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Account No.*");
		l2.setBounds(139, 126, 89, 14);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Cust Id*");
		l3.setBounds(139, 165, 74, 14);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Deposit*");
		l4.setBounds(139, 201, 74, 14);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Account Type*");
		l5.setBounds(363, 126, 89, 14);
		contentPane.add(l5);
		
		JLabel l6 = new JLabel("Account Status*");
		l6.setBounds(363, 165, 104, 14);
		contentPane.add(l6);
		
		JLabel l7 = new JLabel("Date*");
		l7.setBounds(363, 201, 74, 14);
		contentPane.add(l7);
		
		t1 = new JTextField();
		t1.setBounds(224, 123, 86, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(223, 162, 86, 20);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(223, 198, 86, 20);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(462, 123, 86, 20);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(462, 159, 86, 20);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(462, 198, 86, 20);
		contentPane.add(t6);
		
		JButton b1 = new JButton("Create Account");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(t1.getText().trim().equals("") || t2.getText().trim().equals("") || t3.getText().trim().equals("") || t4.getText().trim().equals("") ||
					   t5.getText().trim().equals("") || t6.getText().trim().equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Please fill mandatory(*) Details.");
					} 
				else 
				{	
				Connection con=DBConnection.getConnection();
				String i=t1.getText();
				String c=t2.getText();
				Double de=Double.parseDouble(t3.getText());
				String t=t4.getText();
				String s=t5.getText();System.out.print("1");
				java.util.Date d=new SimpleDateFormat("yyyy-MM-dd").parse(t6.getText());
				System.out.print("2");
				String insert="insert into account values(?,?,?,?,?,?)";
				System.out.print("4");
				PreparedStatement pst=con.prepareStatement(insert);
				System.out.print("5");
				pst.setString(1, i);
				pst.setString(2, c);
				pst.setDouble(3, de);
				pst.setString(4, t);
				pst.setString(6, s);System.out.print("6");
				pst.setDate(5, new java.sql.Date(d.getTime()));
				System.out.print("7");
				pst.executeUpdate();
			    JOptionPane.showMessageDialog(null,"Account Created Successfully.");
			    t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");
			    }
				
			}catch(Exception e1) {e1.printStackTrace();}
			}
		});
		b1.setBounds(280, 253, 122, 23);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Back");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new F4();
				dispose();
			}
			
		});
		b2.setBounds(221, 299, 89, 23);
		contentPane.add(b2);
		
		JButton b3 = new JButton("Next");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new F7();
				dispose();
			}
		});
		b3.setBounds(378, 299, 89, 23);
		contentPane.add(b3);
		
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
