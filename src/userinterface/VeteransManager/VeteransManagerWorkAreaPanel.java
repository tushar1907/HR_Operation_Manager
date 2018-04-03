/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VeteransManager;

import Business.Application.Application;
import Business.ApplicationWorkQueue.ApplicantWorkRequest;
import Business.ApplicationWorkQueue.HRWorkRequest;
import Business.ApplicationWorkQueue.VeteranWorkRequest;
import Business.ApplicationWorkQueue.WorkRequest;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Jobs.Job;
import Business.NGOPersonDirectory.NGOPerson;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.VeteransOrg;
import Business.Role.CTORole;
import Business.Role.HRRole;
import Business.Role.Role;
import Business.Role.VeteransManagerRole;
import Business.VeteransPersonDirectory.VeteranPerson;
import Business.VeteransPersonDirectory.VeteransPersonDirectory;
import javax.swing.JPanel;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import userinterface.SystemAdminWorkAreas.SystemAdminWorkAreaJPanel;

/**
 *
 * @author Tushar
 */
public class VeteransManagerWorkAreaPanel extends javax.swing.JPanel {

    /**
     * Creates new form VeteransManagerWorkAreaPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    EcoSystem business;
    VeteransOrg organization;
    OrganizationDirectory organizationDirectory;

    public VeteransManagerWorkAreaPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business, VeteransOrg organization, OrganizationDirectory organizationDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.organization = organization;
        this.account = account;
        this.organizationDirectory = organizationDirectory;
        //populateJobTable();
        populateJobTable();
        populatePersonTable();
        populateWorkQueueTable();
    }

//    
    public void populateJobTable() {
        DefaultTableModel model = (DefaultTableModel) tblJob.getModel();

        model.setRowCount(0);
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (Job job : org.getJobDirectory().getJoblist()) {
                        if (job.getCategory().equals("Underprivileged")) {
                            Object[] row = new Object[2];
                            row[0] = job;
                            row[1] = job.getJobID();
                            model.addRow(row);
                        }
                    }
                }

            }
        }
    }

    public void populatePersonTable() {
        DefaultTableModel model = (DefaultTableModel) personTable.getModel();

        model.setRowCount(0);
        for (VeteranPerson veteranPerson : organization.getVeteransPersonDirectory().getVeteranPersonList()) {
            {
                Object[] row = new Object[4];
                row[0] = veteranPerson;
                row[1] = veteranPerson.getFlag();
                model.addRow(row);
            }
        }

    }
    
    
    public void populateWorkQueueTable() {
        DefaultTableModel model = (DefaultTableModel) tblNGO.getModel();

        model.setRowCount(0);

        for (WorkRequest work : organization.getWorkQueue().getWorkRequestList()) {
            if (work instanceof ApplicantWorkRequest) {
                if (((ApplicantWorkRequest) work).getVeteranPerson()!= null) {
                    Object[] row = new Object[5];
                    row[0] = work;                    
                    row[1] = ((ApplicantWorkRequest) work).getApplicationID();
                    row[2] = ((ApplicantWorkRequest) work).getJob().getJobPosition();
                    row[3] = ((ApplicantWorkRequest) work).getSendername();
                    model.addRow(row);
                }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblJob = new javax.swing.JTable();
        hrList = new javax.swing.JButton();
        addPersonButton = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblNGO = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Job Positions for UnderPrivileded ");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Veterans Person List");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Veterans Manager Work Area");

        personTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Veterans Name", "Eligibility"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(personTable);

        tblJob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Position", "Job ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblJob);

        hrList.setText("Send to HR");
        hrList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrListActionPerformed(evt);
            }
        });

        addPersonButton.setText("Add Person");
        addPersonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonButtonActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Person Name :");

        tblNGO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Application Status", "Application ID", "Job Position", "Applicant Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblNGO);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Applicantaion Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(224, 224, 224)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addPersonButton)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(128, 128, 128)
                                .addComponent(jLabel2)))
                        .addGap(0, 504, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hrList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemove)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(hrList)))
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemove)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addPersonButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addPersonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonButtonActionPerformed
        // TODO add your handling code here:
        String name = nameTextField.getText();
        if(!name.equals(""))
        {
        organization.getVeteransPersonDirectory().addPerson(name,false,"unemployed");        
        populatePersonTable();
        JOptionPane.showMessageDialog(addPersonButton, "Veteran person added as applicant!");
        nameTextField.setText("");
        }
        else
            JOptionPane.showMessageDialog(addPersonButton, "Please provide a valid name");
    }//GEN-LAST:event_addPersonButtonActionPerformed

    private void hrListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrListActionPerformed

        int seletedVet = personTable.getSelectedRow();  
        int seletedJob = tblJob.getSelectedRow(); 
        if(seletedJob>=0 && seletedVet>=0)
        {
        VeteranPerson veteranPerson = (VeteranPerson) personTable.getValueAt(seletedVet, 0);
        veteranPerson.setFlag(true);
        veteranPerson.setJob((Job) tblJob.getValueAt(seletedJob, 0));        
        ApplicantWorkRequest applicantWorkRequest = new ApplicantWorkRequest();
        applicantWorkRequest.setVeteranPerson((VeteranPerson) personTable.getValueAt(seletedVet, 0));        
        applicantWorkRequest.setJob((Job) tblJob.getValueAt(seletedJob, 0));
        applicantWorkRequest.setFlag(true);
        applicantWorkRequest.setStatus("applied");        
        applicantWorkRequest.setSendername(((VeteranPerson) personTable.getValueAt(seletedVet, 0)).getName()); 
        populatePersonTable();
        organization.getWorkQueue().getWorkRequestList().add(applicantWorkRequest);    
        business.getWorkQueue().getWorkRequestList().add(applicantWorkRequest);
        populateWorkQueueTable();
        JOptionPane.showMessageDialog(hrList, "Applicant profile successfully sent to company HR");
        }
        else 
           JOptionPane.showMessageDialog(hrList, "Please select valid values to send to HR"); 
    }//GEN-LAST:event_hrListActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int selectedperson = personTable.getSelectedRow();
        if(selectedperson>=0)
        {
        VeteranPerson veteranPerson = (VeteranPerson) personTable.getValueAt(selectedperson, 0);
        
        organization.getVeteransPersonDirectory().removeperson(veteranPerson);
        
        populatePersonTable();
        JOptionPane.showMessageDialog(hrList, "Deleted Succesfully"); 
        }
        else
           JOptionPane.showMessageDialog(hrList, "Please select a person to delete"); 
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPersonButton;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton hrList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTable personTable;
    private javax.swing.JTable tblJob;
    private javax.swing.JTable tblNGO;
    // End of variables declaration//GEN-END:variables
}