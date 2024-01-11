package org.madan.repository;


import org.madan.events.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Integer> {
    List<Event> findAll();
    Optional<Event> findById(int id);

    List<Event> findByOrganizerId(int organizerId);
    Optional<Event> findByVenueId(int venueId);
}
