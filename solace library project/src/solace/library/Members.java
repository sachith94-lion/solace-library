/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solace.library;

import AppPackage.AnimationClass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

import net.proteanit.sql.DbUtils;


/**
 *
 * @author sachith
 */
public class Members extends javax.swing.JPanel {

    /**
     * Creates new form Members
     */
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private String M_Type;
    private String MM_Type;
    static Timer t;
    static TimerTask task;
    
    
    public Members() {
        initComponents();
        
        
        
        
        
        
        
        cardpanel.setBackground(new Color(0,0,0,0));
        
        
        pnl_regmem.setVisible(false);
        pnl_editmem.setVisible(false);
        lbl_member_white.setVisible(true);
        lbl_memwhite.setVisible(true);
        pnl_IDprint.setVisible(false);
        
        btn_regmember.setEnabled(true);
        btn_editmem.setEnabled(true);
        btn_memC.setEnabled(true);
        lbl_back2.setVisible(false);
        lbl_reset.setVisible(false);
        
        //connect to DB
        con = DBconnection.connect();
        
        member_table.getTableHeader().setReorderingAllowed(false);
        
        tableload();
        memid();
        
        
        
    }
    
    public void memid(){
        
        try {
            
            String selectq="select count(Member_ID) from members";
            pst = con.prepareStatement(selectq);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String sum=rs.getString("count(Member_ID)");
                int c = Integer.parseInt(sum);
                txt_regmemberid.setText("sol-0"+(c+1));
            }
            
            
        } catch (Exception e) {
        
        }
        
    }
    
    
    
    
    // Method For To Print Panel Contents
    private void printRecord(JPanel panel){
        // Create PrinterJob Here
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        // Set Printer Job Name
        printerJob.setJobName("Print Record");
        // Set Printable
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                // Check If No Printable Content
                if(pageIndex > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                // Make 2D Graphics to map content
                Graphics2D graphics2D = (Graphics2D)graphics;
                // Set Graphics Translations
                // A Little Correction here Multiplication was not working so I replaced with addition
                graphics2D.translate(pageFormat.getImageableX()+10, pageFormat.getImageableY()+10);
                // This is a page scale. Default should be 0.3 I am using 0.5
                graphics2D.scale(0.5, 0.5);
                
                // Now paint panel as graphics2D
                panel.paint(graphics2D);
                
                // return if page exists
                return Printable.PAGE_EXISTS;
            }
        });
        // Store printerDialog as boolean
        boolean returningResult = printerJob.printDialog();
        // check if dilog is showing
        if(returningResult){
            // Use try catch exeption for failure
            try{
                // Now call print method inside printerJob to print
                printerJob.print();
            }catch (PrinterException printerException){
                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
            }
        }
    }
    
    public void time(){
        t = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                btn_regmember.setEnabled(true);
                 btn_editmem.setEnabled(true);
                 btn_memC.setEnabled(true);
                 System.out.println("done");
            }
        };
        
        
        t.schedule(task, 1500);
    
    }
    
    public void backtime(){
        t = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                lbl_back2.setVisible(true);
                 
                 System.out.println("Back Done");
            }
        };
        
        t.schedule(task, 1500);
    }
    
    
    
    
    
    
    
    public void clear(){
        
            txt_memberid.setText("");
            txt_telno.setText("");
            txt_name.setText("");
            txt_address.setText("");
            txt_email.setText("");
            txt_idno.setText("");
            rad_MStaff.setSelected(false);
            rad_MStudent1.setSelected(false);
            
            
    }
    
    public void tableload(){
        
        try {
            String selectq = "select Member_ID,Name,Telephone,Address,Email,ID_No,Member_Type,Registered_Date,Registered_admin from members";
            pst = con.prepareStatement(selectq);
            rs=pst.executeQuery();
            
            member_table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            
            
        } catch (Exception e) {
        }
    }
    
    
    
    void out(){
        AnimationClass anim = new AnimationClass();
        
        //member reg 
        anim.jButtonXLeft(250, -130, 1, 2, btn_regmember);
        anim.jLabelXLeft(190, -260, 1, 2, lbl_memregwhite);
        
        //Edit member
        anim.jButtonXRight(630, 1000, 1, 2, btn_editmem);
        anim.jLabelXRight(610, 1000, 1, 2, lbl_editmem);
        
        //member card
        anim.jButtonYDown(370, 600, 1, 2, btn_memC);
        anim.jLabelYDown(470, 650, 1, 2, lbl_memc);
        
        anim.jLabelXLeft(0, -1000, 1, 4, lbl_blue);
        anim.jLabelXLeft(0, -1000, 2, 4, lbl_blue2);
        anim.jLabelXLeft(0, -1000, 3, 4, lbl_blue3);
        
        anim.jLabelXRight(0, 1000, 1, 4, lbl_green);
        anim.jLabelXRight(0, 1000, 2, 4, lbl_green2);
        anim.jLabelXRight(0, 1000, 3, 4, lbl_green3);
        
        
        
    }
    
    void in(){
        AnimationClass anim = new AnimationClass();
        //member reg
        anim.jButtonXRight(-130,250, 5, 2, btn_regmember);
        anim.jLabelXRight(-260, 190, 5, 2, lbl_memregwhite);
        
        //Edit member
        anim.jButtonXLeft(1000, 630, 4, 2, btn_editmem);
        anim.jLabelXLeft(1000, 610, 4, 2, lbl_editmem);
        
        //member card
        anim.jButtonYUp(600, 370, 5, 2, btn_memC);
        anim.jLabelYUp(650, 470, 6, 2, lbl_memc);
        
        anim.jLabelXRight(-1000, 0, 3, 4, lbl_blue);
        anim.jLabelXRight(-1000, 0, 2, 4, lbl_blue2);
        anim.jLabelXRight(-1000, 0, 1, 4, lbl_blue3);
        
        anim.jLabelXLeft(1000, 0, 3, 4, lbl_green);
        anim.jLabelXLeft(1000, 0, 2, 4, lbl_green2);
        anim.jLabelXLeft(1000, 0, 1, 4, lbl_green3);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_memc = new javax.swing.JLabel();
        lbl_reset = new javax.swing.JLabel();
        btn_memC = new javax.swing.JButton();
        btn_editmem = new javax.swing.JButton();
        lbl_editmem = new javax.swing.JLabel();
        lbl_memregwhite = new javax.swing.JLabel();
        lbl_member_white = new javax.swing.JLabel();
        lbl_memwhite = new javax.swing.JLabel();
        btn_regmember = new javax.swing.JButton();
        lbl_blue = new javax.swing.JLabel();
        lbl_blue2 = new javax.swing.JLabel();
        lbl_blue3 = new javax.swing.JLabel();
        lbl_green = new javax.swing.JLabel();
        lbl_green2 = new javax.swing.JLabel();
        lbl_green3 = new javax.swing.JLabel();
        lbl_back2 = new javax.swing.JLabel();
        lbl_dashicon = new javax.swing.JLabel();
        lbl_Dashboard2 = new javax.swing.JLabel();
        pnl_editmem = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_name7 = new javax.swing.JLabel();
        lbl_name8 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        btn_reset = new javax.swing.JButton();
        lbl_name9 = new javax.swing.JLabel();
        txt_idno = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        lbl_name10 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        lbl_name11 = new javax.swing.JLabel();
        txt_telno = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        lbl_name12 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        lbl_name13 = new javax.swing.JLabel();
        txt_memberid = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        member_table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbl_Dashboard14 = new javax.swing.JLabel();
        txt_search_memid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rad_MStudent1 = new javax.swing.JRadioButton();
        rad_MStaff = new javax.swing.JRadioButton();
        lbl_name16 = new javax.swing.JLabel();
        pnl_regmem = new javax.swing.JPanel();
        lbl_name = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txt_regname = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txt_regidno = new javax.swing.JTextField();
        lbl_name1 = new javax.swing.JLabel();
        txt_regemail = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        txt_regtel = new javax.swing.JTextField();
        lbl_name3 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txt_regaddress = new javax.swing.JTextField();
        lbl_name4 = new javax.swing.JLabel();
        lbl_name5 = new javax.swing.JLabel();
        txt_regmemberid = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        btn_regmembers = new javax.swing.JButton();
        lbl_name6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rad_Staff = new javax.swing.JRadioButton();
        rad_Student1 = new javax.swing.JRadioButton();
        lbl_name14 = new javax.swing.JLabel();
        lbl_name15 = new javax.swing.JLabel();
        btn_mem_card = new javax.swing.JButton();
        pnl_IDprint = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txt_isbn_print = new javax.swing.JTextField();
        lbl_Dashboard16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cardpanel = new javax.swing.JPanel();
        lbl_add = new javax.swing.JLabel();
        lbl_namep = new javax.swing.JLabel();
        lbl_NIC = new javax.swing.JLabel();
        lbl_memID1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_printID = new javax.swing.JButton();
        lbl_Dashboard15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_backtoReg = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(930, 590));
        setLayout(null);

        lbl_memc.setBackground(new java.awt.Color(255, 255, 255));
        lbl_memc.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_memc.setForeground(new java.awt.Color(255, 255, 255));
        lbl_memc.setText("Membership Card");
        add(lbl_memc);
        lbl_memc.setBounds(140, 470, 230, 60);

        lbl_reset.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_reset.setForeground(new java.awt.Color(0, 0, 0));
        lbl_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settings.png"))); // NOI18N
        lbl_reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_resetMouseClicked(evt);
            }
        });
        add(lbl_reset);
        lbl_reset.setBounds(880, 530, 40, 60);

        btn_memC.setBackground(new java.awt.Color(0, 85, 127));
        btn_memC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mem card.png"))); // NOI18N
        btn_memC.setBorder(null);
        btn_memC.setBorderPainted(false);
        btn_memC.setContentAreaFilled(false);
        btn_memC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_memC.setDefaultCapable(false);
        btn_memC.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mem card.png"))); // NOI18N
        btn_memC.setDoubleBuffered(true);
        btn_memC.setFocusable(false);
        btn_memC.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mem card black.png"))); // NOI18N
        btn_memC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_memCActionPerformed(evt);
            }
        });
        add(btn_memC);
        btn_memC.setBounds(180, 370, 140, 120);

        btn_editmem.setBackground(new java.awt.Color(0, 85, 127));
        btn_editmem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/management (1).png"))); // NOI18N
        btn_editmem.setBorder(null);
        btn_editmem.setBorderPainted(false);
        btn_editmem.setContentAreaFilled(false);
        btn_editmem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_editmem.setDefaultCapable(false);
        btn_editmem.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/management (1).png"))); // NOI18N
        btn_editmem.setDoubleBuffered(true);
        btn_editmem.setFocusable(false);
        btn_editmem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_editmem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/management.png"))); // NOI18N
        btn_editmem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editmemActionPerformed(evt);
            }
        });
        add(btn_editmem);
        btn_editmem.setBounds(630, 240, 128, 128);

        lbl_editmem.setBackground(new java.awt.Color(255, 255, 255));
        lbl_editmem.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_editmem.setForeground(new java.awt.Color(255, 255, 255));
        lbl_editmem.setText("Edit Members");
        add(lbl_editmem);
        lbl_editmem.setBounds(610, 380, 170, 20);

        lbl_memregwhite.setBackground(new java.awt.Color(255, 255, 255));
        lbl_memregwhite.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_memregwhite.setForeground(new java.awt.Color(255, 255, 255));
        lbl_memregwhite.setText("Member Registration");
        add(lbl_memregwhite);
        lbl_memregwhite.setBounds(190, 240, 260, 20);

        lbl_member_white.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_member_white.setForeground(new java.awt.Color(105, 105, 105));
        lbl_member_white.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/multiple-users-white.png"))); // NOI18N
        add(lbl_member_white);
        lbl_member_white.setBounds(10, 10, 40, 40);

        lbl_memwhite.setBackground(new java.awt.Color(255, 255, 255));
        lbl_memwhite.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_memwhite.setForeground(new java.awt.Color(255, 255, 255));
        lbl_memwhite.setText("Members");
        add(lbl_memwhite);
        lbl_memwhite.setBounds(50, 20, 110, 20);

        btn_regmember.setBackground(new java.awt.Color(0, 85, 127));
        btn_regmember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add member over.png"))); // NOI18N
        btn_regmember.setBorder(null);
        btn_regmember.setBorderPainted(false);
        btn_regmember.setContentAreaFilled(false);
        btn_regmember.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_regmember.setDefaultCapable(false);
        btn_regmember.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add member over.png"))); // NOI18N
        btn_regmember.setDoubleBuffered(true);
        btn_regmember.setFocusable(false);
        btn_regmember.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_regmember.setPreferredSize(new java.awt.Dimension(128, 128));
        btn_regmember.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add member black.png"))); // NOI18N
        btn_regmember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regmemberActionPerformed(evt);
            }
        });
        add(btn_regmember);
        btn_regmember.setBounds(250, 110, 128, 128);

        lbl_blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regcolorpnl.png"))); // NOI18N
        add(lbl_blue);
        lbl_blue.setBounds(0, 0, 930, 590);

        lbl_blue2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regcolorpnl2.png"))); // NOI18N
        add(lbl_blue2);
        lbl_blue2.setBounds(0, 0, 930, 590);

        lbl_blue3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regcolorpnl3.png"))); // NOI18N
        add(lbl_blue3);
        lbl_blue3.setBounds(0, 0, 930, 590);

        lbl_green.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/managecolorpnl.png"))); // NOI18N
        add(lbl_green);
        lbl_green.setBounds(0, 0, 930, 590);

        lbl_green2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/managecolorpnl2.png"))); // NOI18N
        add(lbl_green2);
        lbl_green2.setBounds(0, 0, 930, 590);

        lbl_green3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/managecolorpnl3.png"))); // NOI18N
        add(lbl_green3);
        lbl_green3.setBounds(0, 0, 930, 590);

        lbl_back2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_back2.setForeground(new java.awt.Color(30, 25, 24));
        lbl_back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back-arrow.png"))); // NOI18N
        lbl_back2.setText("Back");
        lbl_back2.setToolTipText("");
        lbl_back2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_back2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_back2MouseClicked(evt);
            }
        });
        add(lbl_back2);
        lbl_back2.setBounds(40, 530, 71, 24);

        lbl_dashicon.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_dashicon.setForeground(new java.awt.Color(105, 105, 105));
        lbl_dashicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/multiple-users-silhouette.png"))); // NOI18N
        add(lbl_dashicon);
        lbl_dashicon.setBounds(10, 10, 40, 40);

        lbl_Dashboard2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_Dashboard2.setForeground(new java.awt.Color(105, 105, 105));
        lbl_Dashboard2.setText("Members");
        add(lbl_Dashboard2);
        lbl_Dashboard2.setBounds(50, 20, 110, 20);

        pnl_editmem.setBackground(new java.awt.Color(242, 242, 242));
        pnl_editmem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editmembers.png"))); // NOI18N
        pnl_editmem.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 40, 40));

        lbl_name7.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        lbl_name7.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name7.setText("Edit Members");
        lbl_name7.setToolTipText("");
        pnl_editmem.add(lbl_name7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 170, -1));

        lbl_name8.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name8.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name8.setText("Name:");
        lbl_name8.setToolTipText("");
        pnl_editmem.add(lbl_name8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 60, -1));

        txt_name.setBackground(new java.awt.Color(242, 242, 242));
        txt_name.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_name.setForeground(new java.awt.Color(0, 0, 0));
        txt_name.setBorder(null);
        pnl_editmem.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 300, 30));

        jSeparator9.setForeground(new java.awt.Color(60, 63, 65));
        pnl_editmem.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 300, 10));

        btn_reset.setBackground(new java.awt.Color(0, 167, 250));
        btn_reset.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reset button.png"))); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetMouseClicked(evt);
            }
        });
        pnl_editmem.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 150, 40));

        lbl_name9.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name9.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name9.setText("ID No:");
        lbl_name9.setToolTipText("");
        pnl_editmem.add(lbl_name9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 60, -1));

        txt_idno.setBackground(new java.awt.Color(242, 242, 242));
        txt_idno.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_idno.setForeground(new java.awt.Color(0, 0, 0));
        txt_idno.setBorder(null);
        pnl_editmem.add(txt_idno, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 300, 30));

        jSeparator10.setForeground(new java.awt.Color(60, 63, 65));
        pnl_editmem.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 300, 10));

        lbl_name10.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name10.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name10.setText("Member Type:");
        lbl_name10.setToolTipText("");
        pnl_editmem.add(lbl_name10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 120, -1));

        txt_email.setBackground(new java.awt.Color(242, 242, 242));
        txt_email.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(0, 0, 0));
        txt_email.setBorder(null);
        pnl_editmem.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 300, 30));

        jSeparator11.setForeground(new java.awt.Color(60, 63, 65));
        pnl_editmem.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 300, 10));

        lbl_name11.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name11.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name11.setText("Telephone No:");
        lbl_name11.setToolTipText("");
        pnl_editmem.add(lbl_name11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 130, -1));

        txt_telno.setBackground(new java.awt.Color(242, 242, 242));
        txt_telno.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_telno.setForeground(new java.awt.Color(0, 0, 0));
        txt_telno.setBorder(null);
        pnl_editmem.add(txt_telno, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 300, 30));

        jSeparator12.setForeground(new java.awt.Color(60, 63, 65));
        pnl_editmem.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 300, 10));

        lbl_name12.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name12.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name12.setText("Address:");
        lbl_name12.setToolTipText("");
        pnl_editmem.add(lbl_name12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 90, -1));

        txt_address.setBackground(new java.awt.Color(242, 242, 242));
        txt_address.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_address.setForeground(new java.awt.Color(0, 0, 0));
        txt_address.setBorder(null);
        pnl_editmem.add(txt_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 300, 30));

        jSeparator13.setForeground(new java.awt.Color(60, 63, 65));
        pnl_editmem.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 300, 10));

        lbl_name13.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name13.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name13.setText("Member ID:");
        lbl_name13.setToolTipText("");
        pnl_editmem.add(lbl_name13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 110, -1));

        txt_memberid.setBackground(new java.awt.Color(242, 242, 242));
        txt_memberid.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_memberid.setForeground(new java.awt.Color(0, 0, 0));
        txt_memberid.setBorder(null);
        txt_memberid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_memberidKeyReleased(evt);
            }
        });
        pnl_editmem.add(txt_memberid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 300, 30));

        jSeparator14.setForeground(new java.awt.Color(60, 63, 65));
        pnl_editmem.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 300, 10));

        btn_update.setBackground(new java.awt.Color(115, 150, 0));
        btn_update.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/updatebtn.png"))); // NOI18N
        btn_update.setText("Update");
        btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_updateMouseClicked(evt);
            }
        });
        pnl_editmem.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 150, 40));

        btn_delete.setBackground(new java.awt.Color(255, 50, 59));
        btn_delete.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user-with-cross-sign.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });
        pnl_editmem.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, 150, 40));

        member_table.setBackground(new java.awt.Color(255, 255, 255));
        member_table.setModel(new javax.swing.table.DefaultTableModel(
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
        member_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                member_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(member_table);

        pnl_editmem.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 910, 150));

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Dashboard14.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_Dashboard14.setForeground(new java.awt.Color(102, 102, 102));
        lbl_Dashboard14.setText("Member ID:");
        jPanel2.add(lbl_Dashboard14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 20));

        txt_search_memid.setBackground(new java.awt.Color(255, 255, 255));
        txt_search_memid.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_search_memid.setForeground(new java.awt.Color(69, 73, 74));
        txt_search_memid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 105, 105), 1, true));
        txt_search_memid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search_memidKeyReleased(evt);
            }
        });
        jPanel2.add(txt_search_memid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 240, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/magnifier.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 30, 30));

        pnl_editmem.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 430, 50));

        rad_MStudent1.setBackground(new java.awt.Color(242, 242, 242));
        rad_MStudent1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        rad_MStudent1.setForeground(new java.awt.Color(105, 105, 105));
        rad_MStudent1.setText("Student");
        rad_MStudent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_MStudent1ActionPerformed(evt);
            }
        });
        pnl_editmem.add(rad_MStudent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, -1, -1));

        rad_MStaff.setBackground(new java.awt.Color(242, 242, 242));
        rad_MStaff.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        rad_MStaff.setForeground(new java.awt.Color(105, 105, 105));
        rad_MStaff.setText("Staff");
        rad_MStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_MStaffActionPerformed(evt);
            }
        });
        pnl_editmem.add(rad_MStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, -1, -1));

        lbl_name16.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name16.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name16.setText("Email:");
        lbl_name16.setToolTipText("");
        pnl_editmem.add(lbl_name16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 80, -1));

        add(pnl_editmem);
        pnl_editmem.setBounds(0, 50, 930, 540);

        pnl_regmem.setBackground(new java.awt.Color(242, 242, 242));
        pnl_regmem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_name.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name.setText("Member Registration");
        lbl_name.setToolTipText("");
        pnl_regmem.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 250, -1));

        jSeparator3.setForeground(new java.awt.Color(60, 63, 65));
        pnl_regmem.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 300, 10));

        txt_regname.setBackground(new java.awt.Color(242, 242, 242));
        txt_regname.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_regname.setForeground(new java.awt.Color(0, 0, 0));
        txt_regname.setBorder(null);
        pnl_regmem.add(txt_regname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 300, 30));

        jSeparator4.setForeground(new java.awt.Color(60, 63, 65));
        pnl_regmem.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 300, 10));

        txt_regidno.setBackground(new java.awt.Color(242, 242, 242));
        txt_regidno.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_regidno.setForeground(new java.awt.Color(0, 0, 0));
        txt_regidno.setBorder(null);
        pnl_regmem.add(txt_regidno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 300, 30));

        lbl_name1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name1.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name1.setText("ID No:");
        lbl_name1.setToolTipText("");
        pnl_regmem.add(lbl_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 60, -1));

        txt_regemail.setBackground(new java.awt.Color(242, 242, 242));
        txt_regemail.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_regemail.setForeground(new java.awt.Color(0, 0, 0));
        txt_regemail.setBorder(null);
        pnl_regmem.add(txt_regemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 300, 30));

        jSeparator5.setForeground(new java.awt.Color(60, 63, 65));
        pnl_regmem.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 300, 10));

        jSeparator6.setForeground(new java.awt.Color(60, 63, 65));
        pnl_regmem.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 300, 10));

        txt_regtel.setBackground(new java.awt.Color(242, 242, 242));
        txt_regtel.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_regtel.setForeground(new java.awt.Color(0, 0, 0));
        txt_regtel.setBorder(null);
        txt_regtel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_regtelKeyTyped(evt);
            }
        });
        pnl_regmem.add(txt_regtel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 300, 30));

        lbl_name3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name3.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name3.setText("Telephone No:");
        lbl_name3.setToolTipText("");
        pnl_regmem.add(lbl_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 130, -1));

        jSeparator7.setForeground(new java.awt.Color(60, 63, 65));
        pnl_regmem.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 300, 10));

        txt_regaddress.setBackground(new java.awt.Color(242, 242, 242));
        txt_regaddress.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_regaddress.setForeground(new java.awt.Color(0, 0, 0));
        txt_regaddress.setBorder(null);
        pnl_regmem.add(txt_regaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 300, 30));

        lbl_name4.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name4.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name4.setText("Address:");
        lbl_name4.setToolTipText("");
        pnl_regmem.add(lbl_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 90, -1));

        lbl_name5.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name5.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name5.setText("Member ID:");
        lbl_name5.setToolTipText("");
        pnl_regmem.add(lbl_name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 110, -1));

        txt_regmemberid.setBackground(new java.awt.Color(242, 242, 242));
        txt_regmemberid.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_regmemberid.setForeground(new java.awt.Color(0, 0, 0));
        txt_regmemberid.setBorder(null);
        pnl_regmem.add(txt_regmemberid, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 300, 30));

        jSeparator8.setForeground(new java.awt.Color(60, 63, 65));
        pnl_regmem.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 300, 10));

        btn_regmembers.setBackground(new java.awt.Color(255, 255, 255));
        btn_regmembers.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_regmembers.setForeground(new java.awt.Color(0, 85, 127));
        btn_regmembers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-contact.png"))); // NOI18N
        btn_regmembers.setText("Register");
        btn_regmembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_regmembersMouseClicked(evt);
            }
        });
        pnl_regmem.add(btn_regmembers, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 150, 40));

        lbl_name6.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name6.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name6.setText("Name:");
        lbl_name6.setToolTipText("");
        pnl_regmem.add(lbl_name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 60, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-contact2.png"))); // NOI18N
        pnl_regmem.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 40, 40));

        rad_Staff.setBackground(new java.awt.Color(242, 242, 242));
        rad_Staff.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        rad_Staff.setForeground(new java.awt.Color(105, 105, 105));
        rad_Staff.setText("Staff");
        rad_Staff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_StaffActionPerformed(evt);
            }
        });
        pnl_regmem.add(rad_Staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        rad_Student1.setBackground(new java.awt.Color(242, 242, 242));
        rad_Student1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        rad_Student1.setForeground(new java.awt.Color(105, 105, 105));
        rad_Student1.setText("Student");
        rad_Student1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_Student1ActionPerformed(evt);
            }
        });
        pnl_regmem.add(rad_Student1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, -1));

        lbl_name14.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name14.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name14.setText("Email:");
        lbl_name14.setToolTipText("");
        pnl_regmem.add(lbl_name14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 80, -1));

        lbl_name15.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_name15.setForeground(new java.awt.Color(105, 105, 105));
        lbl_name15.setText("Member Type:");
        lbl_name15.setToolTipText("");
        pnl_regmem.add(lbl_name15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 120, -1));

        btn_mem_card.setBackground(new java.awt.Color(255, 255, 255));
        btn_mem_card.setForeground(new java.awt.Color(0, 85, 127));
        btn_mem_card.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/id-card blue.png"))); // NOI18N
        btn_mem_card.setText("Membership Card");
        btn_mem_card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_mem_cardMouseClicked(evt);
            }
        });
        pnl_regmem.add(btn_mem_card, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 170, 40));

        add(pnl_regmem);
        pnl_regmem.setBounds(0, 50, 930, 540);

        pnl_IDprint.setBackground(new java.awt.Color(242, 242, 242));
        pnl_IDprint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(242, 242, 242));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_isbn_print.setBackground(new java.awt.Color(255, 255, 255));
        txt_isbn_print.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txt_isbn_print.setForeground(new java.awt.Color(69, 73, 74));
        txt_isbn_print.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(105, 105, 105), 1, true));
        txt_isbn_print.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_isbn_printKeyReleased(evt);
            }
        });
        jPanel3.add(txt_isbn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 240, -1));

        lbl_Dashboard16.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lbl_Dashboard16.setForeground(new java.awt.Color(102, 102, 102));
        lbl_Dashboard16.setText("Member ID:");
        jPanel3.add(lbl_Dashboard16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/magnifier.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 30, 30));

        pnl_IDprint.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 430, 50));

        cardpanel.setBackground(new java.awt.Color(242, 242, 242));
        cardpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_add.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        lbl_add.setForeground(new java.awt.Color(0, 0, 0));
        cardpanel.add(lbl_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 170, 30));

        lbl_namep.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        cardpanel.add(lbl_namep, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 170, 30));

        lbl_NIC.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        lbl_NIC.setForeground(new java.awt.Color(0, 0, 0));
        cardpanel.add(lbl_NIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 110, 20));

        lbl_memID1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        lbl_memID1.setForeground(new java.awt.Color(0, 0, 0));
        cardpanel.add(lbl_memID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 110, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/member card.png"))); // NOI18N
        cardpanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 220));

        pnl_IDprint.add(cardpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 310, 250));

        btn_printID.setBackground(new java.awt.Color(255, 255, 255));
        btn_printID.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_printID.setForeground(new java.awt.Color(0, 85, 125));
        btn_printID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/id-card blue.png"))); // NOI18N
        btn_printID.setText("Card Print ");
        btn_printID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printIDMouseClicked(evt);
            }
        });
        pnl_IDprint.add(btn_printID, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 150, 40));

        lbl_Dashboard15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbl_Dashboard15.setForeground(new java.awt.Color(102, 102, 102));
        lbl_Dashboard15.setText("Membership Card ");
        pnl_IDprint.add(lbl_Dashboard15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 170, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/id-card gray.png"))); // NOI18N
        pnl_IDprint.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 50, 40));

        btn_backtoReg.setBackground(new java.awt.Color(255, 255, 255));
        btn_backtoReg.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_backtoReg.setForeground(new java.awt.Color(0, 85, 125));
        btn_backtoReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back blue.png"))); // NOI18N
        btn_backtoReg.setText("Back");
        btn_backtoReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backtoRegMouseClicked(evt);
            }
        });
        pnl_IDprint.add(btn_backtoReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 150, 40));

        add(pnl_IDprint);
        pnl_IDprint.setBounds(0, 50, 930, 540);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_back2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back2MouseClicked
        
        
        time();
        
        
        lbl_back2.setVisible(false);
        
        in();
        pnl_regmem.setVisible(false);
        pnl_editmem.setVisible(false);
        pnl_IDprint.setVisible(false);
        lbl_member_white.setVisible(true);
        lbl_memwhite.setVisible(true);
        clear();
        lbl_memID1.setText("");
            lbl_NIC.setText("");
            lbl_namep.setText("");
            lbl_add.setText("");
            txt_isbn_print.setText("");
            
            txt_regname.setText("");
            txt_regidno.setText("");
            txt_regemail.setText("");
            txt_regtel.setText("");
            txt_regaddress.setText("");
            txt_regmemberid.setText("");
            rad_Staff.setSelected(false);
            rad_Student1.setSelected(false);
            
        
    }//GEN-LAST:event_lbl_back2MouseClicked

    private void lbl_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_resetMouseClicked
        in();
        
        btn_regmember.setEnabled(true);
        btn_editmem.setEnabled(true);
        btn_memC.setEnabled(true);
        pnl_regmem.setVisible(false);
        pnl_editmem.setVisible(false);
        lbl_member_white.setVisible(true);
        lbl_memwhite.setVisible(true);
        pnl_IDprint.setVisible(false);
    }//GEN-LAST:event_lbl_resetMouseClicked

    private void btn_regmembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_regmembersMouseClicked
        
        String reg_admin = String.valueOf(Library.lib);
        
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        String reg_date =(s.format(d));
        
        
        if(txt_regmemberid.getText().isEmpty() || txt_regname.getText().isEmpty() || txt_regtel.getText().isEmpty() || txt_regaddress.getText().isEmpty() || txt_regemail.getText().isEmpty() || txt_regidno.getText().isEmpty() || M_Type==null){
            JOptionPane.showMessageDialog(null,"Please complete the form corectly");
        }
        
        else{
            
            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
        if(p==0){
            try {
                String sql="insert into members(Member_ID,Name,Telephone,Address,Email,ID_No,Member_Type,Registered_Date,Registered_admin) values(?,?,?,?,?,?,?,?,?)";
                
                
                pst=con.prepareStatement(sql);
                
                pst.setString(1,txt_regmemberid.getText());
                pst.setString(2,txt_regname.getText());
                pst.setString(3,txt_regtel.getText());
                pst.setString(4,txt_regaddress.getText());
                pst.setString(5,txt_regemail.getText()); 
                pst.setString(6,txt_regidno.getText());
                pst.setString(7,M_Type);
                pst.setString(8,reg_date);
                pst.setString(9,reg_admin);
                
                
                
                
                          
                pst.execute();
                JOptionPane.showMessageDialog(null,"Member registration is successful.");
                
                
        //txt_regmemberid.setText("");
        txt_regname.setText("");
        txt_regtel.setText("");
        txt_regaddress.setText(""); 
        txt_regemail.setText("");
        txt_address.setText("");
        txt_regidno.setText("");
        rad_Staff.setSelected(false);
        rad_Student1.setSelected(false);
        memid();
        
            
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null,"This member ID is already exist. \n\n\n If you need any clarifications, please contact the developer with below message.\n\n --------------------------------------------------------------------only for the developer-----------------------------------------------------------------------------\n"+e+"\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
            
        
        }
        }
        
        
    }//GEN-LAST:event_btn_regmembersMouseClicked

    private void rad_StaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_StaffActionPerformed
        M_Type ="Staff";
        rad_Student1.setSelected(false);
        rad_Staff.setSelected(true);
    }//GEN-LAST:event_rad_StaffActionPerformed

    private void rad_Student1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_Student1ActionPerformed
        M_Type ="Student";
        rad_Student1.setSelected(true);
        rad_Staff.setSelected(false);
    }//GEN-LAST:event_rad_Student1ActionPerformed

    private void txt_regtelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_regtelKeyTyped
        
        char c=evt.getKeyChar();

