package pl.gov.arimr.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import pl.gov.arimr.spring.core.entities.User;
import pl.gov.arimr.spring.core.service.UserService;

import java.util.Set;

@RestController
@RequestMapping(value = "/users")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Set<User> getAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@RequestBody User User) {
        return saveOrUpdate(User);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User User) {
        return saveOrUpdate(User);
    }

    private ResponseEntity<User> saveOrUpdate(User User) {
        try {
            User savedUser = userService.saveOrUpdate(User);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
