package com.back.ofertaBack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;

    private Long agentId;

    private Long clientId;

    private String assetName;

    private String assetPrice;

    private String amount;

}
