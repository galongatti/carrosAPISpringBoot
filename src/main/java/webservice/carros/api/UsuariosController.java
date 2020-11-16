
package webservice.carros.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webservice.carros.api.security.jwt.JwtUtil;
import webservice.carros.domain.Usuario;
import webservice.carros.domain.UsuarioService;
import webservice.carros.domain.dto.UsuarioDTO;


@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public ResponseEntity get(){
        List<UsuarioDTO> listaUsuarios = usuarioService.getUsuarios();
        return ResponseEntity.ok(listaUsuarios);    
    }
    
    @GetMapping("/userInfo")
    public UserDetails userInfo(@AuthenticationPrincipal Usuario user){
        
        Usuario userDetails = (Usuario) JwtUtil.getUserDetails();
        return userDetails;
    
    }
    
}
