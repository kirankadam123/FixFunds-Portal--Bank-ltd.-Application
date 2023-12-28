import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class F11 extends JFrame {

    private JPanel contentPane;
    private JLabel labelCustId;
    private JLabel labelFirstName;
    private JLabel labelMiddleName;
    private JLabel labelLastName;
    private JLabel labelStreet;
    private JLabel labelCity;
    private JLabel labelState;
    private JLabel labelPincode;
    private JLabel labelAadharNo;
    private JLabel labelPANNo;
    private JLabel labelBirthDate;
    private JLabel labelAge;
    private JLabel labelAccountInfo; 
    private JLabel labelFixedDepositInfo; 
    private JLabel lblFdInformation;
    private JLabel lblCustomerInformation;
    private JLabel LogOut;
    private JButton btnNewButton;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    F11 frame = new F11("CustomerId");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public F11(String custid) {
    	setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       
        labelCustId = new JLabel("Customer ID:");
        labelCustId.setBounds(45, 60, 200, 20);
        contentPane.add(labelCustId);

        labelFirstName = new JLabel("First Name:");
        labelFirstName.setBounds(45, 90, 200, 20);
        contentPane.add(labelFirstName);
        
        labelMiddleName = new JLabel("Middle Name:");
        labelMiddleName.setBounds(45, 120, 200, 20);
        contentPane.add(labelMiddleName);

        labelLastName = new JLabel("Last Name:");
        labelLastName.setBounds(45, 150, 200, 20);
        contentPane.add(labelLastName);

        labelStreet = new JLabel("Street:");
        labelStreet.setBounds(45, 180, 200, 20);
        contentPane.add(labelStreet);

        labelCity = new JLabel("City:");
        labelCity.setBounds(45, 208, 200, 20);
        contentPane.add(labelCity);

        labelState = new JLabel("State:");
        labelState.setBounds(45, 239, 130, 20);
        contentPane.add(labelState);

        labelPincode = new JLabel("Pincode:");
        labelPincode.setBounds(45, 270, 200, 20);
        contentPane.add(labelPincode);

        labelAadharNo = new JLabel("Aadhar Number:");
        labelAadharNo.setBounds(45, 300, 200, 20);
        contentPane.add(labelAadharNo);

        labelPANNo = new JLabel("PAN Number:");
        labelPANNo.setBounds(45, 330, 200, 20);
        contentPane.add(labelPANNo);

        labelBirthDate = new JLabel("Birth Date:");
        labelBirthDate.setBounds(45, 361, 200, 20);
        contentPane.add(labelBirthDate);

        labelAge = new JLabel("Age:");
        labelAge.setBounds(45, 392, 200, 20);
        contentPane.add(labelAge);

        
        labelAccountInfo = new JLabel("Information:");
        labelAccountInfo.setBounds(332, 73, 242, 110);
        contentPane.add(labelAccountInfo);

        labelFixedDepositInfo = new JLabel("Information:");
        labelFixedDepositInfo.setHorizontalAlignment(SwingConstants.LEFT);
        labelFixedDepositInfo.setBounds(332, 224, 242, 118);
        contentPane.add(labelFixedDepositInfo);
        
        JLabel lblNewLabel = new JLabel("Account Information");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(332, 53, 160, 31);
        contentPane.add(lblNewLabel);
        
        lblFdInformation = new JLabel("FD Information");
        lblFdInformation.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblFdInformation.setBounds(332, 208, 160, 31);
        contentPane.add(lblFdInformation);
        
        lblCustomerInformation = new JLabel("Customer Information");
        lblCustomerInformation.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCustomerInformation.setBounds(45, 18, 160, 31);
        contentPane.add(lblCustomerInformation);
        
        LogOut = new JLabel("LogOut");
        LogOut.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				new F1();
				dispose();
			}
		});	
        LogOut.setFont(new Font("Tahoma", Font.BOLD, 13));
        LogOut.setBounds(528, 0, 46, 23);
        contentPane.add(LogOut);
        
        btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new F4();
        		       		
        	}
        });
        btnNewButton.setBounds(449, 427, 89, 23);
        contentPane.add(btnNewButton);

        
        try {
            Connection con = DBConnection.getConnection();

                       String q = "select c.*, a.*, fd.* from customer_master c " +
                           "left join account a on c.Cust_id = a.Cust_id " +
                           "left join fixeddeposit fd on c.Cust_id = fd.Cust_id " +
                           "where c.Cust_id = ?";
            
            PreparedStatement pst = con.prepareStatement(q);
            pst.setString(1, custid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                
                labelCustId.setText("Customer ID: " + rs.getString(1));
                labelFirstName.setText("First Name: " + rs.getString(2));
                labelMiddleName.setText("Middle Name: " + rs.getString(3));
                labelLastName.setText("Last Name: " + rs.getString(4));
                labelStreet.setText("Street: " + rs.getString(5));
                labelCity.setText("City: " + rs.getString(6));
                labelState.setText("State: " + rs.getString(7));
                labelPincode.setText("Pincode: " + rs.getString(8));
                labelAadharNo.setText("Aadhar Number: " + rs.getString(9));
                labelPANNo.setText("PAN Number: " + rs.getString(10));
                labelBirthDate.setText("Birth Date: " + rs.getString(11));
                labelAge.setText("Age: " + rs.getString(12));


                
                String accountInfo = "No Account found for this Customer.";
                if (rs.getString(13) != null) {
                    accountInfo = "<html>Account Number: " + rs.getString(13) +
                            "<br>Balance: " + rs.getString(15) +
                            "<br>Account Type: " + rs.getString(16) +
                            "<br>Open Date: " + rs.getString(17) +
                            "<br> Account Status: " + rs.getString(18) + "</html>";
                    }
                labelAccountInfo.setText(accountInfo);

                
                String fdInfo = "No Fixed Deposit found for this Customer.";
                if (rs.getString(19) != null) {
                    fdInfo = "<html>Fixed Deposit ID: " + rs.getString(19) +
                             "<br>FD Type: " + rs.getString(21)+
                             "<br>Amount: "+rs.getDouble(23)+
                             "<br>FD Duration: "+rs.getString(24)+
                             "<br>Nominee Name: "+rs.getString(25)+"</html>";
                }
                labelFixedDepositInfo.setText(fdInfo);
            }

            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
