package com.uhcl.amazonsellers.serviceImpl;

import com.uhcl.amazonsellers.domain.Seller;
import com.uhcl.amazonsellers.repository.SellerRepository;
import com.uhcl.amazonsellers.service.EmailService;
import com.uhcl.amazonsellers.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private EmailService emailService;

    public boolean saveUser(Seller seller)
    {

        if(checkExistingUser(seller.getEmail())==null)
        {
            sellerRepository.save(seller);
            if(!StringUtils.isEmpty(seller.getEmail()))
                emailService.sendEmail(seller.getEmail(),"Welcome to Amazon Sellers","Dear "+seller.getFirstName()+", Thanks for signing up for Amazon Sellers");
            return true;
        }
        else
        {
            return  false;
        }

    }
   public Seller checkUser(Seller seller)
    {

        Seller amazonSeller = checkExistingUser(seller.getEmail());
        if(amazonSeller!=null && amazonSeller.getEmail().equalsIgnoreCase(seller.getEmail()) && amazonSeller.getPassword().equals(seller.getPassword()))
        {

           return  amazonSeller;
        }

        return null;

    }


    public  Seller checkExistingUser(String email)
    {

        return  sellerRepository.findByEmail(email);
    }

    public Seller update(Seller seller){
        if(seller==null || seller.getId()==null)
            return null;
        Seller obj=sellerRepository.findById(seller.getId()).orElse(new Seller());
        obj.setEmail(seller.getEmail());
        obj.setFirstName(seller.getFirstName());
        obj.setLastName(seller.getLastName());
        obj.setSellerId(seller.getSellerId());
        return sellerRepository.save(obj);
    }

    public Seller getSellerById(Long sellerId){
        return sellerRepository.findById(sellerId).get();
    }

}
