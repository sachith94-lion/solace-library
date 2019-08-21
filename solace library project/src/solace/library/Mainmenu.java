/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solace.library;

import AppPackage.AnimationClass;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author sachith
 */
public class Mainmenu extends javax.swing.JFrame {

    /**
     * Creates new form Mainmenu
     */
    
    Connection conn=null;
ResultSet rs=null;
PreparedStatement pst=null;

    int xMouse;
    int yMouse;
    
    
    GridBagLayout layout = new GridBagLayout();
    
    Books bookspnl;
    Members memberpnl;
    Details detailspnl;
    Fine_Calculation finecalpnl;
    Book_Transactions booktranspnl;
    Database dbpnl;
    User userpnl;
    Aboutus aboutuspnl;
    Book_Location BKLocation;
    
    
    public Mainmenu() {
        initComponents();
        
        //connect to DB
        conn = DBconnection.connect();
        lbl_user.setText(String.valueOf(Library.lib).toString());
        
        initialize();
        showData();
        showTime();
        buttoned();
        counmembers();
        countbooks();
        
        
        
        String un1=lbl_user.getText();
        Library.lib = un1;
        
        AnimationClass anim = new AnimationClass();
        anim.jLabelYUp(200,150,30,2, lbl_book);
        anim.jLabelYUp(340,290,30,2, lbl_books);
        anim.jLabelYUp(340,290,30,2, lbl_members);
        anim.jLabelYUp(470,420,30,2, lbl_details);
        anim.jLabelYUp(470,420,30,2, lbl_finecal);      
        anim.jButtonYUp(250, 200, 30, 2, btn_books);
        anim.jButtonYUp(380, 330, 30, 2, btn_details);
        anim.jButtonYUp(380, 330, 30, 2, btn_fincal);
        anim.jButtonYUp(250, 200, 30, 2, btn_members);
        
        anim.jLabelXRight(210,270, 30, 2, lbl_welcome);
        anim.jLabelXLeft(440, 380, 30, 2, lbl_user);
        
        anim.jLabelXLeft(160,90, 30, 2, lbl_btndashboard);
        anim.jLabelXRight(0, 40, 30, 2, lbl_icondashboard);
        
        anim.jLabelXLeft(160,90, 30, 2, lbl_btndatabase);
        anim.jLabelXRight(0, 40, 30, 2, lbl_icondatabase);
        
        anim.jLabelXLeft(160,90, 30, 2, lbl_btndatabase1);
        anim.jLabelXRight(0, 40, 30, 2, lbl_icondatabase1);
        
        anim.jLabelXLeft(160,90, 30, 2, lbl_btnuser);
        anim.jLabelXRight(0, 40, 30, 2, lbl_iconuser);
        
        anim.jLabelXLeft(160,90, 30, 2, lbl_btnaboutus);
        anim.jLabelXRight(0, 40, 30, 2, lbl_iconaboutus);
        
        
        bookspnl =new Books();
        memberpnl = new Members();
        detailspnl = new Details();
        finecalpnl = new Fine_Calculation();
        booktranspnl = new Book_Transactions();
        dbpnl = new Database();
        userpnl = new User();
        aboutuspnl = new Aboutus();
        BKLocation = new Book_Location();
        
        pnl_all.setLayout(layout);
        
        
        
        //Books panel
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        pnl_all.add(bookspnl,c);
        
        //Members panel
        GridBagConstraints m = new GridBagConstraints();
        m.gridx = 0;
        m.gridy = 0;
        pnl_all.add(memberpnl,m);
        
        //Details panel
        GridBagConstraints d = new GridBagConstraints();
        d.gridx = 0;
        d.gridy = 0;
        pnl_all.add(detailspnl,d);
        
        //Fine_Calculation panel
        GridBagConstraints fc = new GridBagConstraints();
        fc.gridx = 0;
        fc.gridy = 0;
        pnl_all.add(finecalpnl,fc);
        
        //Book_Transactions panel
        GridBagConstraints bt = new GridBagConstraints();
        bt.gridx = 0;
        bt.gridy = 0;
        pnl_all.add(booktranspnl,bt);
        
        //Database panel
        GridBagConstraints db = new GridBagConstraints();
        db.gridx = 0;
        db.gridy = 0;
        pnl_all.add(dbpnl,db);
        
        //User panel
        GridBagConstraints u = new GridBagConstraints();
        u.gridx = 0;
        u.gridy = 0;
        pnl_all.add(userpnl,u);
        
        //About Us panel
        GridBagConstraints as = new GridBagConstraints();
        as.gridx = 0;
        as.gridy = 0;
        pnl_all.add(aboutuspnl,as);
        
        //Book Location
        GridBagConstraints bkl = new GridBagConstraints();
        bkl.gridx = 0;
        bkl.gridy = 0;
        pnl_all.add(BKLocation,bkl);
        
        
        
        
        //startup panel settings 
        pnl_Dashboard.setVisible(true);
        pnl_all.setVisible(false);
        bookspnl.setVisible(false);
        memberpnl.setVisible(false);
        finecalpnl.setVisible(false);
        detailspnl.setVisible(false);
        booktranspnl.setVisible(false);
        dbpnl.setVisible(false);
        userpnl.setVisible(false);
        aboutuspnl.setVisible(false);
        BKLocation.setVisible(false);
    }
    
    
    public void counmembers(){
        
        try {
            
            String selectq="select count(Member_ID) from members";
            pst = conn.prepareStatement(selectq);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String sum=rs.getString("count(Member_ID)");
                lbl_member_count.setText(sum);
            }
            
            
        } catch (Exception e) {
        
        }
    }
    
    public void countbooks(){
        
        try {
            
            String selectq="select count(ISBN) from books";
            pst = conn.prepareStatement(selectq);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String sum=rs.getString("count(ISBN)");
                lbl_bookcount.setText(sum);
            }
            
            
        } catch (Exception e) {
        
        }
    }
    
    
    private void initialize(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/icon.png")));
    }
    
    void showData() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        lbl_date1.setText(s.format(d));
    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
        lbl_time.setText(s.format(d)); 
            }

        }
        ).start();
    }
    
    public boolean val;
    void setColor(JPanel panel){
        panel.setBackground(new Color(65,152,196)); 
        val=true;
    }
    
    void resetColor(JPanel panel){
        panel.setBackground(new Color(0,85,127)); 
        val=false;
    }
    
    void EnteredColor(JPanel panel){
        panel.setBackground(new Color(0,57,86));
    }
    
    
    
    public void buttoned(){
        
        //lbl_user.setText(String.valueOf(Library.lib).toString());
        
        String comval;
        comval = String.valueOf(Library.comboval).toString();
        if(comval.equals("Admin")){
            
            btn_Database.setVisible(true);
            pnl_disableDB.setVisible(false);
            
            
            btn_members.setEnabled(true);
            btn_books.setEnabled(true);
            btn_booktransaction.setEnabled(true);
            //btn_User.setLocation(btn_Dashboard.getLocation().x, btn_Dashboard.getLocation().y-30);
            //btn_user.setVisible(true);
        }
        
        else{
            
            btn_Database.setVisible(false);
            pnl_disableDB.setVisible(true);
            pnl_disableDB.setToolTipText("Administration access only");
            btn_members.setEnabled(false);
            btn_members.setToolTipText("Administration access only");
            btn_books.setEnabled(false);
            btn_books.setToolTipText("Administration access only");
            btn_booktransaction.setEnabled(false);
            btn_booktransaction.setToolTipText("Administration access only");
            
            //btn_user.setVisible(false);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_Dashboard = new javax.swing.JPanel();
        lbl_icondashboard = new javax.swing.JLabel();
        lbl_btndashboard = new javax.swing.JLabel();
        pnl_disableDB = new javax.swing.JPanel();
        lbl_btndatabase1 = new javax.swing.JLabel();
        lbl_icondatabase1 = new javax.swing.JLabel();
        btn_Database = new javax.swing.JPanel();
        lbl_icondatabase = new javax.swing.JLabel();
        lbl_btndatabase = new javax.swing.JLabel();
        btn_User = new javax.swing.JPanel();
        lbl_iconuser = new javax.swing.JLabel();
        lbl_btnuser = new javax.swing.JLabel();
        btn_AboutUs = new javax.swing.JPanel();
        lbl_btnaboutus = new javax.swing.JLabel();
        lbl_iconaboutus = new javax.swing.JLabel();
        pnl_top = new javax.swing.JPanel();
        lbl_Exit = new javax.swing.JLabel();
        lbl_date1 = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_welcome = new javax.swing.JLabel();
        lbl_Minimize = new javax.swing.JLabel();
        pnl_Dashboard = new javax.swing.JPanel();
        btn_bklocation = new javax.swing.JButton();
        lbl_copyright = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        lbl_dashicon = new javax.swing.JLabel();
        lbl_logout = new javax.swing.JLabel();
        btn_fincal = new javax.swing.JButton();
        btn_books = new javax.swing.JButton();
        btn_members = new javax.swing.JButton();
        btn_details = new javax.swing.JButton();
        lbl_members = new javax.swing.JLabel();
        lbl_finecal = new javax.swing.JLabel();
        lbl_details = new javax.swing.JLabel();
        lbl_books = new javax.swing.JLabel();
        lbl_book = new javax.swing.JLabel();
        lbl_Dashboard1 = new javax.swing.JLabel();
        lbl_bookcount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_member_count = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_booktransaction = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        plexus = new javax.swing.JLabel();
        pnl_all = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 85, 127));
        jPanel1.setPreferredSize(new java.awt.Dimension(238, 595));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/main menu logo2.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 270, 170));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 270, 180));

        btn_Dashboard.setBackground(new java.awt.Color(65, 152, 196));
        btn_Dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_DashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_DashboardMouseExited(evt);
            }
        });
        btn_Dashboard.setLayout(null);

        lbl_icondashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bar-chart.png"))); // NOI18N
        btn_Dashboard.add(lbl_icondashboard);
        lbl_icondashboard.setBounds(0, 0, 40, 40);

        lbl_btndashboard.setBackground(new java.awt.Color(255, 255, 255));
        lbl_btndashboard.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_btndashboard.setForeground(new java.awt.Color(255, 255, 255));
        lbl_btndashboard.setText("Dashboard");
        btn_Dashboard.add(lbl_btndashboard);
        lbl_btndashboard.setBounds(160, 10, 110, 20);

        jPanel1.add(btn_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 270, 40));

        pnl_disableDB.setBackground(new java.awt.Color(194, 194, 194));
        pnl_disableDB.setLayout(null);

        lbl_btndatabase1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_btndatabase1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_btndatabase1.setForeground(new java.awt.Color(134, 134, 134));
        lbl_btndatabase1.setText("Database");
        pnl_disableDB.add(lbl_btndatabase1);
        lbl_btndatabase1.setBounds(160, 10, 110, 20);

        lbl_icondatabase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/databasegrayy.png"))); // NOI18N
        pnl_disableDB.add(lbl_icondatabase1);
        lbl_icondatabase1.setBounds(0, 0, 40, 40);

        jPanel1.add(pnl_disableDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 270, 40));

        btn_Database.setBackground(new java.awt.Color(0, 85, 127));
        btn_Database.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DatabaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_DatabaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_DatabaseMouseExited(evt);
            }
        });
        btn_Database.setLayout(null);

        lbl_icondatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/database.png"))); // NOI18N
        btn_Database.add(lbl_icondatabase);
        lbl_icondatabase.setBounds(0, 0, 40, 40);

        lbl_btndatabase.setBackground(new java.awt.Color(255, 255, 255));
        lbl_btndatabase.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_btndatabase.setForeground(new java.awt.Color(255, 255, 255));
        lbl_btndatabase.setText("Database");
        btn_Database.add(lbl_btndatabase);
        lbl_btndatabase.setBounds(160, 10, 110, 20);

        jPanel1.add(btn_Database, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 270, 40));

        btn_User.setBackground(new java.awt.Color(0, 85, 127));
        btn_User.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_UserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_UserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_UserMouseExited(evt);
            }
        });
        btn_User.setLayout(null);

        lbl_iconuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/userbtn.png"))); // NOI18N
        btn_User.add(lbl_iconuser);
        lbl_iconuser.setBounds(0, 0, 40, 40);

        lbl_btnuser.setBackground(new java.awt.Color(255, 255, 255));
        lbl_btnuser.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_btnuser.setForeground(new java.awt.Color(255, 255, 255));
        lbl_btnuser.setText("User");
        btn_User.add(lbl_btnuser);
        lbl_btnuser.setBounds(160, 10, 110, 20);

        jPanel1.add(btn_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 270, 40));

        btn_AboutUs.setBackground(new java.awt.Color(0, 85, 127));
        btn_AboutUs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_AboutUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AboutUsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_AboutUsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_AboutUsMouseExited(evt);
            }
        });
        btn_AboutUs.setLayout(null);

        lbl_btnaboutus.setBackground(new java.awt.Color(255, 255, 255));
        lbl_btnaboutus.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_btnaboutus.setForeground(new java.awt.Color(255, 255, 255));
        lbl_btnaboutus.setText("About Us");
        btn_AboutUs.add(lbl_btnaboutus);
        lbl_btnaboutus.setBounds(160, 10, 110, 20);

        lbl_iconaboutus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/group.png"))); // NOI18N
        btn_AboutUs.add(lbl_iconaboutus);
        lbl_iconaboutus.setBounds(0, 0, 40, 40);

        jPanel1.add(btn_AboutUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 270, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 270, 590));

        pnl_top.setBackground(new java.awt.Color(14, 22, 33));
        pnl_top.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        pnl_top.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnl_topMouseDragged(evt);
            }
        });
        pnl_top.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_topMousePressed(evt);
            }
        });
        pnl_top.setLayout(null);

        lbl_Exit.setBackground(new java.awt.Color(0, 81, 146));
        lbl_Exit.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_Exit.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Exit.setText("X");
        lbl_Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ExitMouseClicked(evt);
            }
        });
        pnl_top.add(lbl_Exit);
        lbl_Exit.setBounds(1170, 10, 20, 30);

        lbl_date1.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        lbl_date1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_date1.setText("Date");
        pnl_top.add(lbl_date1);
        lbl_date1.setBounds(940, 0, 190, 50);

        lbl_user.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(255, 255, 255));
        lbl_user.setText("user");
        pnl_top.add(lbl_user);
        lbl_user.setBounds(440, 0, 240, 50);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Solace Library");
        pnl_top.add(jLabel13);
        jLabel13.setBounds(10, 0, 150, 50);

        lbl_welcome.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbl_welcome.setForeground(new java.awt.Color(255, 255, 255));
        lbl_welcome.setText("Welcome:");
        pnl_top.add(lbl_welcome);
        lbl_welcome.setBounds(210, 0, 110, 50);

        lbl_Minimize.setBackground(new java.awt.Color(0, 81, 146));
        lbl_Minimize.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        lbl_Minimize.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Minimize.setText("-");
        lbl_Minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_MinimizeMouseClicked(evt);
            }
        });
        pnl_top.add(lbl_Minimize);
        lbl_Minimize.setBounds(1140, 10, 20, 31);

        getContentPane().add(pnl_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 50));

        pnl_Dashboard.setBackground(new java.awt.Color(242, 242, 242));
        pnl_Dashboard.setLayout(null);

        btn_bklocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnbooklocation.png"))); // NOI18N
        btn_bklocation.setBorder(null);
        btn_bklocation.setBorderPainted(false);
        btn_bklocation.setContentAreaFilled(false);
        btn_bklocation.setDefaultCapable(false);
        btn_bklocation.setDoubleBuffered(true);
        btn_bklocation.setFocusable(false);
        btn_bklocation.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/solace/library/btnbooklocation balck.png"))); // NOI18N
        btn_bklocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bklocationActionPerformed(evt);
            }
        });
        pnl_Dashboard.add(btn_bklocation);
        btn_bklocation.setBounds(550, 70, 60, 70);

        lbl_copyright.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lbl_copyright.setForeground(new java.awt.Color(105, 105, 105));
        lbl_copyright.setText("COPYRIGHT ©  SINHALION");
        pnl_Dashboard.add(lbl_copyright);
        lbl_copyright.setBounds(770, 570, 160, 20);

        lbl_time.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        lbl_time.setForeground(new java.awt.Color(105, 105, 105));
        lbl_time.setText("Time");
        pnl_Dashboard.add(lbl_time);
        lbl_time.setBounds(390, 20, 350, 26);

        lbl_dashicon.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_dashicon.setForeground(new java.awt.Color(105, 105, 105));
        lbl_dashicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bar-chartgray 2.png"))); // NOI18N
        pnl_Dashboard.add(lbl_dashicon);
        lbl_dashicon.setBounds(10, 10, 40, 40);

        lbl_logout.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(105, 105, 105));
        lbl_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        lbl_logout.setText("Logout");
        lbl_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });
        pnl_Dashboard.add(lbl_logout);
        lbl_logout.setBounds(850, 10, 80, 30);

        btn_fincal.setBackground(new java.awt.Color(251, 250, 249));
        btn_fincal.setForeground(new java.awt.Color(251, 250, 249));
        btn_fincal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnfinecal.png"))); // NOI18N
        btn_fincal.setBorder(null);
        btn_fincal.setBorderPainted(false);
        btn_fincal.setContentAreaFilled(false);
        btn_fincal.setDefaultCapable(false);
        btn_fincal.setDoubleBuffered(true);
        btn_fincal.setFocusable(false);
        btn_fincal.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnfinecal.png"))); // NOI18N
        btn_fincal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnfinecal_mouseover.png"))); // NOI18N
        btn_fincal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_fincalMouseClicked(evt);
            }
        });
        pnl_Dashboard.add(btn_fincal);
        btn_fincal.setBounds(290, 380, 90, 90);

        btn_books.setBackground(new java.awt.Color(251, 250, 249));
        btn_books.setForeground(new java.awt.Color(251, 250, 249));
        btn_books.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnbook.png"))); // NOI18N
        btn_books.setBorder(null);
        btn_books.setBorderPainted(false);
        btn_books.setContentAreaFilled(false);
        btn_books.setDefaultCapable(false);
        btn_books.setDoubleBuffered(true);
        btn_books.setFocusable(false);
        btn_books.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnbook.png"))); // NOI18N
        btn_books.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnbook_musepress.png"))); // NOI18N
        btn_books.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_booksActionPerformed(evt);
            }
        });
        pnl_Dashboard.add(btn_books);
        btn_books.setBounds(290, 250, 90, 90);

        btn_members.setBackground(new java.awt.Color(251, 250, 249));
        btn_members.setForeground(new java.awt.Color(251, 250, 249));
        btn_members.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnmember.png"))); // NOI18N
        btn_members.setBorder(null);
        btn_members.setBorderPainted(false);
        btn_members.setContentAreaFilled(false);
        btn_members.setDefaultCapable(false);
        btn_members.setDoubleBuffered(true);
        btn_members.setFocusable(false);
        btn_members.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnmember.png"))); // NOI18N
        btn_members.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnmember_mouseover.png"))); // NOI18N
        btn_members.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_membersActionPerformed(evt);
            }
        });
        pnl_Dashboard.add(btn_members);
        btn_members.setBounds(530, 250, 90, 90);

        btn_details.setBackground(new java.awt.Color(251, 250, 249));
        btn_details.setForeground(new java.awt.Color(251, 250, 249));
        btn_details.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btndetails.png"))); // NOI18N
        btn_details.setBorder(null);
        btn_details.setBorderPainted(false);
        btn_details.setContentAreaFilled(false);
        btn_details.setDefaultCapable(false);
        btn_details.setDoubleBuffered(true);
        btn_details.setFocusable(false);
        btn_details.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btndetails.png"))); // NOI18N
        btn_details.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btndetails_mouseover.png"))); // NOI18N
        btn_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_detailsMouseClicked(evt);
            }
        });
        pnl_Dashboard.add(btn_details);
        btn_details.setBounds(530, 380, 90, 90);

        lbl_members.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        lbl_members.setForeground(new java.awt.Color(105, 105, 105));
        lbl_members.setText("Members");
        pnl_Dashboard.add(lbl_members);
        lbl_members.setBounds(540, 340, 70, 30);

        lbl_finecal.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        lbl_finecal.setForeground(new java.awt.Color(105, 105, 105));
        lbl_finecal.setText("Fine Calculation");
        pnl_Dashboard.add(lbl_finecal);
        lbl_finecal.setBounds(280, 470, 130, 30);

        lbl_details.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        lbl_details.setForeground(new java.awt.Color(105, 105, 105));
        lbl_details.setText("Details");
        pnl_Dashboard.add(lbl_details);
        lbl_details.setBounds(550, 470, 60, 30);

        lbl_books.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        lbl_books.setForeground(new java.awt.Color(105, 105, 105));
        lbl_books.setText("Books");
        pnl_Dashboard.add(lbl_books);
        lbl_books.setBounds(310, 340, 70, 30);

        lbl_book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book-hi1.png"))); // NOI18N
        pnl_Dashboard.add(lbl_book);
        lbl_book.setBounds(210, 200, 490, 370);

        lbl_Dashboard1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_Dashboard1.setForeground(new java.awt.Color(105, 105, 105));
        lbl_Dashboard1.setText("Dashboard");
        pnl_Dashboard.add(lbl_Dashboard1);
        lbl_Dashboard1.setBounds(50, 20, 110, 20);

        lbl_bookcount.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbl_bookcount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gif-load (2).gif"))); // NOI18N
        lbl_bookcount.setText("1");
        lbl_bookcount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnl_Dashboard.add(lbl_bookcount);
        lbl_bookcount.setBounds(40, 290, 120, 130);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Number of Books");
        pnl_Dashboard.add(jLabel3);
        jLabel3.setBounds(30, 270, 160, 30);

        lbl_member_count.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbl_member_count.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gif-load.gif"))); // NOI18N
        lbl_member_count.setText("1");
        lbl_member_count.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnl_Dashboard.add(lbl_member_count);
        lbl_member_count.setBounds(770, 290, 120, 130);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(105, 105, 105));
        jLabel5.setText("Number of members");
        pnl_Dashboard.add(jLabel5);
        jLabel5.setBounds(730, 270, 200, 30);

        btn_booktransaction.setBackground(new java.awt.Color(242, 242, 242));
        btn_booktransaction.setForeground(new java.awt.Color(242, 242, 242));
        btn_booktransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnbooktransaction.png"))); // NOI18N
        btn_booktransaction.setBorder(null);
        btn_booktransaction.setBorderPainted(false);
        btn_booktransaction.setContentAreaFilled(false);
        btn_booktransaction.setDefaultCapable(false);
        btn_booktransaction.setDoubleBuffered(true);
        btn_booktransaction.setFocusable(false);
        btn_booktransaction.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/btnbooktransaction.png"))); // NOI18N
        btn_booktransaction.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/puls2.gif"))); // NOI18N
        btn_booktransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_booktransactionActionPerformed(evt);
            }
        });
        pnl_Dashboard.add(btn_booktransaction);
        btn_booktransaction.setBounds(310, 70, 60, 60);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(105, 105, 105));
        jLabel8.setText("Book Location");
        pnl_Dashboard.add(jLabel8);
        jLabel8.setBounds(530, 130, 110, 20);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(105, 105, 105));
        jLabel7.setText("Book Transactions");
        pnl_Dashboard.add(jLabel7);
        jLabel7.setBounds(280, 130, 130, 20);

        plexus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plexus.gif"))); // NOI18N
        pnl_Dashboard.add(plexus);
        plexus.setBounds(0, 0, 930, 590);

        getContentPane().add(pnl_Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 930, 590));

        pnl_all.setBackground(new java.awt.Color(242, 242, 242));
        getContentPane().add(pnl_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 930, 590));

        setSize(new java.awt.Dimension(1200, 641));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_ExitMouseClicked

    private void pnl_topMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_topMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_pnl_topMousePressed

    private void pnl_topMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_topMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_pnl_topMouseDragged

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        Login ll = new Login();
        ll.show(true);
        this.dispose();
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void btn_DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DashboardMouseClicked
       
        
        setColor(btn_Dashboard);
        resetColor(btn_Database);
        resetColor(btn_AboutUs);
        resetColor(btn_User);
        
        pnl_Dashboard.setVisible(true);
        pnl_all.setVisible(false);
        bookspnl.setVisible(false);
        memberpnl.setVisible(false);
        finecalpnl.setVisible(false);
        detailspnl.setVisible(false);
        booktranspnl.setVisible(false);
        dbpnl.setVisible(false);
        userpnl.setVisible(false);
        aboutuspnl.setVisible(false);
        BKLocation.setVisible(false);
        counmembers();
        countbooks();
        
    }//GEN-LAST:event_btn_DashboardMouseClicked

    private void btn_DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DashboardMouseEntered
        EnteredColor(btn_Dashboard);
        resetColor(btn_AboutUs);
        resetColor(btn_Database);
        resetColor(btn_User);
        
    }//GEN-LAST:event_btn_DashboardMouseEntered

    private void btn_DashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DashboardMouseExited
        if(val=false){
            resetColor(btn_Dashboard);
        }
       /* else{
            setColor(btn_Dashboard);
        }*/
    }//GEN-LAST:event_btn_DashboardMouseExited

    private void btn_DatabaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DatabaseMouseClicked
        setColor(btn_Database);
        resetColor(btn_Dashboard);
        resetColor(btn_AboutUs);
        resetColor(btn_User);
        
        
        dbpnl.setVisible(true);
        pnl_all.setVisible(true);
        bookspnl.setVisible(false);
        memberpnl.setVisible(false);
        finecalpnl.setVisible(false);
        detailspnl.setVisible(false);
        booktranspnl.setVisible(false);
        pnl_Dashboard.setVisible(false);
        userpnl.setVisible(false);
        aboutuspnl.setVisible(false);
        BKLocation.setVisible(false);
        
        
    }//GEN-LAST:event_btn_DatabaseMouseClicked

    private void btn_DatabaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DatabaseMouseEntered
        EnteredColor(btn_Database);
        resetColor(btn_AboutUs);
        resetColor(btn_Dashboard);
        resetColor(btn_User);
    }//GEN-LAST:event_btn_DatabaseMouseEntered

    private void btn_DatabaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DatabaseMouseExited
        if(val=false){
            resetColor(btn_Database);
        }
       /* else{
            setColor(btn_Database);
        }*/
    }//GEN-LAST:event_btn_DatabaseMouseExited

    private void btn_UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UserMouseClicked
        setColor(btn_User);
        resetColor(btn_Dashboard);
        resetColor(btn_AboutUs);
        resetColor(btn_Database);
        
        pnl_Dashboard.setVisible(false);
        pnl_all.setVisible(true);
        bookspnl.setVisible(false);
        memberpnl.setVisible(false);
        finecalpnl.setVisible(false);
        detailspnl.setVisible(false);
        booktranspnl.setVisible(false);
        dbpnl.setVisible(false);
        userpnl.setVisible(true);
        aboutuspnl.setVisible(false);
        BKLocation.setVisible(false);
    }//GEN-LAST:event_btn_UserMouseClicked

    private void btn_UserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UserMouseEntered
        EnteredColor(btn_User);
        resetColor(btn_AboutUs);
        resetColor(btn_Dashboard);
        resetColor(btn_Database);
    }//GEN-LAST:event_btn_UserMouseEntered

    private void btn_UserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UserMouseExited
        if(val=false){
            resetColor(btn_User);
        }
       /* else{
            setColor(btn_User);
        }*/
    }//GEN-LAST:event_btn_UserMouseExited

    private void btn_AboutUsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AboutUsMouseClicked
        setColor(btn_AboutUs);      
        resetColor(btn_Dashboard);
        resetColor(btn_User);
        resetColor(btn_Database); 
        
        pnl_Dashboard.setVisible(false);
        pnl_all.setVisible(true);
        bookspnl.setVisible(false);
        memberpnl.setVisible(false);
        finecalpnl.setVisible(false);
        detailspnl.setVisible(false);
        booktranspnl.setVisible(false);
        dbpnl.setVisible(false);
        userpnl.setVisible(false);
        aboutuspnl.setVisible(true);
        BKLocation.setVisible(false);
    }//GEN-LAST:event_btn_AboutUsMouseClicked

    private void btn_AboutUsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AboutUsMouseEntered
       
           EnteredColor(btn_AboutUs);
           resetColor(btn_User);
        resetColor(btn_Dashboard);
        resetColor(btn_Database);
    
    }//GEN-LAST:event_btn_AboutUsMouseEntered

    private void btn_AboutUsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AboutUsMouseExited
        if(val=false){
            resetColor(btn_AboutUs);
        }
        /*else{
            setColor(btn_AboutUs);
        }*/
    }//GEN-LAST:event_btn_AboutUsMouseExited

    private void btn_fincalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fincalMouseClicked
        pnl_all.setVisible(true);
        finecalpnl.setVisible(true);
        memberpnl.setVisible(false);
        bookspnl.setVisible(false);
        pnl_Dashboard.setVisible(false);
        detailspnl.setVisible(false);
        booktranspnl.setVisible(false);
        dbpnl.setVisible(false);
        userpnl.setVisible(false);
        aboutuspnl.setVisible(false);
        BKLocation.setVisible(false);
    }//GEN-LAST:event_btn_fincalMouseClicked

    private void btn_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_detailsMouseClicked
        pnl_all.setVisible(true);
        finecalpnl.setVisible(false);
        memberpnl.setVisible(false);
        bookspnl.setVisible(false);
        pnl_Dashboard.setVisible(false);
        detailspnl.setVisible(true);
        booktranspnl.setVisible(false);
        dbpnl.setVisible(false);
        userpnl.setVisible(false);
        aboutuspnl.setVisible(false);
        BKLocation.setVisible(false);
    }//GEN-LAST:event_btn_detailsMouseClicked

    private void lbl_MinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_MinimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_lbl_MinimizeMouseClicked

    private void btn_membersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_membersActionPerformed
         pnl_all.setVisible(true);
        memberpnl.setVisible(true);
        bookspnl.setVisible(false);
        pnl_Dashboard.setVisible(false);
        finecalpnl.setVisible(false);
        detailspnl.setVisible(false);
        booktranspnl.setVisible(false);
        dbpnl.setVisible(false);
        userpnl.setVisible(false);
        aboutuspnl.setVisible(false);
        BKLocation.setVisible(false);
    }//GEN-LAST:event_btn_membersActionPerformed

    private void btn_booksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_booksActionPerformed
        
        
        pnl_all.setVisible(true);
        bookspnl.setVisible(true);
        pnl_Dashboard.setVisible(false);
        memberpnl.setVisible(false);
        finecalpnl.setVisible(false);
        detailspnl.setVisible(false);
        booktranspnl.setVisible(false);
        dbpnl.setVisible(false);
        userpnl.setVisible(false);
        aboutuspnl.setVisible(false);
        BKLocation.setVisible(false);
    }//GEN-LAST:event_btn_booksActionPerformed

    private void btn_booktransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_booktransactionActionPerformed
        pnl_all.setVisible(true);
        finecalpnl.setVisible(false);
        memberpnl.setVisible(false);
        bookspnl.setVisible(false);
        pnl_Dashboard.setVisible(false);
        detailspnl.setVisible(false);
        booktranspnl.setVisible(true);
        dbpnl.setVisible(false);
        userpnl.setVisible(false);
        aboutuspnl.setVisible(false);
        BKLocation.setVisible(false);
    }//GEN-LAST:event_btn_booktransactionActionPerformed

    private void btn_bklocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bklocationActionPerformed
        
        pnl_all.setVisible(true);
        finecalpnl.setVisible(false);
        memberpnl.setVisible(false);
        bookspnl.setVisible(false);
        pnl_Dashboard.setVisible(false);
        detailspnl.setVisible(false);
        booktranspnl.setVisible(false);
        dbpnl.setVisible(false);
        userpnl.setVisible(false);
        aboutuspnl.setVisible(false);
        BKLocation.setVisible(true);
    }//GEN-LAST:event_btn_bklocationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_AboutUs;
    private javax.swing.JPanel btn_Dashboard;
    private javax.swing.JPanel btn_Database;
    private javax.swing.JPanel btn_User;
    private javax.swing.JButton btn_bklocation;
    private javax.swing.JButton btn_books;
    private javax.swing.JButton btn_booktransaction;
    private javax.swing.JButton btn_details;
    private javax.swing.JButton btn_fincal;
    private javax.swing.JButton btn_members;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_Dashboard1;
    private javax.swing.JLabel lbl_Exit;
    private javax.swing.JLabel lbl_Minimize;
    private javax.swing.JLabel lbl_book;
    private javax.swing.JLabel lbl_bookcount;
    private javax.swing.JLabel lbl_books;
    private javax.swing.JLabel lbl_btnaboutus;
    private javax.swing.JLabel lbl_btndashboard;
    private javax.swing.JLabel lbl_btndatabase;
    private javax.swing.JLabel lbl_btndatabase1;
    private javax.swing.JLabel lbl_btnuser;
    private javax.swing.JLabel lbl_copyright;
    private javax.swing.JLabel lbl_dashicon;
    private javax.swing.JLabel lbl_date1;
    private javax.swing.JLabel lbl_details;
    private javax.swing.JLabel lbl_finecal;
    private javax.swing.JLabel lbl_iconaboutus;
    private javax.swing.JLabel lbl_icondashboard;
    private javax.swing.JLabel lbl_icondatabase;
    private javax.swing.JLabel lbl_icondatabase1;
    private javax.swing.JLabel lbl_iconuser;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_member_count;
    private javax.swing.JLabel lbl_members;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JLabel lbl_welcome;
    private javax.swing.JLabel plexus;
    private javax.swing.JPanel pnl_Dashboard;
    private javax.swing.JPanel pnl_all;
    private javax.swing.JPanel pnl_disableDB;
    private javax.swing.JPanel pnl_top;
    // End of variables declaration//GEN-END:variables
}
