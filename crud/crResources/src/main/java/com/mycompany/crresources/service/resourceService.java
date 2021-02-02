package com.mycompany.crresources.service;

import com.mycompany.crresources.Entitiy.User;
import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resource")
public class resourceService {

    @Inject User st;
    
    EntityManager em = Persistence.createEntityManagerFactory("resourcePU").createEntityManager();

    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> get(){
        return em.createNamedQuery("User.findAll").getResultList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertuser(User usa){
        em.getTransaction().begin();
        User us = new User();
        us.setName(usa.getName());
        us.setCity(usa.getCity());
        em.persist(us);
        em.getTransaction().commit();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteuser(@PathParam("id")int id){
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
  
    }
    
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id")int id,User usa){
     em.getTransaction().begin();
        User us = em.find(User.class,usa.getId());
      
        us.setName(usa.getName());
        us.setCity(usa.getCity());
        em.merge(us);
        em.getTransaction().commit();
    }
}
