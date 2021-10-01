package com.dh.clinica;



import com.dh.clinica.model.Odontologo;
import com.dh.clinica.service.OdontologoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTests {
        @Autowired
        private OdontologoService odontologoService;


        public void cargarDataSet() {
                this.odontologoService.guardar(new Odontologo("Amy", "Santiago", 4567898));
        }

        @Test
        public void agregarOdontologo() {
                this.cargarDataSet();
                Odontologo odontologo = odontologoService.guardar(new Odontologo("Jake", "Peralta", 99999999));
                Assert.assertTrue(odontologo.getId() != null);

        }


        @Test
        public void traerTodos() {
                this.cargarDataSet();
                List<Odontologo> odontologos = odontologoService.obtenerTodos();
                Assert.assertTrue(!odontologos.isEmpty());
                Assert.assertTrue(odontologos.size() == 1);
                System.out.println(odontologos);
        }

}