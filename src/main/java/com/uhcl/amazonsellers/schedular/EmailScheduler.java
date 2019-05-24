package com.uhcl.amazonsellers.schedular;

import com.uhcl.amazonsellers.domain.Product;
import com.uhcl.amazonsellers.domain.Seller;
import com.uhcl.amazonsellers.repository.ProductRepository;
import com.uhcl.amazonsellers.service.EmailService;
import com.uhcl.amazonsellers.service.ProductService;
import com.uhcl.amazonsellers.service.UserAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
public class EmailScheduler {

    private static Logger log = LoggerFactory.getLogger(EmailScheduler.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserAuthenticationService sellerService;
//Runs everyday at 1.01AM
    @Scheduled(cron = "0 1 1 * * ?")
    public void sendEmailReminders(){
        long now = System.currentTimeMillis() / 1000;
        log.info(
                "schedule tasks using cron jobs - " + now);

        List<Product> list=productService.listAllOOStock();

        for(Product p:list){
            if(p.getSellerId()!=null){
                Seller s=sellerService.getSellerById(p.getSellerId());

                if(s.getEmail()!=null&& !"".equalsIgnoreCase(s.getEmail())){
                    emailService.sendEmail(s.getEmail(),p.getAsin()+" stock is less than lead time","Dear "+s.getFirstName()+", "+p.getName()+" with ASIN number "+p.getAsin()+" has only "+p.getCurrentStock()+" left. Please reorder it.");
                }
            }
        }
    }

}
