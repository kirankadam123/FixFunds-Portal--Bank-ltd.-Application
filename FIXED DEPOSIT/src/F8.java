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

public class F8 extends JFrame {

    private JPanel contentPane;
    private JLabel labelId;
    private JLabel labelFirstName;
    private JLabel labelMiddleName;
    private JLabel labelLastName;
    private JLabel labelStreet;
    private JLabel labelCity;
    private JLabel labelState;
    private JLabel labelPincode;
    private JLabel labelContactNo;
    private JLabel labelDesignation;
    private JLabel labelSalary;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    F8 frame = new F8("employeeId"); 
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public F8(String eid) {
    	setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        labelId = new JLabel("Employee ID:");
        labelId.setBounds(256, 112, 258, 20);
        contentPane.add(labelId);

        labelFirstName = new JLabel("First Name:");
        labelFirstName.setBounds(256, 142, 258, 20);
        contentPane.add(labelFirstName);

        labelMiddleName = new JLabel("Middle Name:");
        labelMiddleName.setBounds(256, 172, 258, 20);
        contentPane.add(labelMiddleName);

        labelLastName = new JLabel("Last Name:");
        labelLastName.setBounds(256, 202, 258, 20);
        contentPane.add(labelLastName);
        
        labelStreet = new JLabel("Street:");
        labelStreet.setBounds(256, 232, 258, 20);
        contentPane.add(labelStreet);

        labelCity = new JLabel("City:");
        labelCity.setBounds(256, 262, 258, 20);
        contentPane.add(labelCity);

        labelState = new JLabel("State:");
        labelState.setBounds(256, 292, 187, 20);
        contentPane.add(labelState);

        labelPincode = new JLabel("Pincode:");
        labelPincode.setBounds(256, 322, 258, 20);
        contentPane.add(labelPincode);

        labelContactNo = new JLabel("Contact No:");
        labelContactNo.setBounds(256, 352, 258, 20);
        contentPane.add(labelContactNo);

        labelDesignation = new JLabel("Designation:");
        labelDesignation.setBounds(256, 382, 258, 20);
        contentPane.add(labelDesignation);

        labelSalary = new JLabel("Salary:");
        labelSalary.setBounds(256, 412, 258, 20);
        contentPane.add(labelSalary);
        
        JLabel lblEmployeeDetails = new JLabel("Employee Details");
        lblEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblEmployeeDetails.setBounds(243, 48, 200, 42);
        contentPane.add(lblEmployeeDetails);
        
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
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        		new F2();
        	}
        });
        btnNewButton.setBounds(535, 427, 89, 23);
        contentPane.add(btnNewButton);



        try {
            Connection con = DBConnection.getConnection();
            String q = "select * from employee where Emp_id = ?";
            PreparedStatement pst = con.prepareStatement(q);
            pst.setString(1, eid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                labelId.setText("Employee ID:      " + rs.getString("Emp_id"));
                labelFirstName.setText("First Name:      " + rs.getString("Emp_fname"));
                labelMiddleName.setText("Middle Name:      " + rs.getString("Emp_mname"));
                labelLastName.setText("Last Name:      " + rs.getString("Emp_lname"));
                labelStreet.setText("Street:      " + rs.getString("E_Street"));
                labelCity.setText("City:      " + rs.getString("E_City"));
                labelState.setText("State:      " + rs.getString("E_State"));
                labelPincode.setText("Pincode:      " + rs.getString("E_Pincode"));
                labelContactNo.setText("Contact No:      " + rs.getString("E_Contactno"));
                labelDesignation.setText("Designation:      " + rs.getString("E_Designation"));
                labelSalary.setText("Salary:      " + rs.getString("E_Salary"));
               
              }

            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
