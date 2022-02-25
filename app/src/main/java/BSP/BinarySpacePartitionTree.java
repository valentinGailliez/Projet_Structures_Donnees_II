package BSP;

import java.util.List;

import Model.Figure;
import Model.Segment;
import ReaderFile.ReaderFile;

public class BinarySpacePartitionTree {

    Tree tree;
    ReaderFile readerFile;

    public BinarySpacePartitionTree(String path) {
        readerFile = new ReaderFile(path);
        Figure figure = readerFile.getFigure();
        this.tree = ConstructingBSP(figure.getSegments());
    }

    private Tree ConstructingBSP(List<Segment> segments) {

        // Check the number of segment
        if (segments.size() <= 1) {
            this.tree.node = segments.get(0);
            return this.tree;
        }
        return null;

    }
}
