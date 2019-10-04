package com.senebaTransfert.senebatrans.controller;


import com.senebaTransfert.senebatrans.model.Partenaire;
import com.senebaTransfert.senebatrans.model.User;
import com.senebaTransfert.senebatrans.repository.PartenaireRepository;
import com.senebaTransfert.senebatrans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping(value = "/user") // comme symfony Api/...
public class UserControleur {

    @Autowired // sa permet de donner le reference de l'objet
    private UserRepository userRepository;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> list(){
        return  userRepository.findAll();
    }
    @Autowired
    PasswordEncoder encoder;
    @PostMapping (value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User add(@RequestBody(required = false) User s){
        s.setPassword(encoder.encode(s.getPassword()));
        return  userRepository.save(s); // on peut utiliser aussi saveOnUpdate   return "redirect:/user";
    }
}
