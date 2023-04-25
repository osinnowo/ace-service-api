package com.appcoy.ace.api.service;

import com.appcoy.ace.api.model.Item;
import com.appcoy.ace.api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    protected ItemRepository repository;

    public List<Item> getItems() {
        return repository.findAll();
    }
}
