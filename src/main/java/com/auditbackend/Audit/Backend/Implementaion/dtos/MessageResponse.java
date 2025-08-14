package com.auditbackend.Audit.Backend.Implementaion.dtos;

import lombok.Data;

@Data

public class MessageResponse {
    private String message;

    public MessageResponse(String message){
        this.message = message;
    }
}
