/*
 * SonarSource Language Recognizer
 * Copyright (C) 2010-2019 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.sslr.internal.matchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Node of a parse tree.
 */
public class ParseNode {

  private final int startIndex;
  private final int endIndex;
  private final ParseNode[] children;
  private final Matcher matcher;

  public ParseNode(int startIndex, int endIndex, List<ParseNode> children, Matcher matcher) {
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    this.children = children.toArray(new ParseNode[0]);
    this.matcher = matcher;
  }

  /**
   * Leaf node.
   */
  public ParseNode(int startIndex, int endIndex, Matcher matcher) {
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    this.matcher = matcher;
    this.children = new ParseNode[0];
  }

  public int getStartIndex() {
    return startIndex;
  }

  /**
   * Be aware that element of input with this index is not included into this node.
   */
  public int getEndIndex() {
    return endIndex;
  }

  public ParseNode[] getChildren() {
    return children;
  }

  public Matcher getMatcher() {
    return matcher;
  }

}
