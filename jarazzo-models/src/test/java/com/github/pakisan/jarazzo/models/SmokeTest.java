package com.github.pakisan.jarazzo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.pakisan.jarazzo.models.v1._0_1.Arazzo;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Named.named;

@DisplayName("Smoke Test")
public class SmokeTest {

  private final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory())
    .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);

  @MethodSource("documents")
  @ParameterizedTest(name = "{index}: {0}")
  public void smokeTest(@NonNull String documentPath) throws JsonProcessingException {
    final var rawDocument = readTextFile(documentPath);
    final var model = objectMapper.readValue(rawDocument, Arazzo.class);

    Assertions.assertNotNull(model);
  }

  public static Stream<Arguments> documents() {
    return Stream.of(
        Arguments.of(named("Apacta.com", "/1.0.1/apacta.yaml")),
        Arguments.of(named("Asana.com", "/1.0.1/asana.yaml")),
        Arguments.of(named("Stripe.com", "/1.0.1/stripe.yaml")),
        Arguments.of(named("BNPL (OAI Example)", "/1.0.1/bnpl.yaml")),
        Arguments.of(named("Pet Coupons (OAI Example)", "/1.0.1/pet-coupons.yaml")),
        Arguments.of(named("Sample Workflow", "/1.0.1/pet-coupons.yaml"))
    );
  }

  protected String readTextFile(@NonNull String filePath) {
    try (Scanner scanner = new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(filePath)), StandardCharsets.UTF_8)) {
      return scanner.useDelimiter("\\A").next();
    } catch (Exception e) {
      throw new RuntimeException("Failed to read file", e);
    }
  }

}
