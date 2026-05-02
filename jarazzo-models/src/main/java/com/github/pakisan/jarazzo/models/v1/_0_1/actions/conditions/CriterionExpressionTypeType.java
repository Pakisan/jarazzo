package com.github.pakisan.jarazzo.models.v1._0_1.actions.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type of condition to be applied
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 */
public enum CriterionExpressionTypeType {

  /**
   * JSONPath as described by [<a href="https://spec.openapis.org/arazzo/latest.html#bib-rfc9535">RFC9535</a>]
   */
  @JsonProperty("jsonpath") JSONPATH,

  /**
   * XPath as described by <a href="https://www.w3.org/TR/xpath-31">XML Path Language 3.1</a>
   */
  @JsonProperty("xpath") XPATH;

  @Override
  public String toString() {
    return name().toLowerCase();
  }

}
