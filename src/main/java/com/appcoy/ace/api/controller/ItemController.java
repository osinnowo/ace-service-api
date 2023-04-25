package com.appcoy.ace.api.controller;

import com.appcoy.ace.api.service.ItemService;
import com.appcoy.ace.api.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    protected ItemService service;

    @GetMapping
    public ResponseEntity getItems() {
        return ResponseEntity.ok(BaseResponse.ok(service.getItems()));
    }
}
