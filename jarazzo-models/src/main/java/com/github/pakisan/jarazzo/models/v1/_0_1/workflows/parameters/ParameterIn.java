package com.github.pakisan.jarazzo.models.v1._0_1.workflows.parameters;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The named location of the parameter
 *
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 * @version 1.0.1
 */
public enum ParameterIn {

  /**
   * path - Used together with OpenAPI style Path Templating, where the parameter value is actually part of the operation’s URL
   * <br><br>
   * This does not include the host or base path of the API
   * <br><br>
   * For example, <b>in</b> <code>/items/{itemId}</code>, the path parameter is <code>itemId</code>
   */
  @JsonProperty("path")
  PATH,

  /**
   * query - Parameters that are appended to the URL
   * <br><br>
   * For example, <b>in</b> <code>/items?id=###</code>, the query parameter is <code>id</code>.
   */
  @JsonProperty("query")
  QUERY,

  /**
   * header - Custom headers that are expected as part of the request
   * <br><br>
   * Note that [<a href="https://spec.openapis.org/arazzo/latest.html#bib-rfc9110">RFC9110</a>] <a href="https://tools.ietf.org/html/rfc9110#name-field-names>Name field names</a> states field names (which includes header) are case-insensitive
   */
  @JsonProperty("header")
  HEADER,

  /**
   * cookie - Used to pass a specific cookie value to the source API.
   */
  @JsonProperty("cookie")
  COOKIE;

  @Override
  public String toString() {
    return name().toLowerCase();
  }

}
