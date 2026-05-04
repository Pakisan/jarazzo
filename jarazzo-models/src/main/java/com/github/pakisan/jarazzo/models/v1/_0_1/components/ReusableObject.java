package com.github.pakisan.jarazzo.models.v1._0_1.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * A simple object to allow referencing of objects contained within the Components Object
 * <br><br>
 * It can be used from locations within steps or workflows in the Arazzo Description
 * <br><br>
 * Note - Input Objects <b>MUST</b> use standard JSON Schema referencing via the <code>$ref</code> keyword
 * while all non JSON Schema objects use this object and its expression based referencing mechanism
 * <br><br>
 * This object cannot be extended with additional properties and any properties added <b>MUST</b> be ignored
 * <br><br>
 * Examples:
 * <br>
 * #1
 * <pre><code>
 *   {
 *     "reference": "$components.successActions.notify"
 *   }
 * </code></pre>
 * <br>
 * #2
 * <pre><code>
 *   {
 *     "reference": "$components.parameters.page",
 *     "value": 1
 *   }
 * </code></pre>
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#reusable-object">Reusable Object</a>
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#components-object">Components Object</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReusableObject {

  /**
   * <b>Required</b>
   * <br><br>
   * A runtime expression used to reference the desired object
   */
  @NonNull
  @JsonProperty(value = "reference", required = true)
  @NotNull(message = "ReusableObject reference must be provided")
  @JsonPropertyDescription("A runtime expression used to reference the desired object")
  private String reference;

  /**
   * Sets a value of the referenced parameter
   * <br><br>
   * This is only applicable for parameter object references
   */
  @Nullable
  @JsonProperty(value = "value")
  @JsonPropertyDescription("Sets a value of the referenced parameter")
  private String value;

}
