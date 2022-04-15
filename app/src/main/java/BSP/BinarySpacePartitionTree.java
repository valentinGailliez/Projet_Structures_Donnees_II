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
        if (segments.size() == 0) {
            return null;
        }
        if (segments.size() == 1) {
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
            float splitingLineIntercept, segmentIntercept;
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

                    /**
                     * Either the two segments are parallels
                     * Either the two segments aren't parallels
                     * 
                     */
                    if (gradientSegment == gradientSplitingLine && orientationSegment.equals(orientationSplitingLine)) {
                        /**
                         * The two segment are parallels
                         * We need to know if it's the same line or not
                         */
                        if (segment.getX() == splitingLine.getX() || segment.getY() == splitingLine.getY()) {
                            positivSubSegments.add(segment);
                        } else {
                            /**
                             * Determine the Y Intercept to know if where to put the segment.
                             */
                            splitingLineIntercept = defineYIntercept(splitingLine, gradientSplitingLine);
                            segmentIntercept = defineYIntercept(segment, gradientSegment);
                            if (segmentIntercept > splitingLineIntercept) {
                                positivSubSegments.add(segment);
                            } else {
                                negativSubSegments.add(segment);
                            }
                        }
                    } else {
                        /**
                         * The two segments aren't parallels
                         * We need to cut the segment into two segments.
                         */
                        float interceptX, interceptY;

                        splitingLineIntercept = defineYIntercept(splitingLine, gradientSplitingLine);

                        segmentIntercept = defineYIntercept(segment, gradientSegment);
                        if (orientationSegment.equals("Vertical")) {
                            interceptX = segment.getX();
                            interceptY = definePoint(splitingLineIntercept, gradientSplitingLine, interceptX);
                        } else {
                            if (orientationSplitingLine.equals("Vertical")) {
                                interceptX = splitingLine.getX();
                                interceptY = definePoint(segmentIntercept, gradientSegment, interceptX);
                            } else {
                                interceptX = ((splitingLineIntercept - segmentIntercept)
                                        / (gradientSplitingLine - gradientSegment));
                                interceptY = ((gradientSplitingLine * segmentIntercept
                                        - gradientSegment * splitingLineIntercept)
                                        / (gradientSplitingLine - gradientSegment));
                            }
                        }
                        Segment firstSegmentCut = new Segment(segment.getX(), segment.getY(), interceptX, interceptY,
                                segment.getColor());
                        Segment secondSegmentCut = new Segment(interceptX, interceptY, segment.getEndX(),
                                segment.getEndY(), segment.getColor());
                        if (gradientSplitingLine >= 0) {
                            if (firstSegmentCut.getEndX() >= firstSegmentCut.getX()) {
                                positivSubSegments.add(firstSegmentCut);
                                negativSubSegments.add(secondSegmentCut);
                            } else {
                                negativSubSegments.add(firstSegmentCut);
                                positivSubSegments.add(secondSegmentCut);
                            }

                        } else {
                            if (firstSegmentCut.getEndX() <= firstSegmentCut.getX()) {
                                positivSubSegments.add(firstSegmentCut);
                                negativSubSegments.add(secondSegmentCut);
                            } else {
                                negativSubSegments.add(firstSegmentCut);
                                positivSubSegments.add(secondSegmentCut);
                            }
                        }
                    }
                }
            }

            tree.setPositivSubTree(ConstructingBSP(positivSubSegments));
            tree.setNegativSubTree(ConstructingBSP(negativSubSegments));
            tree.setNode(splitingLine);

        }
        return tree;

    }

    private float definePoint(float intercept, float gradient, float abs) {
        return abs * gradient + intercept;
    }

    private float defineYIntercept(Segment segment, float gradient) {
        return segment.getY() - (segment.getX() * gradient);
    }

}
