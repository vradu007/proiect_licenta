package gui;

import controller.EmployeeController;
import java.util.List;
import javax.swing.DefaultListModel;
import model.Account;
import model.Employee;
import model.enums.EditRights;


public class EmployeeFrame extends javax.swing.JFrame {

    private DefaultListModel<String> model;
    private Account loggedAccount;
    private Employee employee;
    private int employeeId;
    private int applyBonusClickCount;
    
    public EmployeeFrame(Account loggedAccount, Employee employee) {
        initComponents();
        
        model = new DefaultListModel<String>();
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        this.loggedAccount = loggedAccount;
        this.employee = employee;
        this.employeeId = employee.getId();
        this.applyBonusClickCount = 0;
        
        this.listField.setModel(model);
        renderAttributes();
        
        if(loggedAccount.getEditRights() == EditRights.VIEW_ONLY){
            applyBonusButton.setEnabled(false);
        }
    }
    
    private void renderAttributes(){
        List<String> attributesList = EmployeeController.getInstance().toStringList(employee);
        for(String attribute : attributesList){
            model.addElement(attribute);
        }
    }
    
    private void refresh(){
        model.clear();
        renderAttributes();
        if (this.applyBonusClickCount >= 1){
            applyBonusButton.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        listField = new javax.swing.JList<>();
        applyBonusButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(listField);

        applyBonusButton.setText("Aplica bonus");
        applyBonusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyBonusButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(applyBonusButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyBonusButton)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void applyBonusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBonusButtonActionPerformed
        EmployeeController.getInstance().updateSalaryAccordingly(this.employee);
        this.employee = EmployeeController.getInstance().getEmployeeById(this.employeeId);
        this.applyBonusClickCount++;
        refresh();
    }//GEN-LAST:event_applyBonusButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyBonusButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listField;
    // End of variables declaration//GEN-END:variables
}
