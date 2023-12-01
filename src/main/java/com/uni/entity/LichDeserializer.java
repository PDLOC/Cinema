package com.uni.entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LichDeserializer extends JsonDeserializer<Lich> {

    @Override
    public Lich deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Integer lichValue = jsonParser.getValueAsInt();
        // Xử lý logic để tạo instance Lich từ giá trị lichValue
        Lich lich = new Lich(lichValue, null, null, null, null);
        return lich;
    }
}
