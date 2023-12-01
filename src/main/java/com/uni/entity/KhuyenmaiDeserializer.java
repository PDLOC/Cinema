package com.uni.entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class KhuyenmaiDeserializer extends JsonDeserializer<Khuyenmai> {
	@Override
    public Khuyenmai deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
		String khuyenmaiValue = jsonParser.getValueAsString();
        // Xử lý logic để tạo instance Khuyenmai từ giá trị khuyenmaiValue
        Khuyenmai khuyenmai = new Khuyenmai(khuyenmaiValue, khuyenmaiValue, null, null, null, khuyenmaiValue);
        return khuyenmai;
    }
}
