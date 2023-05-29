gpackage com.bezkoder.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//new comment 2
import com.bezkoder.spring.jpa.h2.dto.ProductQuantityDto;
import com.bezkoder.spring.jpa.h2.dto.TotalSalesDTO;
import com.bezkoder.spring.jpa.h2.model.Sales;
import com.bezkoder.spring.jpa.h2.service.SalesService;
///
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping
    public ResponseEntity<List<Sales>> getAllSales() {
        List<Sales> sales = salesService.getAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }
    @GetMapping("/findTotalQuantityByProduct")
    public List<ProductQuantityDto> findTotalQuantityByProduct(){
        List<Object[]> list = salesService.findTotalQuantityByProduct();

        List<ProductQuantityDto> result = new ArrayList<>();
        for (Object[] obj : list) {
            String productName = obj[0].toString();
            int totalQuantity = Integer.parseInt(obj[1].toString());
            ProductQuantityDto dto = new ProductQuantityDto(productName, totalQuantity);
            result.add(dto);
        }

        return result;
    }
    
    
    @GetMapping("/findTotalRevenueByMonth")
    public List<TotalSalesDTO> findTotalRevenueByMonth() {
        List<Object[]> listbym = salesService.findTotalRevenueByMonth();
        List<TotalSalesDTO> result = new ArrayList<>();
        for (Object[] obj : listbym) {
            int month =  Integer.parseInt(obj[0].toString());
            Double totalRevenue = Double.parseDouble( obj[1].toString());
            TotalSalesDTO dto = new TotalSalesDTO(month, totalRevenue);
            result.add(dto);
        }
        return result;
    }

   

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSaleById(@PathVariable Long id) {
        Sales sale = salesService.getSaleById(id);
        if (sale != null) {
            return new ResponseEntity<>(sale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Sales> createSale(@RequestBody Sales sale) {
        Sales createdSale = salesService.createSale(sale);
        return new ResponseEntity<>(createdSale, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sales> updateSale(@PathVariable Long id, @RequestBody Sales sale) {
        Sales updatedSale = salesService.updateSale(id, sale);
        if (updatedSale != null) {
            return new ResponseEntity<>(updatedSale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        salesService.deleteSale(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
