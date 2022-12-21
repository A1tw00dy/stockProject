package com.example.stock.controller;
 
import java.util.List;

import com.example.stock.pojo.Index;
import com.example.stock.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

  
@RestController
public class IndexController {
    @Autowired
    IndexService indexService;
 
    @GetMapping("/getCodes")
    public List<Index> get() {
        return indexService.get();
    }

    @GetMapping("freshCodes")
    public List<Index> fresh(){
        return indexService.fresh();
    }


    @GetMapping("removeCodes")
    public String remove(){
        indexService.remove();
        return "remove codes successfully";
    }
}