package com.lucas;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/compra-coreografada")
public class CompraCoreografadaResource {

    @Inject
    private PedidoService pedidoService;

    @GET
    @Path("teste")
    @Produces(MediaType.TEXT_PLAIN)
    public Response saga() {
        var id = 0l;

        pedidoService.newPedido(++id, 20);
        pedidoService.newPedido(++id, 20);
        pedidoService.newPedido(++id, 20);
        pedidoService.newPedido(++id, 20);
        pedidoService.newPedido(++id, 20);
        pedidoService.newPedido(++id, 20);
        return Response.ok().build();
    }
}
