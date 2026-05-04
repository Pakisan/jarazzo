package com.github.pakisan.jarazzo.models.v1._0_1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.models.ExtendableObject;
import com.github.pakisan.jarazzo.models.v1._0_1.components.Components;
import com.github.pakisan.jarazzo.models.v1._0_1.info.Info;
import com.github.pakisan.jarazzo.models.v1._0_1.sources.SourceDescription;
import com.github.pakisan.jarazzo.models.v1._0_1.workflows.Workflow;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

/**
 * The Arazzo Specification provides a mechanism that can define sequences of calls and their
 * dependencies to be woven together and expressed in the context of delivering a particular outcome
 * or set of outcomes when dealing with API descriptions (such as OpenAPI descriptions)
 * <br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 *
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html">Arazzo</a>
 * @see ExtendableObject
 * @author Pavel Bodiachevskii <pavelbodyachevskiy@gmail.com>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Arazzo extends ExtendableObject {

  /**
   * <b>Required</b>
   * <br><br>
   * This string <b>MUST</b> be the version number of the Arazzo Specification that the Arazzo Description uses
   * <br><br>
   * The arazzo field <b>MUST</b> be used by tooling to interpret the Arazzo Description
   */
  @NonNull
  @Builder.Default
  @JsonProperty(value = "arazzo", required = true)
  @NotNull(message = "Arazzo version must be provided")
  @JsonPropertyDescription("This string MUST be the version number of the Arazzo Specification that the Arazzo Description uses")
  private String arazzo = "1.0.1";

  /**
   * <b>Required</b>
   * <br><br>
   * Provides metadata about the Arazzo description
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#info-object">Info Object</a>
   */
  @NonNull
  @Builder.Default
  @JsonProperty(value = "info", required = true)
  @NotNull(message = "Arazzo info must be provided")
  @JsonPropertyDescription("Provides metadata about the Arazzo description")
  private Info info = new Info();

  /**
   * <b>Required</b>
   * <br><br>
   * A list of source descriptions such as Arazzo or OpenAPI
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#source-description-object">Source Description Object</a>
   */
  @NonNull
  @JsonProperty(value = "sourceDescriptions", required = true)
  @NotNull(message = "Arazzo sourceDescriptions must be provided")
  @NotEmpty(message = "Arazzo sourceDescriptions list MUST have at least one entry")
  @JsonPropertyDescription("A list of source descriptions such as Arazzo or OpenAPI")
  private List<@NonNull SourceDescription> sourceDescriptions;

  /**
   * <b>Required</b>
   * <br><br>
   * A list of workflows
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#workflow-object">Workflow Object</a>
   */
  @NonNull
  @JsonProperty(value = "workflows", required = true)
  @NotNull(message = "Arazzo workflows must be provided")
  @NotEmpty(message = "Arazzo workflows list MUST have at least one entry")
  @JsonPropertyDescription("A list of workflows")
  private List<@NonNull Workflow> workflows;

  /**
   * Hold various schemas for the Arazzo Description
   *
   * @see <a href="https://spec.openapis.org/arazzo/latest.html#components-object">Components Object</a>
   */
  @Nullable
  @JsonProperty(value = "components")
  @JsonPropertyDescription("Hold various schemas for the Arazzo Description")
  private Components components;

}
