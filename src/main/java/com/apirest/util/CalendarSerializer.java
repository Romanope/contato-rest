package com.apirest.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CalendarSerializer extends JsonSerializer<Calendar> {

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void serialize(Calendar arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {

		String dateAsString = format.format(arg0.getTime());
		arg1.writeString(dateAsString);
	}
}
