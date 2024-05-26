package com.quickstart.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

//    @Autowired //connect Dev to Laptop, field injection

    private Computer com;

    // constructor injection , no need Autowired
    public Dev(@Qualifier("laptop") Computer com) {
        this.com = com;
    }

//    @Autowired
//    R1 myBike;
    public void build() {
        com.compile();
        System.out.println("I'm building a Spring boot app!");
    }
}
