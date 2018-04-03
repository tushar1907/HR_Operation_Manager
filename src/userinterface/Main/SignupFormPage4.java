/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Main;

import Business.Applicant.Applicant;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Jobs.Job;
import Business.Network.Network;
import Business.Organization.CompanyOrg;
import Business.Organization.Organization;
import Business.Role.ApplicantRole;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author raj
 */
public class SignupFormPage4 extends javax.swing.JPanel {

    /**
     * Creates new form SignupForm
     */
    JPanel container;
    EcoSystem system;
    Applicant applicant;
    
    SignupFormPage4(JPanel container, EcoSystem system, Applicant applicant) {
         initComponents();
        this.container= container;
        this.system=system;
       this.applicant=applicant;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        confirmPasswordTF = new javax.swing.JPasswordField();
        enterPasswordTF = new javax.swing.JPasswordField();
        userNameTF = new javax.swing.JTextField();
        eaTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Step 4: Enter Your Credentials for signUp");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Username:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Confirm Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 20));

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jPanel1.add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, 68, -1));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Page 4 ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter Password:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));
        jPanel1.add(confirmPasswordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 200, 30));
        jPanel1.add(enterPasswordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 200, 30));
        jPanel1.add(userNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 200, 30));

        eaTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eaTFActionPerformed(evt);
            }
        });
        jPanel1.add(eaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 200, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter Your Email Address:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        String username = userNameTF.getText();
        String pass = enterPasswordTF.getText();
        String confirm = confirmPasswordTF.getText();
        String email = eaTF.getText();
        
        if(!pass.equals(confirm))
        {
            JOptionPane.showMessageDialog(nextButton,"Passwords do no match");
        }
        
        else if(pass.equals(confirm))
        {
        Applicant applicant= system.getApplicantDirectory().createApplicantLogin(username, pass,email);
        for (Network network : system.getNetworkList()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if(org instanceof CompanyOrg){
                            UserAccount ual = org.getUserAccountDirectory().creatApplicantUserAccount(username, pass, applicant, new ApplicantRole(),email);
                        }
                    }

                }
            }
        //UserAccount ua1 = system.getUserAccountDirectory().creatApplicantUserAccount();
        //ReviewPage rp = new ReviewPage(container,system,applicant);
//        container.add("SignupForm",rp);
//        CardLayout crdLyt = (CardLayout) container.getLayout();
//        crdLyt.next(container);
       
        }
       
       
        
        
        
        
    }//GEN-LAST:event_nextButtonActionPerformed

    private void eaTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eaTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eaTFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPasswordField confirmPasswordTF;
    private javax.swing.JTextField eaTF;
    private javax.swing.JPasswordField enterPasswordTF;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField userNameTF;
    // End of variables declaration//GEN-END:variables
}