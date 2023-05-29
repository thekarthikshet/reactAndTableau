package com.bezkoder.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.jpa.h2.model.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
	//Top selling products by quantity:
	 @Query(value="SELECT s.product_Name, SUM(s.quantity) as tot FROM Sales s GROUP BY s.product_Name ORDER BY tot  desc limit 10",nativeQuery=true)
	    List<Object[]> findTotalQuantityByProduct();
	    
	    
	    
	/*
	 * @Query("SELECT FORMATDATETIME(s.date, 'MMMM') AS month_alias, SUM(s.price * s.quantity) AS total_revenue "
	 * + "FROM Sales s " + "GROUP BY month_alias " + "ORDER BY CASE month_alias " +
	 * "           WHEN 'January' THEN 1 " + "           WHEN 'February' THEN 2 " +
	 * "           WHEN 'March' THEN 3 " + "           WHEN 'April' THEN 4 " +
	 * "           WHEN 'May' THEN 5 " + "           WHEN 'June' THEN 6 " +
	 * "           WHEN 'July' THEN 7 " + "           WHEN 'August' THEN 8 " +
	 * "           WHEN 'September' THEN 9 " + "           WHEN 'October' THEN 10 "
	 * + "           WHEN 'November' THEN 11 " +
	 * "           WHEN 'December' THEN 12 " + "         END") List<Object[]>
	 * findTotalRevenueByMonth();
	 */
	 
	    @Query("SELECT MONTH(DATE) as m , SUM(QUANTITY  *PRICE ) AS TotalRevenue\r\n" + 
	    		"FROM Sales GROUP BY m")
	    List<Object[]> findTotalRevenueByMonth();




}


	

