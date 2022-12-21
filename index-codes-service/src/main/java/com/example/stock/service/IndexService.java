package com.example.stock.service;
 
import java.util.List;

import com.example.stock.pojo.Index;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.hutool.core.collection.CollUtil;
 
@Service
@CacheConfig(cacheNames="indexes")
public class IndexService {
    private List<Index> indexes;
 
    @Cacheable(key="'all_codes'")
    public List<Index> get(){
        Index index = new Index();
        index.setName("无效指数代码");
        index.setCode("000000");
        return CollUtil.toList(index);
    }
}