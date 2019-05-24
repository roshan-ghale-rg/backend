package com.uhcl.amazonsellers.controllers;
import com.uhcl.amazonsellers.domain.Seller;
import com.uhcl.amazonsellers.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/api/v1/seller")
@CrossOrigin
public class UserAuthenticationController {
    @Autowired
    private UserAuthenticationService authenticationServiceService;

    @PostMapping("/register")
    public boolean saveSellerDetails(@RequestBody Seller seller,
                                    BindingResult bindingResult) {
        boolean isRegistered=false;
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        isRegistered=authenticationServiceService.saveUser(seller);
        return isRegistered;
    }
    @PostMapping("/login")
    public ResponseEntity<Object> checkSellerDetails(@RequestBody Seller seller) {
        Seller res=authenticationServiceService.checkUser(seller);
        if(res==null)
            return new ResponseEntity<>(false,HttpStatus.OK);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateSeller(@RequestBody Seller seller){
        Seller res=authenticationServiceService.update(seller);
        if(res==null)
            return new ResponseEntity<>(false,HttpStatus.OK);

        return new ResponseEntity<>(res, HttpStatus.OK);

    }

}
