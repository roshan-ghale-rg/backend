package com.uhcl.amazonsellers.controllers;
import com.uhcl.amazonsellers.domain.*;
import com.uhcl.amazonsellers.serviceImpl.CompetitiveSeller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/getSellers")
@CrossOrigin
public class DataMiningController {
    @Autowired
    private CompetitiveSeller competitiveSeller;


    @GetMapping(produces = "application/json", path="/competitor")
    //@RequestMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody List<AmazonData> getData(@RequestParam String asinNo){

        List<AmazonData> sellers= competitiveSeller.getCompetitiveSellersDetails(asinNo);
        return sellers;

    }

    @GetMapping(produces = "application/json", path="/competitorList")
    //@RequestMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody List<AmazonData> getTopSellerData(@RequestParam int queryId, int id){

            System.out.println("inside the top sellers"+ queryId +" "+ id);
        List<AmazonData> sellers= competitiveSeller.getTopSellers(queryId, id);
        return sellers;

    }

    @GetMapping(produces = "application/json",path = "/sales")

    public @ResponseBody List<SellerCashflow> getSales(@RequestParam  int sellerId){

        List<SellerCashflow> sales= competitiveSeller.getSales(sellerId);
        return sales;

    }

    @GetMapping(produces = "application/json",path = "/competitorKeywords")

    public @ResponseBody List<AlgorithmData> getAlgorithmKeywords(@RequestParam  long amazonId){

        List<AlgorithmData> keywords= competitiveSeller.getKeywords(amazonId);
        return keywords;

    }

/*    @GetMapping(produces = "application/json",path = "/rackKeywords")
    public @ResponseBody String getAlgorithmKeywords(@RequestParam  String description){

        String keywords= competitiveSeller.getRakeKeywords(description);
        return keywords;

    }*/




}