String text=txt_telno.getText();
       if (c == 43 && text.indexOf('+') != -1)
            {
                evt.consume();
            }
       if (!Character.isDigit(c) && c != 8 && c != 43)
            {
                evt.consume();
            }
    }//GEN-LAST:event_txt_regtelKeyTyped

    private void rad_MStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_MStaffActionPerformed
        MM_Type ="Staff";
        rad_MStudent1.setSelected(false);
        rad_MStaff.setSelected(true);
    }//GEN-LAST:event_rad_MStaffActionPerformed

    private void rad_MStudent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_MStudent1ActionPerformed
        MM_Type ="Student";
        rad_MStudent1.setSelected(true);
        rad_MStaff.setSelected(false);
    }//GEN-LAST:event_rad_MStudent1ActionPerformed

    private void member_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_member_tableMouseClicked
        
        
        
        
        
        int r = member_table.getSelectedRow();
        
        String memberid = member_table.getValueAt(r, 0).toString();
        String name = member_table.getValueAt(r, 1).toString();
        String telno = member_table.getValueAt(r, 2).toString();
        String address = member_table.getValueAt(r, 3).toString();
        String email = member_table.getValueAt(r, 4).toString();
        String idno = member_table.getValueAt(r, 5).toString();
        MM_Type = member_table.getValueAt(r, 6).toString();
        //String password = table_users.getValueAt(r, 7).toString();
        if(MM_Type.equals("Staff")){
                    rad_MStudent1.setSelected(false);
                    rad_MStaff.setSelected(true);
                    
                }
                
                if(MM_Type.equals("Student")) {
                    
                    rad_MStudent1.setSelected(true);
                    rad_MStaff.setSelected(false);
                }
        
        
        txt_memberid.setText(memberid);
        txt_name.setText(name);
        txt_telno.setText(telno);
        txt_address.setText(address);
        txt_email.setText(email);
        txt_idno.setText(idno);
        
        
        
        
        
    }//GEN-LAST:event_member_tableMouseClicked

    private void btn_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseClicked
        clear();
        txt_search_memid.setText("");
    }//GEN-LAST:event_btn_resetMouseClicked

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        
        
        if(txt_name.getText().isEmpty() || txt_idno.getText().isEmpty() || txt_address.getText().isEmpty() || txt_telno.getText().isEmpty() || txt_email.getText().isEmpty() || txt_memberid.getText().isEmpty() || MM_Type==null){
            
            JOptionPane.showMessageDialog(null,"Please select your member ID from the table");
        }
        
        else{
            
            int x = JOptionPane.showConfirmDialog(null,"Do you really want to update");
        
        if(x==0){
            String name=txt_name.getText();
        String idno=txt_idno.getText();
        String address=txt_address.getText();
        String telno=txt_telno.getText();
        String email=txt_email.getText();
        String member_id=txt_memberid.getText();
         
        String reg_admin = String.valueOf(Library.lib);
        
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        String reg_date =(s.format(d));
        
 
            try {
                
                String updateq="update members set Member_ID='"+member_id+"',Name='"+name+"',Telephone='"+telno+"',Address='"+address+"',Email='"+email+"',ID_No='"+idno+"',Member_Type='"+MM_Type+"',Registered_Date='"+reg_date+"',Registered_admin='"+reg_admin+"' where Member_ID='"+member_id+"'";
                pst = con.prepareStatement(updateq);
                pst.execute();
                //load table
                tableload();
                
                clear();
                
            } catch (Exception e) {
            }
            
        }
        }
        
        
        
    }//GEN-LAST:event_btn_updateMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        
        if(txt_name.getText().isEmpty() || txt_idno.getText().isEmpty() || txt_address.getText().isEmpty() || txt_telno.getText().isEmpty() || txt_email.getText().isEmpty() || txt_memberid.getText().isEmpty() || MM_Type==null){
            
            JOptionPane.showMessageDialog(null,"Please select your member ID from the table");
        }
        
        else{
            
            int x = JOptionPane.showConfirmDialog(null,"Do you want to delete this");
        
        if(x==0){
            
            String id = txt_memberid.getText();
            
            try {
                String deleteq="delete from members where Member_ID='"+id+"'";
                pst = con.prepareStatement(deleteq);
                pst.execute();
                //load table
                tableload();
                
                clear();
                
                
            } catch (Exception e) {
            }
            
        }
        }
        
        
        
        
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void txt_search_memidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_memidKeyReleased
        
        String name= txt_search_memid.getText();
        
        try {
            String selectq="select Member_ID,Name,Telephone,Address,Email,ID_No,Member_Type,Registered_Date,Registered_admin from members where Name like'%"+name+"%' or Member_ID like'%"+name+"%'";
        
        pst = con.prepareStatement(selectq);
            rs=pst.executeQuery();
            
            member_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txt_search_memidKeyReleased

    private void txt_memberidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_memberidKeyReleased
        if(txt_memberid.getText().equals("")){
            clear();
            txt_search_memid.setText("");
        }
    }//GEN-LAST:event_txt_memberidKeyReleased

    private void txt_isbn_printKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_isbn_printKeyReleased
        
        String isbn= txt_isbn_print.getText();
        
        
        if(txt_isbn_print.getText().equals("")){
            lbl_memID1.setText("");
            lbl_NIC.setText("");
            lbl_namep.setText("");
            lbl_add.setText("");
        }
        
        try {
            String selectq="select Member_ID,Name,Address,ID_No from members where Member_ID='"+isbn+"'";
        
        Statement st =con.createStatement();
            rs= st.executeQuery(selectq);
            
           while(rs.next()){
                String memid=rs.getString("Member_ID");
            lbl_memID1.setText(memid);
            
            String name=rs.getString("Name");
            lbl_namep.setText("<html>"+name+"</html>");
            
            
            String address=rs.getString("Address");
            lbl_add.setText("<html>"+address+"</html>");
            
            String nic=rs.getString("ID_No");
            lbl_NIC.setText(nic);
            
            
            
            
            } 
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txt_isbn_printKeyReleased

    private void btn_printIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printIDMouseClicked
        
        if(txt_isbn_print.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null,"Please search your member ID");
        }
        
        else{
            
            printRecord(cardpanel);
            
        }
        
        lbl_memID1.setText("");
            lbl_NIC.setText("");
            lbl_namep.setText("");
            lbl_add.setText("");
            txt_isbn_print.setText("");
        
        
     
        
    }//GEN-LAST:event_btn_printIDMouseClicked

    private void btn_mem_cardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mem_cardMouseClicked
        
        pnl_regmem.setVisible(false);
        pnl_editmem.setVisible(false);
        lbl_member_white.setVisible(true);
        lbl_memwhite.setVisible(true);
        pnl_IDprint.setVisible(true);
        lbl_member_white.setVisible(false);
        lbl_memwhite.setVisible(false);
        lbl_back2.setVisible(false);
    }//GEN-LAST:event_btn_mem_cardMouseClicked

    private void btn_backtoRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backtoRegMouseClicked
        
        
        lbl_memID1.setText("");
            lbl_NIC.setText("");
            lbl_namep.setText("");
            lbl_add.setText("");
            txt_isbn_print.setText("");
            
            pnl_regmem.setVisible(true);
        pnl_editmem.setVisible(false);
        lbl_member_white.setVisible(false);
        lbl_memwhite.setVisible(false);
        pnl_IDprint.setVisible(false);
        lbl_member_white.setVisible(false);
        lbl_memwhite.setVisible(false);
        lbl_back2.setVisible(true);
            
    }//GEN-LAST:event_btn_backtoRegMouseClicked

    private void btn_regmemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regmemberActionPerformed
        backtime();
        memid();
        btn_regmember.setEnabled(false);
                 btn_editmem.setEnabled(false);
                 btn_memC.setEnabled(false);
                 
                 
                 
        
        out();
        pnl_regmem.setVisible(true);
        lbl_member_white.setVisible(false);
        lbl_memwhite.setVisible(false);
        pnl_editmem.setVisible(false);
        pnl_IDprint.setVisible(false);
        btn_backtoReg.setVisible(true);
        tableload();
    }//GEN-LAST:event_btn_regmemberActionPerformed

    private void btn_editmemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editmemActionPerformed
       backtime();
        btn_regmember.setEnabled(false);
                 btn_editmem.setEnabled(false);
                 btn_memC.setEnabled(false);
                 
        
        out();
        pnl_editmem.setVisible(true);
        pnl_regmem.setVisible(false);
        lbl_member_white.setVisible(false);
        lbl_memwhite.setVisible(false);
        pnl_IDprint.setVisible(false);
        tableload();
    }//GEN-LAST:event_btn_editmemActionPerformed

    private void btn_memCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_memCActionPerformed
       backtime();
        btn_regmember.setEnabled(false);
                 btn_editmem.setEnabled(false);
                 btn_memC.setEnabled(false);
                 
        
        out();
        pnl_regmem.setVisible(false);
        lbl_member_white.setVisible(false);
        lbl_memwhite.setVisible(false);
        pnl_editmem.setVisible(false);
        pnl_IDprint.setVisible(true);
        btn_backtoReg.setVisible(false);
    }//GEN-LAST:event_btn_memCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_backtoReg;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_editmem;
    private javax.swing.JButton btn_memC;
    private javax.swing.JButton btn_mem_card;
    private javax.swing.JButton btn_printID;
    private javax.swing.JButton btn_regmember;
    private javax.swing.JButton btn_regmembers;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_update;
    private javax.swing.JPanel cardpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbl_Dashboard14;
    private javax.swing.JLabel lbl_Dashboard15;
    private javax.swing.JLabel lbl_Dashboard16;
    private javax.swing.JLabel lbl_Dashboard2;
    private javax.swing.JLabel lbl_NIC;
    private javax.swing.JLabel lbl_add;
    private javax.swing.JLabel lbl_back2;
    private javax.swing.JLabel lbl_blue;
    private javax.swing.JLabel lbl_blue2;
    private javax.swing.JLabel lbl_blue3;
    private javax.swing.JLabel lbl_dashicon;
    private javax.swing.JLabel lbl_editmem;
    private javax.swing.JLabel lbl_green;
    private javax.swing.JLabel lbl_green2;
    private javax.swing.JLabel lbl_green3;
    private javax.swing.JLabel lbl_memID1;
    private javax.swing.JLabel lbl_member_white;
    private javax.swing.JLabel lbl_memc;
    private javax.swing.JLabel lbl_memregwhite;
    private javax.swing.JLabel lbl_memwhite;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_name1;
    private javax.swing.JLabel lbl_name10;
    private javax.swing.JLabel lbl_name11;
    private javax.swing.JLabel lbl_name12;
    private javax.swing.JLabel lbl_name13;
    private javax.swing.JLabel lbl_name14;
    private javax.swing.JLabel lbl_name15;
    private javax.swing.JLabel lbl_name16;
    private javax.swing.JLabel lbl_name3;
    private javax.swing.JLabel lbl_name4;
    private javax.swing.JLabel lbl_name5;
    private javax.swing.JLabel lbl_name6;
    private javax.swing.JLabel lbl_name7;
    private javax.swing.JLabel lbl_name8;
    private javax.swing.JLabel lbl_name9;
    private javax.swing.JLabel lbl_namep;
    private javax.swing.JLabel lbl_reset;
    private javax.swing.JTable member_table;
    private javax.swing.JPanel pnl_IDprint;
    private javax.swing.JPanel pnl_editmem;
    private javax.swing.JPanel pnl_regmem;
    private javax.swing.JRadioButton rad_MStaff;
    private javax.swing.JRadioButton rad_MStudent1;
    private javax.swing.JRadioButton rad_Staff;
    private javax.swing.JRadioButton rad_Student1;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_idno;
    private javax.swing.JTextField txt_isbn_print;
    private javax.swing.JTextField txt_memberid;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_regaddress;
    private javax.swing.JTextField txt_regemail;
    private javax.swing.JTextField txt_regidno;
    private javax.swing.JTextField txt_regmemberid;
    private javax.swing.JTextField txt_regname;
    private javax.swing.JTextField txt_regtel;
    private javax.swing.JTextField txt_search_memid;
    private javax.swing.JTextField txt_telno;
    // End of variables declaration//GEN-END:variables
}

