/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantsystem;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author Maningas_Arnel
 */
public class ReservationSystem implements ActionListener{
    
    final private JFrame reservationFrame = new JFrame();
    final private JTextField name, pax;
    final private JButton btn;
    
    final private String sql = "INSERT INTO restodatabase.reservation(`Name`, PAX) VALUES (?, ?);";
    final private String url = "jdbc:mysql://127.0.0.1:3306/restodatabase";
    final private String user = "root";
    final private String password = "PassWord";
    
    final private JTable table;
    final private DefaultTableModel dtm;
    final private JScrollPane scrollBar;
    
    public ReservationSystem() {
        
        name = new JTextField();
        name.setBounds(50, 0,100, 50);
        pax = new JTextField();
        pax.setBounds(50, 100,100, 50);
        btn = new JButton("okay");
        btn.setBounds(50, 200,100, 50);
        btn.addActionListener(e -> {
            try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(sql)) {
                
                System.out.println("Connection Success");
                
                int paxNumber = Integer.parseInt(pax.getText());
                pst.setString(1, name.getText());
                pst.setInt(2, paxNumber);
                
                int rowsAffected = pst.executeUpdate();
                
                System.out.println(rowsAffected);
            }
            catch(SQLException sqle) {
                System.out.println("Connection failed");
                System.out.println("Error: " + sqle.getMessage());
            }
        
        });
        
        String[] columnNames = {"Name", "ReservationNumber", "PAX"};

        dtm = new DefaultTableModel(columnNames, 0);
        
        table = new JTable(dtm);
        connectDBtoTable();
        
        scrollBar = new JScrollPane(table);
        scrollBar.setBounds(200, 200, 600, 100);
        
        reservationFrame.add(scrollBar);
        reservationFrame.add(name);
        reservationFrame.add(pax);
        reservationFrame.add(btn);
        
        reservationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reservationFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        reservationFrame.setLayout(null);
        reservationFrame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public void connectDBtoTable() {
        try(Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT Name, ReservationNumber, PAX FROM restodatabase.reservation");
                
                while (rs.next()) {
                    String n = rs.getString("Name");
                    int rn = rs.getInt("ReservationNumber");
                    int px = rs.getInt("PAX");
                    
                    dtm.addRow(new Object[]{n, rn, px});
                }
        }
        catch(SQLException sql) {
            System.out.println("Error: " + sql.getMessage());
        }
    }
}
