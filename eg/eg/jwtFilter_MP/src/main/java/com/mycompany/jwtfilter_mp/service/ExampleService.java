package com.mycompany.jwtfilter_mp.service;

import com.mycompany.jwtfilter_mp.entity.Student;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/student")
public class ExampleService {

    @GET
    @Path("/jwt")
    @RolesAllowed("User")
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello, world!";
    }
    
    EntityManager em=Persistence.createEntityManagerFactory("student_PU").createEntityManager();
    
//    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Student> getAllStudent() {
        return em.createNamedQuery("Student.findAll").getResultList();
    }
    
    @GET
    @Path("/filter/{firstname}/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Student> filter(@PathParam("firstname")String firstname,@PathParam("email")String email) {
        return em.createNamedQuery("Student.filter").setParameter("firstname", firstname).setParameter("email", email).getResultList();
    }

}
