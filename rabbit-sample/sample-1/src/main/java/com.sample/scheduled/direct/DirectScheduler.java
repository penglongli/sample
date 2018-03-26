package com.sample.scheduled.direct;

import com.sample.service.direct.DirectSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DirectScheduler {

    //private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    private DirectSender sender;


    @Scheduled(fixedRate = 2000)
    public void sayHi() {
        sender.sendHi();
    }

//    @Scheduled(fixedRate = 2000)
//    public void sayHello() {
//
//    }
}
