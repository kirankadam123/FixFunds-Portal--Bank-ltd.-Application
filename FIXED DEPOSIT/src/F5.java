import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class F5 extends JFrame {

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
	private JTextField t12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F5 frame = new F5();
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
	public F5() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("New Customer");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setFont(new Font("Tahoma", Font.BOLD, 18));
		l1.setBounds(271, 52, 142, 30);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("First Name*");
		l2.setBounds(95, 108, 76, 14);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Middle Name*");
		l3.setBounds(95, 148, 86, 14);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Last Name*");
		l4.setBounds(95, 184, 76, 14);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Cust Id*");
		l5.setBounds(95, 220, 76, 14);
		contentPane.add(l5);
		
		JLabel l6 = new JLabel("Birth Date*");
		l6.setBounds(95, 255, 76, 14);
		contentPane.add(l6);
		
		JLabel l8 = new JLabel("Street*");
		l8.setBounds(334, 108, 66, 14);
		contentPane.add(l8);
		
		JLabel l9 = new JLabel("City*");
		l9.setBounds(334, 148, 66, 14);
		contentPane.add(l9);
		
		JLabel l11 = new JLabel("Pincode*");
		l11.setBounds(334, 220, 66, 14);
		contentPane.add(l11);
		
		JLabel l10 = new JLabel("State*");
		l10.setBounds(334, 184, 66, 14);
		contentPane.add(l10);
		
		JLabel l12 = new JLabel("Aadhar No.*");
		l12.setBounds(334, 255, 79, 14);
		contentPane.add(l12);
		
		JLabel l7 = new JLabel("Age*");
		l7.setBounds(95, 291, 76, 14);
		contentPane.add(l7);
		
		JLabel l13 = new JLabel("Pan No.*");
		l13.setBounds(334, 291, 66, 14);
		contentPane.add(l13);
		
		t1 = new JTextField();
		t1.setBounds(181, 105, 86, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(181, 142, 86, 20);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(181, 181, 86, 20);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(181, 217, 86, 20);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(181, 252, 86, 20);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(181, 288, 86, 20);
		contentPane.add(t6);
		
		t7 = new JTextField();
		t7.setColumns(10);
		t7.setBounds(410, 105, 86, 20);
		contentPane.add(t7);
		
		t8 = new JTextField();
		t8.setColumns(10);
		t8.setBounds(410, 145, 86, 20);
		contentPane.add(t8);
		
		t9 = new JTextField();
		t9.setColumns(10);
		t9.setBounds(410, 181, 86, 20);
		contentPane.add(t9);
		
		t10 = new JTextField();
		t10.setColumns(10);
		t10.setBounds(410, 217, 86, 20);
		contentPane.add(t10);
		
		t11 = new JTextField();
		t11.setColumns(10);
		t11.setBounds(410, 252, 86, 20);
		contentPane.add(t11);
		
		t12 = new JTextField();
		t12.setColumns(10);
		t12.setBounds(410, 288, 86, 20);
		contentPane.add(t12);
		
		JButton b1 = new JButton("Register");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (t1.getText().trim().equals("") || t2.getText().trim().equals("") || t3.getText().trim().equals("") || t4.getText().trim().equals("") ||
					   t5.getText().trim().equals("") || t6.getText().trim().equals("") || t7.getText().trim().equals("") || t8.getText().trim().equals("") ||
					   t9.getText().trim().equals("") || t10.getText().trim().equals("") || t11.getText().trim().equals("") || t12.getText().trim().equals("")) 
					{
					 JOptionPane.showMessageDialog(null, "Please fill mandatory(*) Details.");
					} else 
					{
					Connection con=DBConnection.getConnection();
					String f=t1.getText();
					String m=t2.getText();
					String l=t3.getText();
					String i=t4.getText();
					java.util.Date b=new SimpleDateFormat("yyyy-mm-dd").parse(t5.getText());
					int a=Integer.parseInt(t6.getText());
					String str=t7.getText();
					String c=t8.getText();
					String st=t9.getText();
					int p=Integer.parseInt(t10.getText());
					Double ac=Double.parseDouble(t11.getText());
					String pc=t12.getText();
					
					String insert="insert into customer_master values(?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst=con.prepareStatement(insert);
				    pst.setString(1,i);
				    pst.setString(2,f);
				    pst.setString(3,m);
				    pst.setString(4,l);
				    pst.setString(5,str);
				    pst.setString(6,c);
				    pst.setString(7,st);
				    pst.setInt(8,p);
				    pst.setDouble(9,ac);
				    pst.setString(10,pc);
				    pst.setDate(11,new java.sql.Date(b.getTime()));
				    pst.setInt(12,a);
				   
				    pst.executeUpdate();
				    JOptionPane.showMessageDialog(null,"Registered Successfully.");
				    t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");t7.setText("");t8.setText("");
				    t9.setText("");t10.setText("");t11.setText("");t12.setText("");
				    }
				    
				}catch(Exception e1) {}
				
			}
		});
		b1.setBounds(285, 353, 89, 23);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Back");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new F4();
				dispose();
			}
		});
		b2.setBounds(178, 402, 89, 23);
		contentPane.add(b2);
		
		JButton b3 = new JButton("Next");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new F6();
				dispose();
			}
		});
		b3.setBounds(396, 402, 89, 23);
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
