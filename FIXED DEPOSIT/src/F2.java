import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class F2 extends JFrame {
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F2 frame = new F2();
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
	public F2() {
		
		Connection con=DBConnection.getConnection();
		
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME ADMIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(231, 68, 180, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel LogOut = new JLabel("LogOut");
		LogOut.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				new F1();
				dispose();
			}
		});	
		LogOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		LogOut.setBounds(564, 22, 46, 23);
		getContentPane().add(LogOut);
		
		JLabel l1 = new JLabel("Enter Cust id");
		l1.setBounds(130, 170, 90, 14);
		getContentPane().add(l1);
		
		JButton b1_1 = new JButton("Show");
		b1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().equals(""))
    			{
    		       JOptionPane.showMessageDialog(null, "Please enter customer id.");
    			}
    	else {
    		    try {
    		    	String q="select * from customer_master where Cust_id=?";
    		    	PreparedStatement pst=con.prepareStatement(q);    		            		    
    		    String custid = t1.getText().trim();
    		    pst.setString(1,custid);
    		    ResultSet rs=pst.executeQuery();
    		    if(rs.next())
    		    {
				F10 f=new F10(custid);				
				dispose();
    		    }
    		    else {
    		    	JOptionPane.showMessageDialog(null, "Customer not found.");
    		    	t1.setText("");
    		    }
    		    }catch(Exception e1) {}
			}}
		});
		b1_1.setBounds(446, 166, 94, 23);
		getContentPane().add(b1_1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(273, 167, 90, 20);
		getContentPane().add(t1);
		
		JLabel lblViewDetails = new JLabel("View Customer Details");
		lblViewDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblViewDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblViewDetails.setBounds(250, 120, 182, 35);
		getContentPane().add(lblViewDetails);
		
		JLabel lblEnterEmpid = new JLabel("Enter Emp-id");
		lblEnterEmpid.setBounds(130, 250, 90, 14);
		getContentPane().add(lblEnterEmpid);
		
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(t2.getText().equals(""))
						JOptionPane.showMessageDialog(null,"Please Enter Employee Id.");
				else {
    		    	String q="select * from employee where Emp_id=?";
    		    	PreparedStatement pst=con.prepareStatement(q);
				String eid = t2.getText().trim();
				pst.setString(1, eid);
				ResultSet rs=pst.executeQuery();
				if(rs.next()) {
					F8 f=new F8(eid);				
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"Employee not found.");
					t2.setText("");
				}
				}
				}catch(Exception e1) {}
			}
		});
		show.setBounds(446, 246, 94, 23);
		getContentPane().add(show);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(273, 247, 90, 20);
		getContentPane().add(t2);
		
		JLabel lblViewEmployeeDetails = new JLabel("View Employee Details");
		lblViewEmployeeDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblViewEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblViewEmployeeDetails.setBounds(250, 200, 182, 35);
		getContentPane().add(lblViewEmployeeDetails);
		
		JLabel lblRegisterEmployee = new JLabel("Register Employee");
		lblRegisterEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegisterEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegisterEmployee.setBounds(261, 358, 182, 35);
		getContentPane().add(lblRegisterEmployee);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new F3();
				dispose();
			}
		});
		btnRegister.setBounds(273, 404, 105, 23);
		getContentPane().add(btnRegister);
		
		JLabel lblDeleteEmployee = new JLabel("Delete Employee");
		lblDeleteEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeleteEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeleteEmployee.setBounds(261, 281, 182, 35);
		getContentPane().add(lblDeleteEmployee);
		
		JLabel lblEnterEmpid_2 = new JLabel("Enter Emp-id");
		lblEnterEmpid_2.setBounds(130, 330, 90, 14);
		getContentPane().add(lblEnterEmpid_2);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			String n;
			public void actionPerformed(ActionEvent e) {
				try
				{
			    if(!t3.getText().equals(""))
			    {
				String p="select Emp_fname from employee where Emp_id=?";
				String q="delete from employee where Emp_id=?";
				PreparedStatement pst=con.prepareStatement(p);
				pst.setString(1,t3.getText());
				ResultSet rs = pst.executeQuery();
				if(rs.next()){
				n=rs.getString(1);	
				}
				PreparedStatement ps=con.prepareStatement(q);
				ps.setString(1,t3.getText());
				int a=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?","Delete Confirmation",JOptionPane.YES_NO_OPTION);
				if(a==JOptionPane.YES_OPTION)
				{
				 int i=ps.executeUpdate();
				 if(i==0)
				 {
				 JOptionPane.showMessageDialog(null,"Record not found. Please enter a valid Employee ID.");
				 t3.setText("");
				 }else 
				  {					
					JOptionPane.showMessageDialog(null,"Employee "+n+" deleted Successfully.");
					t3.setText("");
				  }
				}
				else if(a==JOptionPane.NO_OPTION)
				{
					t3.setText("");
				}
				}
			    
				else
					JOptionPane.showMessageDialog(null, "Please Enter Employee id.");
				}
				catch(Exception e1){
					
				}
			}	
		});
		Delete.setBounds(446, 326, 94, 23);
		getContentPane().add(Delete);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(273, 327, 90, 20);
		getContentPane().add(t3);
	}
}
