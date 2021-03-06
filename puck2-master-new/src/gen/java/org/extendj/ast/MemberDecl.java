/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.0 */
package org.extendj.ast;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Set;
import beaver.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.LinkedHashSet;
import org.jastadd.util.*;
import java.util.zip.*;
import java.io.*;
import org.jastadd.util.PrettyPrintable;
import org.jastadd.util.PrettyPrinter;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
/**
 * @ast node
 * @declaredat C:\\Users\\Momoche\\Desktop\\projetStage\\puck2-master-new\\extendj\\java4\\grammar\\Java.ast:165
 * @astdecl MemberDecl : BodyDecl;
 * @production MemberDecl : {@link BodyDecl};

 */
public abstract class MemberDecl extends BodyDecl implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public MemberDecl() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:13
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:19
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:23
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public MemberDecl clone() throws CloneNotSupportedException {
    MemberDecl node = (MemberDecl) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:42
   */
  @Deprecated
  public abstract MemberDecl fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:50
   */
  public abstract MemberDecl treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:58
   */
  public abstract MemberDecl treeCopy();
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat C:\\Users\\Momoche\\Desktop\\projetStage\\puck2-master-new\\extendj\\java4\\frontend\\Modifiers.jrag:255
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="C:\\Users\\Momoche\\Desktop\\projetStage\\puck2-master-new\\extendj\\java4\\frontend\\Modifiers.jrag:255")
  public abstract boolean isStatic();
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat C:\\Users\\Momoche\\Desktop\\projetStage\\puck2-master-new\\extendj\\java4\\frontend\\ConstantExpression.jrag:358
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="ConstantExpression", declaredAt="C:\\Users\\Momoche\\Desktop\\projetStage\\puck2-master-new\\extendj\\java4\\frontend\\ConstantExpression.jrag:358")
  public boolean isConstant() {
    boolean isConstant_value = false;
    return isConstant_value;
  }
  /**
   * @declaredat C:\\Users\\Momoche\\Desktop\\projetStage\\puck2-master-new\\extendj\\java4\\frontend\\NameCheck.jrag:376
   * @apilevel internal
   */
  public BodyDecl Define_enclosingMemberDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  /**
   * @declaredat C:\\Users\\Momoche\\Desktop\\projetStage\\puck2-master-new\\extendj\\java4\\frontend\\NameCheck.jrag:376
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute enclosingMemberDecl
   */
  protected boolean canDefine_enclosingMemberDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /** @apilevel internal */
  public ASTNode rewriteTo() {
    return super.rewriteTo();
  }
  /** @apilevel internal */
  public boolean canRewrite() {
    return false;
  }
  /** @apilevel internal */
  protected void collect_contributors_CompilationUnit_problems(CompilationUnit _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat C:\\Users\\Momoche\\Desktop\\projetStage\\puck2-master-new\\extendj\\java4\\frontend\\Modifiers.jrag:225
    if (!isSynthetic() && isStatic() && hostType().isInnerClass() && !isConstant()) {
      {
        java.util.Set<ASTNode> contributors = _map.get(_root);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) _root, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_CompilationUnit_problems(_root, _map);
  }
  /** @apilevel internal */
  protected void contributeTo_CompilationUnit_problems(LinkedList<Problem> collection) {
    super.contributeTo_CompilationUnit_problems(collection);
    if (!isSynthetic() && isStatic() && hostType().isInnerClass() && !isConstant()) {
      collection.add(error("*** Inner classes may not declare static members, "
                + "unless they are compile-time constant fields"));
    }
  }
}
