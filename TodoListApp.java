import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoListApp extends JFrame {

    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;
    private JTextField newITF;
    private JButton addButton;
    private JButton removeButton;

    public TodoListApp() {
        setTitle("Java practice app");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLayout(new BorderLayout());

        //List model és lista
        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);
        JScrollPane scrollPane = new JScrollPane(todoList);
        add(scrollPane, BorderLayout.CENTER);
        

        // Törlés gomb
        removeButton = new JButton("Törlés");
        removeButton.setBackground(Color.green);
        removeButton.setForeground(Color.BLUE);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    todoListModel.remove(selectedIndex);
                }
            }
        });
        //Hozzáadás gomb
        newITF = new JTextField();
        addButton = new JButton("Hozzáadás");
        addButton.setBackground(Color.GREEN);
        addButton.setForeground(Color.BLUE);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = newITF.getText();
                if (!newItem.isEmpty()) {
                    todoListModel.addElement(newItem);
                    newITF.setText("");
                }
            }
        });

        // Panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(Color.GREEN);
        inputPanel.setForeground(Color.GRAY);
        inputPanel.add(newITF, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        inputPanel.add(removeButton, BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.SOUTH);

        
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TodoListApp();
            }
        });
    }
}

