package com.alpha.ControllerClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.EntityClasses.Ent;
import com.alpha.config.JwtResponse;
import com.alpha.config.UserService;

//@RestController
//public class UserController {
//	
//	  @Autowired
//	    private UserService service;
//
//@GetMapping("/test")
//private String access() {
//	return "You are authenticated";
//}
//
//	    @PostMapping("/authlogin")
//	    public String login(@RequestParam String username, @RequestParam String password) {
//System.out.println("In auth login");
//	        return service.verify(username,password);
//	    }
//	 
//}


@RestController
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping("/authlogin")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        String token = service.verify(username, password);
        if (token != null) {
            return ResponseEntity.ok(new JwtResponse(token)); // Respond with the token
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Unauthorized if token is null
    }
}
