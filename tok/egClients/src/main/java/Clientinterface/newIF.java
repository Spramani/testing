/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientinterface;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author shubh
 */
@RegisterRestClient(baseUri = "http://localhost:8080/egResources/rest/example")
public interface newIF {
    
    @GET
    @ClientHeaderParam(name = "authorization", value="{generateToken}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response get();
    
    default String generateToken(){
        return "Bearer "+GenerateToken.generateJWT();
    }  
    
}
