//package webservice.carros;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import webservice.carros.domain.Carro;
//import webservice.carros.domain.CarroService;
//import webservice.carros.domain.dto.CarroDTO;
//import static junit.framework.TestCase.*;
//import java.util.List;
//import java.util.Optional;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class CarroServiceTest {
//
//    @Autowired
//    private CarroService service;
//
//    @Test
//    void testePOST() {
//
//        Carro carro = new Carro();
//        carro.setNome("Ferrari");
//        carro.setTipo("esportivos");
//
//        CarroDTO c = service.save(carro);
//
//        assertNotNull(c);
//        Long id = c.getId();
//
//        c = service.getCarroById(id);
//        assertNotNull(c);
//
//        assertEquals("Ferrari", c.getNome());
//        assertEquals("esportivos", c.getTipo());
//
//        service.delete(id);
//
//        try {
//            assertNull(service.getCarroById(id));
//            fail("O carro não foi excluido");
//        } catch (Exception e) {
//
//        }
//
//    }
//
//    @Test
//    public void testLIsta() {
//
//        List<CarroDTO> carros = service
//                .getCarros();
//
//        assertEquals(30, carros.size());
//
//    }
//
//}
