/*
 * Copyright (C) 2010 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */
package com.sonar.structural.search;

import org.junit.Test;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.dsl.Literal;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class ThisNodeMatcherTest {

  ThisNodeMatcher matcher = new ThisNodeMatcher();
  AstNode astNode = GeographyDsl.geographyParser.parse("Paris London");

  @Test
  public void shouldNotMatch() {
    matcher.addNodeValue("something");
    matcher.addNodeValue("something");
    assertThat(matcher.match(astNode), is(nullValue()));
  }

  @Test
  public void shouldMatchNodeName() {
    matcher.addNodeValue("something");
    matcher.addNodeValue("world");
    assertThat(matcher.match(astNode), is(astNode));
  }

  @Test
  public void shouldMatchTokenValue() {
    matcher.addTokenValue(new Literal("'Paris'"));
    assertThat(matcher.match(astNode), is(astNode));
  }

}