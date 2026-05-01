package com.github.pakisan.jarazzo.models.v1._0_1.sources;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type of source description. Possible values are "openapi" or "arazzo"
 *
 * @version 1.0.1
 * @author Pavel Bodiachevskii <pavelbodyachevskiy@gmail.com>
 */
public enum SourceType {

  @JsonProperty("arazzo")
  ARAZZO,

  @JsonProperty("openapi")
  OPENAPI;

}
