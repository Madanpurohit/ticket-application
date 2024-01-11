package org.madan.controller;

import org.madan.events.Event;
import org.madan.events.Organizer;
import org.madan.events.Product;
import org.madan.repository.EventRepository;
import org.madan.repository.OrganizerRepository;
import org.madan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping(path = "/events")
    public List<Event> getAllEvent(){
        return eventRepository.findAll();
    }
    @GetMapping(path="/event")
    public Event getEventById(@RequestParam("eventId") int eventId){
        return eventRepository.findById(eventId).orElseThrow(()->new NoSuchElementException("element not found"));
    }

    @GetMapping(path = "/events/{organizerId}")
    public List<Event> getEventByOrganizerId(@PathVariable("organizerId") int organizerId ){
        System.out.println(organizerId);
        return eventRepository.findByOrganizerId(organizerId);
    }

    @GetMapping(path = "/oraganizers")
    public List<Organizer> getOrganizers(){
        return organizerRepository.findAll();
    }
    @GetMapping(path = "/product/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        return productRepository.findById(id).orElseThrow(()->new NoSuchElementException("No element found"));
    }
}
