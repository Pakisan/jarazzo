package com.github.pakisan.jarazzo.models.v1._0_1.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.core.ExtendableObject;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * Provides metadata about the Arazzo description
 * <br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 *
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#info-object">Info Object</a>
 * @see ExtendableObject
 * @author Pavel Bodiachevskii <pavelbodyachevskiy@gmail.com>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Info extends ExtendableObject {

  /**
   * <b>Required</b>
   * <br><br>
   * A human-readable title of the Arazzo Description
   */
  @NonNull
  @Builder.Default
  @JsonProperty(value = "title", required = true)
  @NotNull(message = "Info title must be provided")
  @JsonPropertyDescription("A human-readable title of the Arazzo Description")
  private String title = "Arazzo Example";

  /**
   * A short summary of the Arazzo Description
   */
  @Nullable
  @JsonProperty(value = "summary")
  @JsonPropertyDescription("A short summary of the Arazzo Description")
  private String summary;

  /**
   * A description of the purpose of the workflows defined. <a href="https://spec.commonmark.org/">CommonMark syntax</a> <b>MAY</b> be used for rich text representation
   */
  @Nullable
  @JsonProperty(value = "description")
  @JsonPropertyDescription("A description of the purpose of the workflows defined. CommonMark syntax MAY be used for rich text representation.")
  private String description;

  /**
   * <b>Required</b>
   * <br><br>
   * The version identifier of the Arazzo document (which is distinct from the <a href="https://spec.openapis.org/arazzo/latest.html#versions">Arazzo Specification version</a>)
   */
  @NonNull
  @Builder.Default
  @JsonProperty(value = "version", required = true)
  @NotNull(message = "Info version must be provided")
  @JsonPropertyDescription("The version identifier of the Arazzo document (which is distinct from the Arazzo Specification version)")
  private String version = "1.0.0";

}
