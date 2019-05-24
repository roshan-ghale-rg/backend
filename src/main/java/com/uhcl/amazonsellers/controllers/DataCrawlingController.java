package com.uhcl.amazonsellers.controllers;
import com.uhcl.amazonsellers.domain.AmazonData;
import com.uhcl.amazonsellers.domain.ScrappingData;
import com.uhcl.amazonsellers.serviceImpl.CompetitiveSeller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/getSellersDetails")
@CrossOrigin
public class DataCrawlingController {


    @Autowired
    private CompetitiveSeller competitiveSeller;
    @GetMapping(produces = "application/json")
    public @ResponseBody List<AmazonData> getSellersData()
    {

        List<AmazonData> sellers= competitiveSeller.getCompetitiveSellersDetails("B07F7K1G2X");
        return sellers;

    }



}
