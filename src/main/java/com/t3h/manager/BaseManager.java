package com.t3h.manager;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseManager {
    @Autowired
    protected DSLContext dslContext;


    public DSLContext getDslContext(){
        return dslContext;
    }
}
