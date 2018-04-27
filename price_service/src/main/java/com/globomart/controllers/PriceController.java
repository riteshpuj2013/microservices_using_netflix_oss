package com.globomart.controllers;

import com.globomart.exceptions.ResourceNotFoundException;
import com.globomart.models.Price;
import com.globomart.services.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/ps")
public class PriceController {
    @Autowired
    PriceService priceService;

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Price createPrice(@RequestBody @Valid Price price) {
        log.info("createPrice price {}", price);
        return priceService.createPrice(price);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Price getPrice(@PathVariable("id") Long id) throws ResourceNotFoundException {
        log.info("getPrice id {}", id);
        return priceService.getPrice(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePrice(@PathVariable("id") Long id, @RequestBody @Valid Price price) throws ResourceNotFoundException {
        log.info("updatePrice id {} price {}", id, price);
        price.setId(id);
        priceService.updatePrice(id, price);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrice(@PathVariable("id") Long id) throws ResourceNotFoundException {
        log.info("deletePrice id {}", id);
        priceService.deletePrice(id);
    }

    @RequestMapping(value = "*", method = RequestMethod.GET)
    @ResponseBody
    public String getFallback() {
        return "Fallback for GET Requests";
    }
}
