package com.lucas;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/compra-orquestrada")
public class CompraOrquestradaResource {

    @Inject
    private CreditoService creditoService;

    @Inject
    private PedidoService pedidoService;

    @GET
    @Path("teste")
    @Produces(MediaType.TEXT_PLAIN)
    public Response saga() {
        var id = 0l;

        comprar(++id, 20);
        comprar(++id, 20);
        comprar(++id, 20);
        comprar(++id, 20);
        comprar(++id, 20);
        comprar(++id, 20);
        return Response.ok().build();
    }

    private void comprar(Long id, int valor) {
        pedidoService.newPedido(id);

        try {
            creditoService.newPedidoValor(id, valor);
            System.out.println("Pedido: " + id + " " + "Valor: " + valor);
        } catch (IllegalStateException ex) {
            pedidoService.cancelPedido(id);
            System.out.println("Pedido: " + id + " " + "Valor: " + valor + " " + "Cancelado".toUpperCase());
        }
    }
}
