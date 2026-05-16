package com.github.pakisan.jarazzo.core.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.pakisan.jarazzo.models.v1._0_1.components.ReusableObject;
import com.github.pakisan.jarazzo.models.v1._0_1.workflows.parameters.Parameter;

import java.io.IOException;

/**
 * Custom deserializer for handling criterion types in JSON deserialization
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#reusable-object">Reusable Object</a>
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#parameter-object">Parameter Object</a>
 */
public class ParameterDeserializer extends JsonDeserializer<Object> {

  @Override
  public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
    ObjectCodec objectCodec = p.getCodec();
    JsonNode jsonNode = objectCodec.readTree(p);

    try (JsonParser jsonParser = jsonNode.traverse(objectCodec)) {
      if (jsonNode.findValue("reference") != null) {
        return jsonParser.readValueAs(ReusableObject.class);
      } else {
        return jsonParser.readValueAs(Parameter.class);
      }
    }

  }

}
