package com.intellij.structuralsearch.impl.matcher.filters;

import com.intellij.psi.*;

/**
 * Created by IntelliJ IDEA.
 * User: maxim
 * Date: 23.01.2004
 * Time: 1:07:09
 * To change this template use File | Settings | File Templates.
 */
public class TypeFilter extends JavaElementVisitor implements NodeFilter {
  protected boolean result;

  public void visitReferenceExpression(final PsiReferenceExpression expression) {
  }

  @Override public void visitClass(PsiClass aClass) {
    result = true;
  }

  @Override public void visitReferenceElement(PsiJavaCodeReferenceElement psiMethod) {
    result = true;
  }

  private TypeFilter() {}

  private static class NodeFilterHolder {
    private static final NodeFilter instance = new TypeFilter();
  }

  public static NodeFilter getInstance() {
    return NodeFilterHolder.instance;
  }

  public boolean accepts(PsiElement element) {
    result = false;
    if (element!=null) element.accept(this);
    return result;
  }
}
