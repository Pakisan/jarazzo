package com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions;

import com.github.pakisan.jarazzo.models.SerDeTest;
import com.github.pakisan.jarazzo.models.v1._0_1.sources.SourceDescription;
import com.github.pakisan.jarazzo.models.v1._0_1.sources.SourceType;
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
@DisplayName("Criterion Expression Type Object")
@MethodSource("namedArguments")
@ParameterizedClass(name = "{index}: {0}")
public class CriterionExpressionTypeTest extends SerDeTest<CriterionExpressionType> {

  private final String baseObjectJson;
  private final String extendedObjectJson;
  private final String wronglyExtendedObjectJson;
  private final CriterionExpressionType object;

  public CriterionExpressionTypeTest(
    @NonNull String baseObjectJson,
    @NonNull String extendedObjectJson,
    @NonNull String wronglyExtendedObjectJson,
    @NonNull CriterionExpressionType object
  ) {
    this.baseObjectJson = baseObjectJson;
    this.extendedObjectJson = extendedObjectJson;
    this.wronglyExtendedObjectJson = wronglyExtendedObjectJson;
    this.object = object;
  }

  static Stream<Arguments> namedArguments() {
    return Stream.of(
      arguments(
        named("Criterion Expression Type - jsonpath + draft-goessner-dispatch-jsonpath-00", "/1.0.1/actions/conditions/criterionExpressionType - jsonpath + draft-goessner-dispatch-jsonpath-00.json"),
        "/1.0.1/actions/conditions/criterionExpressionType - jsonpath + draft-goessner-dispatch-jsonpath-00 - extended.json",
        "/1.0.1/actions/conditions/criterionExpressionType - jsonpath + draft-goessner-dispatch-jsonpath-00 - wrongly extended.json",
        new CriterionExpressionType(
          CriterionExpressionTypeType.JSONPATH,
          "draft-goessner-dispatch-jsonpath-00"
        )
      ),
      arguments(
        named("Criterion Expression Type - xpath + xpath-10", "/1.0.1/actions/conditions/criterionExpressionType - xpath + xpath-10.json"),
        "/1.0.1/actions/conditions/criterionExpressionType - xpath + xpath-10 - extended.json",
        "/1.0.1/actions/conditions/criterionExpressionType - xpath + xpath-10 - wrongly extended.json",
        new CriterionExpressionType(
          CriterionExpressionTypeType.XPATH,
          "xpath-10"
        )
      ),
      arguments(
        named("Criterion Expression Type - xpath + xpath-20", "/1.0.1/actions/conditions/criterionExpressionType - xpath + xpath-20.json"),
        "/1.0.1/actions/conditions/criterionExpressionType - xpath + xpath-20 - extended.json",
        "/1.0.1/actions/conditions/criterionExpressionType - xpath + xpath-20 - wrongly extended.json",
        new CriterionExpressionType(
          CriterionExpressionTypeType.XPATH,
          "xpath-20"
        )
      ),
      arguments(
        named("Criterion Expression Type - xpath + xpath-30", "/1.0.1/actions/conditions/criterionExpressionType - xpath + xpath-30.json"),
        "/1.0.1/actions/conditions/criterionExpressionType - xpath + xpath-30 - extended.json",
        "/1.0.1/actions/conditions/criterionExpressionType - xpath + xpath-30 - wrongly extended.json",
        new CriterionExpressionType(
          CriterionExpressionTypeType.XPATH,
          "xpath-30"
        )
      )
    );
  }

  @Override
  protected Class<CriterionExpressionType> objectClass() {
    return CriterionExpressionType.class;
  }

  @Override
  public CriterionExpressionType build() {
    return object;
  }

}
