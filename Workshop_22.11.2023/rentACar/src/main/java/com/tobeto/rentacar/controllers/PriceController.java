package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.PriceService;
import com.tobeto.rentacar.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rentacar.services.dtos.price.requests.DeletePriceRequest;
import com.tobeto.rentacar.services.dtos.price.requests.UpdatePriceRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/prices")
public class PriceController {
    private final PriceService priceService;


    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping
    public void add(@RequestBody AddPriceRequest request){
        priceService.add(request);
    }

    @PutMapping
    public void update(@RequestBody UpdatePriceRequest request){
        priceService.update(request);
    }

    @DeleteMapping
    public void delete(@RequestBody DeletePriceRequest request){
        priceService.delete(request);
    }
}
