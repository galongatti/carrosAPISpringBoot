package webservice.carros.domain;
import lombok.Data;
import webservice.carros.domain.dto.CarroDTO;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity(name = "carro")
@Data
@NoArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "url_foto")
    private String urlFoto;
    
    @Column(name = "url_video")
    private String urlVideo;
    
    @Column(name = "latitude")
    private String latitude;
    
    @Column(name = "longitude")
    private String longitude;
         

   

}
