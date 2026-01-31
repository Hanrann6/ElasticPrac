package com.example.es;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelController {

    private final HotelRepository hotelRepository;

    // 데이터 저장
    @PostMapping
    public Hotel save(@RequestBody HotelRequest request) {
        Hotel hotel = Hotel.builder()
                .id(UUID.randomUUID().toString())
                .name(request.name())
                .address(request.address())
                .build();
        return hotelRepository.save(hotel);
    }

    // 이름으로 검색 (/hotels/search?keyword=신라)
    @GetMapping("/search")
    public List<Hotel> search(@RequestParam String keyword) {
        // Nori가 적용되어 있어서 '신라'만 검색해도 '제주신라호텔'이 나옴
        return hotelRepository.findByName(keyword);
    }

    // DTO 데이터 받는 용도
    public record HotelRequest(String name, String address) {}
}
