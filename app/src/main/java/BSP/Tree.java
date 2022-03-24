package BSP;

import java.util.List;

import Model.Segment;

public class Tree {
    private Segment node;
    private Tree positivSubTree;
    private Tree negativSubTree;

    public Tree(Segment node, Tree positivSubTree, Tree negativSubTree) {
        this.node = node;
        this.positivSubTree = positivSubTree;
        this.negativSubTree = negativSubTree;
    }

    public Tree() {
    }

    public Segment getNode() {
        return node;
    }

    public Tree getNegativSubTree() {
        return negativSubTree;
    }

    public void setNegativSubTree(Tree negativSubTree) {
        this.negativSubTree = negativSubTree;
    }

    public Tree getPositivSubTree() {
        return positivSubTree;
    }

    public void setPositivSubTree(Tree positivSubTree) {
        this.positivSubTree = positivSubTree;
    }

    public void setNode(Segment node) {
        this.node = node;
    }

}
