package org.example.checks;

import org.sonar.java.ast.visitors.LinesOfCodeVisitor;
import org.sonar.plugins.java.api.tree.SyntaxToken;

public class LinesOfCodeRule extends LinesOfCodeVisitor {
    @Override public void visitToken(SyntaxToken syntaxToken) {
        System.out.println(syntaxToken);

    }
}
