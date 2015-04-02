package com.springapp.manager;

import com.springapp.guest.Guest;

import java.util.List;

public interface ManagerGuest {
    public List<Guest> getAll();

    public void addGuest(Guest guest);

    public boolean isVisited(Guest guest);
}
