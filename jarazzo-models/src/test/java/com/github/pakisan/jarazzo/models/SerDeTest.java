package com.github.pakisan.jarazzo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pakisan.jarazzo.core.ExtendableObject;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Abstract test class for serialization and deserialization operations
 *
 * @author Pavel Bodiachevskii <pavelbodyachevskiy@gmail.com>
 */
public abstract class SerDeTest<ObjectType> {

  protected final ObjectMapper objectMapper = new ObjectMapper()
    .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);

  /**
   * Returns the class of the object to be serialized and deserialized
   *
   * @return {@link Class}<{@link ObjectType}>
   */
  protected abstract Class<ObjectType> objectClass();

  /**
   * Returns the JSON representation of the object to be serialized and deserialized
   *
   * @return JSON string
   */
  protected abstract String getBaseObjectJson();

  /**
   * Returns the JSON representation of the extended object to be serialized and deserialized
   *
   * @return JSON string
   */
  protected abstract String getExtendedObjectJson();

  /**
   * Returns the JSON representation of the wrongly extended object to be serialized and deserialized
   *
   * @return JSON string
   */
  protected abstract String getWronglyExtendedObjectJson();

  @Test
  @DisplayName("deserialization: compare object with parsed JSON")
  public void compareObjectWithParsedJson() throws JsonProcessingException {
    var expectedObjectAsJson = readTextFile(getBaseObjectJson());
    var expectedObject = objectMapper.readValue(expectedObjectAsJson, objectClass());

    var actualObject = build();
    Assertions.assertEquals(expectedObject, actualObject);
  }

  @Test
  @DisplayName("serialization: compare object with given JSON")
  public void compareObjectWithGivenJson() throws JsonProcessingException {
    var expectedObjectAsJson = readTextFile(getBaseObjectJson());
    var actualObjectAsJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(build());

    Assertions.assertEquals(expectedObjectAsJson, actualObjectAsJson);
  }

  @Test
  @DisplayName("deserialization: compare extended object with parsed JSON")
  public void compareExtendedObjectWithParsedJson() throws JsonProcessingException {
    Assumptions.assumeTrue(
      ExtendableObject.class.isAssignableFrom(objectClass()),
      () -> "This test requires that Expected object must be an instance of ExtendableObject"
    );

    var expectedObjectAsJson = readTextFile(getExtendedObjectJson());
    var expectedObject = objectMapper.readValue(expectedObjectAsJson, objectClass());

    var extensions = (ExtendableObject) expectedObject;
    Assertions.assertNotNull(extensions.getExtensionFields(), "Expected object must have extension fields");
    Assertions.assertEquals(0, extensions.getExtensionFields().get("x-number"), "Expected object must have extension field 'x-number' with value 0");
    Assertions.assertEquals("this is a string", extensions.getExtensionFields().get("x-string"), "Expected object must have extension field 'x-string' with value \"this is a string\"");

    var actualObject = buildExtended();
    Assertions.assertEquals(expectedObject, actualObject);
  }

  @Test
  @DisplayName("serialization: compare extended object with given JSON")
  public void compareExtendedObjectWithGivenJson() throws JsonProcessingException {
    Assumptions.assumeTrue(
      ExtendableObject.class.isAssignableFrom(objectClass()),
      () -> "This test requires that Expected object must be an instance of ExtendableObject"
    );

    var expectedObjectAsJson = readTextFile(getExtendedObjectJson());
    var actualObjectAsJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(buildExtended());

    Assertions.assertEquals(expectedObjectAsJson, actualObjectAsJson);
  }

  @Test
  @DisplayName("deserialization: wrongly extended object")
  public void deserializeWronglyExtendedObject() {
    Assumptions.assumeTrue(
      ExtendableObject.class.isAssignableFrom(objectClass()),
      () -> "This test requires that Expected object must be an instance of ExtendableObject"
    );

    var expectedObjectAsJson = readTextFile(getWronglyExtendedObjectJson());
    var exception = Assertions.assertThrows(JsonMappingException.class, () -> objectMapper.readValue(expectedObjectAsJson, objectClass()));
    Assertions.assertEquals(
      "\"ext-number\" is not valid extension property (through reference chain: %s[\"ext-number\"])".formatted(objectClass().getCanonicalName()),
      exception.getMessage()
    );
  }

  /**
   * Build the expected object to compare with given JSONs
   *
   * @return {@link ObjectType}
   */
  public abstract ObjectType build();

  /**
   * Build the expected extended object to compare with given JSONs
   *
   * @return {@link ObjectType}
   */
  public ObjectType buildExtended() {
    var expectedObject = build();

    if (expectedObject instanceof ExtendableObject) {
      ((ExtendableObject) expectedObject).setExtensionFields(new HashMap<>());
      ((ExtendableObject) expectedObject).getExtensionFields().put("x-number", 0);
      ((ExtendableObject) expectedObject).getExtensionFields().put("x-string", "this is a string");
    }

    return expectedObject;
  }

  protected String readTextFile(@NonNull String filePath) {
    try (Scanner scanner = new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(filePath)), StandardCharsets.UTF_8)) {
      return scanner.useDelimiter("\\A").next();
    } catch (Exception e) {
      throw new RuntimeException("Failed to read file", e);
    }
  }

}
