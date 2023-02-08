package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.User;
import fr.epsi.springHalloween.springHalloween.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping (path = "user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "getAll")
    public Iterable findAll() {
        return userRepository.findAll();
    }

    @GetMapping(path = "getById")
    public User findById(@RequestParam Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        } else {
            return null;
        }
    }

    @PostMapping (path = "create")
    public User create(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @PutMapping (path = "update")
    public User update(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @DeleteMapping (path = "delete")
    public void delete(@RequestParam Integer id) {
        userRepository.deleteById(id);
    }
}
