package com.perezcasal.initoauth.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuthController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/page1")
    public String page1(Model model, @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient
            , @AuthenticationPrincipal OAuth2User auth2User) {

        model.addAttribute("message", " Init with Thymeleaf");
        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
        model.addAttribute("clientId", authorizedClient.getClientRegistration().getClientId());
        model.addAttribute("clientSecret", authorizedClient.getClientRegistration().getClientSecret());
        model.addAttribute("clientRegistrationId", authorizedClient.getClientRegistration().getRegistrationId());
        model.addAttribute("clientAuthorizationType", authorizedClient.getClientRegistration().getAuthorizationGrantType().getValue());
        model.addAttribute("clientRedirectUri", authorizedClient.getClientRegistration().getRedirectUri());

        model.addAttribute("userName", auth2User.getName());
        model.addAttribute("userAttributes", auth2User.getAttributes());
        return "page1";
    }



}
