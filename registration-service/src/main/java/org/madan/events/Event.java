package org.madan.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Event{
    private int id;
    private String name;
    private Organizer organizer;
    private Venue venue;
    private LocalDate StartDate;
    private LocalDate endDate;
}
