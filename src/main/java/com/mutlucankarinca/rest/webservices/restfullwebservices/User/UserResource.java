package com.mutlucankarinca.rest.webservices.restfullwebservices.User;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class UserResource {
    //retrieveAllUsers
    //retrieveUser{id}

    @Autowired
    private UserDaoService userService;
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userService.findAll();
    }
    @GetMapping("users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        User user = userService.findUser(id);
        if (user == null){
            throw new UserNotFoundException("id-" +id);
        }
        EntityModel<User> model = EntityModel.of(user);

        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkToUsers.withRel("all-users"));
        //  /users
        return model;

    }
    @DeleteMapping ("users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userService.deleteById(id);
        if(user==null){
            throw new UserNotFoundException("id-"+id);
        }

    }
    //input - details of user
    //output - CREATED & Return the created URI

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userService.saveUser(user);
        URI locaiton = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(locaiton).build();
    }
}

