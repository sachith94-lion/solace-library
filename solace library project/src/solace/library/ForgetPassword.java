/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solace.library;

import AppPackage.AnimationClass;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author sachith
 */
public class ForgetPassword extends javax.swing.JFrame {

    /**
     * Creates new form ForgetPassword
     */
    
    
    int xMouse;
    int yMouse;
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
    
    public void anime(){
        AnimationClass anim = new AnimationClass();
        anim.jLabelYUp(70,30, 20, 2, lbl_findT);
        anim.jLabelYUp(100,60, 20, 2, lbl_pleaseT);
        anim.jLabelXRight(10,90, 26, 2, lbl_idno);
        anim.jTextFieldXRight(10,90, 24, 2, txt_idno);
        anim.jLabelXRight(10,90, 22, 2, lbl_email);
        anim.jTextFieldXRight(10,90, 20, 2, txt_email);
        anim.jButtonXRight(30, 110, 18, 2, btn_findacc);
        
        con = DBconnection.connect();
    }
    
    
    public ForgetPassword() {
        initComponents();
        anime();
        initialize();
        txt_confirmnpw.setEditable(false);
        txt_newpw1.setEditable(false);
        
    }
    
    public boolean val;
    
      void setColor(JPasswordField PasswordField){
        PasswordField.setBackground(new Color(220, 77, 65)); 
        val=true;
    }
      void resetColor(JPasswordField PasswordField){
        PasswordField.setBackground(new Color(255,255,255)); 
        val=true;
    }

