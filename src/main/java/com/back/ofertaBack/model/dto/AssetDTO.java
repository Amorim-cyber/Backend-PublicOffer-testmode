package com.back.ofertaBack.model.dto;

import javax.validation.constraints.NotNull;

public class AssetDTO {

    private Long id;

    @NotNull
    private String shortName;

    @NotNull
    private String longName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }
}
