package com.example.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface HotelRepository extends ElasticsearchRepository<Hotel, String> {

    // 이름이나 주소에 검색어가 포함된 호텔 찾기
    List<Hotel> findByName(String name);

    List<Hotel> findByAddress(String address);
}
