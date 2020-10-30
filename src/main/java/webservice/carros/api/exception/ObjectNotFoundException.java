/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice.carros.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author gabriel
 */

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException{
    
    
    public ObjectNotFoundException(String message){
        super(message);
    }
    
    public ObjectNotFoundException(String message, Throwable cause){
    
        super(message,cause);
    
    }
    
}
