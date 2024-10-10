package com.bloco.bloco.Service;


import com.bloco.bloco.PedidoRepository.PedidoRepository;
import com.bloco.bloco.model.Pedido;
import com.bloco.bloco.model.PedidoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido createPedido(PedidoRequestDTO data){
        Pedido newPedido = new Pedido();
        newPedido.setAndares(data.andares());
        newPedido.setCor1(data.cor1());
        newPedido.setCor2(data.cor2());
        newPedido.setCor3(data.cor3());
        newPedido.setDesenho1(data.desenho1());
        newPedido.setDesenho2(data.desenho2());
        newPedido.setDesenho3(data.desenho3());
        pedidoRepository.save(newPedido);
        return newPedido;
    }

    public List<Pedido> getAllPedido() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(UUID id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado."));
    }

    public Pedido updatePedido(UUID id, PedidoRequestDTO pedidoRequestoDTO) {
        Pedido updatePedido = getPedidoById(id);
        updatePedido.setAndares(pedidoRequestoDTO.andares());
        updatePedido.setCor1(pedidoRequestoDTO.cor1());
        updatePedido.setCor2(pedidoRequestoDTO.cor2());
        updatePedido.setCor3(pedidoRequestoDTO.cor3());
        updatePedido.setDesenho1(pedidoRequestoDTO.desenho1());
        updatePedido.setDesenho2(pedidoRequestoDTO.desenho2());
        updatePedido.setDesenho3(pedidoRequestoDTO.desenho3());

        return pedidoRepository.save(updatePedido);
    }
    public void deletePedido(UUID id){
        Pedido Pedido = getPedidoById(id);
        pedidoRepository.delete(Pedido);
    }
}