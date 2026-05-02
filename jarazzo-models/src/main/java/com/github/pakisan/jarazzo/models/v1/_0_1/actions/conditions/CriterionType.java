package com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type of condition to be applied
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 */
public enum CriterionType {

  /**
   * simple - where basic literals, operators, and loose comparisons are used in combination with Runtime Expressions
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   */
  @JsonProperty("simple") SIMPLE,

  /**
   * regex - where a regex pattern is applied on the supplied context. The context is defined by a Runtime Expression
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   */
  @JsonProperty("regex") REGEX,

  /**
   * jsonpath - where a JSONPath expression is applied. The root node context is defined by a Runtime Expression
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   */
  @JsonProperty("jsonpath") JSONPATH,

  /**
   * xpath - where an XPath expression is applied. The root node context is defined by a Runtime Expression
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#runtime-expressions">Runtime Expressions</a>
   */
  @JsonProperty("xpath") XPATH;

  @Override
  public String toString() {
    return name().toLowerCase();
  }

}
