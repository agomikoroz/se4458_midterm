package com.abdullahaslan.midterm.repository;

import com.abdullahaslan.midterm.entity.Passenger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class PassengerRepository {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public Passenger get(String username) {
        TypedQuery<Passenger> q = entityManager.createQuery("from Passenger where username = :username", Passenger.class)
                .setParameter("username", username);

        List<Passenger> passengerList = q.getResultList();

        if (passengerList.isEmpty()) return null;
        return passengerList.get(0);
    }
}
