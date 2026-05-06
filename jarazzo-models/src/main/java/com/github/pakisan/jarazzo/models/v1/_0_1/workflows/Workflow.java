package com.github.pakisan.jarazzo.models.v1._0_1.workflows;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.core.ExtendableObject;
import com.github.pakisan.jarazzo.models.v1._0_1.workflows.steps.Step;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Describes the steps to be taken across one or more APIs to achieve an objective
 * <br><br>
 * The workflow object <b>MAY</b> define inputs needed in order to execute workflow steps, where the defined steps represent
 * a call to an API operation or another workflow, and a set of outputs
 * <br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 *
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#workflow-object">Workflow Object</a>
 * @see ExtendableObject
 * @author Pavel Bodiachevskii <pavelbodyachevskiy@gmail.com>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Workflow extends ExtendableObject {

    /**
     * <b>Required</b>
     * <br><br>
     * Unique string to represent the workflow
     * <br><br>
     * The id <b>MUST</b> be unique amongst all workflows described in the Arazzo Description
     * <br>
     * The workflowId value is case-sensitive
     * <br><br>
     * Tools and libraries <b>MAY</b> use the workflowId to uniquely identify a workflow, therefore, it is <b>RECOMMENDED</b> to follow common programming naming conventions
     * <br><br>
     * <b>SHOULD</b> conform to the regular expression <code>[A-Za-z0-9_\-]+</code>
     */
    @NonNull
    @JsonProperty(value = "workflowId", required = true)
    @NotNull(message = "Workflow workflowId must be provided")
    @JsonPropertyDescription("Unique string to represent the workflow")
    @Pattern(regexp = "[A-Za-z0-9_\\-]+", message = "Workflow workflowId must conform to the regular expression [A-Za-z0-9_\\-]+")
    private String workflowId;

    /**
     * A summary of the purpose or objective of the workflow
     */
    @Nullable
    @JsonProperty(value = "summary")
    @JsonPropertyDescription("A summary of the purpose or objective of the workflow")
    private String summary;

    /**
     * A description of the workflow. <a href="https://spec.commonmark.org/">CommonMark syntax</a> <b>MAY</b> be used for rich text representation
     */
    @Nullable
    @JsonProperty(value = "description")
    @JsonPropertyDescription("A description of the workflow. CommonMark syntax MAY be used for rich text representation")
    private String description;

    /**
     * A JSON Schema 2020-12 object representing the input parameters used by this workflow
     */
    @Nullable
    @JsonProperty(value = "inputs")
    @JsonPropertyDescription("A JSON Schema 2020-12 object representing the input parameters used by this workflow")
    private Object inputs;

    /**
     * A list of workflows that <b>MUST</b> be completed before this workflow can be processed
     * <br><br>
     * Each value provided <b>MUST</b> be a workflowId
     * <br>
     * If the workflow depended on is defined within the current {@link Workflow} Document, then specify the {@link Workflow#getWorkflowId()} of the relevant local workflow
     * <br>
     * If the workflow is defined in a separate {@link com.github.pakisan.jarazzo.models.v1._0_1.Arazzo} Document then the workflow <b>MUST</b> be defined in the {@link com.github.pakisan.jarazzo.models.v1._0_1.Arazzo#getSourceDescriptions()} and the workflowId
     * <b>MUST</b> be specified using a Runtime Expression (e.g., <code>$sourceDescriptions.&lt;name&gt;.&lt;workflowId&gt;</code>) to avoid ambiguity or potential clashes
     *
     * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
     */
    @Nullable
    @JsonProperty(value = "dependsOn")
    @JsonPropertyDescription("A list of workflows that MUST be completed before this workflow can be processed")
    private List<@NonNull String> dependsOn;

    /**
     * <b>Required</b>
     * <br><br>
     * An ordered list of steps where each step represents a call to an API operation or to another workflow
     */
    @NonNull
    @JsonProperty(value = "steps", required = true)
    @NotNull(message = "Workflow steps must be provided")
    @NotEmpty(message = "Workflow steps list MUST have at least one entry")
    @JsonPropertyDescription("An ordered list of steps where each step represents a call to an API operation or to another workflow")
    private List<@NonNull Step> steps;

    /**
     * A list of success actions that are applicable for all steps described under this workflow
     * <br><br>
     * These success actions can be overridden at the step level but cannot be removed there
     * <br>
     * If a Reusable Object is provided, it <b>MUST</b> link to success actions defined in the <code>components/successActions</code> of the current Arazzo document
     * <br><br>
     * The list <b>MUST NOT</b> include duplicate success actions
     *
     * @see <a href="https://spec.openapis.org/arazzo/latest.html#reusable-object">Reusable Object</a>
     * @see <a href="https://spec.openapis.org/arazzo/latest.html#success-action-object">Success Action Object</a>
     */
    @Nullable
    @JsonProperty(value = "successActions")
    @JsonPropertyDescription("A list of success actions that are applicable for all steps described under this workflow")
    private List<@NonNull Object> successActions;

    /**
     * A list of failure actions that are applicable for all steps described under this workflow
     * <br><br>
     * These failure actions can be overridden at the step level but cannot be removed there
     * <br>
     * If a Reusable Object is provided, it <b>MUST</b> link to failure actions defined in the <code>components/failureActions</code> of the current Arazzo document
     * <br><br>
     * The list <b>MUST NOT</b> include duplicate failure actions
     *
     * @see <a href="https://spec.openapis.org/arazzo/latest.html#reusable-object">Reusable Object</a>
     * @see <a href="https://spec.openapis.org/arazzo/latest.html#failure-action-object">Failure Action Object</a>
     */
    @Nullable
    @JsonProperty(value = "failureActions")
    @JsonPropertyDescription("A list of failure actions that are applicable for all steps described under this workflow")
    private List<@NonNull Object> failureActions;

    /**
     * A map between a friendly name and a dynamic output value
     * <br><br>
     * The name <b>MUST</b> use keys that match the regular expression: <code>^[a-zA-Z0-9\.\-_]+$</code>
     */
    @Nullable
    @JsonProperty(value = "outputs")
    @JsonPropertyDescription("A map between a friendly name and a dynamic output value")
    private Map<
      @Pattern(regexp = "^[a-zA-Z0-9\\.\\-_]+$", message = "Workflow workflowId must conform to the regular expression [A-Za-z0-9_\\-]+") String,
      String
      > outputs;

    /**
     * A list of parameters that are applicable for all steps described under this workflow
     * <br><br>
     * These parameters can be overridden at the step level but cannot be removed there
     * <br>
     * Each parameter <b>MUST</b> be passed to an operation or workflow as referenced by <code>operationId</code>, <code>operationPath</code>, or <code>workflowId</code> as specified within each step
     * <br>
     * If a Reusable Object is provided, it <b>MUST</b> link to a parameter defined in the <code>components/parameters</code> of the current Arazzo document
     * <br><br>
     * The list <b>MUST NOT</b> include duplicate parameters
     *
     * @see <a href="https://spec.openapis.org/arazzo/latest.html#reusable-object">Reusable Object</a>
     * @see <a href="https://spec.openapis.org/arazzo/latest.html#parameter-object">Parameter Object</a>
     */
    @Nullable
    @JsonProperty(value = "parameters")
    @JsonPropertyDescription("A list of parameters that are applicable for all steps described under this workflow")
    private List<@NonNull Object> parameters;

}
