package com.springapp.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * GuestService for add and find guests.
 */
@Repository
public class GuestService {

    /**
     * Adds new guest.
     * @param guest New Guest.
     */
    public void addGuest(Guest guest) {
        if (!mongoTemplate.collectionExists(Guest.class)) {
            mongoTemplate.createCollection(Guest.class);
        }

        mongoTemplate.insert(guest, COLLECTION_NAME);
    }

    /**
     * MongoTemplate for access to MongoDB.
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Name collection.
     */
    public static final String COLLECTION_NAME = "guests";

    /**
     * Finds guest by name.
     * @param name Name guest.
     * @return Reference on guest or null if can't find guest.s
     */
    public Guest findGuest(String name){
        return  mongoTemplate.findOne(Query.query(Criteria.where("_id").is(name)),
                Guest.class, COLLECTION_NAME);
    }
}
