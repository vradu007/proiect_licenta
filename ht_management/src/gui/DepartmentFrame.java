package gui;

import controller.EmployeeController;
import java.util.List;
import javax.swing.DefaultListModel;
import model.Account;
import model.Department;
import model.Employee;

public class DepartmentFrame extends javax.swing.JFrame {

    private DefaultListModel<Employee> model;
    private Account loggedAccount;
    private Department department;
    
    public DepartmentFrame(Account loggedAccount, Department department) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        
        this.loggedAccount = loggedAccount;
        this.department = department;
        model = new DefaultListModel<>();
        employeesList.setModel(model);
        renderEmployees();
    }

    private void renderEmployees(){
        List<Employee> employees = EmployeeController.getInstance().getAllEmployees();
        model.clear();
        for(Employee employee : employees){
            if(employee.getDepartmentId() == department.getId()){
                model.addElement(employee);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        employeesList = new javax.swing.JList<>();
        departmentNameLabel = new javax.swing.JLabel();
        viewEmployeeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(employeesList);

        viewEmployeeButton.setText("Vezi pagina angajatului");
        viewEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEmployeeButtonActionPerformed(evt);
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
                        .addGap(209, 209, 209)
                        .addComponent(departmentNameLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(viewEmployeeButton)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(departmentNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewEmployeeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEmployeeButtonActionPerformed
        Employee selectedEmployee = employeesList.getSelectedValue();
        new EmployeeFrame(loggedAccount,selectedEmployee);
        this.dispose();
    }//GEN-LAST:event_viewEmployeeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel departmentNameLabel;
    private javax.swing.JList<Employee> employeesList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton viewEmployeeButton;
    // End of variables declaration//GEN-END:variables
}
