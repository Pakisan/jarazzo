package com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.core.ExtendableObject;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.jspecify.annotations.NonNull;

/**
 * An object used to describe the type and version of an expression used within a {@link Criterion} Object
 * <br><br>
 * If this object is not defined, then the following defaults apply:
 * <ul>
 *   <li>JSONPath as described by [<a href="https://spec.openapis.org/arazzo/latest.html#bib-rfc9535">RFC9535</a>]</li>
 *   <li>XPath as described by <a href="https://www.w3.org/TR/xpath-31">XML Path Language 3.1</a></li>
 * </ul>
 * <br><br>
 * Defining this object gives the ability to utilize tooling compatible with older versions of either JSONPath or XPath
 * <br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#criterion-expression-type-object">Criterion Expression Type Object</a>
 * @see ExtendableObject
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CriterionExpressionType extends ExtendableObject {

  /**
   * <b>REQUIRED</b>
   * <br><br>
   * The type of condition to be applied. The options allowed are <code>jsonpath</code> or <code>xpath</code>
   */
  @NonNull
  @JsonProperty(value = "type", required = true)
  @NotNull(message = "Criterion Expression Type type must be provided")
  @JsonPropertyDescription("The type of condition to be applied")
  private CriterionExpressionTypeType type;

  /**
   * <b>REQUIRED</b>
   * <br><br>
   * A shorthand string representing the version of the expression type being used
   * <br><br>
   * The allowed values for <code>JSONPath</code> are <code>draft-goessner-dispatch-jsonpath-00</code>
   * <br><br>
   * The allowed values for <code>XPath</code> are <code>xpath-30</code>, <code>xpath-20</code>, or <code>xpath-10</code>
   */
  @NonNull
  @JsonProperty(value = "version", required = true)
  @NotNull(message = "Criterion Expression Type version must be provided")
  @JsonPropertyDescription("The type of condition to be applied")
  private String version;

}
