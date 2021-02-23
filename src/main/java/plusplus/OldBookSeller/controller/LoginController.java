package plusplus.OldBookSeller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plusplus.OldBookSeller.controller.request.LoginRequest;
import plusplus.OldBookSeller.controller.request.RegisterRequest;
import plusplus.OldBookSeller.controller.request.RetriveRequest;
import plusplus.OldBookSeller.services.UserService;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    UserService userService;
    @GetMapping(value ="/login")
    public String login(@RequestBody LoginRequest loginRequest)
    {
        return userService.login(loginRequest.getUsername(),loginRequest.getPassword());
    }

    @GetMapping(value = "/retrieve")
    public String retrievePassword(@RequestBody RetriveRequest retriveRequest) {
        return userService.retrievePassword(retriveRequest.getEmail(),retriveRequest.getToken());
    }
    @PostMapping(value = "/register")
    public String register(@RequestBody RegisterRequest registerRequest){
        return userService.register(registerRequest.getEmail(),registerRequest.getPassword(),registerRequest.getPhonenumber(),registerRequest.getToken());
    }
    @PostMapping(value = "/{email}")
    public String sendToken(@PathVariable String email){
        return userService.sendTokenToEmail(email);
    }
}
