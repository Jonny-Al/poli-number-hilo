package com.poli.hilos.service;

import com.poli.hilos.entity.EntityNumber;
import com.poli.hilos.repository.IEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NumberIndexService {

    private static final Logger logger = LoggerFactory.getLogger(NumberIndexService.class);

    @Autowired
    IEntityRepository entityRepository;
    private int numMayor = 0;

    public void executeInsert() {
        try {
            logger.info("**** executeInsert ****");
            logger.info("Eliminando registros y empezar de 0");
            entityRepository.deleteAll();
            logger.info("Inicio del insert en random");
            EntityNumber entityNumber = new EntityNumber();
            for (int i = 0; i < 1001; i++) {
                int random = (int) (Math.random() * 1000 + 1);
                entityNumber.setNumberIndex(random);
                entityRepository.save(entityNumber);
            }
            logger.info("**** Finaliza insert ****");
        } catch (Exception e) {
            logger.error("Exception in executeInsert(): ", e);
        }
    }

    @Async
    public void executeFirst() {
        try {
            logger.info("* Consultando primeros 500 (executeFirst)");
            List<EntityNumber> first = entityRepository.getTheHighestNumberFirstAll();
            int mayor = 0;
            for (EntityNumber number : first) {
                if (number.getNumberIndex() > mayor) {
                    mayor = number.getNumberIndex();
                }
            }
            logger.info("Numero mayor en executeFirst() es : {}", mayor);
            validNumberMayor(mayor);
        } catch (Exception e) {
            logger.error("Exception in executeFirst(): ", e);
        }
    }

    @Async
    public void executeLast() {
        try {
            logger.info("Consultando ultimos 500 (executeLast)");
            List<EntityNumber> last = entityRepository.getTheHighestNumberLastAll();
            int mayor = 0;
            for (EntityNumber number : last) {
                if (number.getNumberIndex() > mayor) {
                    mayor = number.getNumberIndex();
                }
            }
            logger.info("Numero mayor en executeLast() es : {}", mayor);
            validNumberMayor(mayor);
        } catch (Exception e) {
            logger.error("Exception in executeLast(): ", e);
        }
    }

    private void validNumberMayor(int number) {
        try {
            numMayor = (number > numMayor) ? number : numMayor;
            logger.error("Numero mayor de variable global es: " + numMayor);
        } catch (Exception e) {
            logger.error("Exception in validNumberMayor(): ", e);
        }
    }


}
