package com.example.stock.service;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.stock.pojo.IndexData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
 
@Service
@CacheConfig(cacheNames="index_datas")
public class IndexDataService {
//    private Map<String, List<IndexData>> indexDatas=new HashMap<>();
    @Autowired RestTemplate restTemplate;
 
    @HystrixCommand(fallbackMethod = "third_part_not_connected")
    @CachePut(key="'indexData-code-'+ #p0",unless = "#result[0].date == 'n/a' ")
//    @CachePut(key="'indexData-code-'+ #p0")
    public List<IndexData> fresh(String code) {
        List<IndexData> indexData = fetch_indexes_from_third_part(code);
        System.out.println(indexData.size());
        return indexData;
    }
     
    @CacheEvict(key="'indexData-code-'+ #p0")
    public void remove(String code){
         
    }
 
    @Cacheable(key="'indexData-code-'+ #p0")
    public List<IndexData> get(String code){
        return CollUtil.toList();
    }
     
    public List<IndexData> fetch_indexes_from_third_part(String code) {
//        List<Map> temp= restTemplate.getForObject("http://127.0.0.1:8090/indexes/"+code+".json",List.class);
//        List<Map> temp= restTemplate.getForObject("http://127.0.0.1:8000/getIndexData/"+code,List.class);
        List<Map> temp = restTemplate.getForObject("http://127.0.0.1:8000/getIndexData/" + code, List.class);
        return map2IndexData(temp);
    }
     
    private List<IndexData> map2IndexData(List<Map> temp) {
        List<IndexData> indexDatas = new ArrayList<>();
        for (Map map : temp) {
            String date = map.get("date").toString();
            float closePoint = Convert.toFloat(map.get("closePoint"));
            IndexData indexData = new IndexData();
             
            indexData.setDate(date);
            indexData.setClosePoint(closePoint);
            indexDatas.add(indexData);
        }
         
        return indexDatas;
    }
 
    public List<IndexData> third_part_not_connected(String code){
        IndexData index= new IndexData();
        index.setClosePoint(0);
        index.setDate("n/a");
        return CollectionUtil.toList(index);
    }
         
}