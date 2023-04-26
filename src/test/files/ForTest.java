package org.example.checks;

import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.ImportTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Collections;
import java.util.List;

public class ForTest extends IssuableSubscriptionVisitor {

    @Override public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.IMPORT);
    }

    @Override
    public void visitNode(Tree tree) {
        // Visit CLASS node only => cast could be done
        ImportTree treeImport = (ImportTree) tree;
        System.out.println(treeImport);

    }
}
