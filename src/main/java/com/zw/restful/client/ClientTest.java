package com.zw.restful.client;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * @program: RestfulMaven
 * @description:
 * @author: zhang wei
 * @create: 2018-07-25 00:05
 **/
public class ClientTest {
    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(getBaseURI());
        //Now printing the server code of different media type
        System.out.println(target.path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class));
        System.out.println(target.path("hello").request().accept(MediaType.TEXT_XML).get(String.class));
        System.out.println(target.path("hello").request().accept(MediaType.TEXT_HTML).get(String.class));
    }
    private static URI getBaseURI() {

        return UriBuilder.fromUri("http://localhost:8080/rest").build();
    }
}
