package br.com.achimid.financalc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRentableService {

    @Autowired
    RentableService rentableService;

    @Test
    public void test_calcularAmount() {
        BigDecimal aplicado = new BigDecimal(10);
        BigDecimal quantoTempoEmSemanas = new BigDecimal(30);

        BigDecimal amount = rentableService.calcularAmount(aplicado, quantoTempoEmSemanas);

        Assert.assertEquals(new BigDecimal(383.04).setScale(2, BigDecimal.ROUND_DOWN), amount);
    }

}
