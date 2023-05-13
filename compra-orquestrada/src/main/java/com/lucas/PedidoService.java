package com.lucas;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped //Essa anotação faz com que seja possivel injetar a classe, similar ao @Service do Spring
public class PedidoService {

    private Set<Long> pedidos = new HashSet<>();

    public void newPedido(Long id) {
        pedidos.add(id);
    }

    public void cancelPedido(Long id) {
         pedidos.remove(id);
    }
}
