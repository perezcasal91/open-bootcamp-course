package com.perezcasal.junit.suite;

import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.*;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;


@Suite
@SuiteDisplayName("Init with Junit Suit")
@SelectPackages({"com.perezcasal.junit.operation", "com.perezcasal.junit.management"})
@SelectDirectories("src/test/resources")
public class TestController {
}
