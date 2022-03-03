package com.bootcamp.credit_card.service.impl;

import com.bootcamp.credit_card.model.CreditCard;
import com.bootcamp.credit_card.repository.ICreditCardRepository;
import com.bootcamp.credit_card.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final ICreditCardRepository repository;

    @Override
    public Flux<CreditCard> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<CreditCard> findByNroCuenta(String id) {
        return repository.findByNroCuenta(id);
    }

    @Override
    public Mono<CreditCard> save(CreditCard creditCard) {

        Integer digitCode1 = (int) (10000 * Math.random());
        Integer digitCode2 = (int) (10000 * Math.random());
        Integer digitCode3 = (int) (10000 * Math.random());
        Integer digitCode4 = (int) (10000 * Math.random());
        String nro_cuenta=digitCode1.toString()+"-"+digitCode2.toString()+"-"+digitCode3.toString()+"-"+digitCode4.toString();
        creditCard.setNroCuenta(nro_cuenta);
        Integer limite = (int) (10000 * Math.random());
        creditCard.setLimiteConsumo(limite);
        creditCard.setCantidadConsumo(0);
        creditCard.setSaldo(limite);

        return repository.save(creditCard);
    }

    @Override
    public Mono<CreditCard> update(CreditCard creditCard) {
        Integer digitCode1 = (int) (10000 * Math.random());
        Integer digitCode2 = (int) (10000 * Math.random());
        Integer digitCode3 = (int) (10000 * Math.random());
        Integer digitCode4 = (int) (10000 * Math.random());
        String nro_cuenta=digitCode1.toString()+"-"+digitCode2.toString()+"-"+digitCode3.toString()+"-"+digitCode4.toString();
        creditCard.setNroCuenta(nro_cuenta);
        Integer limite = (int) (10000 * Math.random());
        creditCard.setLimiteConsumo(limite);
        creditCard.setCantidadConsumo(0);
        creditCard.setSaldo(limite);

        return repository.save(creditCard);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id).subscribe();

    }
}
