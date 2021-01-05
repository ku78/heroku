package com.geekbrains.shop.service;

import com.geekbrains.shop.entities.MethodLogDetails;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionObjectHolder {

    private long amountClicks = 0;
    private List<MethodLogDetails> logDetails = new ArrayList<>();

    public SessionObjectHolder() {
        System.out.println("Session object created!");
    }

    public long getAmountClicks() {
        return amountClicks;
    }

    public List<MethodLogDetails> getLogDetails() {
        return logDetails;
    }

    public void addClick() {
        amountClicks++;
    }


}
