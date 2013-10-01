package faunus.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class EdgeFileParser {
	
	public void parseOutput() throws IOException {
		final Multimap<Long, Long> edges = ArrayListMultimap.create();
		final String path = "output/job-0/";
		
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if (listOfFiles[i].isFile())
			{
				String file = listOfFiles[i].getName();
				if (file.startsWith("sideeffect-m-"))
				{
					System.out.println(path + file);
					parseFile(edges, path + file);
				}
			}
		}
		
		// System.out.println(edges);
		// printMultimap(edges);
		System.out.println(edges.size() + " in total.");
	}

	private void printMultimap(final Multimap<Long, Long> edges) {
		for (Entry<Long, Long> entry : edges.entries()) {
			final Long key = entry.getKey();
			final Long value = entry.getValue();
			System.out.println(key + ": " + value);
		}
	}
	
	private void parseFile(Multimap<Long, Long> edges, final String file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
		   parseLine(edges, line);
		}
		br.close();		
	}

	private void parseLine(Multimap<Long, Long> edges, final String line) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(line); 
		
		boolean first = true;
		long currentSourceVertexId = 0;
		while (m.find()) {
			long id = Integer.parseInt(m.group());
			if (first) {
				currentSourceVertexId = id;
				first = false;
			} else {
				edges.put(currentSourceVertexId, id);
			}
		}
	}
}
