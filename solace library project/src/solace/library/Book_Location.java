/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solace.library;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sachith
 */
public class Book_Location extends javax.swing.JPanel {

    /**
     * Creates new form Book_Location
     */
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public Book_Location() {
        initComponents();
        
        //connect to DB
        con = DBconnection.connect();
        
        
        book_table.getTableHeader().setReorderingAllowed(false);
        
        
       
        
        
        
        
        
        
        bktableload();
        pnlcolor();
        pnlvisible();
        
        
        
    }
    
    public void pnlcolor(){
        
        pnl_11.setBackground(new Color(0, 85, 127,190));
        pnl_12.setBackground(new Color(0, 85, 127,190));
        pnl_13.setBackground(new Color(0, 85, 127,190));
        pnl_14.setBackground(new Color(0, 85, 127,190));
        pnl_15.setBackground(new Color(0, 85, 127,190));
        
        pnl_21.setBackground(new Color(0, 85, 127,190));
        pnl_22.setBackground(new Color(0, 85, 127,190));
        pnl_23.setBackground(new Color(0, 85, 127,190));
        pnl_24.setBackground(new Color(0, 85, 127,190));
        pnl_25.setBackground(new Color(0, 85, 127,190));
        
        pnl_31.setBackground(new Color(0, 85, 127,190));
        pnl_32.setBackground(new Color(0, 85, 127,190));
        pnl_33.setBackground(new Color(0, 85, 127,190));
        pnl_34.setBackground(new Color(0, 85, 127,190));
        pnl_35.setBackground(new Color(0, 85, 127,190));
        
        pnl_41.setBackground(new Color(0, 85, 127,190));
        pnl_42.setBackground(new Color(0, 85, 127,190));
        pnl_43.setBackground(new Color(0, 85, 127,190));
        pnl_44.setBackground(new Color(0, 85, 127,190));
        pnl_45.setBackground(new Color(0, 85, 127,190));
        
        pnl_51.setBackground(new Color(0, 85, 127,190));
        pnl_52.setBackground(new Color(0, 85, 127,190));
        pnl_53.setBackground(new Color(0, 85, 127,190));
        pnl_54.setBackground(new Color(0, 85, 127,190));
        pnl_55.setBackground(new Color(0, 85, 127,190));
        
        pnl_61.setBackground(new Color(0, 85, 127,190));
        pnl_62.setBackground(new Color(0, 85, 127,190));
        pnl_63.setBackground(new Color(0, 85, 127,190));
        pnl_64.setBackground(new Color(0, 85, 127,190));
        pnl_65.setBackground(new Color(0, 85, 127,190));
    }
    
    public void pnlvisible(){
        
        pnl_11.setVisible(false);
        pnl_12.setVisible(false);
        pnl_13.setVisible(false);
        pnl_14.setVisible(false);
        pnl_15.setVisible(false);
        
        pnl_21.setVisible(false);
        pnl_22.setVisible(false);
        pnl_23.setVisible(false);
        pnl_24.setVisible(false);
        pnl_25.setVisible(false);
        
        pnl_31.setVisible(false);
        pnl_32.setVisible(false);
        pnl_33.setVisible(false);
        pnl_34.setVisible(false);
        pnl_35.setVisible(false);
        
        pnl_41.setVisible(false);
        pnl_42.setVisible(false);
        pnl_43.setVisible(false);
        pnl_44.setVisible(false);
        pnl_45.setVisible(false);
        
        pnl_51.setVisible(false);
        pnl_52.setVisible(false);
        pnl_53.setVisible(false);
        pnl_54.setVisible(false);
        pnl_55.setVisible(false);
        
        pnl_61.setVisible(false);
        pnl_62.setVisible(false);
        pnl_63.setVisible(false);
        pnl_64.setVisible(false);
        pnl_65.setVisible(false);
    }
    
