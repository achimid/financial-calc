package br.com.achimid.financalc.controller;

import br.com.achimid.financalc.dto.RequestParams;
import br.com.achimid.financalc.service.RentableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/calcular")
public class RentableController {

    @Autowired
    private RentableService rentableService;

    @PostMapping
    public BigDecimal calcular(@RequestBody RequestParams params) {
        return rentableService.calcularAmount(params.getValorAplicado(), new BigDecimal(36));
    }
}
