/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solace.library;

/**
 *
 * @author sachith
 */
public class Aboutus extends javax.swing.JPanel {

    /**
     * Creates new form Aboutus
     */
    public Aboutus() {
        initComponents();
        
        
        lbl_aboutus.setText("<html> Solace Library is a library within a SOLACE institute where students and staff have access to a variety of resources. The goal of the Solace library media center is to ensure that all members of the institute community have equitable access \"to books and reading, to information, and to information technology."
                + "\" A Solace library media center "
                + "\"uses all types of media... is automated, and utilizes the Internet [as well as books] for information gathering."
                + "\" Solace libraries are distinct from public libraries because they serve as "
                + "\"learner-oriented laboratories which support, extend, and individualize the student's curriculum... A Solace library serves as the center and coordinating agency for all material used in the institute."
                + "\" </html>");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_copyright = new javax.swing.JLabel();
        lbl_aboutus = new javax.swing.JLabel();
        lbl_Dashboard1 = new javax.swing.JLabel();
        lbl_dashicon = new javax.swing.JLabel();
        lbl_Dashboard2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(930, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_copyright.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lbl_copyright.setForeground(new java.awt.Color(105, 105, 105));
        lbl_copyright.setText("COPYRIGHT ©  SINHALION");
        add(lbl_copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 570, -1, -1));

        lbl_aboutus.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_aboutus.setForeground(new java.awt.Color(0, 0, 0));
        add(lbl_aboutus, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 820, 270));

        lbl_Dashboard1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbl_Dashboard1.setForeground(new java.awt.Color(105, 105, 105));
        lbl_Dashboard1.setText("Version 1.0");
        add(lbl_Dashboard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 80, 20));

        lbl_dashicon.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_dashicon.setForeground(new java.awt.Color(105, 105, 105));
        lbl_dashicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user111.png"))); // NOI18N
        add(lbl_dashicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        lbl_Dashboard2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_Dashboard2.setForeground(new java.awt.Color(105, 105, 105));
        lbl_Dashboard2.setText("About Us");
        add(lbl_Dashboard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 170, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loginlogo.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 250, 190));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aboutus label.gif"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 590));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_Dashboard1;
    private javax.swing.JLabel lbl_Dashboard2;
    private javax.swing.JLabel lbl_aboutus;
    private javax.swing.JLabel lbl_copyright;
    private javax.swing.JLabel lbl_dashicon;
    // End of variables declaration//GEN-END:variables
}
