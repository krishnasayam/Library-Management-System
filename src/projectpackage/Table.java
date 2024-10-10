package projectpackage;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Table extends JFrame {
    private JButton loadButton;
    private JTable table;
    private JScrollPane scrollPane;
    private JLabel label;

    public Table() {
    	getContentPane().setBackground(new Color(47, 79, 79));
        setTitle("Database Table Example");
        setSize(1220, 819);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loadButton = new JButton("Load Data");
        loadButton.setBounds(0, 0, 1079, 44);
        loadButton.setForeground(new Color(0, 100, 0));
        loadButton.setFont(new Font("Tahoma", Font.BOLD, 22));
        loadButton.addActionListener(new LoadButtonListener());

        table = new JTable();
        table.setBackground(new Color(47, 79, 79));
        table.setForeground(new Color(255, 255, 0));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 44, 1206, 738);
        getContentPane().setLayout(null);
        getContentPane().add(loadButton);
        getContentPane().add(scrollPane);
        
        label = new JLabel("New label");
        scrollPane.setRowHeaderView(label);
        
        JButton lblNewLabel = new JButton("Back");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91782\\eclipse-workspace\\LMSProject\\src\\image\\back.png"));
        lblNewLabel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		STUDENTPAGE.main(new String[] {});
        		setVisible(false);
        	}
        });
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblNewLabel.setBounds(1077, 0, 129, 44);
        getContentPane().add(lblNewLabel);
    }

    private class LoadButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
          
            loadDataFromDatabase();
        }
    }

    private void loadDataFromDatabase() {
       
        

        try {
 			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/first","root","root");           
 			String query = "SELECT * FROM BOOKS";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                model.addColumn(metaData.getColumnName(columnIndex));
            }

            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                model.addRow(row);
            }

            table.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data from database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	Table example = new Table();
            example.setVisible(true);
        });
    }
}