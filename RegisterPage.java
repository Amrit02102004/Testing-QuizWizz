import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterPage extends JFrame implements ActionListener {
    private JLabel titleCard, nameLabel, emailLabel, phoneLabel, genderLabel, passwordLabel, confirmPasswordLabel;
    private JTextField nameField, emailField, phoneField;
    private JComboBox<String> genderComboBox;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton signUpButton;
    private JLabel backgroundImage;

    public RegisterPage() {
        setTitle("Student's Registration Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        titleCard = new JLabel("Student's Registration Page");
        titleCard.setFont(new Font("Arial", Font.BOLD, 24));
        titleCard.setForeground(new Color(255, 255, 255));
        titleCard.setBounds(100, 10, 450, 30);
        add(titleCard);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(50, 60, 100, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 60, 180, 20);
        add(nameField);

        emailLabel = new JLabel("Email Address:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(50, 100, 100, 20);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 100, 180, 20);
        add(emailField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setBounds(50, 140, 100, 20);
        add(genderLabel);

        String[] genders = {"Male", "Female", "Others"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(150, 140, 100, 20);
        add(genderComboBox);

        phoneLabel = new JLabel("Phone number:");
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setBounds(50, 180, 100, 20);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150, 180, 180, 20);
        add(phoneField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(50, 220, 100, 20);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 220, 180, 20);
        add(passwordField);

        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPasswordLabel.setForeground(Color.WHITE);
        confirmPasswordLabel.setBounds(50, 260, 120, 20);
        add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(170, 260, 160, 20);
        add(confirmPasswordField);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(new Color(51, 204, 255));
        signUpButton.setFont(new Font("Arial", Font.BOLD, 14));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBounds(250, 320, 100, 30);
        add(signUpButton);
        signUpButton.addActionListener(this); // Registering action listener

        backgroundImage = new JLabel(new ImageIcon("background.jpg"));
        backgroundImage.setBounds(0, 0, 650, 432);
        add(backgroundImage);

        setSize(650, 432);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String gender = (String) genderComboBox.getSelectedItem();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            try (PrintWriter writer = new PrintWriter(new FileWriter("users.csv", true))) {
                writer.println(name + "," + email + "," + phone + "," + gender + "," + password + "," + confirmPassword);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            Login loginPage = new Login();
            loginPage.setVisible(true);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegisterPage().setVisible(true);
            }
        });
    }
}