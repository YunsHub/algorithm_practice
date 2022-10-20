package class1;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class id_10171 {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("\\    /\\");
		bw.newLine();	// 줄 구분자
		
		bw.write(" )  ( ')");
		bw.newLine();	
        
		bw.write("(  /  )");
		bw.newLine();
        
		bw.write(" \\(__)|");
        
		bw.flush();
		bw.close();
	}

}