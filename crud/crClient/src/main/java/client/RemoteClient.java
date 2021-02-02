/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.User;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author shubh
 */

@RegisterRestClient(baseUri = "http://localhost:8080/crResources/rest/resource")

public interface RemoteClient {


    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> get();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertuser(User us);

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteuser(@PathParam("id")int id);    

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id")int id,User usa);
}
