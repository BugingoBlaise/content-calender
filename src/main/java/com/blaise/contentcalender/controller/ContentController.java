package com.blaise.contentcalender.controller;

import com.blaise.contentcalender.model.Content;
import com.blaise.contentcalender.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    public final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content>findAll(){
        return repository.findall();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Content"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content,@PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable Integer id){
repository.delete(id);
    }




}
