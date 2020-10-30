package webservice.carros.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import webservice.carros.domain.dto.CarroDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import webservice.carros.api.exception.ObjectNotFoundException;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros() {
        return rep.findAll().stream().map(c -> CarroDTO.create(c)).collect(Collectors.toList());
    }

    public CarroDTO getCarroById(Long id){
        return rep.findById(id).map(c -> CarroDTO.create(c)).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<CarroDTO> getCarroByTipo(String tipo) {

        /*
        * Optional<Carro> carro = rep.findByTipo;
        * if(carro.isPresent()){
        *   return Optional.ofNullable(new CarroDTO(carro.get()))
        *else {
        *   return null
        * }
        * */
        return rep.findByTipo(tipo)
                .stream()
                .map(c -> CarroDTO.create(c))
                .collect(Collectors.toList());

    }

    public CarroDTO save(Carro carro) {
        Assert.notNull(carro.getId(), "Não deve informar o id");
        Assert.notNull(carro, "Não foi possível inserir o registro");
        return CarroDTO.create(rep.save(carro));
    }

    public CarroDTO update(Carro carro) {

        CarroDTO optional = getCarroById(carro.getId());

        Carro db = new Carro();
        db.setNome(carro.getNome());
        db.setTipo(carro.getTipo());
        return CarroDTO.create(rep.save(db));

    }

    public void delete(long id) {
        rep.deleteById(id);

    }
}
