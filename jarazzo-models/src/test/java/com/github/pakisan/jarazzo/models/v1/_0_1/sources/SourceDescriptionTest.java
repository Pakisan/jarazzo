package com.github.pakisan.jarazzo.models.v1._0_1.sources;

import com.github.pakisan.jarazzo.models.SerDeTest;
import lombok.Getter;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Getter
@DisplayName("Source Description Object")
@MethodSource("namedArguments")
@ParameterizedClass(name = "{index}: {0}")
public class SourceDescriptionTest extends SerDeTest<SourceDescription> {

  private final String baseObjectJson;
  private final String extendedObjectJson;
  private final String wronglyExtendedObjectJson;
  private final SourceDescription object;

  public SourceDescriptionTest(
    @NonNull String baseObjectJson,
    @NonNull String extendedObjectJson,
    @NonNull String wronglyExtendedObjectJson,
    @NonNull SourceDescription object
  ) {
    this.baseObjectJson = baseObjectJson;
    this.extendedObjectJson = extendedObjectJson;
    this.wronglyExtendedObjectJson = wronglyExtendedObjectJson;
    this.object = object;
  }

  static Stream<Arguments> namedArguments() {
    return Stream.of(
      arguments(
        named("Source Description Object", "/1.0.1/sources/sourceDescription.json"),
        "/1.0.1/sources/sourceDescription - extended.json",
        "/1.0.1/sources/sourceDescription - wrongly extended.json",
        new SourceDescription(
          "petStoreDescription",
          "https://github.com/swagger-api/swagger-petstore/blob/master/src/main/resources/openapi.yaml",
          null
        )
      ),
      arguments(
        named("Source Description Object - OpenAPI", "/1.0.1/sources/openapi/sourceDescription.json"),
        "/1.0.1/sources/openapi/sourceDescription - extended.json",
        "/1.0.1/sources/openapi/sourceDescription - wrongly extended.json",
        new SourceDescription(
          "petStoreDescription",
          "https://github.com/swagger-api/swagger-petstore/blob/master/src/main/resources/openapi.yaml",
          SourceType.OPENAPI
        )
      ),
      arguments(
        named("Source Description Object - Arazzo", "/1.0.1/sources/arazzo/sourceDescription.json"),
        "/1.0.1/sources/arazzo/sourceDescription - extended.json",
        "/1.0.1/sources/arazzo/sourceDescription - wrongly extended.json",
        new SourceDescription(
          "petStoreDescription",
          "https://github.com/swagger-api/swagger-petstore/blob/master/src/main/resources/openapi.yaml",
          SourceType.ARAZZO
        )
      )
    );
  }

  @Override
  protected Class<SourceDescription> objectClass() {
    return SourceDescription.class;
  }

  @Override
  public SourceDescription build() {
    return object;
  }

}
