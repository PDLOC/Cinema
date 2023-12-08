package com.uni.entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LoaigheDeserializer extends JsonDeserializer<Loaighe> {
	@Override
	public Loaighe deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		String maloai = jsonParser.getValueAsString();
		Loaighe loaighe = new Loaighe(maloai, maloai, null);
		return loaighe;
	}
}
