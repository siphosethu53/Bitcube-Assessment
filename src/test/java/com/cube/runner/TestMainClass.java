package com.cube.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/cube/feature", 
        glue = { "com.cube.stepdef"}, 
        monochrome = true, 
        plugin = { "pretty", "html:target/reports/HtmlReports/HtmlReports.html", "json:target/reports/JsonReports/JsonReports.json", "junit:target/reports/XmlReport.xml" }, 
        tags = "@HappyPath, @HyperlinkDefects", "@EdgecaseDefect"
)
public class TestMainClass {

}
