/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author Maningas_Arnel
 */
public class POS_Actions extends POS{
    String url = "jdbc:mysql://127.0.0.1:3306/restodatabase";
    String username = "root";
    String password = "PassWord";
    String sql = "INSERT INTO restodatabase.reservation(`Name`, ReservationNumber, PAX) VALUES (?, ?, ?);";
    public POS_Actions() {
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement pst = conn.prepareStatement(sql)) {
                    
                    pst.setString(1, "Arnel");
                    pst.setInt(2, 5);
                    pst.setInt(3, 9);
                    
                    pst.executeUpdate();
                    
                }
        catch(SQLException sqle) {
                System.out.println(sqle.getMessage());
                }
    }
}
