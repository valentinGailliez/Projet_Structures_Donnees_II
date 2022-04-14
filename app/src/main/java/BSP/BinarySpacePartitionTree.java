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
            float gradientSplitingLine, gradientSegment;
            String orientationSplitingLine, orientationSegment;
            if (splitingLine.getEndX() != splitingLine.getX()) {
                orientationSplitingLine = "Oblique";
                gradientSplitingLine = (splitingLine.getEndY() - splitingLine.getY())
                        / (splitingLine.getEndX() - splitingLine.getX());
            } else {
                gradientSplitingLine = splitingLine.getY();
                orientationSplitingLine = "Vertical";
            }

            List<Segment> positivSubSegments = new ArrayList<>();
            List<Segment> negativSubSegments = new ArrayList<>();

            // Loop on every segments of our file
            for (Segment segment : segments) {
                // If it's not the same segment
                if (!(segment == splitingLine)) {
                    // Get the gradient of each segment
                    if (segment.getEndX() != segment.getX()) {
                        orientationSegment = "Oblique";
                        gradientSegment = (segment.getEndY() - segment.getY())
                                / (segment.getEndX() - segment.getX());
                    } else {
                        orientationSegment = "Vertical";
                        gradientSegment = segment.getY();
                    }
                    if (gradientSegment == gradientSplitingLine && orientationSegment.equals(orientationSplitingLine)) {
                        if (segment.getX() == splitingLine.getX() || segment.getY() == splitingLine.getY()) {
                            positivSubSegments.add(segment);
                        } else {
                            
                        }
                    } else {

                    }
                }
            }

            tree.setPositivSubTree(ConstructingBSP(positivSubSegments));
            tree.setNegativSubTree(ConstructingBSP(negativSubSegments));
            tree.setNode(splitingLine);

        }
        return tree;

    }

}
