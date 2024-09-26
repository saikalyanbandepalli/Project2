package org.revature.RevTaskManagement.repository;

import org.revature.RevTaskManagement.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    // Custom query methods can be defined here if needed
}