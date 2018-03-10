package org.zhuonima.exchange.common.exceptions;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ExchangeExceptionSerialzer extends StdSerializer<ExchangeException> {

    public ExchangeExceptionSerialzer() {
        super(ExchangeException.class);
    }

    @Override
    public void serialize(ExchangeException e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("timestamp", e.getTimestamp());
        jsonGenerator.writeStringField("service", e.getService());
        jsonGenerator.writeStringField("message", e.getMessage());
        jsonGenerator.writeEndObject();
    }
}
