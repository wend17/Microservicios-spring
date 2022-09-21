package com.wendy.app.servicioitem.service;

import com.wendy.app.servicioitem.models.Item;
import com.wendy.app.servicioitem.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
        return productos.stream().map(p->new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathvariables = new HashMap<String, String>();
        pathvariables.put("id", id.toString());
        Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}",Producto.class, pathvariables);
        return new Item(producto,cantidad);
    }
}
