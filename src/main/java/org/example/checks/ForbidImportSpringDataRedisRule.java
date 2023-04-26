package org.example.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.*;

import java.util.Collections;
import java.util.List;
@Rule(key = "ForbidImportSpringDataRedisRule")
public class ForbidImportSpringDataRedisRule extends IssuableSubscriptionVisitor {


    @Override public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.IMPORT);
    }


    @Override
    public void visitNode(Tree tree) {
        // Visit CLASS node only => cast could be done
        ImportTree treeImport = (ImportTree) tree;
//        System.out.println(treeImport.toString());
//        System.out.println(treeImport);

//        PackageDeclarationTree



        String importStatement = fullQualifiedName(treeImport.qualifiedIdentifier());
        if(importStatement.trim().replaceAll(" ","").contains("org.sonar.plugins")){
            reportIssue(((ImportTree) tree),"禁止使用org.sonar.plugins");
        }

    }

     private static String fullQualifiedName(Tree tree) {
    if (tree.is(Tree.Kind.IDENTIFIER)) {
      return ((IdentifierTree) tree).name();
    } else if (tree.is(Tree.Kind.MEMBER_SELECT)) {
      MemberSelectExpressionTree m = (MemberSelectExpressionTree) tree;
      return fullQualifiedName(m.expression()) + "." + m.identifier().name();
    }
    throw new UnsupportedOperationException(String.format("Kind/Class '%s' not supported", tree.getClass()));
  }
}
