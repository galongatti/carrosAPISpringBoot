///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package webservice.carros;
//
//import java.net.URI;
//import java.util.List;
//import junit.framework.TestCase;
//import static junit.framework.TestCase.*;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import webservice.carros.domain.Carro;
//import webservice.carros.domain.dto.CarroDTO;
//
///**
// *
// * @author gabriel
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = CarrosApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class CarroAPITest {
//
//    @Autowired
//    private TestRestTemplate rest;
//
//    public ResponseEntity getCarro(String url) {
//        ResponseEntity listaCarros = rest.withBasicAuth("admin", "123").getForEntity(url, CarroDTO.class);
//        return listaCarros;
//        return new ResponseEntity<>(listaCarros, HttpStatus.OK);
//    }
//
//    public ResponseEntity getCarros(String url) {
//
//        return rest.withBasicAuth("admin", "123").exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CarroDTO>>() {
//
//        });
//
//    }
//
//    @Test
//    public void testList() {
//        List<CarroDTO> carros = (List<CarroDTO>) getCarros("/api/v1/carros").getBody();
//        assertNotNull(carros);
//        TestCase.assertEquals(30, carros.size());
//    }
//
//    @Test
//    public void testListaPortTipo() {
//
//        List<CarroDTO> carros = (List<CarroDTO>) getCarros("/api/v1/carros/tipo/classicos").getBody();
//        assertEquals(10, carros.size());
//
//        carros = (List<CarroDTO>) getCarros("/api/v1/carros/tipo/esportivos").getBody();
//        assertEquals(10, carros.size());
//
//        carros = (List<CarroDTO>) getCarros("/api/v1/carros/tipo/luxo").getBody();
//        assertEquals(10, carros.size());
//
//        HttpStatus status = getCarros("/api/v1/carros/tipo/XXX").getStatusCode();
//        assertEquals(HttpStatus.NO_CONTENT, status);
//
//    }
//
//    @Test
//    public void testeGetOk() {
//
//        ResponseEntity<CarroDTO> response = getCarro("/api/v1/carros/11");
//        assertEquals(response.getStatusCode(), HttpStatus.OK);
//
//        CarroDTO c = response.getBody();
//        assertEquals("Ferrari FF", c.getNome());
//
//    }
//
//    @Test
//    public void testGetNotFound() {
//
//        ResponseEntity response = getCarro("/api/v1/carros/1100");
//        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
//
//    }
//
//    private URI getUri(Long id) {
//        return ServletUriComponentsBuilder.fromCurrentRequestUri()
//                .path("/{id}")
//                .buildAndExpand(id)
//                .toUri();
//    }
//
//    @Test
//    public void testSave() {
//
//        Carro carro = new Carro();
//        carro.setNome("Porshe");
//        carro.setTipo("esportivos");
//
//        ResponseEntity response = rest.withBasicAuth("admin", "123").postForEntity("/api/v1/carros", carro, null);
//        System.out.println(response);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//
//        String location = response.getHeaders().get("location").get(0);
//        CarroDTO c = (CarroDTO) getCarro(location).getBody();
//
//        assertNotNull(c);
//        assertEquals("Porshe", c.getNome());
//        assertEquals("esportivos", c.getTipo());
//
//        rest.withBasicAuth("admin", "123").delete(location);
//
//        assertEquals(HttpStatus.NOT_FOUND, getCarro(location).getStatusCode());
//
//    }
//
//}
