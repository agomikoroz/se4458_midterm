package com.abdullahaslan.midterm.repository;

import com.abdullahaslan.midterm.entity.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepository {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public Ticket get(int id) {
        return entityManager.find(Ticket.class, id);
    }

    @Transactional
    public void updateOrInsert(Ticket ticket) {
        entityManager.merge(ticket);
    }

}
