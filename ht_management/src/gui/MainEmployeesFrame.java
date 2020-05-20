package gui;

import controller.AccountController;
import controller.EmployeeController;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Account;
import model.Employee;
import model.enums.EditRights;

public class MainEmployeesFrame extends javax.swing.JFrame {
    
    private DefaultListModel<Employee> model;
    private Account loggedAccount;
    
    public MainEmployeesFrame(Account loggedAccount) {
        
        initComponents();
        
        model = new DefaultListModel<>();
        listField.setModel(model);
        this.loggedAccount = loggedAccount;
        
        setLocationRelativeTo(null);
        setVisible(true);
        renderEmployees();
        if(this.loggedAccount.getEditRights() == EditRights.VIEW_ONLY){
            addEmployeeButton.setEnabled(false);
            removeButton.setEnabled(false);
            addAccountButton.setEnabled(false);
        }
    }
    
    private void renderEmployees(){
        List<Employee> employees = EmployeeController.getInstance().getAllEmployees();
        model.clear();
        employees.forEach(employee -> model.addElement(employee));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        departmentsButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listField = new javax.swing.JList<>();
        addEmployeeButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        addAccountButton = new javax.swing.JButton();
        viewSelectedEmployee = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        departmentsButton.setText("Switch to departments");
        departmentsButton.setFocusable(false);
        departmentsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        departmentsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        departmentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentsButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listField);

        addEmployeeButton.setText("Add new employee");
        addEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addAccountButton.setText("Add new account");
        addAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccountButtonActionPerformed(evt);
            }
        });

        viewSelectedEmployee.setText("View selected employee");
        viewSelectedEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSelectedEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(departmentsButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(addEmployeeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addAccountButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewSelectedEmployee)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(departmentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmployeeButton)
                    .addComponent(removeButton)
                    .addComponent(addAccountButton)
                    .addComponent(viewSelectedEmployee))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void departmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentsButtonActionPerformed
        new MainDepartmentsFrame(this.loggedAccount);
        this.dispose();
    }//GEN-LAST:event_departmentsButtonActionPerformed

    private void addEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeButtonActionPerformed
        new AddEmployeeFrame(this.loggedAccount);
        this.dispose();
    }//GEN-LAST:event_addEmployeeButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Employee toBeRemovedEmployee = listField.getSelectedValue();
        
        EmployeeController.getInstance().deleteEmployee(toBeRemovedEmployee);
        JOptionPane.showMessageDialog(this, "Un angajat a fost sters");
        refresh();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAccountButtonActionPerformed
        new AddAccountFrame(loggedAccount);
    }//GEN-LAST:event_addAccountButtonActionPerformed

    private void viewSelectedEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSelectedEmployeeActionPerformed
        new EmployeeFrame(loggedAccount, listField.getSelectedValue());
    }//GEN-LAST:event_viewSelectedEmployeeActionPerformed

    private void refresh(){
        model.clear();
        renderEmployees();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAccountButton;
    private javax.swing.JButton addEmployeeButton;
    private javax.swing.JButton departmentsButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Employee> listField;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton viewSelectedEmployee;
    // End of variables declaration//GEN-END:variables
}
