package com.alan.crud.controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;

import com.alan.crud.entities.Contact;
import com.alan.crud.repositories.*;

@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

  @Autowired
  ContactRepository contactRepository;

  @GetMapping
  public Iterable<Contact> list() {
    return contactRepository.findAll();
  }

  @PostMapping
  public Contact save(@RequestBody Contact contact) {
    contactRepository.save(contact);
    return contact;
  }

  @GetMapping(path="{id}")
  public Object get(@PathVariable Long id) {
    var contact = contactRepository.findById(id);

    JSONObject response = new JSONObject();

    if(contact.isEmpty()) {
      response.put("status", "error");
      response.put("message", "id not found");
      return response;
    }

    response.put("status", "success");
    response.put("data", contact);

    return response;
  }

  @DeleteMapping(path="{id}")
  public Object delete(@PathVariable Long id) {
    var contact = contactRepository.findById(id);

    JSONObject response = new JSONObject();
    if(contact.isEmpty()) {
      response.put("status", "error");
      response.put("message", "id not found");
      return response;
    }

    contactRepository.deleteById(id);

    response.put("status", "success");
    response.put("message", "contact removed with success");
    return response;
  }
}
