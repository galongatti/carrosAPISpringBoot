package webservice.carros.domain.dto;

import lombok.Data;
import org.modelmapper.ModelMapper;
import webservice.carros.domain.Carro;

import javax.persistence.*;

@Data
public class CarroDTO {

    private long id;

    private String nome;

    private String tipo;

    public static CarroDTO create(Carro c){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(c,CarroDTO.class);

    }

}
