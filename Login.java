import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login extends JFrame implements ActionListener {
    private JPanel Left;
    private JPanel Right;
    private JButton jButton1;
    private JButton jButton2; // Added SignUp button
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPasswordField jPasswordField1;
    private JTextField jTextField1;

    public Login() {
        this.initComponents();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.Right = new JPanel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.Left = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jLabel3 = new JLabel();
        this.jPasswordField1 = new JPasswordField();
        this.jButton1 = new JButton();
        this.jLabel4 = new JLabel();
        this.jButton2 = new JButton(); // SignUp button

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("LOGIN");
        this.setPreferredSize(new Dimension(800, 500));
        this.jPanel1.setBackground(new Color(255, 255, 255));
        this.jPanel1.setPreferredSize(new Dimension(800, 500));
        this.jPanel1.setLayout(null); // Set layout to null
        this.Right.setBackground(new Color(0, 102, 102));
        this.Right.setPreferredSize(new Dimension(400, 500));
        this.jLabel6.setFont(new Font("Showcard Gothic", Font.BOLD, 36));
        this.jLabel6.setForeground(new Color(255, 255, 255));
        this.jLabel6.setText("Quiz Whiz");
        this.jLabel7.setFont(new Font("Segoe UI Light", 0, 19));
        this.jLabel7.setForeground(new Color(204, 204, 204));
        this.jLabel7.setHorizontalAlignment(JLabel.RIGHT);
        this.jLabel7.setText("copyright © QuizWhiz All rights reserved");
        GroupLayout RightLayout = new GroupLayout(this.Right);
        this.Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup().addGap(0, 81, 32767).addComponent(this.jLabel7).addGap(40, 40, 40))
                .addGroup(RightLayout.createSequentialGroup().addGroup(RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(RightLayout.createSequentialGroup().addGap(103, 103, 103).addComponent(this.jLabel6)).addGroup(RightLayout.createSequentialGroup().addGap(145, 145, 145).addComponent(this.jLabel5))).addContainerGap(-1, 32767)));
        RightLayout.setVerticalGroup(RightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(RightLayout.createSequentialGroup().addGap(136, 136, 136).addComponent(this.jLabel5).addGap(26, 26, 26).addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 91, 32767).addComponent(this.jLabel7).addGap(78, 78, 78)));
        this.jPanel1.add(this.Right);
        this.Right.setBounds(0, 0, 400, 500);
        this.Left.setBackground(new Color(255, 255, 255));
        this.Left.setMinimumSize(new Dimension(400, 500));
        this.jLabel1.setFont(new Font("Segoe UI", 1, 36));
        this.jLabel1.setForeground(new Color(0, 102, 102));
        this.jLabel1.setText("LOGIN");
        this.jLabel2.setBackground(new Color(102, 102, 102));
        this.jLabel2.setFont(new Font("Segoe UI", 0, 14));
        this.jLabel2.setText("Email");
        this.jTextField1.setFont(new Font("Segoe UI", 0, 14));
        this.jTextField1.setForeground(new Color(102, 102, 102));
        this.jLabel3.setBackground(new Color(102, 102, 102));
        this.jLabel3.setFont(new Font("Segoe UI", 0, 14));
        this.jLabel3.setText("Password");
        this.jButton1.setBackground(new Color(0, 102, 102));
        this.jButton1.setFont(new Font("Segoe UI", 0, 14));
        this.jButton1.setForeground(new Color(255, 255, 255));
        this.jButton1.setText("Login");
        this.jButton1.setFocusable(false);
        this.jLabel4.setText("I don't have an account");
        this.jButton2.setFont(new Font("Segoe UI", 0, 14)); // SignUp button
        this.jButton2.setForeground(new Color(255, 255, 255)); // SignUp button
        this.jButton2.setBackground(new Color(0, 102, 102)); // SignUp button
        this.jButton2.setText("Sign Up"); // SignUp button
        this.jButton2.setFocusable(false); // SignUp button

        GroupLayout LeftLayout = new GroupLayout(this.Left);
        this.Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
                LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LeftLayout.createSequentialGroup()
                                .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(LeftLayout.createSequentialGroup()
                                                .addGap(138, 138, 138)
                                                .addComponent(this.jLabel1))
                                        .addGroup(LeftLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(this.jLabel2)
                                                                .addComponent(this.jTextField1)
                                                                .addComponent(this.jLabel3)
                                                                .addComponent(this.jPasswordField1, -1, 343, 32767)
                                                                .addComponent(this.jButton1, -2, 93, -2))
                                                        .addGroup(LeftLayout.createSequentialGroup()
                                                                .addComponent(this.jLabel4)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(this.jButton2))))))) ;

        LeftLayout.setVerticalGroup(
                LeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LeftLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(this.jLabel1)
                                .addGap(40, 40, 40)
                                .addComponent(this.jLabel2)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(this.jTextField1, -2, 40, -2)
                                .addGap(18, 18, 18)
                                .addComponent(this.jLabel3)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(this.jPasswordField1, -2, 40, -2)
                                .addGap(26, 26, 26)
                                .addComponent(this.jButton1, -2, 36, -2)
                                .addGap(33, 33, 33)
                                .addGroup(LeftLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(this.jLabel4)
                                        .addComponent(this.jButton2)) // Add SignUp button
                                .addContainerGap(37, 32767)));


        this.jPanel1.add(this.Left);
        this.Left.setBounds(400, 0, 400, 500);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(this.jPanel1, -2, -1, -2)
                                .addGap(0, 129, Short.MAX_VALUE)
                        )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(this.jPanel1, -2, -1, -2)
                                .addGap(0, 149, Short.MAX_VALUE)
                        )
        );
        this.getAccessibleContext().setAccessibleName("LOGIN");
        this.pack();
        this.jButton1.addActionListener(this); // Add ActionListener to the Login button
        this.jButton2.addActionListener(this); // Add ActionListener to the SignUp button
    }

    // Method to authenticate user credentials from CSV file
    private boolean authenticateUser(String username, String password) {
        String csvFile = "users.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if (data.length >= 2 && data[1].equals(username) && data[4].equals(password)) {
                    return true; // Username and password match
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Username and password don't match
    }

    // Action performed when buttons are clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) { // Login button clicked
            String username = jTextField1.getText().trim();
            String password = new String(jPasswordField1.getPassword());

            // Check if username and password match
            if (authenticateUser(username, password)) {
                // Open quiz page with the username
                Quiz quizPage = new Quiz(username);
                quizPage.setVisible(true);
                this.dispose(); // Close the login window
            } else {
                // Display error message for invalid credentials
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jButton2) { // SignUp button clicked
            // Open the register page
            RegisterPage registerPage = new RegisterPage();
            registerPage.setVisible(true);
            this.dispose(); // Close the login window
        }
    }

    public static void main(String[] args) {
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
    }
}
