package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value = "/bakers")
public class BakerController {
    @Autowired
    private BakerService service;

    public BakerController(BakerService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/readall")
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @RequestMapping (method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @RequestMapping (method =  RequestMethod.POST, value = "/")
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @RequestMapping (method = RequestMethod.PUT, value = "/update")
    public ResponseEntity<Baker> update(Long id, @RequestBody Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @RequestMapping (method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<Boolean> destroy(Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
