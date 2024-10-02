package com.gadburg.contactlistapi.controller;

import com.gadburg.contactlistapi.entity.Contact;
import com.gadburg.contactlistapi.service.ContactService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gadburg.contactlistapi.dto.ContactDTO;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    
    private final ContactService contactService;

    //endpoint general
    @GetMapping
    public Iterable<Contact> list(){
        return contactService.findAll();
    }

    //endpoint por id
    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id){
        return contactService.findById(id);
    }

    //crear contacto
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@Validated @RequestBody ContactDTO contactDTO){
        return contactService.create(contactDTO);
    }

    //actualizar contacto
    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id, @Validated @RequestBody ContactDTO contactDTO){
        return contactService.update(id, contactDTO);
    }

    //borrar contacto
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        contactService.delete(id);
    }

}
