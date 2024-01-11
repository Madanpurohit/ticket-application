package org.madan.events;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
@Data
public class Event{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "organizer_id",referencedColumnName = "id",nullable = false)
    private Organizer organizer;
    @ManyToOne
    @JoinColumn(name = "venue_id",referencedColumnName = "id",nullable = false)
    private Venue venue;
    @Column
    private LocalDate StartDate;
    @Column
    private LocalDate endDate;
}
