
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
public class UsuarioRolesDTO {
    private String login;
    private String nome;   
    private String roles;
    
   
    
    @Query(value = "SELECT new com.carros.api.demos.UsuarioRoleDTO(u.login,u.email,r.nome) FROM Usuarios u inner join u.roles r")
    
    
    public String toJson() throws JsonProcessingException{
    
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(this);
    
    }
    
    
    
}
