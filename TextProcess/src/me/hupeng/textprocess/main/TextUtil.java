package me.hupeng.textprocess.main;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class TextUtil {

	private String fileInputName;
	private String fileOutputName;
	private Integer mood;

	private Map<String, Integer> map;

	private File inFile;
	private FileInputStream fileInputStream;
	private InputStreamReader inputStreamReader;
	private BufferedReader bufferedReader;

	private File outFile;
	private FileOutputStream fileOutputStream;
	private OutputStreamWriter outputStreamWriter;
	private BufferedWriter bufferedWriter;

	public TextUtil(Configuration configuration) {

		try {
			map = new HashMap<String, Integer>();

			this.fileInputName = configuration.getFileInputName();
			this.fileOutputName = configuration.getFileOutputName();
			this.mood = configuration.getMood();

			inFile = new File(fileInputName);
			fileInputStream = new FileInputStream(inFile);
			inputStreamReader = new InputStreamReader(fileInputStream,
					configuration.getInputCharCode());
			bufferedReader = new BufferedReader(inputStreamReader);

			// TODO:
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String readLine() {
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}

	public void doService() {
		String lineString;
		while ((lineString = readLine()) != null) {
			map.clear();
			String titleString = lineString.substring(0, 21);
			String contentString = lineString.substring(21);

			for (int i = 0; i < 10; i++) {
				contentString.replaceAll("  ", " ");
			}

			int wordNum = contentString.split(" ").length;

			for (int i = 0; i < wordNum - 1; i++) {

				String beforeString = contentString.split(" ")[i];
				String afterString = contentString.split(" ")[i + 1];

				// TODO:
				String temString = beforeString + "," + afterString;
				if (mood == 0) {
					map.put(temString, 1);
					if (i + 2 < contentString.split(" ").length) {
						beforeString = contentString.split(" ")[i];
						afterString = contentString.split(" ")[i + 2];

						temString = beforeString + "," + afterString;
						map.put(temString, 1);
					}
				}

				if (mood == 1) {
					beforeString = contentString.split(" ")[i];
					afterString = contentString.split(" ")[i + 1];
					temString = beforeString + "," + afterString;
					if (map.get(temString) != null) {
						map.put(temString, map.get(temString) + 1);
					} else {
						temString = afterString + "," + beforeString;
						if (map.get(temString) != null) {
							map.put(temString, map.get(temString) + 1);
						}
					}
					if (i + 2 < contentString.split(" ").length) {
						beforeString = contentString.split(" ")[i];
						afterString = contentString.split(" ")[i + 2];
						temString = beforeString + "," + afterString;
						if (map.get(temString) != null) {
							map.put(temString, map.get(temString) + 1);
						} else {
							temString = afterString + "," + beforeString;
							if (map.get(temString) != null) {
								map.put(temString, map.get(temString) + 1);
							} else {
								temString = beforeString + "," + afterString;
								map.put(temString, 1);
							}
						}
					}

				}

				// TODO:
				outFile = new File(fileOutputName);
				if (!outFile.exists()) {
					outFile.mkdirs();
				}
				if (fileOutputName.charAt(fileOutputName.length() - 1) != '/') {
					System.out.println("old path:" + fileOutputName);
					fileOutputName += '/';
					System.out.println("new path:" + fileOutputName);
				}

				if (mood == 0) {
					outFile = new File(fileOutputName + titleString + "_1.txt");
				} else {
					if (mood == 1) {
						outFile = new File(fileOutputName + titleString
								+ "_2.txt");
					}
				}

				try {
					fileOutputStream = new FileOutputStream(outFile);
					outputStreamWriter = new OutputStreamWriter(
							fileOutputStream, "UTF-8");
					bufferedWriter = new BufferedWriter(outputStreamWriter);
					bufferedWriter.write("Source,Target,Type,Weight" + "\r\n");
					for (String key : map.keySet()) {
						System.out.println("key= " + key + " and value= "
								+ map.get(key));
						bufferedWriter.write(key + ",undirected," + map.get(key) + ".0" + "\r\n");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
				
					e.printStackTrace();
				} finally {
					try {
						bufferedWriter.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		}
		
		try {
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();

			bufferedWriter.close();
			outputStreamWriter.close();
			fileOutputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
