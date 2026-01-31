package com.example.es;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Getter
@Setter
@Builder
// 인덱스 이름 설정
@Document(indexName = "hotels")
// Nori 설정 파일 적용
@Setting(settingPath = "/elastic/es-setting.json")
public class Hotel {

    @Id
    private String id;

    // 한국어 검색이 필요한 필드에 nori_custom_analyzer 적용
    @Field(type = FieldType.Text, analyzer = "nori_custom_analyzer")
    private String name;

    // 주소도 한국어 검색이 필요하므로 적용
    @Field(type = FieldType.Text, analyzer = "nori_custom_analyzer")
    private String address;
}