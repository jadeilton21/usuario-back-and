package com.jadeilton.usuario_back_end.infrastructure.exceptions;



public class ConflictException extends RuntimeException{

    public ConflictException(String mensage){
        super(mensage);
    }
    public ConflictException(String mensage, Throwable cause){
        super(mensage,cause);
    }



}
