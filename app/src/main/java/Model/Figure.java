package Model;

import java.util.ArrayList;
import java.util.List;

public class Figure {

	List<Segment> segments;

	public Figure() {
		this.segments = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Figure [segments=" + segments + "]";
	}

	public boolean AddSegment(Segment s) {
		if (segments.size() == 0)
			return segments.add(s);
		if (!(segments.contains(s)))
			return segments.add(s);
		return false;
	}

}
