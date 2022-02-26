package com.filopl.springbootspotify;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserInfo {

    @GetMapping("/user")
    public Principal get(Principal principal) {
        return principal;
    }

}
