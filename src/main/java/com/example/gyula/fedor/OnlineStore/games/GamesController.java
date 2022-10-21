package com.example.gyula.fedor.OnlineStore.games;

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
public class GamesController {

    private GamesRepository gamesRepository;

    public GamesController(GamesRepository gamesRepository){
        this.gamesRepository = gamesRepository;
    }

    @GetMapping("/games")
    public List<Games> retrieveAllGames(){
        return gamesRepository.findAll();
    }

    @GetMapping("/games/{id}")
    public EntityModel<Games> getGameById(@PathVariable long id) throws GameNotFoundException {
        Optional<Games> foundGame =  gamesRepository.findById(id);

        if(foundGame.isEmpty()){
            throw new GameNotFoundException("id: " + id);
        }

        EntityModel<Games> entityModel = EntityModel.of(foundGame.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllGames());
        entityModel.add(link.withRel("all-games"));

        return entityModel;
    }

    @PostMapping("/games")
    public ResponseEntity<Object> addGame(@Valid @RequestBody Games games){
        Games addedGames = gamesRepository.save(games);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedGames.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/games/{id}")
    public ResponseEntity<Object> updateGame(@PathVariable long id, @RequestBody Games games) throws GameNotFoundException {

        Games gamesToModify = gamesRepository.findById(id).orElseThrow(() -> new GameNotFoundException("This games was not found in the catalog."));

        gamesToModify.setName(games.getName());
        gamesToModify.setDescription(games.getDescription());
        gamesToModify.setDeveloper(games.getDeveloper());
        gamesToModify.setPublisher(games.getPublisher());
        gamesToModify.setPrice(games.getPrice());

        gamesRepository.save(gamesToModify);

        return ResponseEntity.ok(gamesToModify);
    }

    @DeleteMapping("/games/{id}")
    public void deleteGameById(@PathVariable long id){
        gamesRepository.deleteById(id);
    }



}
