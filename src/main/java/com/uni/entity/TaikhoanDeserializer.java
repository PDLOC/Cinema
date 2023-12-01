package com.uni.entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TaikhoanDeserializer extends JsonDeserializer<Taikhoan> {
    @Override
    public Taikhoan deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String taikhoanValue = jsonParser.getValueAsString();
        // Xử lý logic để tạo instance Taikhoan từ giá trị taikhoanValue
        Taikhoan taikhoan = new Taikhoan(taikhoanValue, taikhoanValue, taikhoanValue, taikhoanValue, null, taikhoanValue, taikhoanValue, taikhoanValue, null, null);
        return taikhoan;
    }
}