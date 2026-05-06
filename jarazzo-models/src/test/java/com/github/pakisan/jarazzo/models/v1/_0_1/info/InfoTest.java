package com.github.pakisan.jarazzo.models.v1._0_1.info;

import com.github.pakisan.jarazzo.models.SerDeTest;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Info Object")
public class InfoTest extends SerDeTest<Info> {

  @Override
  protected Class<Info> objectClass() {
    return Info.class;
  }

  @Override
  protected String getBaseObjectJson() {
    return "/1.0.1/info/info.json";
  }

  @Override
  protected String getExtendedObjectJson() {
    return "/1.0.1/info/info - extended.json";
  }

  @Override
  protected String getWronglyExtendedObjectJson() {
    return "/1.0.1/info/info - wrongly extended.json";
  }

  @Override
  public Info build() {
    return new Info(
      "A pet purchasing workflow",
      "This workflow showcases how to purchase a pet through a sequence of API calls",
      "This workflow walks you through the steps of searching for, selecting, and purchasing an available pet.\n",
      "1.0.1"
    );
  }

}
