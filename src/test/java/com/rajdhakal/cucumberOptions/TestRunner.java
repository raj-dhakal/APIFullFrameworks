package com.rajdhakal.cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/rajdhakal/features", glue="com/rajdhakal/stepdefinations",monochrome = true)
public class TestRunner {

}
