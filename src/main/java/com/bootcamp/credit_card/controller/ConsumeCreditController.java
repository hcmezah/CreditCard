package com.bootcamp.credit_card.controller;

import com.bootcamp.credit_card.model.ConsumeCredit;
import com.bootcamp.credit_card.service.ConsumeCreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consume-credit")
public class ConsumeCreditController {

    private final ConsumeCreditService service;
    @GetMapping
    public Flux<ConsumeCredit> getAll(){
        return this.service.getAllConsumeCredit();
    }

    @GetMapping("/{nroTarjetaCredito}")
    public Flux<ConsumeCredit> getForCode(@PathVariable("nroTarjetaCredito") String nroTarjetaCredito){
        return this.service.getForNroTarjCred(nroTarjetaCredito);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ConsumeCredit> createCosumeCredit(@RequestBody ConsumeCredit consumeCredit){
        return this.service.saveConsumeCredit(consumeCredit);
    }

    @PutMapping
    public Mono<ResponseEntity<ConsumeCredit>> update(@RequestBody ConsumeCredit consumeCredit){
        return this.service.updateConsumeCredit(consumeCredit).flatMap(dep -> Mono.just(ResponseEntity.ok(dep)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("{id}")
    public Mono<ResponseEntity<ConsumeCredit>>delete(@PathVariable("id") String id){
        return this.service.deleteConsumeCredit(id).flatMap(dep -> Mono.just(ResponseEntity.ok(dep)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
