import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(read.readLine());
		StringTokenizer st;
		
		if(cases < 1 && cases > 100)
			return;
		
		while(cases-- > 0){
			st = new StringTokenizer(read.readLine());
			char[] original = st.nextToken().toCharArray();
			char[] result = st.nextToken().toCharArray();
			if(original.length > 100 || result.length > 100)
				continue;
			
			int cont = 0;
			for(int j = 0; j < original.length; j++)
				if(original[j] != result[j])
					cont++;
			
			pw.println(cont);
		}
			pw.flush();
	}
	

}
