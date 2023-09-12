import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Student {
    private String name;
    private int rollNumber;
    private String address;
    private String phoneNumber;

    public Student(String name, int rollNumber, String address, String phoneNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Address: " + address + ", Phone Number: " + phoneNumber;
    }
}

class StudentRecord {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                break;
            }
        }
    }

    public Student findStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public Student findStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

public class StudentRecordApp {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField nameField, rollNumberField, addressField, phoneField;
    private JButton addButton, removeButton, findButton;

    private StudentRecord studentRecord = new StudentRecord();

    public StudentRecordApp() {
        frame = new JFrame("Student Record System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JLabel nameLabel = new JLabel("Name:");
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel phoneLabel = new JLabel("Phone Number:");

        nameField = new JTextField();
        rollNumberField = new JTextField();
        addressField = new JTextField();
        phoneField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(rollNumberLabel);
        inputPanel.add(rollNumberField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);

        addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int rollNumber = Integer.parseInt(rollNumberField.getText());
                String address = addressField.getText();
                String phoneNumber = phoneField.getText();

                Student student = new Student(name, rollNumber, address, phoneNumber);
                studentRecord.addStudent(student);

                textArea.append("Student added: " + student + "\n");

                nameField.setText("");
                rollNumberField.setText("");
                addressField.setText("");
                phoneField.setText("");
            }
        });

        removeButton = new JButton("Remove Student");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rollNumber = Integer.parseInt(rollNumberField.getText());
                studentRecord.removeStudent(rollNumber);

                textArea.append("Student removed with Roll Number: " + rollNumber + "\n");

                nameField.setText("");
                rollNumberField.setText("");
                addressField.setText("");
                phoneField.setText("");
            }
        });

        findButton = new JButton("Find Student");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchInput = nameField.getText();

                Student student = studentRecord.findStudent(searchInput);

                if (student != null) {
                    textArea.append("Student found: " + student + "\n");
                } else {
                    textArea.append("Student not found with Name/Roll Number: " + searchInput + "\n");
                }

                nameField.setText("");
                rollNumberField.setText("");
                addressField.setText("");
                phoneField.setText("");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(findButton);

        textArea = new JTextArea();
        textArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(textArea), BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentRecordApp();
            }
        });
    }
}
