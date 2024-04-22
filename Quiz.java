import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;

public class Quiz extends JFrame implements ActionListener {
    String[] questions ={
            "Which company created Java?",
            "In which year was Java created?",
            "What was Java originally called?",
            "Who is credited with creating Java?",
            "What does JVM stand for?",
            "Which keyword is used to define a constant in Java?",
            "Which collection class is synchronized?",
            "What is the parent class of all classes in Java?",
            "What is the default value of the local variables?",
            "What is the purpose of the 'final' keyword in Java?"
    };
    String[][] options={
            {"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
            {"1989","1996","1972","1492"},
            {"Apple","Latte","Oak","Koffing"},
            {"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerberg"},
            {"Java Virtual Machine","Java Very Mighty","Just Very Much","Jumping Virtual Mode"},
            {"final","const","static","define"},
            {"ArrayList","LinkedList","Vector","Hashtable"},
            {"Object","System","Applet","Java"},
            {"0","1","Garbage value","Depends on the type of variable"},
            {"To define constant values","To prevent method overriding","To define a class","To allow inheritance only from the current class"}
    };
    char guess;
    int index = 0;
    int correct_answers = 0;
    int total_questions = questions.length;
    int seconds = 10;
    String username; // Added to store username

    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel time_label = new JLabel();
    Timer timer;

    public Quiz(String username) { // Modified constructor to accept username
        this.username = username; // Store username
        setTitle("QuizWhiz");
        setSize(700, 400);
        getContentPane().setBackground(new Color(240, 240, 255)); // Background color
        getContentPane().setLayout(null);
        setResizable(false); // Make the frame non-resizable

        time_label.setBounds(600, 20, 100, 30);
        time_label.setForeground(Color.RED); // Timer color
        getContentPane().add(time_label);

        textfield.setBounds(20, 60, 660, 30);
        textfield.setEditable(false);
        textfield.setForeground(Color.BLUE); // Question number color
        getContentPane().add(textfield);

        textarea.setBounds(20, 100, 660, 60);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setEditable(false);
        textarea.setForeground(new Color(50, 100, 150)); // Question color
        getContentPane().add(textarea);

        buttonA.setBounds(50, 180, 300, 50);
        customizeButton(buttonA);
        getContentPane().add(buttonA);
        buttonA.addActionListener(this);
        addHoverEffect(buttonA);

        buttonB.setBounds(400, 180, 300, 50);
        customizeButton(buttonB);
        getContentPane().add(buttonB);
        buttonB.addActionListener(this);
        addHoverEffect(buttonB);

        buttonC.setBounds(50, 240, 300, 50);
        customizeButton(buttonC);
        getContentPane().add(buttonC);
        buttonC.addActionListener(this);
        addHoverEffect(buttonC);

        buttonD.setBounds(400, 240, 300, 50);
        customizeButton(buttonD);
        getContentPane().add(buttonD);
        buttonD.addActionListener(this);
        addHoverEffect(buttonD);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        startTimer();
        displayQuestion();
    }

    public void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seconds > 0) {
                    int minutes = seconds / 60;
                    int secs = seconds % 60;
                    time_label.setText(String.format("Time Left: %02d:%02d", minutes, secs));
                    seconds--;
                } else {
                    timer.stop();
                    index++;
                    if (index < total_questions) {
                        displayQuestion();
                        seconds = 10; // Reset timer
                        startTimer();
                    } else {
                        results();
                        generateReport(); // Generate report when quiz is completed
                    }
                }
            }
        });
        timer.start();
    }

    public void displayQuestion() {
        textfield.setText("Question " + (index + 1));
        textarea.setText(questions[index]);
        buttonA.setText(options[index][0]);
        buttonB.setText(options[index][1]);
        buttonC.setText(options[index][2]);
        buttonD.setText(options[index][3]);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton)e.getSource();
        guess = clickedButton.getText().charAt(0);
        timer.stop();
        check();
        index++;
        if (index < total_questions) {
            displayQuestion();
            seconds = 10; // Reset timer
            startTimer();
        } else {
            results();
            generateReport(); // Generate report when quiz is completed
        }
    }

    public void check() {
        if (guess == options[index][0].charAt(0)) {
            correct_answers++;
        }
    }

    public void results() {
        getContentPane().removeAll();
        repaint();

        JLabel resultLabel = new JLabel("Your score: " + ((correct_answers * 100) / total_questions) + "%");
        resultLabel.setBounds(300, 150, 200, 50);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        getContentPane().add(resultLabel);
    }

    public void customizeButton(JButton button) {
        button.setBackground(new Color(255, 200, 100));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
    }

    public void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(255, 230, 150));
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(255, 200, 100));
            }
        });
    }

    public void generateReport() {
        String filename = "report.csv";
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(username + "," + ((correct_answers * 100) / total_questions) + "%\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage: new Quiz("username");
    }
}
