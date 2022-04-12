package BSP;

import java.util.ArrayList;
import java.util.List;

import Model.Figure;
import Model.Segment;
import ReaderFile.ReaderFile;

public class BinarySpacePartitionTree {

    Tree tree;
    ReaderFile readerFile;
    ArrayList<Segment> segments = new ArrayList<>();

    public BinarySpacePartitionTree(String path) {
        readerFile = new ReaderFile(path);
        Figure figure = readerFile.getFigure();
        this.tree = ConstructingBSP(figure.getSegments());
    }

    private Tree ConstructingBSP(List<Segment> segments) {
        Tree tree = new Tree();
        // Check the number of segment
        if (segments.size() <= 1) {
            tree.setNode(segments.get(0));
        } else {
            // Get the first segment to divide the other one
            Segment splitingLine = segments.get(0);

            for (Segment segment : segments) {
                if (!(segment == splitingLine)) {
                    
                }
            }

            List<Segment> positivSubSegments = new ArrayList<>();
            List<Segment> negativSubSegments = new ArrayList<>();
            tree.setPositivSubTree(ConstructingBSP(positivSubSegments));
            tree.setNegativSubTree(ConstructingBSP(negativSubSegments));

        }
        return tree;

    }

}
