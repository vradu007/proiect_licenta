package gui;

import controller.AccountController;
import controller.EmployeeController;
import java.util.List;
import model.Account;
import model.Employee;
import model.enums.AccessRights;


public class LoginFrame extends javax.swing.JFrame {
    
    private Account foundAccount;
    private Employee foundEmployee;
    
    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        refresh();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("username:");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("parola:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(loginButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(errorLabel)))
                .addContainerGap(266, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordField)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addComponent(loginButton)
                .addGap(44, 44, 44)
                .addComponent(errorLabel)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        List<Account> accounts = AccountController.getInstance().getAllAccounts();
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean found = false;
        for(Account account : accounts){
            if(username.equals(account.getUsername()) && password.equals(account.getPassword())){
                found = true;
                foundAccount = account;
            }
        }
        
        if(found){
            if(foundAccount.getAccessRights() == AccessRights.VIEW_ALL){
                new MainEmployeesFrame(foundAccount);
                this.dispose();
            }else{
                List<Employee> employees = EmployeeController.getInstance().getAllEmployees();
                for(Employee employee : employees){
                    if(employee.getId() == foundAccount.getEmployeeId()){
                        foundEmployee = employee;
                    }
                }
                new EmployeeFrame(foundAccount, foundEmployee).setVisible(true);
                this.dispose();
            }
        }else{
            errorLabel.setText("Username-ul sau parola sunt gresite");
            refresh();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void refresh(){
        usernameField.setText("");
        passwordField.setText("");
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
