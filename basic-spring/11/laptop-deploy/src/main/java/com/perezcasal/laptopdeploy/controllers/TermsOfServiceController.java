package com.perezcasal.laptopdeploy.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Tag(name = "Term of Service")
public class TermsOfServiceController {

    @Operation(summary = "Term of Service", description = "Test of Term of Service Page.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "text/plain"))
    })
    @GetMapping(value = "${app.environment}", produces = "text/plain")
    public String termOfService() {
        return "This is a project in production. Thanks for all.";
    }
}
