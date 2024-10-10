package com.bloco.bloco.PedidoRepository;

import com.bloco.bloco.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
    //Selecionar todos os pedidos
    @Query("SELECT p FROM Pedido p")
    List<Pedido> findAllPedido();
    //selecionar pedido pelo id
    @Query("SELECT p FROM Pedido p WHERE p.id = :id")
    Optional<Pedido> findByIdPedido(UUID id);

    //Atualizar Pedido
    @Query("UPDATE Pedido p SET p.andares=:andares, "+
            "p.cor1=:cor1, p.cor2=:cor2, p.cor3=:cor3, p.desenho1=:desenho1, p.desenho2=:desenho2, p.desenho3=:desenho3 WHERE p.id = :id")
    void updatepedido(UUID id, int andares, String cor1, String cor2, String cor3, String desenho1, String desenho2, String desenho3);
    //deletar Pedido
    @Query("DELETE FROM Pedido p WHERE p.id = :id")
    void deleteByIdPedido(UUID id);
}
