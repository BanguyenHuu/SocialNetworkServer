/*
 * This file is generated by jOOQ.
*/
package com.t3h.mysql.tables.records;


import com.t3h.mysql.tables.Friends;

import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FriendsRecord extends UpdatableRecordImpl<FriendsRecord> implements Record3<String, String, Date> {

    private static final long serialVersionUID = 190097121;

    /**
     * Setter for <code>doan.friends.user1_id</code>.
     */
    public void setUser1Id(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>doan.friends.user1_id</code>.
     */
    public String getUser1Id() {
        return (String) get(0);
    }

    /**
     * Setter for <code>doan.friends.user2_id</code>.
     */
    public void setUser2Id(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>doan.friends.user2_id</code>.
     */
    public String getUser2Id() {
        return (String) get(1);
    }

    /**
     * Setter for <code>doan.friends.time_create</code>.
     */
    public void setTimeCreate(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>doan.friends.time_create</code>.
     */
    public Date getTimeCreate() {
        return (Date) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, Date> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<String, String, Date> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Friends.FRIENDS.USER1_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Friends.FRIENDS.USER2_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field3() {
        return Friends.FRIENDS.TIME_CREATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getUser1Id();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUser2Id();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value3() {
        return getTimeCreate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FriendsRecord value1(String value) {
        setUser1Id(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FriendsRecord value2(String value) {
        setUser2Id(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FriendsRecord value3(Date value) {
        setTimeCreate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FriendsRecord values(String value1, String value2, Date value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FriendsRecord
     */
    public FriendsRecord() {
        super(Friends.FRIENDS);
    }

    /**
     * Create a detached, initialised FriendsRecord
     */
    public FriendsRecord(String user1Id, String user2Id, Date timeCreate) {
        super(Friends.FRIENDS);

        set(0, user1Id);
        set(1, user2Id);
        set(2, timeCreate);
    }
}