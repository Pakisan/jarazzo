package com.github.pakisan.jarazzo.models.v1._0_1.workflows.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.models.ExtendableObject;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

/**
 * A single request body describing the <code>Content-Type</code> and request body content to be passed by a step to an operation.
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#request-body-object">Request Body Object</a>
 * @see ExtendableObject
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RequestBody extends ExtendableObject {

  /**
   * The Content-Type for the request content
   * <br><br>
   * If omitted then refer to <code>Content-Type</code> specified at the targeted operation to understand serialization requirements
   */
  @Nullable
  @JsonProperty(value = "contentType")
  @JsonPropertyDescription("The Content-Type for the request content")
  private String contentType;

  /**
   * A value representing the request body payload
   * <br><br>
   * The value can be a literal value or can contain Runtime Expressions which <b>MUST</b> be evaluated prior to calling the referenced operation
   * <br><br>
   * To represent examples of media types that cannot be naturally represented in <code>JSON</code> or <code>YAML</code>, use a string value to contain the example, escaping where necessary
   */
  @Nullable
  @JsonProperty(value = "payload")
  @JsonPropertyDescription("The payload for the request")
  private Object payload;

  /**
   * A list of locations and values to set within a payload
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   */
  @Nullable
  @JsonProperty(value = "replacements")
  @JsonPropertyDescription("A list of locations and values to set within a payload")
  private List<@NonNull PayloadReplacement> replacements;

}
