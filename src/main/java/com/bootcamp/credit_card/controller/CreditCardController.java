package com.bootcamp.credit_card.controller;

import com.bootcamp.credit_card.model.CreditCard;
import com.bootcamp.credit_card.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit_card")
public class CreditCardController {

    private final CreditCardService service;

    @GetMapping
    public Flux<CreditCard> getCreditCards() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<CreditCard> getCreditCard(@PathVariable("id") String id) {
        return service.findByNroCuenta(id);
    }

    @PostMapping
    public Mono<CreditCard> saveCreditCard(@RequestBody CreditCard creditCard){
        return service.save(creditCard);
    }

    @PutMapping
    public Mono<CreditCard> updateCreditCard(@RequestBody CreditCard creditCard){
        return service.update(creditCard);
    }

    @DeleteMapping("/{id}")
    public void deleteCreditCard(@PathVariable("id") String id) {
        service.delete(id);
    }

}
