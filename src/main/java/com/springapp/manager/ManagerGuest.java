package com.springapp.manager;

import com.springapp.guest.Guest;

import java.util.List;

/**
 * Interface for manage guests.
 */
public interface ManagerGuest {
    /**
     * Gets all guests.
     * @return List guests.
     */
    public List<Guest> getAll();

    /**
     * Adds new guest.
     * @param guest Guest.
     */
    public void addGuest(Guest guest);

    /**
     * Checks on visited guest page welcome.
     * @param guest Guest.
     * @return True if guest was visited page welcome, false another.
     */
    public boolean isVisited(Guest guest);
}
