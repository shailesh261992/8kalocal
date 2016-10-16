package com.project.messdeck.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.project.messdeck.entity.Area;

public class AreaSerailizer extends JsonSerializer<Area> {

	@Override
	public void serialize(Area arg0, JsonGenerator generator, SerializerProvider arg2)
			throws IOException, JsonProcessingException {

		generator.writeStartObject();
		generator.writeFieldName("area");
		generator.writeObject(arg0);

		generator.writeFieldName("pincode");
		generator.writeObject(arg0.getPincode());
		generator.writeFieldName("city");
		generator.writeObject(arg0.getCity());
		generator.writeFieldName("district");
		generator.writeObject(arg0.getCity().getDistrict());
		generator.writeFieldName("state");
		generator.writeObject(arg0.getCity().getDistrict().getState());
		generator.writeFieldName("country");
		generator.writeObject(arg0.getCity().getDistrict().getState().getCountry());

		generator.writeEndObject();
	}

}
