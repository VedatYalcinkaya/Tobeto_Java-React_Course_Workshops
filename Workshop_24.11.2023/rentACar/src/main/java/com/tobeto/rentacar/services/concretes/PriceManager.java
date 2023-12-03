package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.entities.Price;
import com.tobeto.rentacar.repositories.PriceRepository;
import com.tobeto.rentacar.services.abstracts.PriceService;
import com.tobeto.rentacar.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rentacar.services.dtos.price.requests.DeletePriceRequest;
import com.tobeto.rentacar.services.dtos.price.requests.UpdatePriceRequest;
import com.tobeto.rentacar.services.dtos.price.responses.GetPriceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceManager implements PriceService {

    private final PriceRepository priceRepository;

    public PriceManager(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void add(AddPriceRequest request) {
        if (request.getDailyPrice() < 200 || request.getWeeklyPrice() < 600 || request.getMonthlyPrice() <1800)
            throw new RuntimeException("Günlük 200, Haftalık 600, Yıllık 1800'den aşağı fiyat veremezsiniz");

        Price price = new Price();
        price.setDailyPrice(request.getDailyPrice());
        price.setWeeklyPrice(request.getWeeklyPrice());
        price.setMonthlyPrice(request.getMonthlyPrice());
        priceRepository.save(price);
    }

    @Override
    public void update(UpdatePriceRequest request) {
        if (request.getDailyPrice() < 200 || request.getWeeklyPrice() < 600 || request.getMonthlyPrice() <1800)
            throw new RuntimeException("Günlük 200, Haftalık 600, Yıllık 1800'den aşağı fiyat veremezsiniz");

        Price priceToUpdate = priceRepository.findById(request.getId()).orElseThrow();
        priceToUpdate.setDailyPrice(request.getDailyPrice());
        priceToUpdate.setWeeklyPrice(request.getWeeklyPrice());
        priceToUpdate.setMonthlyPrice(request.getMonthlyPrice());
        priceRepository.save(priceToUpdate);
    }

    @Override
    public void delete(DeletePriceRequest request) {
        Price priceToDelete = priceRepository.findById(request.getId()).orElseThrow();
        priceRepository.delete(priceToDelete);
    }

    @Override
    public List<GetPriceResponse> getPriceAsc() {
        return priceRepository.findPricesAsc();
    }

    @Override
    public List<GetPriceResponse> getPriceDesc() {
        return priceRepository.findPricesDesc();
    }
}
