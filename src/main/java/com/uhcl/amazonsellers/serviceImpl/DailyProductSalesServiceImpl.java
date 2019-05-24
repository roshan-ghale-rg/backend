package com.uhcl.amazonsellers.serviceImpl;

import com.uhcl.amazonsellers.domain.DailyProductSales;
import com.uhcl.amazonsellers.repository.DailyProductSalesRepository;
import com.uhcl.amazonsellers.service.DailyProductSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyProductSalesServiceImpl implements DailyProductSalesService {

    @Autowired
    private DailyProductSalesRepository salesRepo;

    public List<DailyProductSales> getAll(){
        return salesRepo.findAll();
    }

    public List<DailyProductSales> getAllByProductId(Long productId){
        return salesRepo.findByProductId(productId);
    }
}
