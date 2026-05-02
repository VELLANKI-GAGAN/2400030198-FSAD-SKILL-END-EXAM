package com.klef.fsad.exam;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        persistTransports(session);
        tx.commit();

        session.beginTransaction();
        displayAllTransports(session);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

    private static void persistTransports(Session session) {
        Transport t1 = new Transport("Express Courier", "2026-05-02", "Dispatched", "Truck", 4500.00);
        Transport t2 = new Transport("City Logistics", "2026-05-03", "In Transit", "Van", 2800.00);
        Transport t3 = new Transport("Airport Freight", "2026-05-04", "Delivered", "Cargo Plane", 12500.00);

        session.persist(t1);
        session.persist(t2);
        session.persist(t3);
    }

    private static void displayAllTransports(Session session) {
        String hql = "from Transport";

        Query<Transport> query = session.createQuery(hql, Transport.class);
        List<Transport> list = query.list();

        System.out.println("--- Transport Records ---");

        for (Transport t : list) {
            System.out.println(
                t.id + " " +
                t.name + " " +
                t.date + " " +
                t.status + " " +
                t.vehicleType + " " +
                t.fare
            );
        }
    }
}