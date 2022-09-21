package com.wendy.app.servicioitem.service;

import com.wendy.app.servicioitem.clientes.ProductoClienteRest;
import com.wendy.app.servicioitem.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Primary
public class ItemServiceFeign implements ItemService{

    @Autowired
    private ProductoClienteRest clientefeign;
    @Override
    public List<Item> findAll() {
        return clientefeign.listar().stream().map(p->new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(clientefeign.detalle(id),cantidad);
    }
}
