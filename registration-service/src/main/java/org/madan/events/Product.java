package org.madan.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product{
    private int id;
    private int eventId;
    private String name;
    private String description;
    private BigDecimal price;
}
