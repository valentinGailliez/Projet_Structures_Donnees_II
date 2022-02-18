package ReaderFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Model.Figure;
import Model.Segment;

public class ReaderFile {

	Figure figure = new Figure();
	Segment segment;

	public ReaderFile(String path) {
		try {
			this.figure = read(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Figure read(String path) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader(
				path));
		String line;
		String line_cut[];
		in.readLine();
		while ((line = in.readLine()) != null) {
			line_cut = line.split(" ");
			segment = new Segment(Float.parseFloat(line_cut[0]), Float.parseFloat(line_cut[1]),
					Float.parseFloat(line_cut[2]), Float.parseFloat(line_cut[3]), line_cut[4]);
			figure.AddSegment(segment);
		}
		in.close();

		return figure;
	}

	@Override
	public String toString() {
		return "Figure [" + figure.toString() + "]";
	}

}
