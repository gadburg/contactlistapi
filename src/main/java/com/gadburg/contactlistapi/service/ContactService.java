package com.gadburg.contactlistapi.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.gadburg.contactlistapi.dto.ContactDTO;
import com.gadburg.contactlistapi.entity.Contact;
import com.gadburg.contactlistapi.exception.ResourceNotFoundException;
import com.gadburg.contactlistapi.repository.ContactRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ContactService {

    
    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact findById(Integer id){
        return contactRepository
            .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Contact create(ContactDTO contactDTO){
        Contact contact = mapper.map(contactDTO, Contact.class);
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, ContactDTO contactDTO){
        Contact contactFromDb= findById(id);
        mapper.map(contactDTO, contactFromDb);
        return contactRepository.save(contactFromDb);
    }

    public void delete(Integer id){
        Contact contactFromDb= findById(id);
        contactRepository.delete(contactFromDb);
    }
}
