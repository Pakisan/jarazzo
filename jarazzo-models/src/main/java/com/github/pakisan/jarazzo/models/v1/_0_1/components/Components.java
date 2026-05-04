package com.github.pakisan.jarazzo.models.v1._0_1.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.github.pakisan.jarazzo.models.ExtendableObject;
import com.github.pakisan.jarazzo.models.v1._0_1.actions.FailureAction;
import com.github.pakisan.jarazzo.models.v1._0_1.actions.SuccessAction;
import com.github.pakisan.jarazzo.models.v1._0_1.workflows.parameters.Parameter;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Map;

/**
 * Holds a set of reusable objects for different aspects of the Arazzo Specification
 * <br><br>
 * All objects defined within the components object will have no effect on the Arazzo Description unless they are explicitly referenced from properties outside the components object
 * <br><br>
 * Components are scoped to the Arazzo document they are defined in
 * <br><br>
 * For example, if a step defined in Arazzo document “A” references a workflow defined in Arazzo document “B”, the components in “A” are not considered when evaluating the workflow referenced in “B”
 * <br><br><br>
 * This object <b>MAY</b> be extended with <a href="https://spec.openapis.org/arazzo/latest.html#specification-extensions">Specification Extensions</a>
 *
 * @version 1.0.1
 * @see <a href="https://spec.openapis.org/arazzo/latest.html#components-object">Components Object</a>
 * @see ExtendableObject
 * @author Pavel Bodiachevskiy <pavelbodyachevskiy@gmail.com>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Components extends ExtendableObject {

    /**
     * An object to hold reusable JSON Schema 2020-12 schemas to be referenced from workflow inputs
     */
    @Nullable
    @JsonProperty(value = "inputs")
    @JsonPropertyDescription("An object to hold reusable JSON Schema 2020-12 schemas to be referenced from workflow inputs")
    private Map<
      @Pattern(regexp = "^[a-zA-Z0-9\\.\\-_]+$", message = "All the fixed fields declared above are objects that MUST use keys that match the regular expression: ^[a-zA-Z0-9\\.\\-_]+$") String,
      @NonNull Object
      > inputs;

    /**
     * An object to hold reusable Parameter Objects
     */
    @Nullable
    @JsonProperty(value = "parameters")
    @JsonPropertyDescription("An object to hold reusable Parameter Objects")
    private Map<
      @Pattern(regexp = "^[a-zA-Z0-9\\.\\-_]+$", message = "All the fixed fields declared above are objects that MUST use keys that match the regular expression: ^[a-zA-Z0-9\\.\\-_]+$") String,
      @NonNull Parameter
      > parameters;

    /**
     * An object to hold reusable Success Actions Objects
     */
    @Nullable
    @JsonProperty(value = "successActions")
    @JsonPropertyDescription("An object to hold reusable Success Actions Objects")
    private Map<
      @Pattern(regexp = "^[a-zA-Z0-9\\.\\-_]+$", message = "All the fixed fields declared above are objects that MUST use keys that match the regular expression: ^[a-zA-Z0-9\\.\\-_]+$") String,
      @NonNull SuccessAction
      > successActions;

    /**
     * An object to hold reusable Failure Actions Objects
     */
    @Nullable
    @JsonProperty(value = "failureActions")
    @JsonPropertyDescription("An object to hold reusable Failure Actions Objects")
    private Map<
      @Pattern(regexp = "^[a-zA-Z0-9\\.\\-_]+$", message = "All the fixed fields declared above are objects that MUST use keys that match the regular expression: ^[a-zA-Z0-9\\.\\-_]+$") String,
      @NonNull FailureAction
      > failureActions;

}