    public void row1(){
        
        pnl_21.setVisible(false);
        pnl_22.setVisible(false);
        pnl_23.setVisible(false);
        pnl_24.setVisible(false);
        pnl_25.setVisible(false);
        
        pnl_31.setVisible(false);
        pnl_32.setVisible(false);
        pnl_33.setVisible(false);
        pnl_34.setVisible(false);
        pnl_35.setVisible(false);
        
        pnl_41.setVisible(false);
        pnl_42.setVisible(false);
        pnl_43.setVisible(false);
        pnl_44.setVisible(false);
        pnl_45.setVisible(false);
        
        pnl_51.setVisible(false);
        pnl_52.setVisible(false);
        pnl_53.setVisible(false);
        pnl_54.setVisible(false);
        pnl_55.setVisible(false);
        
        pnl_61.setVisible(false);
        pnl_62.setVisible(false);
        pnl_63.setVisible(false);
        pnl_64.setVisible(false);
        pnl_65.setVisible(false);
    }
    
    public void row2(){
        pnl_11.setVisible(false);
        pnl_12.setVisible(false);
        pnl_13.setVisible(false);
        pnl_14.setVisible(false);
        pnl_15.setVisible(false);
        
        
        
        pnl_31.setVisible(false);
        pnl_32.setVisible(false);
        pnl_33.setVisible(false);
        pnl_34.setVisible(false);
        pnl_35.setVisible(false);
        
        pnl_41.setVisible(false);
        pnl_42.setVisible(false);
        pnl_43.setVisible(false);
        pnl_44.setVisible(false);
        pnl_45.setVisible(false);
        
        pnl_51.setVisible(false);
        pnl_52.setVisible(false);
        pnl_53.setVisible(false);
        pnl_54.setVisible(false);
        pnl_55.setVisible(false);
        
        pnl_61.setVisible(false);
        pnl_62.setVisible(false);
        pnl_63.setVisible(false);
        pnl_64.setVisible(false);
        pnl_65.setVisible(false);
    }
    
    public void row3(){
        pnl_11.setVisible(false);
        pnl_12.setVisible(false);
        pnl_13.setVisible(false);
        pnl_14.setVisible(false);
        pnl_15.setVisible(false);
        
        pnl_21.setVisible(false);
        pnl_22.setVisible(false);
        pnl_23.setVisible(false);
        pnl_24.setVisible(false);
        pnl_25.setVisible(false);
        
        
        
        pnl_41.setVisible(false);
        pnl_42.setVisible(false);
        pnl_43.setVisible(false);
        pnl_44.setVisible(false);
        pnl_45.setVisible(false);
        
        pnl_51.setVisible(false);
        pnl_52.setVisible(false);
        pnl_53.setVisible(false);
        pnl_54.setVisible(false);
        pnl_55.setVisible(false);
        
        pnl_61.setVisible(false);
        pnl_62.setVisible(false);
        pnl_63.setVisible(false);
        pnl_64.setVisible(false);
        pnl_65.setVisible(false);
    }
    
    public void row4(){
       pnl_11.setVisible(false);
        pnl_12.setVisible(false);
        pnl_13.setVisible(false);
        pnl_14.setVisible(false);
        pnl_15.setVisible(false);
        
        pnl_21.setVisible(false);
        pnl_22.setVisible(false);
        pnl_23.setVisible(false);
        pnl_24.setVisible(false);
        pnl_25.setVisible(false);
        
        pnl_31.setVisible(false);
        pnl_32.setVisible(false);
        pnl_33.setVisible(false);
        pnl_34.setVisible(false);
        pnl_35.setVisible(false);
        
        
        
        pnl_51.setVisible(false);
        pnl_52.setVisible(false);
        pnl_53.setVisible(false);
        pnl_54.setVisible(false);
        pnl_55.setVisible(false);
        
        pnl_61.setVisible(false);
        pnl_62.setVisible(false);
        pnl_63.setVisible(false);
        pnl_64.setVisible(false);
        pnl_65.setVisible(false); 
    }
    
    public void row5(){
        pnl_11.setVisible(false);
        pnl_12.setVisible(false);
        pnl_13.setVisible(false);
        pnl_14.setVisible(false);
        pnl_15.setVisible(false);
        
        pnl_21.setVisible(false);
        pnl_22.setVisible(false);
        pnl_23.setVisible(false);
        pnl_24.setVisible(false);
        pnl_25.setVisible(false);
        
        pnl_31.setVisible(false);
        pnl_32.setVisible(false);
        pnl_33.setVisible(false);
        pnl_34.setVisible(false);
        pnl_35.setVisible(false);
        
        pnl_41.setVisible(false);
        pnl_42.setVisible(false);
        pnl_43.setVisible(false);
        pnl_44.setVisible(false);
        pnl_45.setVisible(false);
        
        
        
        pnl_61.setVisible(false);
        pnl_62.setVisible(false);
        pnl_63.setVisible(false);
        pnl_64.setVisible(false);
        pnl_65.setVisible(false);
    }
    
