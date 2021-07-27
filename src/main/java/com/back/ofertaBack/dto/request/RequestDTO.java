package com.back.ofertaBack.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

    private Long id;

    @NotEmpty
    private Long agentId;

    @NotEmpty
    private Long clientId;

    @NotEmpty
    private String assetName;

    @NotEmpty
    private String assetPrice;

    @NotEmpty
    private String amount;

    private String status;

    private String description;

}
