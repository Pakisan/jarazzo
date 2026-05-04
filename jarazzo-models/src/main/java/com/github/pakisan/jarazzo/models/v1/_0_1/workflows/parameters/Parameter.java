package com.github.pakisan.jarazzo.models.v1._0_1.workflows.parameters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.models.ExtendableObject;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * Describes a single step parameter
 * <br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#parameter-object">Parameter Object</a>
 * @see ExtendableObject
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Parameter extends ExtendableObject {

  /**
   * <b>Required</b>
   * <br><br>
   * The name of the parameter
   * <br><br>
   * Parameter names are case sensitive
   */
  @NonNull
  @JsonProperty(value = "name", required = true)
  @NotNull(message = "Parameter name must be provided")
  @JsonPropertyDescription("The name of the parameter")
  private String name;

  /**
   * The location of the parameter
   * <br><br>
   * Possible values are <code>path</code>, <code>query</code>, <code>header</code>, or <code>cookie</code>
   * <br><br>
   * When the step in context specifies a workflowId, then all parameters map to workflow inputs
   * <br><br>
   * In all other scenarios (e.g., a step specifies an operationId), the in field <b>MUST</b> be specified
   */
  @Nullable
  @JsonProperty(value = "in")
  @JsonPropertyDescription("The named location of the parameter")
  private ParameterIn in;

  /**
   * <b>Required</b>
   * <br><br>
   * The value to pass in the parameter
   * <br><br>
   * The value can be a constant or a Runtime Expression to be evaluated and passed to the referenced operation or workflow
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   */
  @NonNull
  @JsonProperty(value = "value", required = true)
  @NotNull(message = "Parameter value must be provided")
  @JsonPropertyDescription("The value to pass in the parameter")
  private Object value;

}
