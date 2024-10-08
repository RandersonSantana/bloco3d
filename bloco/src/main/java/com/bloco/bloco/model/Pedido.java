package com.bloco.bloco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name ="pedido")
public class Pedido {
    @Id
    @GeneratedValue
    private UUID id;
    private int andares;
    private  String cor1;
    private  String cor2;
    private  String cor3;
    private  String desenho1;
    private  String desenho3;
    private  String desenho2;
}