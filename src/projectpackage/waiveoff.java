package projectpackage;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class waiveoff extends JFrame {

    private JTextArea textArea;

    public waiveoff() {
        setTitle("Fines");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        getContentPane().add(scrollPane);

        fetchAndUpdateFines();
    }

    private void fetchAndUpdateFines() {
        try {
			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM fine");

            StringBuilder stringBuilder = new StringBuilder();
            while (resultSet.next()) {
                int fineName = resultSet.getInt("stu_id");
                double fineAmount = resultSet.getDouble("fine");

                double reducedAmount = fineAmount * 0.7;

               int update= statement.executeUpdate("UPDATE fine SET reducedfine = " + reducedAmount + " WHERE stu_id = '" + fineName + "'");
               if (update > 0) {
                   JOptionPane.showMessageDialog(null, "Waive Off UPDATED!");
               } else {
                   JOptionPane.showMessageDialog(null, "Waive Off FAILED");
               }
            }
            textArea.setText(stringBuilder.toString());

            //resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            waiveoff frame = new waiveoff();
          //  frame.setVisible(true);
        });
    }
}