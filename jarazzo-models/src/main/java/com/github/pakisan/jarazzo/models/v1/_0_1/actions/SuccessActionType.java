package com.github.pakisan.jarazzo.models.v1._0_1.actions;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * The type of action to take upon success
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 */
@JsonClassDescription("The type of action to take upon success")
public enum SuccessActionType {

  /**
   * The workflow ends, and context returns to the caller with applicable outputs
   */
  @JsonProperty("end")
  @JsonPropertyDescription("The workflow ends, and context returns to the caller with applicable outputs")
  END,

  /**
   * A one-way transfer of workflow control to the specified label (either a <code>workflowId</code> or <code>stepId</code>)
   */
  @JsonProperty("goto")
  @JsonPropertyDescription("A one-way transfer of workflow control to the specified label (either a workflowId or stepId)")
  GOTO;

  @Override
  public String toString() {
    return name().toLowerCase();
  }

}
