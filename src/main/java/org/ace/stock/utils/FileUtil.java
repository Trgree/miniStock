package org.ace.stock.utils;

import java.io.*;
import java.util.List;

public class FileUtil {

	public static void readFile(String file, List<String> list) {
		File f = new File(file);
		if(!f.exists()) {
			return;
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = br.readLine()) != null && !"".equals(line.trim())) {
				list.add(line);
			}
			System.out.println("read cache size:" + list.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		}
	}
	
	public static int writeFile(String outfile, List<String> list, boolean append) {
		if(list.size() <=0) {
			System.out.println("没有记录");
			return 0;
		}
		System.out.println(list.size());
		PrintWriter pw = null;
		int result  = 0;
		try {
			pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outfile, append),"utf-8" ));
			for(String line : list) {
				pw.println(line);
				result++;
			}
			pw.flush();
			System.out.println("输出到文件:" + outfile);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if(pw !=null) {
				pw.close();
			}
		}
	}
}
