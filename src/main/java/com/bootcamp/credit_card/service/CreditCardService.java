package com.bootcamp.credit_card.service;

import com.bootcamp.credit_card.model.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {
    public Flux<CreditCard> findAll();
    public Mono<CreditCard> findByNroCuenta(String id);
    public Mono<CreditCard> save(CreditCard creditCard);
    public Mono<CreditCard> update(CreditCard creditCard);
    public void delete(String id);


}
