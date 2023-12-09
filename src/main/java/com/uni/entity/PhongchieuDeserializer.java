package com.uni.entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PhongchieuDeserializer extends JsonDeserializer<Room> {
	@Override
    public Room deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String roomValue = jsonParser.getValueAsString();
        // Xử lý logic để tạo instance Taikhoan từ giá trị taikhoanValue
        Room room = new Room(roomValue, roomValue, null, null, null);
        return room;
    }
}
