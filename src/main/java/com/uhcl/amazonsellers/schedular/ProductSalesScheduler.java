package com.uhcl.amazonsellers.schedular;

import com.uhcl.amazonsellers.domain.DailyProductSales;
import com.uhcl.amazonsellers.domain.Product;
import com.uhcl.amazonsellers.domain.ProductForecast;
import com.uhcl.amazonsellers.service.DailyProductSalesService;
import com.uhcl.amazonsellers.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class ProductSalesScheduler {

    private static Logger log = LoggerFactory.getLogger(EmailScheduler.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private DailyProductSalesService salesService;

    //Runs everyday at 1.05AM
    @Scheduled(cron = "0 1 5 * * ?")
    //@Scheduled(cron = "*/1 * * * * ?")
    public void updateSalesVelocity(){
        log.info("Running updateSalesVelocity cron");
        List<Product> products=productService.listAll();
        List<DailyProductSales> sales;
        for(Product p:products){
           sales=salesService.getAllByProductId(p.getId());
           log.info(sales.size()+" sales records fount for "+p.getName());
           p.setSalesVelocity(new BigDecimal(calculateSalesVelocity(sales)));
           log.info("New sales velocity "+p.getSalesVelocity());
           p.setProductForecast(calculateProductForcast(p.getProductForecast(),p));
           productService.updateProduct(p);
        }

    }

    public ProductForecast calculateProductForcast(ProductForecast pf,Product p){
        if(p.getCurrentStock()!=null&&p.getCurrentStock()!=0){
            int currentStock=p.getCurrentStock();
            double salesVelocity=p.getSalesVelocity().doubleValue();
            Double ooStock=currentStock/(salesVelocity);
            int safetyStock=currentStock/10;//10% safety stock
            pf.setOoStock(ooStock.intValue()-safetyStock);
        }
        if(pf.getOoStock()!=null&&pf.getOoStock()!=0&&pf.getLeadTime()!=null&&pf.getLeadTime()!=0){
            pf.setReorder(pf.getOoStock()-pf.getLeadTime());
        }

        return  pf;
    }

    public Double calculateSalesVelocity(List<DailyProductSales> list){

        double salesVelocity=0.001;
        int totalSales=0;
        for(DailyProductSales p:list){
            totalSales+=p.getItemsSold();
        }

        if(totalSales>0)
            salesVelocity=totalSales/list.size();

        return salesVelocity;
    }
}
