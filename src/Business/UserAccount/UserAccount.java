/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Applicant.Applicant;
import Business.Employee.Employee;
import Business.Role.Role;
import Business.ApplicationWorkQueue.WorkQueue;

/**
 *
 * @author raunak
 */
public class UserAccount {

    private String username;
    private String password;
    private Employee employee;
    private Applicant applicant;
    private Role role;
    private WorkQueue workQueue;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public UserAccount() {
        workQueue = new WorkQueue();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public Applicant getApplicant() {
        return applicant;
    }
    
    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return username;
    }

}
