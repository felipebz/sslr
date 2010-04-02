/*
 * Copyright (C) 2010 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */

package com.sonarsource.sslr.api;

public interface Rule extends AstNodeType {

  public Rule is(Object... matchers);

  public Rule or(Object... matchers);

  public Rule skip();

  public void mock();

}
