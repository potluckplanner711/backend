package com.lambdaschool.bwpotluckplanner.controllers;

import com.lambdaschool.bwpotluckplanner.models.User;
import com.lambdaschool.bwpotluckplanner.models.UserMin;
import com.lambdaschool.bwpotluckplanner.models.UserRoles;
import com.lambdaschool.bwpotluckplanner.services.RoleService;
import com.lambdaschool.bwpotluckplanner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class OpenController
{
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/createuser", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addUser(HttpServletRequest httpServletRequest, @Valid @RequestBody
                                     UserMin newminuser) throws
            URISyntaxException
    {
        User newuser = new User();

        newuser.setFname(newminuser.getFname());
        newuser.setLname(newminuser.getLname());
        newuser.setUsername(newminuser.getUsername());
        newuser.setEmail(newminuser.getEmail());
        newuser.setPassword(newminuser.getPassword());

        Set<UserRoles> newRoles = new HashSet<>();
        newRoles.add(new UserRoles(newuser, roleService.findByName("user")));
        newuser.setRoles(newRoles);

        newuser = userService.save(newuser);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromUriString(httpServletRequest.getServerName() + ":" + httpServletRequest.getLocalPort() + "/users/user/{userId}")
                .buildAndExpand(newuser.getUserid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        RestTemplate restTemplate = new RestTemplate();
        String requestURI = "http://" + httpServletRequest.getServerName() + (httpServletRequest.getServerName().equalsIgnoreCase("localhost") ? ":" + httpServletRequest.getLocalPort() : "") + "/login";

        List<MediaType> acceptableMediaTypes = new ArrayList<>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(acceptableMediaTypes);
        headers.setBasicAuth(System.getenv("OAUTHCLIENTID"), System.getenv("OAUTHCLIENTSECRET"));

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("scope", "read write trust");
        map.add("email", newminuser.getEmail());
        map.add("password", newminuser.getPassword());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        String theToken = restTemplate.postForObject(requestURI, request, String.class);

        return new ResponseEntity<>(theToken, responseHeaders,
                HttpStatus.CREATED);
    }

    @ApiIgnore
    @GetMapping("favicon.ico")
    public void returnNoFavicon()
    {

    }
}
