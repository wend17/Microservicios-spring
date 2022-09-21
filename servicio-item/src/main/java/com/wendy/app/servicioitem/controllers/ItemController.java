package com.wendy.app.servicioitem.controllers;

import com.wendy.app.servicioitem.models.Item;
import com.wendy.app.servicioitem.models.Producto;
import com.wendy.app.servicioitem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/listar")
    public List<Item> listar() {
        return itemService.findAll();
    }

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
        return itemService.findById(id, cantidad);
    }

}
