package org.madan.repository;

import org.madan.events.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VenueRepository extends JpaRepository<Venue,Integer> {

    Optional<Venue> findById(int id);
    List<Venue> findAll();
}
