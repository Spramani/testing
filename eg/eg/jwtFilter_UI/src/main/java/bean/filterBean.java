/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import client.studentIF;
import entity.Student;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author admin
 */
@Named(value = "filterBean")
@RequestScoped
public class filterBean {
    
     @Inject @RestClient studentIF sif;
    String firstname="",emaill="";
    Collection<Student> students;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public Collection<Student> getStudents() {
         if (firstname.equals(""))
         {
            return sif.getAllStudent();
         }
         else
         {
            return sif.filter(firstname, emaill);
         }
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public void filter()
    {
        students=null;
        students = sif.filter(firstname, emaill);
    }
    
}
