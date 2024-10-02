package com.gadburg.contactlistapi.repository;

import org.springframework.data.repository.CrudRepository;
import com.gadburg.contactlistapi.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer>{

}
