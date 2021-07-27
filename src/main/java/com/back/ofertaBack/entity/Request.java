package com.back.ofertaBack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long agentId;

    @Column(nullable = false)
    private Long clientId;

    @Column(nullable = false)
    private String assetName;

    @Column(nullable = false)
    private String assetPrice;

    @Column(nullable = false)
    private String amount;

    private String status;

    private String description;

}
