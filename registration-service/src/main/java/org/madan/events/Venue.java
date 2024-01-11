package org.madan.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venue{
    private int id;
    private String name;
    private String street;
    private String city;
    private String country;
}
