package com.example.stock.service;
 
import java.util.List;

import com.example.stock.pojo.IndexData;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.hutool.core.collection.CollUtil;
 
@Service
@CacheConfig(cacheNames="index_datas")
public class IndexDataService {
 
    @Cacheable(key="'indexData-code-'+ #p0")
    public List<IndexData> get(String code){
        return CollUtil.toList();
    }
}