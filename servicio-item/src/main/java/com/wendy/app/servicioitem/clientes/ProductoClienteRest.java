package com.wendy.app.servicioitem.clientes;

import com.wendy.app.servicioitem.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "servicio-productos", url = "localhost:8001")
public interface ProductoClienteRest {

    @GetMapping("/listar") // ruta del otro servicio (productos)
    public List<Producto> listar();

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id);
}
