package com.wendy.app.servicioitem.service;

import com.wendy.app.servicioitem.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();
    Item findById(Long id, Integer cantidad);
}
