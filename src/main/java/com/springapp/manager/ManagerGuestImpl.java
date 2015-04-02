package com.springapp.manager;

import com.springapp.utils.HibernateUtil;
import com.springapp.guest.Guest;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ManagerGuestImpl implements ManagerGuest {

    @Override
    public List<Guest> getAll() {
        Session session = null;
        List busses = new ArrayList<Guest>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            busses = session.createCriteria(Guest.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return busses;
    }

    @Override
    public void addGuest(Guest guest) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(guest);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
