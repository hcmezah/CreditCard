package com.bootcamp.credit_card.repository;

import com.bootcamp.credit_card.model.ConsumeCredit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IConsumeCreditRepository extends ReactiveMongoRepository<ConsumeCredit,String> {

    Flux<ConsumeCredit> findByNroTarjetaCredito (String nroTarjetaCredito);

}
