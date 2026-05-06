package com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions;

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
@DisplayName("Criterion Object")
@MethodSource("namedArguments")
@ParameterizedClass(name = "{index}: {0}")
public class CriterionTest extends SerDeTest<Criterion> {

  private final String baseObjectJson;
  private final String extendedObjectJson;
  private final String wronglyExtendedObjectJson;
  private final Criterion object;

  public CriterionTest(
    @NonNull String baseObjectJson,
    @NonNull String extendedObjectJson,
    @NonNull String wronglyExtendedObjectJson,
    @NonNull Criterion object
  ) {
    this.baseObjectJson = baseObjectJson;
    this.extendedObjectJson = extendedObjectJson;
    this.wronglyExtendedObjectJson = wronglyExtendedObjectJson;
    this.object = object;
  }

  static Stream<Arguments> namedArguments() {
    return Stream.of(
      arguments(
        named("Criterion - simple", "/1.0.1/actions/conditions/criterion - simple.json"),
        "/1.0.1/actions/conditions/criterion - simple - extended.json",
        "/1.0.1/actions/conditions/criterion - simple - wrongly extended.json",
        new Criterion(
          "$response.body",
          "$[?count(@.pets) > 0]",
          CriterionType.SIMPLE
        )
      ),
      arguments(
        named("Criterion - regex", "/1.0.1/actions/conditions/criterion - regex.json"),
        "/1.0.1/actions/conditions/criterion - regex - extended.json",
        "/1.0.1/actions/conditions/criterion - regex - wrongly extended.json",
        new Criterion(
          "$response.body",
          "$[?count(@.pets) > 0]",
          CriterionType.REGEX
        )
      ),
      arguments(
        named("Criterion - jsonpath", "/1.0.1/actions/conditions/criterion - jsonpath.json"),
        "/1.0.1/actions/conditions/criterion - jsonpath - extended.json",
        "/1.0.1/actions/conditions/criterion - jsonpath - wrongly extended.json",
        new Criterion(
          "$response.body",
          "$[?count(@.pets) > 0]",
          CriterionType.JSONPATH
        )
      ),
      arguments(
        named("Criterion - xpath", "/1.0.1/actions/conditions/criterion - xpath.json"),
        "/1.0.1/actions/conditions/criterion - xpath - extended.json",
        "/1.0.1/actions/conditions/criterion - xpath - wrongly extended.json",
        new Criterion(
          "$response.body",
          "$[?count(@.pets) > 0]",
          CriterionType.XPATH
        )
      ),
      arguments(
        named("Criterion - expression type", "/1.0.1/actions/conditions/criterion - expression type.json"),
        "/1.0.1/actions/conditions/criterion - expression type - extended.json",
        "/1.0.1/actions/conditions/criterion - expression type - wrongly extended.json",
        new Criterion(
          "$response.body",
          "$[?count(@.pets) > 0]",
          new CriterionExpressionType(
            CriterionExpressionTypeType.JSONPATH,
            "draft-goessner-dispatch-jsonpath-00"
          )
        )
      )
    );
  }

  @Override
  protected Class<Criterion> objectClass() {
    return Criterion.class;
  }

  @Override
  public Criterion build() {
    return object;
  }

}
