/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solace.library;

import AppPackage.AnimationClass;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author sachith
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    int xMouse;
    int yMouse;
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Login() {
        initComponents();
        initialize();
        AnimationClass anim = new AnimationClass();
        anim.jLabelXRight(-30,20, 20, 2, lbl_login);
        anim.jLabelYUp(220,140, 13, 2, lbl_logo);
        anim.jLabelYUp(130,90, 30, 2, lbl_UN);
        anim.jLabelYUp(220,180, 30, 2, lbl_PW);
        anim.jLabelYUp(290,260, 30, 2, lbl_SP);
        anim.jButtonXRight(-90, 40, 10, 2, btn_FGPW);
        anim.jButtonXLeft(260, 180, 10, 2, btn_Login1);
        
        con = DBconnection.connect();
        //anim.jTextFieldYUp(201,120, 15, 2, txt_LogUN);
        
        resetT();
        
        
    }
    
    public void resetT(){
        txt_LogUN.setText("");
           txt_LogPW.setText("");
           cmb_Position.setSelectedIndex(0);
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

        jPanel1 = new javax.swing.JPanel();
        lbl_Exit = new javax.swing.JLabel();
        lbl_SP = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_UN = new javax.swing.JLabel();
        txt_LogUN = new javax.swing.JTextField();
        lbl_PW = new javax.swing.JLabel();
        txt_LogPW = new javax.swing.JPasswordField();
        cmb_Position = new javax.swing.JComboBox<>();
        btn_FGPW = new javax.swing.JButton();
        btn_Login1 = new javax.swing.JButton();
        lbl_login = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_SignUp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 85, 127));
        jPanel1.setPreferredSize(new java.awt.Dimension(313, 533));
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
        jPanel1.setLayout(null);

        lbl_Exit.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_Exit.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Exit.setText("X");
        lbl_Exit.setToolTipText("");
        lbl_Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ExitMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_Exit);
        lbl_Exit.setBounds(270, 0, 15, 31);

        lbl_SP.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_SP.setForeground(new java.awt.Color(255, 255, 255));
        lbl_SP.setText("Select Position:");
        lbl_SP.setToolTipText("");
        jPanel1.add(lbl_SP);
        lbl_SP.setBounds(20, 290, 132, 23);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 240, 257, 10);

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(20, 150, 257, 10);

        lbl_UN.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_UN.setForeground(new java.awt.Color(255, 255, 255));
        lbl_UN.setText("Username:");
        lbl_UN.setToolTipText("");
        jPanel1.add(lbl_UN);
        lbl_UN.setBounds(20, 130, 93, 23);

        txt_LogUN.setBackground(new java.awt.Color(0, 85, 127));
        txt_LogUN.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt_LogUN.setForeground(new java.awt.Color(255, 255, 255));
        txt_LogUN.setBorder(null);
        jPanel1.add(txt_LogUN);
        txt_LogUN.setBounds(20, 120, 260, 30);

        lbl_PW.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_PW.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PW.setText("Password:");
        lbl_PW.setToolTipText("");
        jPanel1.add(lbl_PW);
        lbl_PW.setBounds(20, 220, 86, 23);

        txt_LogPW.setBackground(new java.awt.Color(0, 85, 127));
        txt_LogPW.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt_LogPW.setForeground(new java.awt.Color(255, 255, 255));
        txt_LogPW.setBorder(null);
        jPanel1.add(txt_LogPW);
        txt_LogPW.setBounds(20, 210, 260, 30);

        cmb_Position.setBackground(new java.awt.Color(240, 240, 240));
        cmb_Position.setForeground(new java.awt.Color(0, 85, 127));
        cmb_Position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "staff", "Student" }));
        cmb_Position.setBorder(null);
        jPanel1.add(cmb_Position);
        cmb_Position.setBounds(20, 290, 260, 26);

        btn_FGPW.setBackground(new java.awt.Color(0, 85, 127));
        btn_FGPW.setForeground(new java.awt.Color(255, 255, 255));
        btn_FGPW.setText("Forget Password?");
        btn_FGPW.setBorder(null);
        btn_FGPW.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_FGPW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_FGPWMouseClicked(evt);
            }
        });
        jPanel1.add(btn_FGPW);
        btn_FGPW.setBounds(-90, 400, 130, 40);

        btn_Login1.setBackground(new java.awt.Color(255, 255, 255));
        btn_Login1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btn_Login1.setForeground(new java.awt.Color(0, 85, 127));
        btn_Login1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lock.png"))); // NOI18N
        btn_Login1.setText("Login");
        btn_Login1.setBorder(null);
        btn_Login1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Login1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Login1MouseClicked(evt);
            }
        });
        jPanel1.add(btn_Login1);
        btn_Login1.setBounds(260, 400, 90, 40);

        lbl_login.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbl_login.setForeground(new java.awt.Color(255, 255, 255));
        lbl_login.setText("Login");
        lbl_login.setToolTipText("");
        jPanel1.add(lbl_login);
        lbl_login.setBounds(-30, 40, 63, 31);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 290, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(null);

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loginlogo.png"))); // NOI18N
        jPanel2.add(lbl_logo);
        lbl_logo.setBounds(10, 220, 240, 160);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Don't  Have An Account ?");
        jLabel2.setToolTipText("");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 370, 210, 23);

        btn_SignUp.setBackground(new java.awt.Color(255, 255, 255));
        btn_SignUp.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btn_SignUp.setForeground(new java.awt.Color(0, 85, 127));
        btn_SignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/signup.png"))); // NOI18N
        btn_SignUp.setText("Sign Up");
        btn_SignUp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_SignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SignUpMouseClicked(evt);
            }
        });
        jPanel2.add(btn_SignUp);
        btn_SignUp.setBounds(80, 400, 90, 40);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 500));

        setSize(new java.awt.Dimension(540, 494));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_ExitMouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
       /* xMouse=evt.getX();
        yMouse=evt.getY();*/
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
      /*  int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        this.setLocation(x-xMouse, y-yMouse);*/
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btn_SignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SignUpMouseClicked
        SignUp su = new SignUp();
        su.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btn_SignUpMouseClicked

    private void btn_Login1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Login1MouseClicked
        try {
            
            String password=txt_LogPW.getText();
            String sha1=encryption.SHA1(password);                     
        String sha512=encryption.SHA512(sha1);
        String md5=encryption.MD5(sha512);
            String selectq="select username,password,position from users where (username =? and password =? and position=?)";
            
            int count =0;
            
            pst=con.prepareStatement(selectq);
           
           pst.setString(1,txt_LogUN.getText());
           pst.setString(2,md5);
           pst.setString(3,cmb_Position.getSelectedItem().toString());
           
           rs= pst.executeQuery();
           
           while(rs.next()){
               String un=rs.getString("username");
               Library.lib = un;
               count = count+1;
           }
           
           String access = (cmb_Position.getSelectedItem().toString());
           String ad=txt_LogUN.getText();
           Library.comboval = access;
           

               if(access=="Admin" || ad=="admin"){
               
               if(count==1){
                   //JOptionPane.showMessageDialog(null,"Success");
               Mainmenu j = new Mainmenu();
               j.setVisible(true);
               this.dispose();
               resetT();
               }
               
               else if(count>1){
                   JOptionPane.showMessageDialog(null,"Duplicate Username or Password Access denied");
                   }
               
               
               
           else{
               JOptionPane.showMessageDialog(null,"Please check your username , password and position correctly");
               
           }   
               
               
           }
 
           else if(access=="Student")
           {
               if(count ==1){
                  //JOptionPane.showMessageDialog(null,"Success");
               Mainmenu j = new Mainmenu();
               j.setVisible(true);
               this.dispose(); 
               resetT();
               }
  
               else{
               JOptionPane.showMessageDialog(null,"Please check your username , password and position correctly"); 
               
           }     
               
           }
           
           
           else if(access=="staff")
           {
               if(count ==1){
                  //JOptionPane.showMessageDialog(null,"Success");
               Mainmenu j = new Mainmenu();
               j.setVisible(true);
               this.dispose();
               resetT();
               }
  
               else{
               JOptionPane.showMessageDialog(null,"Please check your username , password and position correctly"); 
               
           }     
               
           }
           
           
           
          
           else
           {
               JOptionPane.showMessageDialog(null,"Please complete the form correctly");
               
           }
          /*
           txt_LogUN.setText("");
           txt_LogPW.setText("");
           cmb_Position.setSelectedIndex(0);*/
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Please contact the developer"+"\n"+e);
        }
    }//GEN-LAST:event_btn_Login1MouseClicked

    private void btn_FGPWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_FGPWMouseClicked
        ForgetPassword fp = new ForgetPassword();
               fp.setVisible(true);
               this.dispose(); 
    }//GEN-LAST:event_btn_FGPWMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_FGPW;
    private javax.swing.JButton btn_Login1;
    private javax.swing.JButton btn_SignUp;
    private javax.swing.JComboBox<String> cmb_Position;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_Exit;
    private javax.swing.JLabel lbl_PW;
    private javax.swing.JLabel lbl_SP;
    private javax.swing.JLabel lbl_UN;
    private javax.swing.JLabel lbl_login;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JPasswordField txt_LogPW;
    private javax.swing.JTextField txt_LogUN;
    // End of variables declaration//GEN-END:variables
}
