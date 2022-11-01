package com.example.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

class MyOrder {

}

public class DemoService {

    // Programmatic transaction

    @Autowired
    private TransactionTemplate transactionTemplate;

    public void processOrdering(MyOrder order){
        transactionTemplate.execute( status -> {
            // 1. Generate a new order in DB
            // 2. Generate a new invoice in DB
            return order;
        });
        // 3. Call payment gateway => API
        transactionTemplate.execute( status -> {
            // 4. Save payment result to DB
            // 5. Create subscription in DB
            return "";
        });
        // 6. Send invoice to email => API
    }


}
