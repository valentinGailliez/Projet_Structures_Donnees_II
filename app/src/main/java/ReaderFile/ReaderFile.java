package ReaderFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Model.Figure;
import Model.Segment;

public class ReaderFile {

	Figure figure = new Figure();
	Segment segment;
	
	public ReaderFile() {
		
	}
	
	public Figure read() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:/Users/valen/Desktop/UMONS/Passerelles/Projet De Structures de données/app/scene/rectanglesHuge.txt"));
		String line;
		String line_cut[];
		in.readLine();
		while ((line = in.readLine()) != null)
		{
			line_cut = line.split(" ");
			segment = new Segment(Float.parseFloat(line_cut[0]),Float.parseFloat(line_cut[1]),Float.parseFloat(line_cut[2]),Float.parseFloat(line_cut[3]),line_cut[4]);
			figure.AddSegment(segment);
		}
		in.close();
		
		return figure;
	}
	
}
