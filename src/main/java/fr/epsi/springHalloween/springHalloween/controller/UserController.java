package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.User;
import fr.epsi.springHalloween.springHalloween.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
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
            User filteredUser = new User();
            filteredUser.setId(user.get().getId());
            filteredUser.setEmail(user.get().getEmail());
            filteredUser.setFirstName(user.get().getFirstName());
            filteredUser.setLastName(user.get().getLastName());
            filteredUser.setAdmin(user.get().isAdmin());
            filteredUser.setAddress(user.get().getAddress());
            filteredUser.setEnterprise(user.get().isEnterprise());
            return filteredUser;
        } else {
            return null;
        }
    }

    @PostMapping (path = "create")
    public User create(@RequestBody User user) {
        userRepository.save(user);
        User filteredUser = new User();
        filteredUser.setId(user.getId());
        filteredUser.setEmail(user.getEmail());
        filteredUser.setFirstName(user.getFirstName());
        filteredUser.setLastName(user.getLastName());
        filteredUser.setAdmin(user.isAdmin());
        filteredUser.setAddress(user.getAddress());
        filteredUser.setEnterprise(user.isEnterprise());
        return filteredUser;
    }

    @PutMapping (path = "update")
    public User update(@RequestBody User user) {
        userRepository.save(user);
        User filteredUser = new User();
        filteredUser.setId(user.getId());
        filteredUser.setEmail(user.getEmail());
        filteredUser.setFirstName(user.getFirstName());
        filteredUser.setLastName(user.getLastName());
        filteredUser.setAdmin(user.isAdmin());
        filteredUser.setAddress(user.getAddress());
        filteredUser.setEnterprise(user.isEnterprise());
        return filteredUser;
    }

    @DeleteMapping (path = "delete")
    public ResponseEntity<Void> delete(@RequestParam Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "login")
    public ResponseEntity<User> login(@RequestBody User user) {
        try {
            Optional<User> userFound = Optional.ofNullable(userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()));
            if (userFound.isPresent()) {
                User filteredUser = new User();
                filteredUser.setId(userFound.get().getId());
                filteredUser.setEmail(userFound.get().getEmail());
                filteredUser.setFirstName(userFound.get().getFirstName());
                filteredUser.setLastName(userFound.get().getLastName());
                filteredUser.setAdmin(userFound.get().isAdmin());
                filteredUser.setAddress(userFound.get().getAddress());
                filteredUser.setEnterprise(userFound.get().isEnterprise());
                return ResponseEntity.status(HttpStatus.OK).body(filteredUser);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}