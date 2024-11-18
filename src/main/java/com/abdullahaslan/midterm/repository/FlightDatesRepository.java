package com.abdullahaslan.midterm.repository;

import com.abdullahaslan.midterm.entity.FlightDates;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class FlightDatesRepository {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public void insert(FlightDates flightDates) {
        entityManager.merge(flightDates);
    }

    @Transactional
    public FlightDates get(int flightID, Date date) {
        TypedQuery<FlightDates> q = entityManager.createQuery("""
                from FlightDates
                where flightID = :flightID and date = :date
                """, FlightDates.class)
                .setParameter("flightID", flightID)
                .setParameter("date", date);
        return q.getSingleResult();
    }

}
