package com.lucas;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped //Essa anotação faz com que seja possivel injetar a classe, similar ao @Service do Spring
public class PedidoService {

    @Inject
    CreditoService creditoService;

    private Set<Long> pedidos = new HashSet<>();

    public void newPedido(Long id, int valor) {
        pedidos.add(id);

        try {
            creditoService.newPedidoValor(id, valor);
            System.out.println("Pedido: " + id + " " + "Valor: " + valor);
        } catch (IllegalStateException ex) {
            this.cancelPedido(id);
            System.out.println("Pedido: " + id + " " + "Valor: " + valor + " " + "Cancelado".toUpperCase());
        }
    }

    private void cancelPedido(Long id) {
         pedidos.remove(id);
    }
}
