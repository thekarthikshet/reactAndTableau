package com.bezkoder.spring.jpa.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.jpa.h2.model.Sales;
import com.bezkoder.spring.jpa.h2.repository.SalesRepository;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Sales getSaleById(Long id) {
        return salesRepository.findById(id).orElse(null);
    }

    public Sales createSale(Sales sale) {
        return salesRepository.save(sale);
    }
    
    public List<Object[]> findTotalQuantityByProduct()
    {
    	return salesRepository.findTotalQuantityByProduct();
    }
    
    
    public List<Object[]> findTotalRevenueByMonth()
    {
    	
    	return salesRepository.findTotalRevenueByMonth();
    }

    public Sales updateSale(Long id, Sales sale) {
        Sales existingSale = salesRepository.findById(id).orElse(null);
        if (existingSale != null) {
            existingSale.setProductName(sale.getProductName());
            existingSale.setCustomerName(sale.getCustomerName());
            existingSale.setQuantity(sale.getQuantity());
            existingSale.setPrice(sale.getPrice());
            existingSale.setDate(sale.getDate());
            return salesRepository.save(existingSale);
        }
        return null;
    }

    public void deleteSale(Long id) {
        salesRepository.deleteById(id);
    }

}
