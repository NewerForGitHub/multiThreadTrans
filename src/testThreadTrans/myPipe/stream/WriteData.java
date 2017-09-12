package testThreadTrans.myPipe.stream;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {

	public void writeMethod(PipedOutputStream out) {
		System.out.println("write: ");
		for(int i=0; i<300; i++) {
			String outData = i + 1 + "";
			try {
				out.write(outData.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print(outData);
		}
		System.out.println();
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
