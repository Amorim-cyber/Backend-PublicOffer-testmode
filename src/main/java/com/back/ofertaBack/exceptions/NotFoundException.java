package com.back.ofertaBack.exceptions;


import com.back.ofertaBack.util.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
