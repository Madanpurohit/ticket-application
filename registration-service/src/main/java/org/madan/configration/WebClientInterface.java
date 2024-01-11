package org.madan.configration;

import org.madan.events.Event;
import org.madan.events.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface WebClientInterface {
    @GetExchange("/product/{id}")
    Product getProductById(@PathVariable("id") Integer id);

    @GetExchange("/event")
    Event getEventById(@RequestParam("eventId") Integer eventId);
}
