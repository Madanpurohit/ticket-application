package org.madan.repository;

import org.madan.events.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {
    public List<Organizer> findAll();
}
