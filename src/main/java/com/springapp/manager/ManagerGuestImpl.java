package com.springapp.manager;

import com.springapp.utils.HibernateUtil;
import com.springapp.guest.Guest;
import org.hibernate.Session;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manager guest to control guests.
 */
public class ManagerGuestImpl implements ManagerGuest {

    /**
     * Gets all guests.
     * @return List guests.
     */
    @Override
    public List<Guest> getAll() {
        Session session = null;
        List<Guest> guests = new ArrayList<Guest>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            guests = session.createCriteria(Guest.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ERROR_MESSAGE_GET_ALL_GUESTS, JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return guests;
    }

    /**
     * Const for error when get all guests.
     */
    private final String ERROR_MESSAGE_GET_ALL_GUESTS =  "Error 'getAll'";

    /**
     * Adds new guest.
     * @param guest Guest.
     */
    @Override
    public void addGuest(Guest guest) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(guest);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ERROR_MESSAGE_ADD_GUEST, JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Const for error when add new guest.
     */
    private final String ERROR_MESSAGE_ADD_GUEST = "Error add guest";

    /**
     * Checks on visited guest page welcome.
     * @param newGuest Guest.
     * @return True if guest was visited page welcome, false another.
     */
    @Override
    public boolean isVisited(Guest newGuest) {
        List<Guest> guests = getAll();

        for (Guest guest:guests){
            if (guest.getName().equals(newGuest.getName()))
                return true;
        }

        return false;
    }
}
