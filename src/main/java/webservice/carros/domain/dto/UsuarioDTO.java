
package webservice.carros.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.modelmapper.ModelMapper;
import webservice.carros.domain.Usuario;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {
    private String login;
    private String nome;
    private String email;    
    private String token;
    
    private List<String> roles;
    
    public static UsuarioDTO create(Usuario user){
    
        ModelMapper modelMapper = new ModelMapper();
        UsuarioDTO dto = modelMapper.map(user, UsuarioDTO.class);   
        dto.roles = user.getRoles().stream().map(r -> r.getNome()).collect(Collectors.toList());
        return dto;
    
    }
    
    public static UsuarioDTO create(Usuario user, String token){
    
        UsuarioDTO dto = create(user);
        dto.token = token;
        return dto;
    
    }
    
    public String toJson() throws JsonProcessingException{
    
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(this);
    
    }
    
    
    
}
