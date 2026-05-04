package com.github.pakisan.jarazzo.models.v1._0_1.workflows.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.models.ExtendableObject;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.jspecify.annotations.NonNull;

/**
 * Describes a location within a payload (e.g., a request body) and a value to set within the location
 * <br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#payload-replacement-object">Payload Replacement Object</a>
 * @see ExtendableObject
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PayloadReplacement extends ExtendableObject {

  /**
   * <b>Required</b>
   * <br><br>
   * A <a href="https://tools.ietf.org/html/rfc6901">JSON Pointer</a> or <a href="https://www.w3.org/TR/xpath-31/#id-expressions">XPath Expression</a> which <b>MUST</b> be resolved against the request body
   * <br><br>
   * Used to identify the location to inject the <b>value</b>
   */
  @NonNull
  @JsonProperty(value = "target", required = true)
  @NotNull(message = "PayloadReplacement target must be provided")
  @JsonPropertyDescription("A JSON Pointer or XPath Expression which MUST be resolved against the request body")
  private String target;

  /**
   * <b>Required</b>
   * <br><br>
   * The value set within the target location
   * <br><br>
   * The value can be a constant or a Runtime Expression to be evaluated and passed to the referenced operation or workflow
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   */
  @NonNull
  @JsonProperty(value = "value", required = true)
  @NotNull(message = "PayloadReplacement value must be provided")
  @JsonPropertyDescription("The value set within the target location")
  private Object value;

}
