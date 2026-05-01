package com.github.pakisan.jarazzo.models.v1._0_1.sources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.models.ExtendableObject;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * Describes a source description (such as an OpenAPI description) that will be referenced by one or more workflows described within an Arazzo Description.
 * <br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 *
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#source-description-object">Source Description Object</a>
 * @see ExtendableObject
 * @author Pavel Bodiachevskii <pavelbodyachevskiy@gmail.com>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SourceDescription extends ExtendableObject {

  /**
   * <b>Required</b>
   * <br><br>
   * A unique name for the source description
   * <br><br>
   * Tools and libraries MAY use the name to uniquely identify a source description; therefore, it is <b>RECOMMENDED</b> to follow common programming naming conventions
   * <br><br>
   * <b>SHOULD</b> conform to the regular expression <code>[A-Za-z0-9_\-]+</code>
   */
  @NonNull
  @JsonProperty(value = "name", required = true)
  @NotNull(message = "Source Description name must be provided")
  @JsonPropertyDescription("A unique name for the source description")
  @Pattern(regexp = "[A-Za-z0-9_\\-]+", message = "Source Description name must conform to the regular expression [A-Za-z0-9_\\-]+")
  private String name;

  /**
   * <b>Required</b>
   * <br><br>
   * A URL to a source description to be used by a workflow
   * <br><br>
   * If a relative reference is used, it MUST be in the form of a URI-reference as defined by [<a href="https://spec.openapis.org/arazzo/latest.html#bib-rfc3986">RFC3986</a>] <a href="https://tools.ietf.org/html/rfc3986#section-4.2">Section 4.2</a>
   */
  @NonNull
  @JsonProperty(value = "url", required = true)
  @NotNull(message = "Source Description url must be provided")
  @JsonPropertyDescription("A URL to a source description to be used by a workflow")
  private String url;

  /**
   * The type of source description. Possible values are "openapi" or "arazzo"
   */
  @Nullable
  private SourceType type;

}
