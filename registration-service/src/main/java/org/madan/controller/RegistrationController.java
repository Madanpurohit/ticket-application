package org.madan.controller;

import jakarta.validation.Valid;
import org.madan.configration.WebClientInterface;
import org.madan.events.Event;
import org.madan.events.Product;
import org.madan.registration.Registration;
import org.madan.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/registration")
public class RegistrationController {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    WebClient webClient;
    @Autowired
    WebClientInterface webClientInterface;

    @PostMapping
    public Registration create(@RequestBody @Valid Registration registration){
//        Product product = webClient.get()
//                .uri("/product/{id}", registration.productId())
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .retrieve()
//                .bodyToMono(Product.class)
//                .block();
        Product product = webClientInterface.getProductById(registration.productId());
        System.out.println(product);
//        Event event = webClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path("event")
//                        .queryParam("eventId", product.getEventId())
//                        .build()
//                ).retrieve()
//                .bodyToMono(Event.class)
//                .block();
        Event event = webClientInterface.getEventById(product.getEventId());
        String ticket = UUID.randomUUID().toString();
        return registrationRepository.save(new Registration(null, registration.productId(),ticket, event.getName(),registration.attendeeName()));
    }
    @GetMapping(path = "/{ticketCode}")
    public Registration getRegistration(@PathVariable("ticketCode") String ticket){
        return registrationRepository.findByTicketCode(ticket).orElseThrow(
                ()->new NoSuchElementException("Element not found")
        );
    }
}
