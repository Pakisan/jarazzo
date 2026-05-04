package com.github.pakisan.jarazzo.models.v1._0_1.workflows.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.models.ExtendableObject;
import com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions.Criterion;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Describes a single workflow step which MAY be a call to an API operation (<a href="https://spec.openapis.org/oas/latest.html#operation-object">OpenAPI Operation Object</a>) or another <a href="https://spec.openapis.org/arazzo/latest.html#workflow-object">Workflow Object</a>
 * <br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#step-object">Step Object</a>
 * @see ExtendableObject
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Step extends ExtendableObject {

  /**
   * <b>Required</b>
   * <br><br>
   * Unique string to represent the step
   * <br><br>
   * The stepId <b>MUST</b> be unique amongst all steps described in the workflow
   * <br><br>
   * The stepId value is case-sensitive
   * <br><br>
   * Tools and libraries <b>MAY</b> use the stepId to uniquely identify a workflow step, therefore,
   * it is <b>RECOMMENDED</b> to follow common programming naming conventions
   * <br><br>
   * <b>SHOULD</b> conform to the regular expression <code>[A-Za-z0-9_\-]+</code>
   */
  @NonNull
  @JsonProperty(value = "stepId", required = true)
  @NotNull(message = "Step stepId must be provided")
  @Pattern(regexp = "[A-Za-z0-9_\\-]+", message = "Step stepId must conform to the regular expression [A-Za-z0-9_\\-]+")
  @JsonPropertyDescription("Unique string to represent the step")
  private String stepId;

  /**
   * A description of the step. <a href="https://spec.commonmark.org/">CommonMark syntax</a> <b>MAY</b> be used for rich text representation
   */
  @Nullable
  @JsonProperty(value = "description")
  @JsonPropertyDescription("A description of the step. CommonMark syntax MAY be used for rich text representation")
  private String description;

  /**
   * The name of an existing, resolvable operation, as defined with a unique <code>operationId</code> and existing within one of the <code>sourceDescriptions</code>
   * <br><br>
   * The referenced operation will be invoked by this workflow step
   * <br><br>
   * If multiple (non arazzo type) sourceDescriptions are defined, then the operationId <b>MUST</b> be specified using a Runtime Expression (e.g., <code>$sourceDescriptions.&lt;name&gt;.&lt;workflowId&gt;</code>) to avoid ambiguity or potential clashes
   * <br><br>
   * This field is mutually exclusive of the operationPath and workflowId fields respectively
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   */
  @Nullable
  @JsonProperty(value = "operationId")
  @JsonPropertyDescription("The name of an existing, resolvable operation, as defined with a unique operationId and existing within one of the sourceDescriptions")
  private String operationId;

  /**
   * A reference to a {@link com.github.pakisan.jarazzo.models.v1._0_1.sources.SourceDescription} combined with a JSON Pointer to reference an operation
   * <br><br>
   * This field is mutually exclusive of the <code>operationId</code> and <code>workflowId</code> fields respectively
   * <br><br>
   * The operation being referenced <b>MUST</b> be described within one of the <code>sourceDescriptions</code> descriptions
   * <br><br>
   * A Runtime Expression syntax <b>MUST</b> be used to identify the source description document
   * <br><br>
   * If the referenced operation has an <code>operationId</code> defined then the <code>operationId</code> SHOULD be preferred over the <code>operationPath</code>
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#source-description-object">Source Description Object</a>
   * @see <a href="https://tools.ietf.org/html/rfc6901">JSON Pointer</a>
   */
  @Nullable
  @JsonProperty(value = "operationPath")
  @JsonPropertyDescription("A reference to a Source combined with a JSON Pointer to reference an operation")
  private String operationPath;

  /**
   * The workflowId referencing an existing workflow within the Arazzo description
   * <br><br>
   * If the referenced workflow is contained within an arazzo type <code>sourceDescription</code>, then the <code>workflowId</code> <b>MUST</b>
   * be specified using a Runtime Expression (e.g., <code>$sourceDescriptions.&lt;name&gt;.&lt;workflowId&gt;</code>) to avoid ambiguity or potential clashes
   * <br><br>
   * The field is mutually exclusive of the <code>operationId</code> and <code>operationPath</code> fields respectively
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   */
  @Nullable
  @JsonProperty(value = "workflowId")
  @JsonPropertyDescription("The workflowId referencing an existing workflow within the Arazzo description")
  private String workflowId;

  /**
   * A list of parameters that <b>MUST</b> be passed to an operation or workflow as referenced by <code>operationId</code>, <code>operationPath</code>, or <code>workflowId</code>
   * <br><br>
   * If a parameter is already defined at the Workflow, the new definition will override it but can never remove it
   * <br><br>
   * If a Reusable Object is provided, it <b>MUST</b> link to a parameter defined in the <code>components/parameters</code> of the current Arazzo document
   * <br><br>
   * The list <b>MUST NOT</b> include duplicate parameters
   */
  @Nullable
  @JsonProperty(value = "parameters")
  @JsonPropertyDescription("A list of parameters that MUST be passed to an operation or workflow as referenced by operationId, operationPath, or workflowId")
  private List<@NonNull Object> parameters;

  /**
   * The request body to pass to an operation as referenced by <code>operationId</code> or <code>operationPath</code>
   * <br><br>
   * The requestBody is fully supported in HTTP methods where the HTTP 1.1 specification [<a href="https://spec.openapis.org/arazzo/latest.html#bib-rfc9110">RFC9110</a>] <a href="https://tools.ietf.org/html/rfc9110#section-9.3">Section 9.3</a>
   * explicitly defines semantics for “content” like request bodies, such as within <code>POST</code>, <code>PUT</code>, and <code>PATCH</code> methods
   * <br><br>
   * For methods where the HTTP specification provides less clarity—such as <code>GET</code>, <code>HEAD</code>, and <code>DELETE</code> - the use of <code>requestBody</code> is
   * permitted but does not have well-defined semantics
   * <br><br>
   * In these cases, its use <b>SHOULD</b> be avoided if possible.
   */
  @Nullable
  @JsonProperty(value = "requestBody")
  @JsonPropertyDescription("The request body to pass to an operation as referenced by operationId or operationPath")
  private RequestBody requestBody;

  /**
   * A list of assertions to determine the success of the step
   * <br><br>
   * Each assertion is described using a {@link Criterion} Object
   * <br><br>
   * All assertions <b>MUST</b> be satisfied for the step to be deemed successful
   */
  @Nullable
  @JsonProperty(value = "successCriteria")
  @NotEmpty(message = "Step successCriteria list MUST have at least one entry")
  @JsonPropertyDescription("A list of assertions to determine the success of the step")
  private List<@NonNull Criterion> successCriteria;

  /**
   * An array of success action objects that specify what to do upon step success
   * <br><br>
   * If omitted, the next sequential step shall be executed as the default behavior
   * <br><br>
   * If multiple success actions have similar criteria, the first sequential action matching the criteria <b>SHALL</b> be the action executed
   * <br><br>
   * If a success action is already defined at the Workflow, the new definition will override it but can never remove it
   * <br><br>
   * If a Reusable Object is provided, it <b>MUST</b> link to a success action defined in the components of the current Arazzo document
   * <br><br>
   * The list <b>MUST NOT</b> include duplicate success actions
   *
   * @see com.github.pakisan.jarazzo.models.v1._0_1.actions.SuccessAction
   * @see com.github.pakisan.jarazzo.models.v1._0_1.components.ReusableObject
   */
  @Nullable
  @JsonProperty(value = "onSuccess")
  @JsonPropertyDescription("An array of success action objects that specify what to do upon step success")
  private List<@NonNull Object> onSuccess;

  /**
   * An array of failure action objects that specify what to do upon step failure
   * <br><br>
   * If omitted, the default behavior is to break and return
   * <br><br>
   * If multiple failure actions have similar criteria, the first sequential action matching the criteria <b>SHALL</b> be the action executed
   * <br><br>
   * If a failure action is already defined at the Workflow, the new definition will override it but can never remove it
   * <br><br>
   * If a Reusable Object is provided, it <b>MUST</b> link to a failure action defined in the components of the current Arazzo document
   * <br><br>
   * The list <b>MUST NOT</b> include duplicate failure actions
   *
   * @see com.github.pakisan.jarazzo.models.v1._0_1.actions.FailureAction
   * @see com.github.pakisan.jarazzo.models.v1._0_1.components.ReusableObject
   */
  @Nullable
  @JsonProperty(value = "onFailure")
  @JsonPropertyDescription("An array of failure action objects that specify what to do upon step failure")
  private List<@NonNull Object> onFailure;

  /**
   * A map between a friendly name and a dynamic output value defined using a runtime expression
   * <br><br>
   * The name <b>MUST</b> use keys that match the regular expression: <code>^[a-zA-Z0-9\.\-_]+$</code>
   */
  @Nullable
  @JsonProperty(value = "outputs")
  @Pattern(regexp = "^[a-zA-Z0-9\\.\\-_]+$", message = "Step outputs must conform to the regular expression [A-Za-z0-9_\\-]+")
  @JsonPropertyDescription("A map between a friendly name and a dynamic output value defined using a runtime expression")
  private Map<String, String> outputs;

}
