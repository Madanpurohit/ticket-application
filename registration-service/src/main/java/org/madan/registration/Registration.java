package org.madan.registration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("registrations")
public record Registration(
        @Id String id,
        @NotNull(message = "Product Id Should be there")
        Integer productId,
        String ticketCode,
        String EventName,
        @NotBlank String attendeeName
) {
}
