package com.sample.scheduled.defaul;

import com.sample.service.defaul.DefaultSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DefaultScheduler {

    @Autowired
    public DefaultSender sender;

    @Scheduled(fixedRate = 500)
    public void sayHi() {
        sender.sendHi();
    }
}
