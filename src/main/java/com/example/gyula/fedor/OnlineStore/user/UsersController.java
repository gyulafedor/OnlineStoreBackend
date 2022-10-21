package com.example.gyula.fedor.OnlineStore.user;

import com.example.gyula.fedor.OnlineStore.games.GameNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    public List<Users> retrieveAllUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<Users> retrieveUserById(@PathVariable String id) throws UserNotFoundException {
        Optional<Users> foundUser =  usersRepository.findById(id);

        if(foundUser.isEmpty()){
            throw new UserNotFoundException("User with id (" + id + ") was not found.");
        }

        EntityModel<Users> entityModel = EntityModel.of(foundUser.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@Valid @RequestBody Users users){
        Users addedUsers = usersRepository.save(users);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedUsers.getEmail())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable String id, @RequestBody Users users) throws GameNotFoundException {

        Users usersToModify = usersRepository.findById(id).orElseThrow(() -> new GameNotFoundException("This games was not found in the catalog."));

        usersToModify.setEmail(users.getEmail());
        usersToModify.setName(users.getName());
        usersToModify.setPassword(users.getPassword());

        usersRepository.save(usersToModify);

        return ResponseEntity.ok(usersToModify);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable String id){
        usersRepository.deleteById(id);
    }



}
