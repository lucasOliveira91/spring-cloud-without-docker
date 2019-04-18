package com.example.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-converter")
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {
        CurrencyConversionBean respo = proxy.retriveExchangeValue(from, to);
        return new CurrencyConversionBean(respo.getId(), from, to, respo.getConversionMultiple(), respo.getQuantity(), quantity.multiply(respo.getConversionMultiple()), 0);
    }
}
