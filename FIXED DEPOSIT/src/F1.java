import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JPasswordField;

public class F1 extends JFrame {

    private JPanel contentPane;
    private JTextField t1;
    private JComboBox<String> comboBox;
    private JPasswordField t2;
    private JTextField t3;
    private JTextField t4;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    F1 frame = new F1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    String GenerateRandomCaptcha()
    {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%1234567890";
        Random r = new Random();       
        String c="";
        for(int i=0;i<6;i++)
        {
        	int n = r.nextInt(s.length());
        	c+=s.charAt(n);
        }
        return c;
    }

    
    public F1() {
        comboBox = new JComboBox<>();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Login");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1.setBounds(279, 59, 101, 59);
        contentPane.add(l1);

        JLabel l2 = new JLabel("UserId");
        l2.setBounds(225, 197, 46, 14);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(225, 248, 64, 14);
        contentPane.add(l3);

        t1 = new JTextField();
        t1.setBounds(343, 194, 86, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JButton b2 = new JButton("Back");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new Fo();
                dispose();
            }
        });
        b2.setBounds(225, 375, 89, 23);
        contentPane.add(b2);

        JButton b1 = new JButton("Login");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedRole = comboBox.getSelectedItem() != null ? comboBox.getSelectedItem().toString(): "";

                    if (!selectedRole.isEmpty()) {
                        String username = t1.getText();
                        String password = new String(t2.getPassword());

                        if (!username.isEmpty() && !password.isEmpty()) {
                          if (t3.getText().equals(t4.getText())) 
                          {
                            if (selectedRole.equals("Employee")) {
                                Connection con = DBConnection.getConnection();
                                String q = "select * from employee where Emp_Id=? and Emp_fname=?";
                                try (PreparedStatement pst = con.prepareStatement(q)) {
                                    pst.setString(1, username);
                                    pst.setString(2, password);
                                    ResultSet rs = pst.executeQuery();

                                    if (rs.next()) {
                                        JOptionPane.showMessageDialog(null, "Login Successfully.");
                                        new F4();
                                        dispose();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Invalid username or password.");
                                        t1.setText("");t2.setText("");t3.setText("");t4.setText(GenerateRandomCaptcha());
                                    }
                                }
                            } else if (selectedRole.equals("Admin") && username.equals("Admin") && password.equals("1234")) {
                                JOptionPane.showMessageDialog(null, "Login Successfully.");
                                new F2();
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null,"Invalid username or password.");
                                t1.setText("");t2.setText("");t3.setText("");t4.setText(GenerateRandomCaptcha());
                                
                            }
                        }else
                        {
                        	JOptionPane.showMessageDialog(null,"Incorrect captcha. Please enter the correct captcha.");
                        	t2.setText("");t3.setText("");t4.setText(GenerateRandomCaptcha());
                        } 
                        }else {
                            JOptionPane.showMessageDialog(null, "Please Enter Username and Password.");t3.setText("");t4.setText(GenerateRandomCaptcha());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Select Appropriate Role.");
                        t1.setText("");t2.setText("");t3.setText("");t4.setText(GenerateRandomCaptcha());
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        b1.setBounds(340, 375, 89, 23);
        contentPane.add(b1);

        comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Admin", "Employee"}));
        comboBox.setBounds(343, 138, 86, 22);
        contentPane.add(comboBox);
        
        JLabel l4 = new JLabel("Forgot Password?");
        l4.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e) {
        		String selectedRole = comboBox.getSelectedItem() != null ? comboBox.getSelectedItem().toString()
                        : "";
        		 if (!selectedRole.isEmpty() && selectedRole.equals("Employee")) {
        			new F9();
        			dispose();
        		 }
        		 else if(selectedRole.equals("Admin")) {
        			 JOptionPane.showMessageDialog(null,"For security reasons, admin password changes are restricted. ");
        		 }else
        			 JOptionPane.showMessageDialog(null, "Please Select role as Employee.");
        	}
        });
        l4.setForeground(new Color(0, 0, 255));
        l4.setBounds(279, 350, 106, 14);
        contentPane.add(l4);
        
        JLabel lblSelectYourRole = new JLabel("Select Your Role");
        lblSelectYourRole.setBounds(225, 142, 108, 14);
        contentPane.add(lblSelectYourRole);
        
        t2 = new JPasswordField();
        t2.setEchoChar('*');
        t2.setBounds(343, 245, 86, 20);
        contentPane.add(t2);
        
        t3 = new JTextField();
        t3.setColumns(10);
        t3.setBounds(343, 292, 86, 20);
        contentPane.add(t3);
        
        JLabel lblEnterCaptcha = new JLabel("Enter Captcha");
        lblEnterCaptcha.setBounds(225, 295, 108, 14);
        contentPane.add(lblEnterCaptcha);
        
        t4 = new JTextField();
        t4.setBackground(new Color(192, 192, 192));
        t4.setColumns(10);
        t4.setBounds(279, 323, 86, 20);
        contentPane.add(t4);
        t4.setText(GenerateRandomCaptcha());
        }
}
