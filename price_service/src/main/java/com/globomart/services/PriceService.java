package com.globomart.services;

import com.globomart.exceptions.ResourceNotFoundException;
import com.globomart.models.Price;
import com.globomart.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PriceService {

    @Autowired
    PriceRepository priceRepository;

    public Price createPrice(Price price) {
        price
        return priceRepository.save(price);
    }

    public Price getPrice(Long id) throws ResourceNotFoundException {
        Price price = priceRepository.findOne(id);
        if (price == null) {
            throw new ResourceNotFoundException(Price.class, "id", id.toString());
        }
        return price;
    }

    public void updatePrice(Long id, Price price) throws ResourceNotFoundException {
        checkResourceFound(id);
        priceRepository.save(price);
    }

    public void deletePrice(Long id) throws ResourceNotFoundException {
        checkResourceFound(id);
        priceRepository.delete(id);
    }

    private void checkResourceFound(Long id) throws ResourceNotFoundException {
        if (!priceRepository.exists(id)) {
            throw new ResourceNotFoundException(Price.class, "id", id.toString());
        }
    }
}
