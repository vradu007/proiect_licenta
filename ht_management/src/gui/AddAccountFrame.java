package gui;

import controller.AccountController;
import controller.EmployeeController;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import model.Account;
import model.enums.AccessRights;
import model.enums.EditRights;

public class AddAccountFrame extends javax.swing.JFrame {

    private String username;
    private String password;
    private String repeatPassword;
    private int employeeId;
    private String nickname;
    private AccessRights accessRights;
    private EditRights editRights;
    private Account loggedAccount;
    
    public AddAccountFrame(Account loggedAccount) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        this.loggedAccount = loggedAccount;
        buttonGroup1.add(viewSelfRadio);
        buttonGroup1.add(viewAllRadio);
        buttonGroup2.add(viewOnlyRadio);
        buttonGroup2.add(editRadio);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        repeatPasswordField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        employeeIdField = new javax.swing.JTextField();
        nicknameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        viewSelfRadio = new javax.swing.JRadioButton();
        viewAllRadio = new javax.swing.JRadioButton();
        viewOnlyRadio = new javax.swing.JRadioButton();
        editRadio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("username:");

        jLabel2.setText("parola:");

        jLabel3.setText("reintroduceti parola:");

        registerButton.setText("Inregistrare");
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
        });

        jLabel4.setText("id angajat:");

        jLabel5.setText("nametag:");

        viewSelfRadio.setText("view-self");
        viewSelfRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSelfRadioActionPerformed(evt);
            }
        });

        viewAllRadio.setText("view-all");
        viewAllRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllRadioActionPerformed(evt);
            }
        });

        viewOnlyRadio.setText("view-only");
        viewOnlyRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOnlyRadioActionPerformed(evt);
            }
        });

        editRadio.setText("edit");
        editRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(registerButton)
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewOnlyRadio)
                    .addComponent(viewSelfRadio)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nicknameField)
                        .addComponent(repeatPasswordField)
                        .addComponent(passwordField)
                        .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(employeeIdField))
                    .addComponent(viewAllRadio)
                    .addComponent(editRadio))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repeatPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nicknameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewSelfRadio)
                    .addComponent(viewAllRadio))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewOnlyRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(registerButton)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
        username = usernameField.getText();
        password = passwordField.getText();
        repeatPassword = repeatPasswordField.getText();
        employeeId = Integer.parseInt(employeeIdField.getText());
        nickname = nicknameField.getText();
        
        if(!passwordValidation(password, repeatPassword)){
            JOptionPane.showMessageDialog(this, "Parolele nu sunt identice!");
            new AddAccountFrame(this.loggedAccount);
        }
        
        
        if(EmployeeController.getInstance().getAllEmployeeId().contains(employeeId)){
            AccountController.getInstance().addAccount(
                new Account(
                        username,
                        password,
                        accessRights,
                        editRights,
                        nickname,
                        employeeId
                )
            );
            new LoginFrame().setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Id-ul de angajat nu exista in baza de date");
        }
    }//GEN-LAST:event_registerButtonMouseClicked

    private void editRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRadioActionPerformed
        this.editRights = EditRights.EDIT;
    }//GEN-LAST:event_editRadioActionPerformed

    private void viewOnlyRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOnlyRadioActionPerformed
        this.editRights = EditRights.VIEW_ONLY;
    }//GEN-LAST:event_viewOnlyRadioActionPerformed

    private void viewAllRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllRadioActionPerformed
        this.accessRights = AccessRights.VIEW_ALL;
    }//GEN-LAST:event_viewAllRadioActionPerformed

    private void viewSelfRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSelfRadioActionPerformed
        this.accessRights = AccessRights.VIEW_SELF;
    }//GEN-LAST:event_viewSelfRadioActionPerformed

    
    private boolean passwordValidation(String password, String repeatPassword){
        if(password.equals(repeatPassword)){
            return true;
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton editRadio;
    private javax.swing.JTextField employeeIdField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nicknameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField repeatPasswordField;
    private javax.swing.JTextField usernameField;
    private javax.swing.JRadioButton viewAllRadio;
    private javax.swing.JRadioButton viewOnlyRadio;
    private javax.swing.JRadioButton viewSelfRadio;
    // End of variables declaration//GEN-END:variables

    
    
}
