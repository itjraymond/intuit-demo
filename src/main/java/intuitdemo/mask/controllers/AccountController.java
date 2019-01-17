package intuitdemo.mask.controllers;

import intuitdemo.mask.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@Component
@Path("/intuit")
public class AccountController {


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("account")
    public Account processAccount(Account account) {
        log.info("POST Account:  " + account);
        return account;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("account")
    public Account getAccount() {
        Account account = new Account("123456789", "1234 5555 1234 6666", "John", "Doh");
        log.info("GET account:  " + account);
        return account;

    }
}
