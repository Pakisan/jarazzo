package com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.models.ExtendableObject;
import com.github.pakisan.jarazzo.models.v1._0_1.actions.SuccessAction;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * An object used to specify the context, conditions, and condition types
 * that can be used to prove or satisfy assertions specified in Step Object successCriteria,
 * {@link SuccessAction#getCriteria()}, and Failure Action Object criteria
 * <br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 * <br><br>
 * As part of a condition expression, you can use <code>boolean</code>, <code>null</code>, <code>number</code>, or <code>string</code> data types:
 * <ul>
 *   <li><code>boolean</code> - <code>true</code> or <code>false</code></li>
 *   <li><code>null</code> - <code>null</code></li>
 *   <li><code>number</code> - Any <code>number</code> number format supported in <a href="https://spec.openapis.org/arazzo/latest.html#data-types">Data Types</a></li>
 *   <li><code>string</code> - Strings <b>MUST</b> use single quotes (<code>‘</code>) around the string. To use a literal single quote, escape the literal single quote using an additional single quote (<code>’'</code>)</li>
 * </ul>
 * <br><br>
 * As part of a condition expression, you can use operations:
 * <ul>
 *   <li><code><</code>	Less than</li>
 *   <li><code><=</code>	Less than or equal</li>
 *   <li><code>></code>	Greater than</li>
 *   <li><code>>=</code>	Greater than or equal</li>
 *   <li><code>==</code>	Equal</li>
 *   <li><code>!=</code>	Not equal</li>
 *   <li><code>!</code>	Not</li>
 *   <li><code>&&</code>	And</li>
 *   <li><code>||</code>	Or</li>
 *   <li><code>()</code>	Logical Grouping</li>
 *   <li><code>[]</code>	Index (0-based)</li>
 *   <li><code>.</code>	Property de-reference</li>
 * </ul>
 * <br>
 * String comparisons <b>MUST</b> be case insensitive
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#criterion-object">Criterion Object</a>
 * @see ExtendableObject
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Criterion extends ExtendableObject {

  /**
   * A Runtime Expression used to set the context for the condition to be applied on
   * <br><br>
   * If type is specified, then the context <b>MUST</b> be provided (e.g. <code>$response.body</code> would set the context that a JSONPath query expression could be applied to).
   */
  @Nullable
  @JsonProperty(value = "context")
  @JsonPropertyDescription("A runtime expression used to set the context for the condition to be applied on")
  private String context;

  /**
   * <b>Required</b>
   * <br><br>
   * The condition to apply
   * <br><br>
   * Conditions can be simple (e.g. <code>$statusCode == 200</code> which applies an operator on a value obtained from a runtime expression),
   * or a regex, or a JSONPath expression
   * <br><br>
   * For regex or JSONPath, the type and context <b>MUST</b> be specified
   */
  @NonNull
  @JsonProperty(value = "condition", required = true)
  @NotNull(message = "Criterion condition must be provided")
  @JsonPropertyDescription("The condition to apply")
  private String condition;

  /**
   * The type of condition to be applied
   * <br><br>
   * If specified, the options allowed are <code>simple</code>, <code>regex</code>, <code>jsonpath</code> or <code>xpath</code>
   * <br><br>
   * If omitted, then the condition is assumed to be <code>simple</code>, which at most combines literals, operators and Runtime Expressions
   * <br><br>
   * If <code>jsonpath</code>, then the expression <b>MUST</b> conform to <a href = "https://tools.ietf.org/html/rfc9535">JSONPath</a>
   * <br><br>
   * If <code>xpath</code> the expression <b>MUST</b> conform to <a href="https://www.w3.org/TR/xpath-31/#d2e24229">XML Path Language 3.1</a>
   * <br><br>Should other variants of JSONPath or XPath be required, then a Criterion Expression Type Object <b>MUST</b> be specified
   *
   * @see CriterionType
   * @see CriterionExpressionType
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   */
  @Nullable
  @Builder.Default
  @JsonProperty(value = "type")
  @JsonPropertyDescription("The type of condition to be applied")
  private Object type = CriterionType.SIMPLE;

}
