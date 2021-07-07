package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //means this class is a Controller
@RequestMapping(path="/demo") //this means URL start with /demo
public class MainController {
    @Autowired //this means to get the bean called userRepository -> 생성자 대신하는 역할인듯
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody User addNewUser(@RequestParam String name, @RequestParam String email){ //h2 관련 스터디에서는 객체 자체를 인자로 전달했는데 차이점이 뭘까?
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        userRepository.save(newUser);
        return newUser;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllusers(){
        return userRepository.findAll();
    }
}