    private void initialize(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/icon.png")));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pln_main = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbl_username = new javax.swing.JLabel();
        txt_verification = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_getV = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btn_resetpw = new javax.swing.JButton();
        txt_confirmnpw = new javax.swing.JPasswordField();
        txt_newpw1 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        lbl_findT = new javax.swing.JLabel();
        lbl_pleaseT = new javax.swing.JLabel();
        lbl_idno = new javax.swing.JLabel();
        txt_idno = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        btn_findacc = new javax.swing.JButton();
        lbl_back = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_Exit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pln_main.setBackground(new java.awt.Color(255, 255, 255));
        pln_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_username.setBackground(new java.awt.Color(30, 25, 24));
        lbl_username.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(30, 25, 24));
        jPanel3.add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 80, 30));

        txt_verification.setBackground(new java.awt.Color(255, 255, 255));
        txt_verification.setForeground(new java.awt.Color(0, 85, 127));
        txt_verification.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 85, 127), 2));
        txt_verification.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_verificationKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_verificationKeyReleased(evt);
            }
        });
        jPanel3.add(txt_verification, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 190, 30));

        jLabel8.setBackground(new java.awt.Color(30, 25, 24));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 25, 24));
        jLabel8.setText("New Password:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 120, 30));

        btn_getV.setBackground(new java.awt.Color(255, 255, 255));
        btn_getV.setForeground(new java.awt.Color(0, 85, 127));
        btn_getV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/verification code.png"))); // NOI18N
        btn_getV.setText("get verification code");
        btn_getV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_getVMouseClicked(evt);
            }
        });
        jPanel3.add(btn_getV, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 200, 40));

        jLabel9.setBackground(new java.awt.Color(30, 25, 24));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 25, 24));
        jLabel9.setText("Verification Code:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 130, 30));

        jLabel10.setBackground(new java.awt.Color(30, 25, 24));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 25, 24));
        jLabel10.setText("Username:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 80, 30));

        jLabel5.setBackground(new java.awt.Color(30, 25, 24));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 25, 24));
        jLabel5.setText("Reset your password using the verification method below.");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 400, 70));

        btn_back.setBackground(new java.awt.Color(255, 255, 255));
        btn_back.setForeground(new java.awt.Color(0, 85, 127));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back-arrow.png"))); // NOI18N
        btn_back.setText("Back");
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
        });
        jPanel3.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 170, 40));

        jLabel12.setBackground(new java.awt.Color(30, 25, 24));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 25, 24));
        jLabel12.setText("Confirm New Password:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 160, 30));

        btn_resetpw.setBackground(new java.awt.Color(255, 255, 255));
        btn_resetpw.setForeground(new java.awt.Color(0, 85, 127));
        btn_resetpw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Reset password.png"))); // NOI18N
        btn_resetpw.setText("Reset Password");
        btn_resetpw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetpwMouseClicked(evt);
            }
        });
        jPanel3.add(btn_resetpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 170, 40));

        txt_confirmnpw.setBackground(new java.awt.Color(255, 255, 255));
        txt_confirmnpw.setForeground(new java.awt.Color(0, 85, 127));
        txt_confirmnpw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 85, 127), 2));
        txt_confirmnpw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_confirmnpwKeyReleased(evt);
            }
        });
        jPanel3.add(txt_confirmnpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 190, 30));

        txt_newpw1.setBackground(new java.awt.Color(255, 255, 255));
        txt_newpw1.setForeground(new java.awt.Color(0, 85, 127));
        txt_newpw1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 85, 127), 2));
        jPanel3.add(txt_newpw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 190, 30));

        pln_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 540, 430));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        lbl_findT.setBackground(new java.awt.Color(30, 25, 24));
        lbl_findT.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lbl_findT.setForeground(new java.awt.Color(30, 25, 24));
        lbl_findT.setText("First, Let's find your account ");
        jPanel2.add(lbl_findT);
        lbl_findT.setBounds(60, 70, 280, 50);

        lbl_pleaseT.setBackground(new java.awt.Color(30, 25, 24));
        lbl_pleaseT.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_pleaseT.setForeground(new java.awt.Color(30, 25, 24));
        lbl_pleaseT.setText("please enter your ID No and email");
        jPanel2.add(lbl_pleaseT);
        lbl_pleaseT.setBounds(60, 100, 260, 50);

        lbl_idno.setBackground(new java.awt.Color(30, 25, 24));
        lbl_idno.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        lbl_idno.setForeground(new java.awt.Color(30, 25, 24));
        lbl_idno.setText("ID No");
        jPanel2.add(lbl_idno);
        lbl_idno.setBounds(10, 130, 40, 30);

        txt_idno.setBackground(new java.awt.Color(255, 255, 255));
        txt_idno.setForeground(new java.awt.Color(0, 85, 127));
        txt_idno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 85, 127), 2));
        jPanel2.add(txt_idno);
        txt_idno.setBounds(10, 160, 190, 30);

        lbl_email.setBackground(new java.awt.Color(30, 25, 24));
        lbl_email.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(30, 25, 24));
        lbl_email.setText("Email");
        jPanel2.add(lbl_email);
        lbl_email.setBounds(10, 190, 40, 30);

        txt_email.setBackground(new java.awt.Color(255, 255, 255));
        txt_email.setForeground(new java.awt.Color(0, 85, 127));
        txt_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 85, 127), 2));
        jPanel2.add(txt_email);
        txt_email.setBounds(10, 220, 190, 30);

        btn_findacc.setBackground(new java.awt.Color(255, 255, 255));
        btn_findacc.setForeground(new java.awt.Color(0, 85, 127));
        btn_findacc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find.png"))); // NOI18N
        btn_findacc.setText("Find account");
        btn_findacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_findaccMouseClicked(evt);
            }
        });
        jPanel2.add(btn_findacc);
        btn_findacc.setBounds(30, 270, 150, 40);

        pln_main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 400, 430));

        lbl_back.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_back.setForeground(new java.awt.Color(30, 25, 24));
        lbl_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back-arrow.png"))); // NOI18N
        lbl_back.setText("Back");
        lbl_back.setToolTipText("");
        lbl_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_backMouseClicked(evt);
            }
        });
        pln_main.add(lbl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 70, -1));

        getContentPane().add(pln_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 550, 430));

        jPanel1.setBackground(new java.awt.Color(0, 85, 127));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Forget Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/key.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbl_Exit.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_Exit.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Exit.setText("X");
        lbl_Exit.setToolTipText("");
        lbl_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ExitMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 70));

        setSize(new java.awt.Dimension(544, 494));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseClicked
        Login ll = new Login();
        ll.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_lbl_backMouseClicked

    private void btn_findaccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_findaccMouseClicked
        
        
        
        try {
            String idno=txt_idno.getText();
            String email=txt_email.getText();
            
            
                
                String selectq="select username,email from users where (IDNo =? and email =?)";
            
            int count =0;
            
            pst=con.prepareStatement(selectq);
            
            pst.setString(1,idno);
           pst.setString(2,email);
           
           rs= pst.executeQuery();
            while(rs.next()){
               String un=rs.getString("username");
               String getemail=rs.getString("email");
                Library.ggetemail = getemail;
               
               lbl_username.setText(un);
               
               count = count+1;
           }
            
             
                 if(email.equals(String.valueOf(Library.ggetemail).toString())){
               if(count==1){
                jPanel2.setLocation(jPanel1.getLocation().x -380, jPanel1.getLocation().y);
                jPanel3.setLocation(jPanel1.getLocation().x - 5, jPanel1.getLocation().y);
                
            }
            
            else if(count>1){
                   JOptionPane.showMessageDialog(null,"Duplicate IDNo or Email Access denied");
                   }
            
            else{
               JOptionPane.showMessageDialog(null,"IDNo or Email is not correct");
           }  
            }
                
                 else if(txt_idno.getText().isEmpty() || txt_email.getText().isEmpty()){
                     
                     JOptionPane.showMessageDialog(null,"form is empty, please complete the form correctly.");
                 }        
            else{
                   JOptionPane.showMessageDialog(null,"IDNo or Email is not correct");
                   
                            
           }
                 
        } catch (Exception e) {
        }
        
        
        
        
    }//GEN-LAST:event_btn_findaccMouseClicked

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        
        jPanel2.setLocation(jPanel1.getLocation().x +80, jPanel1.getLocation().y);
        jPanel3.setLocation(jPanel1.getLocation().x +510, jPanel1.getLocation().y);
        lbl_username.setText("");
        txt_idno.setText("");
        txt_email.setText("");
        
        
        
        
        
    }//GEN-LAST:event_btn_backMouseClicked

    private void lbl_ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_ExitMouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void btn_getVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_getVMouseClicked
   
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.user", "sachithbassplayer@gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", 465);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false"); 
       
    char[] otp  = GenerateOTP.sendOTP(6);
        System.out.println(otp);
        
        String Vcode = String.valueOf(otp);
        Library.Vcodess= Vcode;
        
        
        try {

        String email=txt_email.getText();

                Session session = Session.getDefaultInstance(props, null);
                session.setDebug(true);
                MimeMessage message = new MimeMessage(session);
                message.setText("your Verification code is: "+Vcode );
                
                message.setSubject("Verification code for your account");
                message.setFrom(new InternetAddress("sachithbassplayer@gmail.com"));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.trim()));
                message.saveChanges();
                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", "sachithbassplayer@gmail.com", "bass@941234playerforAnY");
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
                System.out.println("Your password mailed to you");
                JOptionPane.showMessageDialog(null,"An email has been sent to your registered email address.\n" +
"Please enter the verification code included in that email.");
        } catch (Exception e) {
        }
        
        
       
    }//GEN-LAST:event_btn_getVMouseClicked

    private void txt_verificationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_verificationKeyReleased
        String Vcode= String.valueOf(Library.Vcodess);
        
        
        
        if(Vcode.equals(txt_verification.getText())){
            
            txt_confirmnpw.setEditable(true);
            txt_newpw1.setEditable(true);
            txt_verification.setEditable(false);
            
                JOptionPane.showMessageDialog(null,"Verification succeeded.");
            
            
        }
        
        else{
            txt_confirmnpw.setEditable(false);
            txt_newpw1.setEditable(false);
        }
        
    }//GEN-LAST:event_txt_verificationKeyReleased

    private void txt_verificationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_verificationKeyPressed
       /* String Vcode= String.valueOf(Library.Vcodess);
        
        System.out.println(Vcode);
        
        if(Vcode.equals(txt_verification.getText())){
            
            txt_confirmnpw.setEditable(true);
            txt_newpw1.setEditable(true);
        }
        
        else{
            txt_confirmnpw.setEditable(false);
            txt_newpw1.setEditable(false);
        }*/
    }//GEN-LAST:event_txt_verificationKeyPressed

    private void btn_resetpwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetpwMouseClicked
        
        if(txt_verification.getText().isEmpty() || txt_confirmnpw.getText().isEmpty() || txt_newpw1.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null,"please complete the form correctly.");
            
        }
        
        else if(!txt_confirmnpw.getText().equals(txt_newpw1.getText())){
            
            JOptionPane.showMessageDialog(null,"password is not match");
            setColor(txt_confirmnpw);
        }
        
        
        else{
        
        try {
            
            String newpw=txt_newpw1.getText();
            String Connewpw=txt_confirmnpw.getText();
            String un=lbl_username.getText();
            
            String sha1=encryption.SHA1(Connewpw);
        String sha512=encryption.SHA512(sha1);
        String md5=encryption.MD5(sha512);
            
            String sql= "update users set password='"+md5+"' where username='"+un+"'";
            
            pst=con.prepareStatement(sql);
                pst.execute();
                
                
        } catch (Exception e) {
        }
  
        txt_confirmnpw.setText("");
        txt_verification.setText("");
        txt_newpw1.setText("");
        
        JOptionPane.showMessageDialog(null,"Password Reset Succeeded.");
        Login ll = new Login();
        ll.setVisible(true);
        this.dispose();
    }
        
        
        
                
    }//GEN-LAST:event_btn_resetpwMouseClicked

    private void txt_confirmnpwKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_confirmnpwKeyReleased
        
        if(txt_confirmnpw.getText().equals(txt_newpw1.getText())){
            
            resetColor(txt_confirmnpw);
        }
    }//GEN-LAST:event_txt_confirmnpwKeyReleased

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
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_findacc;
    private javax.swing.JButton btn_getV;
    private javax.swing.JButton btn_resetpw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_Exit;
    private javax.swing.JLabel lbl_back;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_findT;
    private javax.swing.JLabel lbl_idno;
    private javax.swing.JLabel lbl_pleaseT;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPanel pln_main;
    private javax.swing.JPasswordField txt_confirmnpw;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_idno;
    private javax.swing.JPasswordField txt_newpw1;
    private javax.swing.JTextField txt_verification;
    // End of variables declaration//GEN-END:variables
}