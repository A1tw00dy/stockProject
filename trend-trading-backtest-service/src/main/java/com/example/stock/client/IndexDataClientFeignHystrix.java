package com.example.stock.client;
 
import java.util.List;

import com.example.stock.pojo.IndexData;
import org.springframework.stereotype.Component;

import cn.hutool.core.collection.CollectionUtil;
 
@Component
public class IndexDataClientFeignHystrix implements IndexDataClient {
 
    @Override
    public List<IndexData> getIndexData(String code) {
        IndexData indexData = new IndexData();
        indexData.setClosePoint(0);
        indexData.setDate("0000-00-00");
        return CollectionUtil.toList(indexData);
    }
 
}