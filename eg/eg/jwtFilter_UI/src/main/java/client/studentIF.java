/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.Student;
import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author admin
 */
@RegisterRestClient(baseUri = "http://localhost:8080/jwtFilter_MP/rest/student")
public interface studentIF {
    
    @ClientHeaderParam(name = "authorization",value = "{genrateJWT}")
    @GET
    @Path("/jwt")
    @Produces(MediaType.TEXT_PLAIN)
    public String get();
    
    default String genrateJWT()
    {
        return "Bearer "+ GenerateToken.generateJWT();
    }
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Student> getAllStudent();
    
    @GET
    @Path("/filter/{firstname}/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Student> filter(@PathParam("firstname")String firstname,@PathParam("email")String email);
}
