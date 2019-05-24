package com.uhcl.amazonsellers.controllers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/getProfit")
@CrossOrigin
public class ProfitAnalysisController  implements Serializable{

    @GetMapping(path = "/week")
    public @ResponseBody String getProfitSalesInfo(){

        String message;
        ArrayList<Integer> sales= new ArrayList<>();
        sales.add(65);
        sales.add(59);
        sales.add(80);
        sales.add(81);
        sales.add(56);
        sales.add(56);
        sales.add(40);

        ArrayList<Integer> profit= new ArrayList<>();
        profit.add(28);
        profit.add(48);
        profit.add(40);
        profit.add(19);
        profit.add(86);
        profit.add(27);
        profit.add(90);

ArrayList<String> days= new ArrayList<>();
        days.add("Feb 9, 2019");
        days.add("Feb 10, 2019");
        days.add("Feb 11, 2019");
        days.add("Feb 12, 2019");
        days.add("Feb 13, 2019");
        days.add("Feb 14, 2019");
        days.add("Feb 15, 2019");


        JSONObject sellersAnalysis = new JSONObject();
        sellersAnalysis.put("SellerId", "1644256");

        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();

        item.put("information", "Profit and sales for the last 7 days");
        item.put("Marketplace Id", 3);
        item.put("Name", "Seller One");
        array.put(item);

        sellersAnalysis.put("Profile", array);
        sellersAnalysis.put("sales",sales);
        sellersAnalysis.put("profit",profit);
        sellersAnalysis.put("days",days);


        message = sellersAnalysis.toString();
        return message;
    }




}
