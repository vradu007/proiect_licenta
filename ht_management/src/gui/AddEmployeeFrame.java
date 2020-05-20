package gui;

import controller.EmployeeController;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Account;
import model.Employee;
import utils.DateManager;
import utils.IdManager;

public class AddEmployeeFrame extends javax.swing.JFrame {

    private Account loggedAccount;
    
    public AddEmployeeFrame(Account loggedAccount) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        this.loggedAccount = loggedAccount;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        employmentDateField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        salaryField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bonusSchemeField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CNPField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jobTitleField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        productivityIndexField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        accountIdField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        departmentIdField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        addEmployeeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Prenume:");

        jLabel2.setText("Nume:");

        jLabel3.setText("Data angajarii:");

        jLabel4.setText("Salariu:");

        jLabel5.setText("Bonus:");

        jLabel6.setText("Adresa:");

        jLabel7.setText("Email:");

        jLabel8.setText("CNP:");

        jLabel9.setText("Telefon:");

        jLabel10.setText("Functie:");

        jLabel11.setText("Indice de productivitate:");

        jLabel12.setText("Id user:");

        jLabel13.setText("Id departament:");

        addEmployeeButton.setText("Adauga");
        addEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addEmployeeButton)
                    .addComponent(departmentIdField, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(accountIdField)
                    .addComponent(productivityIndexField)
                    .addComponent(jobTitleField)
                    .addComponent(phoneNumberField)
                    .addComponent(CNPField)
                    .addComponent(emailField)
                    .addComponent(addressField)
                    .addComponent(bonusSchemeField)
                    .addComponent(salaryField)
                    .addComponent(employmentDateField)
                    .addComponent(firstNameField)
                    .addComponent(lastNameField))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employmentDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bonusSchemeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CNPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productivityIndexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addEmployeeButton)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeButtonActionPerformed
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        Date employmentDate = DateManager.asDate(LocalDate.parse(employmentDateField.getText()));
        double salary = Double.parseDouble(salaryField.getText());
        double bonusScheme = Double.parseDouble(bonusSchemeField.getText());
        String address = addressField.getText();
        String email = emailField.getText();
        String CNP = CNPField.getText();
        String phoneNumber = phoneNumberField.getText();
        String jobTitle = jobTitleField.getText();
        double productivityIndex = Double.parseDouble(productivityIndexField.getText());
        int departmentId = Integer.parseInt(departmentIdField.getText());
        
        Employee employee = new Employee(firstName,lastName,employmentDate,salary,bonusScheme,address,email,
                CNP,phoneNumber,jobTitle,productivityIndex,departmentId);
        employee.setId(IdManager.getInstance().getEmployeeId());
        
        if(validateFields(employee)){
            EmployeeController.getInstance().addEmployee(employee);
            JOptionPane.showMessageDialog(this, "A fost adaugat un nou angajat");
            new MainEmployeesFrame(loggedAccount);
        }else{
            JOptionPane.showMessageDialog(this, "Campurile nu sunt corecte");
        }
    }//GEN-LAST:event_addEmployeeButtonActionPerformed

    private boolean validateFields(Employee employee){
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CNPField;
    private javax.swing.JTextField accountIdField;
    private javax.swing.JButton addEmployeeButton;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField bonusSchemeField;
    private javax.swing.JTextField departmentIdField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField employmentDateField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jobTitleField;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JTextField productivityIndexField;
    private javax.swing.JTextField salaryField;
    // End of variables declaration//GEN-END:variables
}
