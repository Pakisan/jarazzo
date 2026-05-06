package com.github.pakisan.jarazzo.models.v1._0_1.components;

import com.github.pakisan.jarazzo.models.SerDeTest;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Reusable Object")
@MethodSource("namedArguments")
@ParameterizedClass(name = "{index}: {0}")
public class ReusableObjectTest extends SerDeTest<ReusableObject> {

  private final String baseObjectJson;
  private final ReusableObject object;

  public ReusableObjectTest(@NonNull String baseObjectJson, @NonNull ReusableObject object) {
    this.baseObjectJson = baseObjectJson;
    this.object = object;
  }

  static Stream<Arguments> namedArguments() {
    return Stream.of(
      arguments(named("Reusable Object", "/1.0.1/components/reusableObject.json"), new ReusableObject("$components.successActions.notify", "24")),
      arguments(named("Reusable Object without value", "/1.0.1/components/reusableObject - without value.json"), new ReusableObject("$components.successActions.notify", null))
    );
  }

  @Override
  protected Class<ReusableObject> objectClass() {
    return ReusableObject.class;
  }

  @Override
  protected String getBaseObjectJson() {
    return baseObjectJson;
  }

  @Override
  protected String getExtendedObjectJson() {
    return "";
  }

  @Override
  protected String getWronglyExtendedObjectJson() {
    return "";
  }

  @Override
  public ReusableObject build() {
    return object;
  }

}
