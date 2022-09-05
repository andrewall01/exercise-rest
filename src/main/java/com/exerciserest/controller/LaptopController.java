package com.exerciserest.controller;

import com.exerciserest.entities.Laptop;
import com.exerciserest.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;


@RestController
public class LaptopController {
    LaptopRepository repository;
    private static final Logger log = LoggerFactory.getLogger(LaptopController.class);

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/laptop")
    public List<Laptop> findAll() {
        return repository.findAll();
    }

    @ApiOperation("Buscar una laptop por clave primaria")
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){
        Optional<Laptop> laptopOpt = repository.findById(id);

        return laptopOpt.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity
                        .notFound()
                        .build());
    }

    @PostMapping("/api/laptop")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return repository.save(laptop);
    }

    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop> update (@RequestBody Laptop laptop){
        if (laptop.getId()==null){
            log.warn("No se puede actualizar un objeto no creado");
            return ResponseEntity.badRequest().build();
        }

        if(!repository.existsById(laptop.getId())){
            log.warn("No se puede actualizar un objeto que aun no ha sido creado");
            return ResponseEntity.notFound().build();
        }

        Laptop result = repository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ApiIgnore
    @DeleteMapping("/api/laptop")
    public ResponseEntity<Laptop> deleteAll(){
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
