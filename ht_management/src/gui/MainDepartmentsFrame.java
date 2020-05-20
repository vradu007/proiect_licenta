
package gui;

import controller.DepartmentController;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Account;
import model.Department;
import model.enums.EditRights;


public class MainDepartmentsFrame extends javax.swing.JFrame {

    private DefaultListModel<Department> model;
    private Account loggedAccount;
    
    public MainDepartmentsFrame(Account loggedAccount) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        
        this.loggedAccount = loggedAccount;
        model = new DefaultListModel<>();
        listField.setModel(model);
        
        renderDepartments();
        
        if(this.loggedAccount.getEditRights() == EditRights.VIEW_ONLY){
            addButton.setEnabled(false);
            removeButton.setEnabled(false);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listField = new javax.swing.JList<>();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        switchToEmployeesButton = new javax.swing.JButton();
        viewSelectedDepartment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(listField);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        switchToEmployeesButton.setText("Switch to employees");
        switchToEmployeesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchToEmployeesButtonActionPerformed(evt);
            }
        });

        viewSelectedDepartment.setText("View selected department");
        viewSelectedDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSelectedDepartmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(switchToEmployeesButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 239, Short.MAX_VALUE)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewSelectedDepartment)
                .addGap(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(switchToEmployeesButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(removeButton)
                    .addComponent(viewSelectedDepartment))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void renderDepartments(){
        List<Department> departments = DepartmentController.getInstance().getAllDepartments();
        model.clear();
        departments.forEach(department -> model.addElement(department));
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        new AddDepartmentFrame(loggedAccount);
        this.dispose();
    }//GEN-LAST:event_addButtonActionPerformed
    
    private void switchToEmployeesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchToEmployeesButtonActionPerformed
        new MainEmployeesFrame(loggedAccount);
        this.dispose();
    }//GEN-LAST:event_switchToEmployeesButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Department toBeDeletedDepartment = listField.getSelectedValue();
        DepartmentController.getInstance().deleteDepartment(toBeDeletedDepartment);
        JOptionPane.showMessageDialog(this, "Un departament a fost sters");
        refresh();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void viewSelectedDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSelectedDepartmentActionPerformed
        new DepartmentFrame(loggedAccount, listField.getSelectedValue());
    }//GEN-LAST:event_viewSelectedDepartmentActionPerformed

    private void refresh(){
        model.clear();
        renderDepartments();
        listField.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Department> listField;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton switchToEmployeesButton;
    private javax.swing.JButton viewSelectedDepartment;
    // End of variables declaration//GEN-END:variables
}
