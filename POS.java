/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Maningas_Arnel
 */
public class POS {
    
    final private JFrame posFrame = new JFrame("POS");
    private JPanel cardPanel, 
                    posPanel, 
                    menuPanel, namePanel, leftPanel, rightPanel, searchPanel,
                    itemPanel, receiptPanel; 
    private JScrollPane menuScroll, receiptScroll;
    private JLabel restoNameLabel, cherryBlossom; 
    private JTextField searchBar;
    private JButton searchBtn, payBtn, menuBtn, iBtn, dBtn;
    private JTextArea receiptArea = new JTextArea();;
   
    final private String imagePath = "C:\\Users\\arnel\\OneDrive\\Desktop\\ChineseRestoSwing\\src\\main\\java\\Images\\";
    final private Random random = new Random();
    final private StringBuilder stringBuild = new StringBuilder();
    final private SpringLayout springLayout = new SpringLayout();
    
    final private JLabel header = new JLabel("""
                                                                        RESTO NAME
                                                                         ADDRESS
                                                                        DATE & TIME
                                                          
                                """);
  
    public POS() {
//Panels
    //Menu Panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 3, 30, 30));
        menuPanel.setBackground(Color.decode("#F3C43E"));

        //Add to Menu
        for (int i = 1; i <= 9; i++) {
            ImageIcon mealPictures = new ImageIcon(imagePath + "m" + i + ".jpg");
            Image size = mealPictures.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon scaledImg = new ImageIcon(size);

            JButton meals = new JButton(scaledImg);
            meals.setPreferredSize(new Dimension(160, 150));
            meals.setBackground(null);
            meals.setBorder(null);
            meals.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Image Panel
            itemPanel = new JPanel();
            itemPanel.setLayout(springLayout);
            itemPanel.setPreferredSize(new Dimension(160, 290));
     
            // generates random prices at the moment
            int pRand = random.nextInt(20, 50);
            
            // name of the food
            JLabel foodName = new JLabel("Meal " + i);
            foodName.setPreferredSize(new Dimension(100, 100));
            foodName.setFont(new Font("Arial", Font.BOLD, 20));
            
            // price of the food
            JLabel price = new JLabel("$" + pRand);
            price.setFont(new Font("Arial", Font.BOLD, 20));
            
            // Quantity Label
            JLabel quantityLabel = new JLabel(String.valueOf(1));
            quantityLabel.setFont(new Font("Arial", Font.BOLD, 20));

            // Button Listener
            meals.addActionListener(e -> {       
               
                receiptArea.append(foodName.getText() + "\t\t" + price.getText() + "\t" + quantityLabel.getText() + "\n\n");
                
                springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, header, 50, SpringLayout.HORIZONTAL_CENTER, itemPanel);
                springLayout.putConstraint(SpringLayout.NORTH, header, 10, SpringLayout.NORTH, itemPanel);
                
                springLayout.putConstraint(SpringLayout.WEST, foodName, 10, SpringLayout.WEST, itemPanel);
                springLayout.putConstraint(SpringLayout.NORTH, foodName, 10, SpringLayout.SOUTH, header);

                springLayout.putConstraint(SpringLayout.WEST, price, 10, SpringLayout.EAST, foodName);
                springLayout.putConstraint(SpringLayout.NORTH, price, 0, SpringLayout.NORTH, foodName);

                springLayout.putConstraint(SpringLayout.WEST, quantityLabel, 10, SpringLayout.EAST, price);
                springLayout.putConstraint(SpringLayout.NORTH, quantityLabel, 0, SpringLayout.NORTH, price);
                
            });    
            
            // Components in the grid
            itemPanel.add(meals);
            itemPanel.add(Box.createRigidArea(new Dimension(5, 10)));
            itemPanel.add(foodName);
            itemPanel.add(price);
            
            // Layout properties
            springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, meals, 5, SpringLayout.HORIZONTAL_CENTER, itemPanel);
            springLayout.putConstraint(SpringLayout.NORTH, meals, 35, SpringLayout.NORTH, itemPanel);

            springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, foodName, 25, SpringLayout.HORIZONTAL_CENTER, itemPanel);
            springLayout.putConstraint(SpringLayout.NORTH, foodName, -15, SpringLayout.SOUTH, meals);

            springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, price, 5, SpringLayout.HORIZONTAL_CENTER, itemPanel);
            springLayout.putConstraint(SpringLayout.NORTH, price, -30, SpringLayout.SOUTH, foodName);
            
            menuPanel.add(itemPanel);
        }
        
        //ScrollPane
            menuScroll = new JScrollPane(menuPanel);
            menuScroll.setBounds(150, 170, 800, 530);
            
            //Search Panel
        searchPanel = new JPanel();
        searchPanel.setLayout(null);
        searchPanel.setBackground(Color.decode("#fad25f"));
        searchPanel.setBounds(150, 100, 800, 70);
        
        //Search Bar
            searchBar = new JTextField();
            searchBar.setBounds(400, 20, 300, 30);
            
        //Search Button
            ImageIcon searchImage = new ImageIcon(imagePath + "Search.png");
            Image dimensions = searchImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon scaledSearchImg = new ImageIcon(dimensions);
            
            searchBtn = new JButton(scaledSearchImg);
            searchBtn.setBounds( 720, 20, 50, 30);
            searchBtn.setFocusPainted(false);
            searchBtn.setBorder(null);
            searchBtn.setBackground(null);
            searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
        //Add to Search Panel
            searchPanel.add(searchBar);
            searchPanel.add(searchBtn);

    //Left Panel    
        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.decode("#9F0102"));
        leftPanel.setBounds(0, 0, 150, 700);
        
        //Image
            ImageIcon picture1 = new ImageIcon(imagePath + "CherryBlossom.png");
            Image img1 = picture1.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
            ImageIcon scaledImage1 = new ImageIcon(img1);
            
            ImageIcon picture2 = new ImageIcon(imagePath + "San.png");
            Image img2 = picture2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon scaledImage2 = new ImageIcon(img2);
        //Label
            cherryBlossom = new JLabel(scaledImage1);
            cherryBlossom.setBounds(0, 400, 150, 300);
        //Button
            menuBtn = new JButton(scaledImage2); 
            menuBtn.setBackground(null);
            menuBtn.setFocusPainted(false);
            menuBtn.setBorder(null);
            menuBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            menuBtn.setBounds(20, 20, 20, 20);
            
        //Add to SideBar
            leftPanel.add(cherryBlossom);
            leftPanel.add(menuBtn);
            
    //Name Panel
        namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT,30, 30));
        namePanel.setBackground(Color.decode("#FF0114"));
        namePanel.setBounds(150, 0, 800, 100);
        
        //Label
            restoNameLabel = new JLabel("Golden Dynasty");
            restoNameLabel.setFont(new Font("Arial", Font.ITALIC, 30));
            restoNameLabel.setForeground(Color.WHITE);
        
        //Adding to Name Panel
            namePanel.add(restoNameLabel);
        
    //Right Panel
        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.decode("#066839"));
        rightPanel.setBounds(950, 0 , 425, 700);
        
        // TextArea           
            receiptArea.setLayout(springLayout);
            receiptArea.setBounds(0, 0 , 395, 465);  
            receiptArea.setFont(new Font("Arial", Font.PLAIN, 13));
            
            receiptArea.setText(header.getText());
           
        // ReceiptPanel
            receiptPanel = new JPanel();
            receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.Y_AXIS));
            receiptPanel.setBounds(0, 0, 395, 465);
            receiptPanel.add(receiptArea);
            
        // ScrollBar
            receiptScroll = new JScrollPane(receiptPanel);
            receiptScroll.setBounds(10, 15, 395, 450);
            // Add ReceiptPanel to ScrollPane
                 
        //Buttons
            payBtn = new JButton("Pay");
            payBtn.setBackground(Color.decode("#99ff99"));
            payBtn.setFont(new Font("Arial", Font.BOLD, 30));
            payBtn.setFocusPainted(false);
            payBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            payBtn.addActionListener(e -> {
                //receiptPane.setText("");
                JOptionPane.showMessageDialog(null, "I MISS YOU");
            });
            payBtn.setBounds(10, 550, 395, 70);
                
        //Add to Receipt Panel
            rightPanel.add(receiptScroll);
            rightPanel.add(payBtn);
            rightPanel.revalidate();
            rightPanel.repaint();
        
//POSPanel
        posPanel = new JPanel();
        posPanel.setLayout(null);  
       
        posPanel.add(leftPanel);
        posPanel.add(namePanel);
        posPanel.add(menuScroll);
        posPanel.add(rightPanel);
        posPanel.add(searchPanel);
        
//CardPanel
        cardPanel = new JPanel(new CardLayout());
        cardPanel.add(posPanel, "posPanel");

//Add to Frame
        posFrame.add(cardPanel);
        
//Frame Properties
        posFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        posFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        posFrame.setSize(1024, 768);
        posFrame.setVisible(true);
    }
}
