package com.github.pakisan.jarazzo.models.v1._0_1.actions;

import com.github.pakisan.jarazzo.models.SerDeTest;
import com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions.Criterion;
import com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions.CriterionExpressionType;
import com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions.CriterionExpressionTypeType;
import com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions.CriterionType;
import lombok.Getter;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Getter
@DisplayName("Success Action Object")
@MethodSource("namedArguments")
@ParameterizedClass(name = "{index}: {0}")
public class SuccessActionTest extends SerDeTest<SuccessAction> {

  private final String baseObjectJson;
  private final String extendedObjectJson;
  private final String wronglyExtendedObjectJson;
  private final SuccessAction object;

  public SuccessActionTest(
    @NonNull String baseObjectJson,
    @NonNull String extendedObjectJson,
    @NonNull String wronglyExtendedObjectJson,
    @NonNull SuccessAction object
  ) {
    this.baseObjectJson = baseObjectJson;
    this.extendedObjectJson = extendedObjectJson;
    this.wronglyExtendedObjectJson = wronglyExtendedObjectJson;
    this.object = object;
  }

  static Stream<Arguments> namedArguments() {
    return Stream.of(
      arguments(
        named("Success Action - stepId & goto", "/1.0.1/actions/successAction - stepId and goto.json"),
        "/1.0.1/actions/successAction - stepId and goto - extended.json",
        "/1.0.1/actions/successAction - stepId and goto - wrongly extended.json",
        new SuccessAction(
          "JoinWaitingList",
          SuccessActionType.GOTO,
          null,
          "joinWaitingListStep",
          List.of(
            new Criterion(
              "$response.body",
              "$[?count(@.pets) > 0]",
              CriterionType.JSONPATH
            )
          )
        )
      ),
      arguments(
        named("Success Action - workflowId & end", "/1.0.1/actions/successAction - workflowId and end.json"),
        "/1.0.1/actions/successAction - workflowId and end - extended.json",
        "/1.0.1/actions/successAction - workflowId and end - wrongly extended.json",
        new SuccessAction(
          "JoinWaitingList",
          SuccessActionType.END,
          "waitingListWorkflow",
          null,
          List.of(
            new Criterion(
              "$response.body",
              "$[?count(@.pets) > 0]",
              CriterionType.JSONPATH
            )
          )
        )
      )
    );
  }

  @Override
  protected Class<SuccessAction> objectClass() {
    return SuccessAction.class;
  }

  @Override
  public SuccessAction build() {
    return object;
  }

}
