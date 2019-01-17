package intuitdemo.mask;

import intuitdemo.mask.controllers.AccountController;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class AccountControllerTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(AccountController.class);
    }

    @Test
    public void shouldGetAccount_WhenMakingHttpGetRequest() {
        Response response = target("/intuit/account").request().get();

        assertEquals("Http Response should be 200 ", Response.Status.OK.getStatusCode(), response.getStatus());
        String payload = response.readEntity(String.class);
        assertEquals("Payload is: ", "{\"account\":\"123456789\",\"cc\":\"1234 5555 1234 6666\",\"lastname\":\"Doh\",\"firstname\":\"John\"}", payload);

    }

    @Test
    public void shouldPostAccount_WhenPayloadIsPresent() {
        Response response = target("/intuit/account")
                .request()
                .post(Entity.json("{\"account\":\"987654321\",\"cc\":\"1234 5555 1234 7777\",\"lastname\":\"Doh\",\"firstname\":\"Bob\"}"));

        assertEquals("Http response should be 200 ", Response.Status.OK.getStatusCode(), response.getStatus());
        String payload = response.readEntity(String.class);
        assertEquals("Payload is: ", "{\"account\":\"987654321\",\"cc\":\"1234 5555 1234 7777\",\"lastname\":\"Doh\",\"firstname\":\"Bob\"}", payload);

    }

}
