package com.github.pakisan.jarazzo.models.v1._0_1.actions;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type of action to take upon failure
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 */
public enum FailureActionType {

  /**
   * end - The workflow ends, and context returns to the caller with applicable outputs
   */
  @JsonProperty("end")
  END,

  /**
   * goto - A one-way transfer of workflow control to the specified label (either a {@link FailureAction#getWorkflowId()} or {@link FailureAction#getStepId()})
   */
  @JsonProperty("goto")
  GOTO,

  /**
   * retry - The current step will be retried
   * <br><br>
   * The retry will be constrained by the {@link FailureAction#getRetryAfter()} and {@link FailureAction#getRetryLimit()} fields
   * <br><br>
   * If a stepId or workflowId are specified, then the reference is executed and the context is returned, after which the current step is retried.
   */
  @JsonProperty("retry")
  RETRY;

  @Override
  public String toString() {
    return name().toLowerCase();
  }

}