    public void row6(){
        pnl_11.setVisible(false);
        pnl_12.setVisible(false);
        pnl_13.setVisible(false);
        pnl_14.setVisible(false);
        pnl_15.setVisible(false);
        
        pnl_21.setVisible(false);
        pnl_22.setVisible(false);
        pnl_23.setVisible(false);
        pnl_24.setVisible(false);
        pnl_25.setVisible(false);
        
        pnl_31.setVisible(false);
        pnl_32.setVisible(false);
        pnl_33.setVisible(false);
        pnl_34.setVisible(false);
        pnl_35.setVisible(false);
        
        pnl_41.setVisible(false);
        pnl_42.setVisible(false);
        pnl_43.setVisible(false);
        pnl_44.setVisible(false);
        pnl_45.setVisible(false);
        
        pnl_51.setVisible(false);
        pnl_52.setVisible(false);
        pnl_53.setVisible(false);
        pnl_54.setVisible(false);
        pnl_55.setVisible(false);
        
        
    }
    
    
    
    public void bktableload(){
        
        try {
            String selectq = "select ISBN,Book_Name,Category,Rack_No,Row_No,Column_No from books";
            pst = con.prepareStatement(selectq);
            rs=pst.executeQuery();
            
            book_table.setModel(DbUtils.resultSetToTableModel(rs));
            // resizing the column width
       book_table.getColumnModel().getColumn(0).setPreferredWidth(200);
       book_table.getColumnModel().getColumn(1).setPreferredWidth(390);
       book_table.getColumnModel().getColumn(2).setPreferredWidth(100);
       book_table.getColumnModel().getColumn(3).setPreferredWidth(45);
       book_table.getColumnModel().getColumn(4).setPreferredWidth(45);
       book_table.getColumnModel().getColumn(5).setPreferredWidth(60);
       
       book_table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
            
            
            
            
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_62 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        pnl_63 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        pnl_61 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        pnl_65 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        pnl_64 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        pnl_54 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        pnl_51 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        pnl_53 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        pnl_55 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        pnl_52 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        pnl_45 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        pnl_44 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        pnl_41 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        pnl_43 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pnl_42 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        pnl_35 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        pnl_32 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        pnl_33 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pnl_34 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        pnl_31 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        pnl_22 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pnl_25 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pnl_24 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pnl_23 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pnl_21 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pnl_15 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pnl_14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnl_13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnl_12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnl_11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_Dashboard7 = new javax.swing.JLabel();
        lbl_rackNo = new javax.swing.JLabel();
        lbl_Dashboard5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        book_table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txt_searchbooks = new javax.swing.JTextField();
        lbl_Dashboard8 = new javax.swing.JLabel();
        lbl_dashicon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(930, 590));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_62.setBackground(new java.awt.Color(0, 0, 0));
        pnl_62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Here 6,2");
        pnl_62.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_62, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 150, 40));

        pnl_63.setBackground(new java.awt.Color(0, 0, 0));
        pnl_63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Here 6,3");
        pnl_63.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_63, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 150, 40));

        pnl_61.setBackground(new java.awt.Color(0, 0, 0));
        pnl_61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Here 6,1");
        pnl_61.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_61, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 150, 40));

        pnl_65.setBackground(new java.awt.Color(0, 0, 0));
        pnl_65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Here 6,5");
        pnl_65.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_65, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 150, 40));

        pnl_64.setBackground(new java.awt.Color(0, 0, 0));
        pnl_64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Here 6,4");
        pnl_64.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_64, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 140, 40));

        pnl_54.setBackground(new java.awt.Color(0, 0, 0));
        pnl_54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Here 5,4");
        pnl_54.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_54, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 140, 40));

        pnl_51.setBackground(new java.awt.Color(0, 0, 0));
        pnl_51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Here 5,1");
        pnl_51.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_51, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 150, 40));

        pnl_53.setBackground(new java.awt.Color(0, 0, 0));
        pnl_53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Here 5,3");
        pnl_53.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_53, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 150, 40));

        pnl_55.setBackground(new java.awt.Color(0, 0, 0));
        pnl_55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Here 5,5");
        pnl_55.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_55, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 150, 40));

        pnl_52.setBackground(new java.awt.Color(0, 0, 0));
        pnl_52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Here 5,2");
        pnl_52.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_52, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 150, 40));

        pnl_45.setBackground(new java.awt.Color(0, 0, 0));
        pnl_45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Here 4,5");
        pnl_45.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_45, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 150, 40));

        pnl_44.setBackground(new java.awt.Color(0, 0, 0));
        pnl_44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Here 4,4");
        pnl_44.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_44, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 140, 40));

        pnl_41.setBackground(new java.awt.Color(0, 0, 0));
        pnl_41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Here 4,1");
        pnl_41.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_41, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 150, 40));

        pnl_43.setBackground(new java.awt.Color(0, 0, 0));
        pnl_43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Here 4,3");
        pnl_43.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_43, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 150, 40));

        pnl_42.setBackground(new java.awt.Color(0, 0, 0));
        pnl_42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Here 4,2");
        pnl_42.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_42, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 150, 40));

        pnl_35.setBackground(new java.awt.Color(0, 0, 0));
        pnl_35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Here 3,5");
        pnl_35.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_35, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 150, 40));

        pnl_32.setBackground(new java.awt.Color(0, 0, 0));
        pnl_32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Here 3,2");
        pnl_32.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_32, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 150, 40));

        pnl_33.setBackground(new java.awt.Color(0, 0, 0));
        pnl_33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Here 3,3");
        pnl_33.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_33, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 150, 40));

        pnl_34.setBackground(new java.awt.Color(0, 0, 0));
        pnl_34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Here 3,4");
        pnl_34.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_34, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 140, 40));

        pnl_31.setBackground(new java.awt.Color(0, 0, 0));
        pnl_31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Here 3,1");
        pnl_31.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 150, 40));

        pnl_22.setBackground(new java.awt.Color(0, 0, 0));
        pnl_22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Here 2,2");
        pnl_22.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 150, 40));

        pnl_25.setBackground(new java.awt.Color(0, 0, 0));
        pnl_25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Here 2,5");
        pnl_25.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 150, 40));

        pnl_24.setBackground(new java.awt.Color(0, 0, 0));
        pnl_24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Here 2,4");
        pnl_24.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 140, 40));

        pnl_23.setBackground(new java.awt.Color(0, 0, 0));
        pnl_23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Here 2,3");
        pnl_23.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 150, 40));

        pnl_21.setBackground(new java.awt.Color(0, 0, 0));
        pnl_21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Here 2,1");
        pnl_21.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 150, 40));

        pnl_15.setBackground(new java.awt.Color(0, 0, 0));
        pnl_15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Here 1,5");
        pnl_15.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 150, 40));

        pnl_14.setBackground(new java.awt.Color(0, 0, 0));
        pnl_14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Here 1,4");
        pnl_14.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 140, 40));

        pnl_13.setBackground(new java.awt.Color(0, 0, 0));
        pnl_13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Here 1,3");
        pnl_13.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 150, 40));

        pnl_12.setBackground(new java.awt.Color(0, 0, 0));
        pnl_12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Here 1,2");
        pnl_12.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 150, 40));

        pnl_11.setBackground(new java.awt.Color(0, 0, 0));
        pnl_11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Here 1,1");
        pnl_11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        add(pnl_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 150, 40));

        lbl_Dashboard7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_Dashboard7.setForeground(new java.awt.Color(105, 105, 105));
        lbl_Dashboard7.setText("Book Location");
        add(lbl_Dashboard7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, -10, 150, 50));

        lbl_rackNo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbl_rackNo.setForeground(new java.awt.Color(255, 255, 255));
        add(lbl_rackNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 50, 20));

        lbl_Dashboard5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_Dashboard5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Dashboard5.setText("Rack No:");
        add(lbl_Dashboard5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 80, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rack.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 750, 360));

        book_table.setBackground(new java.awt.Color(255, 255, 255));
        book_table.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        book_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        book_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                book_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(book_table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 910, 150));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/magnifier.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 390, 30, 30));

        txt_searchbooks.setBackground(new java.awt.Color(255, 255, 255));
        txt_searchbooks.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_searchbooks.setForeground(new java.awt.Color(69, 73, 74));
        txt_searchbooks.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 105, 105), 1, true));
        txt_searchbooks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchbooksKeyReleased(evt);
            }
        });
        add(txt_searchbooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 590, 30));

        lbl_Dashboard8.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_Dashboard8.setForeground(new java.awt.Color(105, 105, 105));
        lbl_Dashboard8.setText("Enter ISBN / Book Name :");
        add(lbl_Dashboard8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 210, 30));

        lbl_dashicon.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_dashicon.setForeground(new java.awt.Color(105, 105, 105));
        lbl_dashicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bkl.png"))); // NOI18N
        add(lbl_dashicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchbooksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchbooksKeyReleased
      
        
        if(txt_searchbooks.getText().equals("")){
            pnlvisible();
            lbl_rackNo.setText("");
            bktableload();
        }
        
        else{
            String ISBN= txt_searchbooks.getText();
        
        try {
            String selectq="select ISBN,Book_Name,Category,Rack_No,Row_No,Column_No from books where ISBN like'%"+ISBN+"%' or Book_Name like'%"+ISBN+"%'";
        
        pst = con.prepareStatement(selectq);
            rs=pst.executeQuery();
            
            book_table.setModel(DbUtils.resultSetToTableModel(rs));
            // resizing the column width
       book_table.getColumnModel().getColumn(0).setPreferredWidth(200);
       book_table.getColumnModel().getColumn(1).setPreferredWidth(390);
       book_table.getColumnModel().getColumn(2).setPreferredWidth(100);
       book_table.getColumnModel().getColumn(3).setPreferredWidth(45);
       book_table.getColumnModel().getColumn(4).setPreferredWidth(45);
       book_table.getColumnModel().getColumn(5).setPreferredWidth(60);
       
       book_table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        } catch (Exception e) {
        }
            
        }
        
        
    }//GEN-LAST:event_txt_searchbooksKeyReleased

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        
        if(txt_searchbooks.getText().isEmpty()){
            
            bktableload();
        }
    }//GEN-LAST:event_formMouseEntered

    private void book_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_book_tableMouseClicked
        
        int r = book_table.getSelectedRow();
        
        String rackname = book_table.getValueAt(r, 3).toString();
        String isbn = book_table.getValueAt(r, 0).toString();
        String bkname = book_table.getValueAt(r, 1).toString();
        
        String row = book_table.getValueAt(r, 4).toString();
        String col = book_table.getValueAt(r, 5).toString();

        lbl_rackNo.setText(rackname);
        txt_searchbooks.setText(isbn+" / "+bkname);
        
        
        
        //---------------------------------row1---------------------------------
        if(row.equals("1") && col.equals("1")){
            
            pnl_11.setVisible(true);
        pnl_12.setVisible(false);
        pnl_13.setVisible(false);
        pnl_14.setVisible(false);
        pnl_15.setVisible(false);
        row1();
            
        }
        
        
        if(row.equals("1") && col.equals("2")){
            
            pnl_11.setVisible(false);
        pnl_12.setVisible(true);
        pnl_13.setVisible(false);
        pnl_14.setVisible(false);
        pnl_15.setVisible(false);
         row1();   
        }
        
        
        if(row.equals("1") && col.equals("3")){
            
            pnl_11.setVisible(false);
        pnl_12.setVisible(false);
        pnl_13.setVisible(true);
        pnl_14.setVisible(false);
        pnl_15.setVisible(false);
            row1();
        }
        
        
        if(row.equals("1") && col.equals("4")){
            
           pnl_11.setVisible(false);
        pnl_12.setVisible(false);
        pnl_13.setVisible(false);
        pnl_14.setVisible(true);
        pnl_15.setVisible(false);
            row1();
        }
        
        
        if(row.equals("1") && col.equals("5")){
            
            pnl_11.setVisible(false);
        pnl_12.setVisible(false);
        pnl_13.setVisible(false);
        pnl_14.setVisible(false);
        pnl_15.setVisible(true);
            row1();
        }
        
        
        
        
        
        //---------------------------------row2---------------------------------
        if(row.equals("2") && col.equals("1")){
            
            pnl_21.setVisible(true);
        pnl_22.setVisible(false);
        pnl_23.setVisible(false);
        pnl_24.setVisible(false);
        pnl_25.setVisible(false);
            row2();
        }
        
        if(row.equals("2") && col.equals("2")){
            
            pnl_21.setVisible(false);
        pnl_22.setVisible(true);
        pnl_23.setVisible(false);
        pnl_24.setVisible(false);
        pnl_25.setVisible(false);
            row2();
        }
        
        if(row.equals("2") && col.equals("3")){
            
            pnl_21.setVisible(false);
        pnl_22.setVisible(false);
        pnl_23.setVisible(true);
        pnl_24.setVisible(false);
        pnl_25.setVisible(false);
            row2();
        }
        
        if(row.equals("2") && col.equals("4")){
            
            pnl_21.setVisible(false);
        pnl_22.setVisible(false);
        pnl_23.setVisible(false);
        pnl_24.setVisible(true);
        pnl_25.setVisible(false);
            row2();
        }
        
        if(row.equals("2") && col.equals("5")){
            
           pnl_21.setVisible(false);
        pnl_22.setVisible(false);
        pnl_23.setVisible(false);
        pnl_24.setVisible(false);
        pnl_25.setVisible(true);
            row2();
        }
        
        
        //---------------------------------row3---------------------------------
        if(row.equals("3") && col.equals("1")){
            
            pnl_31.setVisible(true);
        pnl_32.setVisible(false);
        pnl_33.setVisible(false);
        pnl_34.setVisible(false);
        pnl_35.setVisible(false);
            row3();
        }
        
        if(row.equals("3") && col.equals("2")){
            
            pnl_31.setVisible(false);
        pnl_32.setVisible(true);
        pnl_33.setVisible(false);
        pnl_34.setVisible(false);
        pnl_35.setVisible(false);
            row3();
        }
        
        if(row.equals("3") && col.equals("3")){
            
            pnl_31.setVisible(false);
        pnl_32.setVisible(false);
        pnl_33.setVisible(true);
        pnl_34.setVisible(false);
        pnl_35.setVisible(false);
            row3();
        }
        
        if(row.equals("3") && col.equals("4")){
            
            pnl_31.setVisible(false);
        pnl_32.setVisible(false);
        pnl_33.setVisible(false);
        pnl_34.setVisible(true);
        pnl_35.setVisible(false);
            row3();
        }
        
        if(row.equals("3") && col.equals("5")){
            
           pnl_31.setVisible(false);
        pnl_32.setVisible(false);
        pnl_33.setVisible(false);
        pnl_34.setVisible(false);
        pnl_35.setVisible(true);
            row3();
        }
        
        
        
        
        //---------------------------------row4---------------------------------
       if(row.equals("4") && col.equals("1")){
            
            pnl_41.setVisible(true);
        pnl_42.setVisible(false);
        pnl_43.setVisible(false);
        pnl_44.setVisible(false);
        pnl_45.setVisible(false);
            row4();
        }
        
        if(row.equals("4") && col.equals("2")){
            
            pnl_41.setVisible(false);
        pnl_42.setVisible(true);
        pnl_43.setVisible(false);
        pnl_44.setVisible(false);
        pnl_45.setVisible(false);
            row4();
        }
        
        if(row.equals("4") && col.equals("3")){
            
            pnl_41.setVisible(false);
        pnl_42.setVisible(false);
        pnl_43.setVisible(true);
        pnl_44.setVisible(false);
        pnl_45.setVisible(false);
            row4();
        }
        
        if(row.equals("4") && col.equals("4")){
            
            pnl_41.setVisible(false);
        pnl_42.setVisible(false);
        pnl_43.setVisible(false);
        pnl_44.setVisible(true);
        pnl_45.setVisible(false);
            row4();
        }
        
        if(row.equals("4") && col.equals("5")){
            
           pnl_41.setVisible(false);
        pnl_42.setVisible(false);
        pnl_43.setVisible(false);
        pnl_44.setVisible(false);
        pnl_45.setVisible(true);
            row4();
        } 
        
        
        
        //---------------------------------row5---------------------------------
        if(row.equals("5") && col.equals("1")){
            
            pnl_51.setVisible(true);
        pnl_52.setVisible(false);
        pnl_53.setVisible(false);
        pnl_54.setVisible(false);
        pnl_55.setVisible(false);
            row5();
        }
        
        if(row.equals("5") && col.equals("2")){
            
            pnl_51.setVisible(false);
        pnl_52.setVisible(true);
        pnl_53.setVisible(false);
        pnl_54.setVisible(false);
        pnl_55.setVisible(false);
            row5();
        }
        
        if(row.equals("5") && col.equals("3")){
            
            pnl_51.setVisible(false);
        pnl_52.setVisible(false);
        pnl_53.setVisible(true);
        pnl_54.setVisible(false);
        pnl_55.setVisible(false);
            row5();
        }
        
        if(row.equals("5") && col.equals("4")){
            
            pnl_51.setVisible(false);
        pnl_52.setVisible(false);
        pnl_53.setVisible(false);
        pnl_54.setVisible(true);
        pnl_55.setVisible(false);
            row5();
        }
        
        if(row.equals("5") && col.equals("5")){
            
           pnl_51.setVisible(false);
        pnl_52.setVisible(false);
        pnl_53.setVisible(false);
        pnl_54.setVisible(false);
        pnl_55.setVisible(true);
            row5();
        } 
        
        
        //---------------------------------row6---------------------------------
        if(row.equals("6") && col.equals("1")){
            
            pnl_61.setVisible(true);
        pnl_62.setVisible(false);
        pnl_63.setVisible(false);
        pnl_64.setVisible(false);
        pnl_65.setVisible(false);
            row6();
        }
        
        if(row.equals("6") && col.equals("2")){
            
            pnl_61.setVisible(false);
        pnl_62.setVisible(true);
        pnl_63.setVisible(false);
        pnl_64.setVisible(false);
        pnl_65.setVisible(false);
            row6();
        }
        
        if(row.equals("6") && col.equals("3")){
            
            pnl_61.setVisible(false);
        pnl_62.setVisible(false);
        pnl_63.setVisible(true);
        pnl_64.setVisible(false);
        pnl_65.setVisible(false);
            row6();
        }
        
        if(row.equals("6") && col.equals("4")){
            
            pnl_61.setVisible(false);
        pnl_62.setVisible(false);
        pnl_63.setVisible(false);
        pnl_64.setVisible(true);
        pnl_65.setVisible(false);
            row6();
        }
        
        if(row.equals("6") && col.equals("5")){
            
           pnl_61.setVisible(false);
        pnl_62.setVisible(false);
        pnl_63.setVisible(false);
        pnl_64.setVisible(false);
        pnl_65.setVisible(true);
            row6();
        } 
        
        
        
    }//GEN-LAST:event_book_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable book_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Dashboard5;
    private javax.swing.JLabel lbl_Dashboard7;
    private javax.swing.JLabel lbl_Dashboard8;
    private javax.swing.JLabel lbl_dashicon;
    private javax.swing.JLabel lbl_rackNo;
    private javax.swing.JPanel pnl_11;
    private javax.swing.JPanel pnl_12;
    private javax.swing.JPanel pnl_13;
    private javax.swing.JPanel pnl_14;
    private javax.swing.JPanel pnl_15;
    private javax.swing.JPanel pnl_21;
    private javax.swing.JPanel pnl_22;
    private javax.swing.JPanel pnl_23;
    private javax.swing.JPanel pnl_24;
    private javax.swing.JPanel pnl_25;
    private javax.swing.JPanel pnl_31;
    private javax.swing.JPanel pnl_32;
    private javax.swing.JPanel pnl_33;
    private javax.swing.JPanel pnl_34;
    private javax.swing.JPanel pnl_35;
    private javax.swing.JPanel pnl_41;
    private javax.swing.JPanel pnl_42;
    private javax.swing.JPanel pnl_43;
    private javax.swing.JPanel pnl_44;
    private javax.swing.JPanel pnl_45;
    private javax.swing.JPanel pnl_51;
    private javax.swing.JPanel pnl_52;
    private javax.swing.JPanel pnl_53;
    private javax.swing.JPanel pnl_54;
    private javax.swing.JPanel pnl_55;
    private javax.swing.JPanel pnl_61;
    private javax.swing.JPanel pnl_62;
    private javax.swing.JPanel pnl_63;
    private javax.swing.JPanel pnl_64;
    private javax.swing.JPanel pnl_65;
    private javax.swing.JTextField txt_searchbooks;
    // End of variables declaration//GEN-END:variables
}
