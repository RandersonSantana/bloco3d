package com.bloco.bloco.controller;

import com.bloco.bloco.Service.PedidoService;
import com.bloco.bloco.model.Pedido;
import com.bloco.bloco.model.PedidoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
    @RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @Operation(description = "Buscar todos os pedidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "tudo certo"),
            @ApiResponse(responseCode = "400", description = "Não encontrado pedidos"),
            @ApiResponse(responseCode = "404", description = "Página não encontrada")
    })
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Pedido> create(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        Pedido newPedido = this.pedidoService.createPedido(pedidoRequestDTO);
        return ResponseEntity.ok(newPedido);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "tudo certo"),
            @ApiResponse(responseCode = "400", description = "Não encontrado pedidos"),
            @ApiResponse(responseCode = "404", description = "Página não encontrada")
    })
    @GetMapping
    public  ResponseEntity<List<Pedido>>  getAllPedido(){
        List<Pedido> pedidos = this.pedidoService.getAllPedido();
        return ResponseEntity.ok(pedidos);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "tudo certo"),
            @ApiResponse(responseCode = "400", description = "Não encontrado pedidos"),
            @ApiResponse(responseCode = "404", description = "Página não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") UUID id){
        Pedido pedido = this.pedidoService.getPedidoById(id);
        return ResponseEntity.ok(pedido);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "tudo certo"),
            @ApiResponse(responseCode = "400", description = "Não encontrado pedidos"),
            @ApiResponse(responseCode = "404", description = "Página não encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> UpdatePedido(
            @PathVariable("id")UUID id, PedidoRequestDTO pedidoRequestDTO){
        Pedido updatePedido = this.pedidoService.updatePedido(id, pedidoRequestDTO);
        return  ResponseEntity.ok(updatePedido);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable("id")UUID id){
        this.pedidoService.deletePedido(id);
        return  ResponseEntity.noContent().build();
    }
}
