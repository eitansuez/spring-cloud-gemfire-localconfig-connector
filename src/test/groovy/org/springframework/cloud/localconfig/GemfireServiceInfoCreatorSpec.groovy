package org.springframework.cloud.localconfig

import org.springframework.cloud.service.UriBasedServiceData
import spock.lang.Specification

/**
 * Created by esuez on 1/15/16.
 */
class GemfireServiceInfoCreatorSpec extends Specification {

  def "should register gemfire as scheme"() {
    when:
    def serviceCreator = new GemfireServiceInfoCreator()

    then:
    serviceCreator.accept(new UriBasedServiceData("some-service", "gemfire://localhost:10334/")) == true
  }

  def "should produce locator string from uri"() {
    expect:
    GemfireServiceInfoCreator.extractLocatorFromUri("gemfire://localhost:10334") == "localhost[10334]"
  }

  def "should produce locator string from uri with trailing slash"() {
    expect:
    GemfireServiceInfoCreator.extractLocatorFromUri("gemfire://localhost:10334/") == "localhost[10334]"
  }

}
