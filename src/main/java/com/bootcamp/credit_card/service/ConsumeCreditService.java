package com.bootcamp.credit_card.service;

import com.bootcamp.credit_card.model.ConsumeCredit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ConsumeCreditService {
    Flux<ConsumeCredit> getAllConsumeCredit();

    //Mono<Deposit> getDeposit();
    Flux<ConsumeCredit> getForNroTarjCred(String code);

    Mono<ConsumeCredit> saveConsumeCredit(ConsumeCredit consumeCredit);

    Mono<ConsumeCredit> updateConsumeCredit(ConsumeCredit consumeCredit);

    Mono<ConsumeCredit> deleteConsumeCredit(String id);
}
