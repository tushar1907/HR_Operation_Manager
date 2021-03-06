/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CTO;

import Business.ApplicationWorkQueue.HRWorkRequest;
import Business.ApplicationWorkQueue.WorkRequest;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CompanyOrg;
import Business.Organization.OrganizationDirectory;
import Business.Role.CTORole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tushar
 */
public class CTOWorkAreaPanel extends javax.swing.JPanel {

    /**
     * Creates new form CompanyManagerWorkAreaPanel
     */
    JPanel userProcessContainer;
    EcoSystem business;
    Enterprise enterprise;
    CompanyOrg organization;
    UserAccount userAccount;
    OrganizationDirectory organizationDirectory;

    public CTOWorkAreaPanel(JPanel userProcessContainer, EcoSystem business, Enterprise enterprise, CompanyOrg organization, UserAccount userAccount, OrganizationDirectory organizationDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        this.organizationDirectory = organizationDirectory;
        populateHRWorkRequestTable();
    }

    public void populateHRWorkRequestTable() {
        DefaultTableModel model = (DefaultTableModel) hrrequestTable.getModel();
        
        model.setRowCount(0);
        outer:
        for (UserAccount useraccount : organization.getUserAccountDirectory().getUserAccountList()) {
            if (useraccount.getRole() instanceof CTORole && useraccount.equals(userAccount)) {
                for (WorkRequest work : useraccount.getWorkQueue().getWorkRequestList()) {

                    if (work instanceof HRWorkRequest) {
                        Object[] row = new Object[6];
                        row[0] =  work;
                        //row[1] =  work.getStatus();
                        row[1] = ((HRWorkRequest) work).getApplicationID();
                        row[2] = ((HRWorkRequest) work).getJob().getJobPosition();
                        row[3] = ((HRWorkRequest) work).getAccount();
                        row[4] = useraccount.getEmployee().getName();
                        model.addRow(row);
                        //break outer;
                    }

                }
//               break outer; 
            }
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

        btnSelected = new javax.swing.JButton();
        btnRejected = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCreateJobs = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        hrrequestTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));

        btnSelected.setText("Applicant Selected");
        btnSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectedActionPerformed(evt);
            }
        });

        btnRejected.setText("Applicant Rejected");
        btnRejected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectedActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CTO Work Area");

        btnCreateJobs.setText("Create Jobs-->>");
        btnCreateJobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateJobsActionPerformed(evt);
            }
        });

        hrrequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Application Status", "Application ID", "Job Position", "Applicant Name", "Assigned to"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(hrrequestTable);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Applicant Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRejected, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56)
                        .addComponent(btnCreateJobs, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateJobs, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelected)
                    .addComponent(btnRejected))
                .addContainerGap(228, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateJobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateJobsActionPerformed

        CreateJobPanel createJobPanel = new CreateJobPanel(userProcessContainer, business, enterprise, organizationDirectory, userAccount);
        userProcessContainer.add("CreateJobPanel", createJobPanel);
        CardLayout cardlayout = (CardLayout) userProcessContainer.getLayout();
        cardlayout.next(userProcessContainer);

    }//GEN-LAST:event_btnCreateJobsActionPerformed

    private void btnSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectedActionPerformed
        int selectedAppRow = hrrequestTable.getSelectedRow();
        if(selectedAppRow>=0)
        {
        HRWorkRequest hRWorkRequestid = (HRWorkRequest) hrrequestTable.getValueAt(selectedAppRow, 0);

        for (UserAccount useraccount : organization.getUserAccountDirectory().getUserAccountList()) {
            if (useraccount.getRole() instanceof CTORole) {
                for (WorkRequest work : useraccount.getWorkQueue().getWorkRequestList()) {
                    
                    if (work instanceof HRWorkRequest && ((HRWorkRequest) work).getApplicationID()== hRWorkRequestid.getApplicationID()) {
                        hRWorkRequestid.setStatus("Selected");
                    }
                }
            }
        }
        populateHRWorkRequestTable();
        }
        else
            JOptionPane.showMessageDialog(btnSelected, "Please select an Applicant from Applicant Details table to Accept his application");
    }//GEN-LAST:event_btnSelectedActionPerformed

    private void btnRejectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectedActionPerformed
        int selectedAppRow = hrrequestTable.getSelectedRow();
        if(selectedAppRow>=0)
        {
        HRWorkRequest hRWorkRequestid = (HRWorkRequest) hrrequestTable.getValueAt(selectedAppRow, 0);

        for (UserAccount useraccount : organization.getUserAccountDirectory().getUserAccountList()) {
            if (useraccount.getRole() instanceof CTORole) {
                for (WorkRequest work : useraccount.getWorkQueue().getWorkRequestList()) {
                    
                    if (work instanceof HRWorkRequest && ((HRWorkRequest) work).getApplicationID()== hRWorkRequestid.getApplicationID()) {
                        hRWorkRequestid.setStatus("Rejected");
                    }
                }
            }
        }
        populateHRWorkRequestTable();
        }
        else
            JOptionPane.showMessageDialog(btnSelected, "Please select an Applicant from Applicant Details table to Reject his application");
    }//GEN-LAST:event_btnRejectedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateJobs;
    private javax.swing.JButton btnRejected;
    private javax.swing.JButton btnSelected;
    private javax.swing.JTable hrrequestTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
