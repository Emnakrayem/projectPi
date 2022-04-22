package com.spring.projectpi.Registration;


import com.spring.projectpi.entites.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
private final RegistrationService registrationService;
    @PostMapping("/add")
    public String register(@RequestBody User user) {
        return registrationService.register(user);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {

        return registrationService.confirmToken(token);
    }

}