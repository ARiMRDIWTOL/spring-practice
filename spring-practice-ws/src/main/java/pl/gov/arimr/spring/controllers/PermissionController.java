package pl.gov.arimr.spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.gov.arimr.spring.core.constant.UserRole;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/permissions")
public class PermissionController {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserRole> getAll() {
        return Arrays.asList(UserRole.values());
    }
}
