package com.perezcasal.designpatterns.patterns.behavioral.chain.filter;

import com.perezcasal.designpatterns.patterns.behavioral.chain.filter.processor.AuthenticationProcessor;
import com.perezcasal.designpatterns.patterns.behavioral.chain.filter.processor.CSRFProcessor;
import com.perezcasal.designpatterns.patterns.behavioral.chain.filter.provider.CSRFProvider;

public class FilterMain {
    public static void main(String[] args) {
        AuthenticationProcessor csrf = new CSRFProcessor(null);
        AuthenticationProcessor jwt = new CSRFProcessor(csrf);
        AuthenticationProcessor oauth = new CSRFProcessor(jwt);
        oauth.isAuthenticated(new CSRFProvider("c-s-r-f"));
    }
}
