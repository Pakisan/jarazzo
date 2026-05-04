package com.github.pakisan.jarazzo.models.v1._0_1.actions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.models.ExtendableObject;
import com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions.Criterion;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

/**
 * A single success action which describes an action to take upon success of a workflow step
 * <br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 *
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#success-action-object">Success Action Object</a>
 * @see ExtendableObject
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SuccessAction extends ExtendableObject {

    /**
     * <b>Required</b>
     * <br><br>
     * The name of the success action
     * <br><br>
     * Names are case sensitive
     */
    @NonNull
    @JsonProperty(value = "name", required = true)
    @NotNull(message = "SuccessAction name must be provided")
    @JsonPropertyDescription("The name of the success action")
    private String name;

    /**
     * <b>Required</b>
     * <br><br>
     * The type of action to take. Possible values are <code>end</code> or <code>goto</code>.
     */
    @NonNull
    @JsonProperty(value = "type", required = true)
    @NotNull(message = "SuccessAction type must be provided")
    @JsonPropertyDescription("The type of action to take")
    private SuccessActionType type;

    /**
     * The workflowId referencing an existing workflow within the Arazzo description to transfer to upon success of the step
     * <br><br>
     * This field is only relevant when the type field value is <code>goto</code>
     * <br>
     * If the referenced workflow is contained within an arazzo type sourceDescription, then the workflowId <b>MUST</b> be
     * specified using a Runtime Expression (e.g., <code>$sourceDescriptions.&lt;name&gt;.&lt;workflowId&gt;</code>) to avoid ambiguity or potential clashes
     * <br><br>
     * <b>This field is mutually exclusive to <code>stepId</code></b>
     *
     * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
     * @see com.github.pakisan.jarazzo.models.v1._0_1.workflows.Workflow#getWorkflowId()
     * @see com.github.pakisan.jarazzo.models.v1._0_1.Arazzo#getSourceDescriptions()
     */
    @Nullable
    @JsonProperty(value = "workflowId")
    @JsonPropertyDescription("The workflowId referencing an existing workflow within the Arazzo description to transfer to upon success of the step")
    private String workflowId;

    /**
     * The stepId to transfer to upon success of the step
     * <br><br>
     * This field is only relevant when the type field value is <code>goto</code>
     * <br>The referenced stepId <b>MUST</b> be within the current workflow
     * <br><br>
     * <b>This field is mutually exclusive to <code>workflowId</code></b>
     */
    @Nullable
    @JsonProperty(value = "stepId")
    @JsonPropertyDescription("The stepId to transfer to upon success of the step")
    private String stepId;

    /**
     * A list of assertions to determine if this action <b>SHALL</b> be executed
     * <br><br>
     * Each assertion is described using a Criterion Object
     * <br><br>
     * All criteria assertions <b>MUST</b> be satisfied for the action to be executed
     *
     * @see Criterion
     */
    @Nullable
    @JsonProperty(value = "criteria")
    @JsonPropertyDescription("A list of assertions to determine if this action SHALL be executed")
    private List<@NonNull Criterion> criteria;

}
