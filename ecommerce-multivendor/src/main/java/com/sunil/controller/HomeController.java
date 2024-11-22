package com.sunil.controller;

import com.sunil.response.APIResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping()
    public APIResponse HomeControllerHandler() {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setResponse("Welcome to ecommerce multi vendor system");
        return apiResponse;
    }
}
