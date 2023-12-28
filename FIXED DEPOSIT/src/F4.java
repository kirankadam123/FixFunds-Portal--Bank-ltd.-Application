import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class F4 extends JFrame {

    Connection con = DBConnection.getConnection();
    private JPanel contentPane;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t6;
    private JTextField t5;
    private JComboBox<String> comboBox;
    private JTextField t9;
    private JTextField t7;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    F4 frame = new F4();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public F4() {
        comboBox = new JComboBox<>();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Enter Cust id");
        l1.setBounds(38, 127, 90, 14);
        contentPane.add(l1);

        JButton b1 = new JButton("Show");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(t3.getText().equals(""))
            			{
            		       JOptionPane.showMessageDialog(null, "Please enter customer id.");
            			}
            	else {
            		try {
        		    	String q="select * from customer_master where Cust_id=?";
        		    	PreparedStatement pst=con.prepareStatement(q);    		            		            		                	
            	String custid = t3.getText().trim();
            	pst.setString(1,custid);
    		    ResultSet rs=pst.executeQuery();
    		    if(rs.next())
    		    {
				F11 f=new F11(custid);				
				dispose();
    		    }
    		    else {
    		    	JOptionPane.showMessageDialog(null, "Customer not found.");
    		    	t3.setText("");
    		    }
    		    }catch(Exception e1) {}
            }}
        });
        b1.setBounds(305, 123, 94, 23);
        contentPane.add(b1);

        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.addItem("Customer");
        comboBox1.addItem("Bank Account");
        comboBox1.addItem("FD");

        JButton b2 = new JButton("Register");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("ComboBox1 items: " + comboBox1.getItemCount());
                String selectedRole = comboBox1.getSelectedItem() != null ? comboBox1.getSelectedItem().toString() : "";
                System.out.println("Selected Role: " + selectedRole); // Debugging line

                if (selectedRole.equals("Customer")) {
                    new F5();dispose();
                } else if (selectedRole.equals("Bank Account")) {
                    new F6();dispose();
                } else if (selectedRole.equals("FD")) {
                    new F7();dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select Appropriate Role.");
                }
            }
        });

        b2.setBounds(474, 304, 90, 23);
        contentPane.add(b2);

        t2 = new JTextField();
        t2.setText("Enter Account No.");
        t2.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                t2.setText("");
            }
        });
        t2.setColumns(10);
        t2.setBounds(38, 353, 102, 20);
        contentPane.add(t2);

        JLabel l4 = new JLabel("Withdraw Amount");
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(38, 322, 170, 20);
        contentPane.add(l4);

        t3 = new JTextField();
        t3.setBounds(192, 124, 90, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        JComboBox comboBox2 = new JComboBox();
        comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Select acc type", "Customer", "Bank Account", "FD"}));
        comboBox2.setBounds(38, 198, 118, 22);
        contentPane.add(comboBox2);

        t4 = new JTextField();
        t4.setColumns(10);
        t4.setBounds(192, 199, 90, 20);
        contentPane.add(t4);
        
        

        JLabel lblNewLabel = new JLabel("Manage Customer");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(225, 11, 208, 55);
        contentPane.add(lblNewLabel);

        JLabel LogOut = new JLabel("LogOut");
        LogOut.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new F1();
                dispose();
            }
        });
        LogOut.setHorizontalAlignment(SwingConstants.CENTER);
        LogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
        LogOut.setBounds(573, 0, 61, 35);
        contentPane.add(LogOut);

        JLabel lblViewDetails = new JLabel("View Customer Details");
        lblViewDetails.setHorizontalAlignment(SwingConstants.LEFT);
        lblViewDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblViewDetails.setBounds(38, 77, 182, 35);
        contentPane.add(lblViewDetails);

        JLabel lblViewDetails_1 = new JLabel("Delete Account");
        lblViewDetails_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblViewDetails_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblViewDetails_1.setBounds(38, 152, 158, 35);
        contentPane.add(lblViewDetails_1);

        JButton Delete = new JButton("Delete");
        Delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        		
        		Connection con=DBConnection.getConnection();
        		PreparedStatement pst,pst1,pst2;
        		String s1=t4.getText();
        		
        		String selectedRole1 = comboBox2.getSelectedItem() != null ? comboBox2.getSelectedItem().toString() : "";
        		
        		if(selectedRole1.equals("Customer"))
        		{    if(!s1.equals("")) {   			
        			String q1="delete from fixeddeposit where Cust_id=?";
        			String q2="delete from account where Cust_id=?";
        			String q3="delete from customer_master where Cust_id=?";
        			pst=con.prepareStatement(q1);
        			pst.setString(1,s1);
        			pst1=con.prepareStatement(q2);
        			pst1.setString(1,s1);
        			pst2=con.prepareStatement(q3);
        			pst2.setString(1,s1);
        			int a=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?","Delete Confirmation",JOptionPane.YES_NO_OPTION);
    				if(a==JOptionPane.YES_OPTION)
    				{
        			pst.executeUpdate();
        			pst1.executeUpdate();
        			int i=pst2.executeUpdate();
        			if(i==0) {
        				JOptionPane.showMessageDialog(null, "No record found. Please enter valid Customer id.");
        				t4.setText("");
        			}else
        			JOptionPane.showMessageDialog(null, "record deleted succesfully");
        		}else if(a==JOptionPane.NO_OPTION )
				{
					t4.setText("");
				}
        		}
        		else
        			JOptionPane.showMessageDialog(null, "Please Enter customer id.");
        			
        		}else if(selectedRole1.equals("Bank Account"))
        		{    if(!s1.equals("")) { 
        			String q1="delete from fixeddeposit where Acc_no=?";
        			String q2="delete from account where Acc_no=?";
        			pst=con.prepareStatement(q1);
        			pst1=con.prepareStatement(q2);
        			pst.setString(1, s1);
        			pst1.setString(1, s1);
        			pst.executeUpdate();
        			int i=pst1.executeUpdate();
        			if(i==0) {
        				JOptionPane.showMessageDialog(null, "No record found. Please enter valid Account No.");
        				t4.setText("");
        			}else
        			JOptionPane.showMessageDialog(null, "record deleted succesfully");
           		
        		}
        		else
        			JOptionPane.showMessageDialog(null, "Please Enter Account no.");
        			
        		}
        		else if(selectedRole1.equals("FD"))
        		{  if(!s1.equals("")) { 
        			String q="delete from fixeddeposit where FD_ID=?";
        			pst=con.prepareStatement(q);
        			pst.setString(1, s1);
        			int i=pst.executeUpdate();
        			if(i==0) {
        				JOptionPane.showMessageDialog(null, "No record found. Please enter valid FD id.");
        			}else
        			JOptionPane.showMessageDialog(null, "record deleted succesfully");        			
        		}
        		else
        			JOptionPane.showMessageDialog(null, "Please Enter FD id.");
        			
        		}else 
        		{
                    JOptionPane.showMessageDialog(null, "Please Select Appropriate Role.");
                }
        		
        	}
        	catch(Exception e1) {
        		e1.printStackTrace();
        	}
        }
        });
        Delete.setBounds(305, 197, 94, 23);
        contentPane.add(Delete);

        JButton Withdraw = new JButton("Withdraw");
        Withdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            	    if (t2.getText().equals("") || t2.getText().equals("Enter Account No.")) {
            	        JOptionPane.showMessageDialog(null, "Please Enter valid Account no.");
            	    } else if (t6.getText().equals("") || t6.getText().equals("Enter Amount.")) {
            	        JOptionPane.showMessageDialog(null, "Please Enter amount");
            	    } else {
            	        String an = t2.getText();
            	        double am = Double.parseDouble(t6.getText());

            	        // Check if the balance is sufficient
            	        String p = "select Acc_Balance from account where Acc_no=?";
            	        PreparedStatement ps = con.prepareStatement(p);
            	        ps.setString(1, an);
            	        ResultSet rs = ps.executeQuery();

            	        if (rs.next()) {
            	            double currentBalance = rs.getDouble("Acc_Balance");

            	            if (currentBalance >= am) {
            	                
            	                String q = "update account set Acc_Balance=Acc_Balance-? where Acc_no=?";
            	                PreparedStatement pst = con.prepareStatement(q);
            	                pst.setDouble(1, am);
            	                pst.setString(2, an);
            	                int i = pst.executeUpdate();

            	                if (i == 0) {
            	                    JOptionPane.showMessageDialog(null, "Withdrawal failed. Account not found.");
            	                } else {
            	                    JOptionPane.showMessageDialog(null, am + " rs withdrawn Successfully from account no. " + an + ".");
            	                    t2.setText("Enter Account No.");
            	                    t6.setText("Enter Amount.");
            	                }
            	            } else {
            	                
            	                JOptionPane.showMessageDialog(null, "Withdrawal failed. Insufficient account balance.");
            	                t2.setText("Enter Account No.");
            	                t6.setText("Enter Amount.");
            	            }
            	        } else {
            	            JOptionPane.showMessageDialog(null, "Withdrawal failed. Account not found.");
            	            t2.setText("Enter Account No.");
            	            t6.setText("Enter Amount.");
            	        }
            	    }
            	} catch (Exception e1) {
            	    e1.printStackTrace();
            	}


            }
        });
        Withdraw.setBounds(305, 350, 94, 23);
        contentPane.add(Withdraw);

        t6 = new JTextField();
        t6.setText("Enter Amount.");
        t6.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                t6.setText("");
            }
        });
        t6.setColumns(10);
        t6.setBounds(191, 353, 91, 20);
        contentPane.add(t6);

        JLabel lblCheckBalance = new JLabel("Check Balance");
        lblCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCheckBalance.setBounds(38, 396, 170, 20);
        contentPane.add(lblCheckBalance);

        JLabel lblNewLabel_1 = new JLabel("Enter Account No.");
        lblNewLabel_1.setBounds(38, 434, 102, 14);
        contentPane.add(lblNewLabel_1);

        t5 = new JTextField();
        t5.setColumns(10);
        t5.setBounds(192, 428, 90, 20);
        contentPane.add(t5);

        JButton Check = new JButton("Check");
        Check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (t5.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Please Enter valid Account no.");
                    } else {
                        String q = "select Acc_Balance from account where Acc_no=?";
                        PreparedStatement pst = con.prepareStatement(q);
                        pst.setString(1, t5.getText());
                        ResultSet rs = pst.executeQuery();
                        if (rs.next()) {
                            Double b = rs.getDouble(1);
                            JOptionPane.showMessageDialog(null, "Account Balance of account no.: " + t5.getText() + " is" + b);
                            t5.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Account is not found");
                            t5.setText("");
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        Check.setBounds(305, 427, 94, 23);
        contentPane.add(Check);

        JLabel lblViewDetails_1_1 = new JLabel("Register");
        lblViewDetails_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblViewDetails_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblViewDetails_1_1.setBounds(474, 203, 130, 35);
        contentPane.add(lblViewDetails_1_1);
        
        comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Select acc type", "Customer", "Bank Account", "FD"}));
        comboBox1.setBounds(474, 258, 118, 22);
        contentPane.add(comboBox1);
        
        t9 = new JTextField();
        t9.setText("Enter Account No.");
        t9.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                t9.setText("");
            }
        });
        t9.setColumns(10);
        t9.setBounds(38, 273, 102, 20);
        contentPane.add(t9);
        
        JLabel lblDepositAmount = new JLabel("Deposit Amount");
        lblDepositAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDepositAmount.setBounds(38, 242, 170, 20);
        contentPane.add(lblDepositAmount);
        
        JButton b6 = new JButton("Deposit");
        b6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			if(t9.getText().equals("")||t9.getText().equals("Enter Account No."))
        				JOptionPane.showMessageDialog(null, "Please enter Account no.");
        			else if(t7.getText().equals("")||t7.getText().equals("Enter Amount."))
        				JOptionPane.showMessageDialog(null,"Please enter amount.");
        			    else
        			     {
        			    	String an=t9.getText();
        			    	Double am=Double.parseDouble(t7.getText());
        			    	
        			    	String q="update account set Acc_Balance=Acc_Balance + ? where Acc_no=?";
        			    	PreparedStatement pst=con.prepareStatement(q);
        			    	pst.setDouble(1, am);
         	                pst.setString(2, an);
        			    	int i=pst.executeUpdate();
        			    	if(i==0)
        			    	{
        			    		JOptionPane.showMessageDialog(null, "Account not found.");
        			    		t9.setText("Enter Account No.");
        			    		t7.setText("Enter Amount.");
        			    	}
        			    	else
        			    	{
        			    		JOptionPane.showMessageDialog(null, am+" rs Amount Deposited Successfully to the account "+an);
        			    		t9.setText("Enter Account No.");
        			    		t7.setText("Enter Amount.");
        			    	}	
        			     }
        			
        		}catch(Exception e1) {}
        		}
        	}
        );
        b6.setBounds(305, 270, 94, 23);
        contentPane.add(b6);
        
        t7 = new JTextField();
        t7.setText("Enter Amount.");
        t7.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                t7.setText("");
            }
        });
        t7.setColumns(10);
        t7.setBounds(191, 273, 91, 20);
        contentPane.add(t7);
    }
}
