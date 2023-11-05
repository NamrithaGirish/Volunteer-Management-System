import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class SignUpPage extends JFrame implements ActionListener{
    //SignUp
    JButton signup;
    JPanel p1,p2,p3,p4,p5,p6;
    JTextField uname, name, pass, phno, pass2;
    JLabel uname_label,name_label, pass_label, phno_label, pass2_label;
    SignUpPage(){
        super("SIGN UP");
        setSize(220,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uname_label = new JLabel("USERNAME");
        pass_label = new JLabel("PASSWORD");
        pass2_label =  new JLabel("REPEAT PASSWORD");
        name_label = new JLabel("NAME");
        phno_label = new JLabel("PHONE NUMBER");
        uname = new JTextField(20);
        pass = new JTextField(30);
        pass2 = new JTextField(30);
        name = new JTextField(30);
        phno = new JTextField(10);
        signup = new JButton("SIGN UP");

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        p6=new JPanel();

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        p1.add(uname_label);
        p1.add(uname);
        p2.add(name_label);
        p2.add(name);
        p3.add(phno_label);
        p3.add(phno);
        p4.add(pass_label);
        p4.add(pass);
        p5.add(pass2_label);
        p5.add(pass2);
        p6.add(signup);

        setVisible(true);
        signup.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        String url = "jdbc:mysql://localhost:3306/voltr_mgmt_sys"; // Change to your database URL
        String username = "root"; // Change to your MySQL username
        String password = "yourpassword"; // Change to your MySQL password

        Connection connection = null;

        try {
            // Load the MySQL JDBC driver (make sure the JAR file is in your classpath)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connected to the MySQL database!");
                // Perform database operations here

                // Don't forget to close the connection when you're done
                connection.close();
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("MySQL JDBC driver not found: " + ex.getMessage());
        } catch (SQLException ex) {
            System.err.println("Connection failed: " + ex.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error closing the database connection: " + ex.getMessage());
            }
        }
        
    } 

    
    
}
class dbms{
    public static void main(String args[]){
        new SignUpPage();
        
    }
}


