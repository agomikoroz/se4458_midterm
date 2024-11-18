package com.abdullahaslan.midterm.repository;

import com.abdullahaslan.midterm.entity.Flight;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class FlightRepository {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public Flight getOne(String from, String to) {
        TypedQuery<Flight> q = entityManager.createQuery("""
                from Flight AS f
                where f.from = :from and f.to = :to
                """, Flight.class)
                .setParameter("from", from)
                .setParameter("to", to);
        return q.getSingleResult();
    }

    @Transactional
    public Flight findByID(int id) {
        return entityManager.find(Flight.class, id);
    }

    @Transactional
    public int insert(Flight flight) {
        flight = entityManager.merge(flight);
        return flight.getId();
    }

    @Transactional
    public List<Flight> getAll(String from, String to) {
        TypedQuery<Flight> q = entityManager.createQuery("""
                from Flight f
                where f.from = :from and f.to = :to
                """, Flight.class)
                .setParameter("from", from)
                .setParameter("to", to);
        return q.getResultList();
    }
}
