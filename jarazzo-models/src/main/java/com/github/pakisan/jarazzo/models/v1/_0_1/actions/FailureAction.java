package com.github.pakisan.jarazzo.models.v1._0_1.actions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.core.ExtendableObject;
import com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions.Criterion;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

/**
 * A single failure action which describes an action to take upon failure of a workflow step
 * <br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#failure-action-object">Failure Action Object</a>
 * @see ExtendableObject
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FailureAction extends ExtendableObject {

  /**
   * <b>Required</b>
   * <br><br>
   * The name of the failure action
   * <br><br>
   * Names are case sensitive
   */
  @NonNull
  @JsonProperty(value = "name", required = true)
  @NotNull(message = "FailureAction name must be provided")
  @JsonPropertyDescription("The name of the failure action")
  private String name;

  /**
   * <b>Required</b>
   * <br><br>
   * The type of action to take. Possible values are <code>end</code>, <code>retry</code>, or <code>goto</code>
   */
  @NonNull
  @JsonProperty(value = "type", required = true)
  @NotNull(message = "FailureAction type must be provided")
  @JsonPropertyDescription("The type of action to take")
  private FailureActionType type;

  /**
   * The workflowId referencing an existing workflow within the Arazzo description to transfer to upon failure of the step
   * <br><br>
   * This field is only relevant when the type field value is <code>goto</code> or <code>retry</code>
   * <br><br>
   * If the referenced workflow is contained within an arazzo type sourceDescription, then the workflowId <b>MUST</b> be
   * specified using a Runtime Expression (e.g., <code>$sourceDescriptions.&lt;name&gt;.&lt;workflowId&gt;</code>) to avoid ambiguity or potential clashes
   * <br><br>
   * This field is mutually exclusive to <code>stepId</code>
   * <br><br>
   * When used with <code>retry</code>, context transfers back upon completion of the specified workflow
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   * @see com.github.pakisan.jarazzo.models.v1._0_1.workflows.Workflow#getWorkflowId()
   * @see com.github.pakisan.jarazzo.models.v1._0_1.Arazzo#getSourceDescriptions()
   */
  @Nullable
  @JsonProperty(value = "workflowId")
  @JsonPropertyDescription("The workflowId referencing an existing workflow within the Arazzo description to transfer to upon failure of the step")
  private String workflowId;

  /**
   * The stepId to transfer to upon failure of the step
   * <br><br>
   * This field is only relevant when the type field value is <code>goto</code> or <code>retry</code>
   * <br><br>
   * The referenced stepId <b>MUST</b> be within the current workflow
   * <br><br>
   * This field is mutually exclusive to workflowId
   * <br><br>
   * When used with <code>retry</code>, context transfers back upon completion of the specified step
   */
  @Nullable
  @JsonProperty(value = "stepId")
  @JsonPropertyDescription("The stepId to transfer to upon failure of the step")
  private String stepId;

  /**
   * A non-negative decimal indicating the seconds to delay after the step failure before another attempt <b>SHALL</b> be made
   * <br><br>
   * <b>Note:</b> if an HTTP <code>Retry-After</code> response header was returned to a step from a targeted operation, then it <b>SHOULD</b> overrule this particular field value
   * <br><br>
   * This field only applies when the type field value is <code>retry</code>.
   */
  @Nullable
  @Min(0)
  @JsonProperty(value = "retryAfter")
  @JsonPropertyDescription("A non-negative decimal indicating the seconds to delay after the step failure before another attempt SHALL be made")
  private Double retryAfter;

  /**
   * A non-negative integer indicating how many attempts to retry the step <b>MAY</b> be attempted before failing the overall step
   * <br><br>
   * If not specified then a single retry <b>SHALL</b> be attempted
   * <br><br>
   * This field only applies when the type field value is <code>retry</code>
   * <br><br>
   * The retryLimit <b>MUST</b> be exhausted prior to executing subsequent failure actions
   */
  @Nullable
  @Min(0)
  @JsonProperty(value = "retryLimit")
  @JsonPropertyDescription("A non-negative integer indicating how many attempts to retry the step MAY be attempted before failing the overall step")
  private Integer retryLimit;

  /**
   * A list of assertions to determine if this action <b>SHALL</b> be executed
   * <br><br>
   * Each assertion is described using a Criterion Object
   *
   * @see Criterion
   */
  @Nullable
  @JsonProperty(value = "criteria")
  @JsonPropertyDescription("A list of assertions to determine if this action SHALL be executed")
  private List<@NonNull Criterion> criteria;

}
