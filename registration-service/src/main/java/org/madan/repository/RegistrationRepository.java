package org.madan.repository;

import org.madan.registration.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RegistrationRepository extends MongoRepository<Registration,String> {

    Optional<Registration> findByTicketCode(String ticket);
    void deleteByTicketCode(String ticket);
}
