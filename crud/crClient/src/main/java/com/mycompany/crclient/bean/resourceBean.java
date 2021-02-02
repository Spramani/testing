/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crclient.bean;

import client.RemoteClient;
import entity.User;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author shubh
 */
@Named(value = "resourceBean")
@RequestScoped
public class resourceBean {

    /**
     * Creates a new instance of resourceBean
     */
    
    @Inject @RestClient RemoteClient rc;
    Collection<User> userdata;
    
    int id;
    String name;
    String city;

    public RemoteClient getRc() {
        return rc;
    }

    public void setRc(RemoteClient rc) {
        this.rc = rc;
    }

    public Collection<User> getUserdata() {
        userdata = rc.get();
        return userdata;
    }

    public void setUserdata(Collection<User> userdata) {
        this.userdata = userdata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public resourceBean() {
    }
    
    public void adduser(){
        User us = new User();
        us.setName(name);
        us.setCity(city);
        
        rc.insertuser(us);
    }

    public String updateuser(int id,User us){
        this.id = id;
        name = us.getName();
        city = us.getCity();
        
        return "edit.jsf";
    }
    
    public String change(){
       User us = new User();
        us.setId(id);
        us.setName(name);
        us.setCity(city);
        rc.update(id, us);
        return "index.jsf";
    }
    
    public void delete(int id){
        rc.deleteuser(id);
    }
}
