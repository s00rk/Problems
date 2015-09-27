import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int casos, i, player, aplayer = -1, pos;
		StringTokenizer st;
		String ganadores;
		
		int [] jugador;
		int [] casilla;
		int [] lanzamiento;
		
		casos = Integer.parseInt(read.readLine());
		if(casos < 1 && casos > 100)
			return;
		while(casos-- > 0)
		{
			st = new StringTokenizer(read.readLine());
			jugador = new int[Integer.parseInt(st.nextToken())];
			casilla = new int[Integer.parseInt(st.nextToken())];
			lanzamiento = new int[Integer.parseInt(st.nextToken())];
			
			if(jugador.length < 2 || jugador.length > 10)
				continue;
			if(casilla.length < 5 || casilla.length > 100)
				continue;
			if(lanzamiento.length < 1 || lanzamiento.length > 1000)
				continue;
			
			st = new StringTokenizer(read.readLine());
			i = 0;
			do{
				casilla[i] = Integer.parseInt(st.nextToken());
				i++;
			}while(st.hasMoreTokens());
			
			st = new StringTokenizer(read.readLine());
			i = 0;
			do{
				lanzamiento[i] = Integer.parseInt(st.nextToken());
				i++;
			}while(st.hasMoreTokens());
			
			for(i = 0; i < jugador.length; i++)
				jugador[i] = 0;
			
			player = 0;			
			ganadores = "";
			for(i = 0; i < lanzamiento.length; i++)
			{	
				aplayer = -1;
				pos = jugador[player];
				while(pos == casilla.length-1){
					if(aplayer == -1)
						aplayer = player;
					player++;
					if(player == jugador.length)
						player = 0;
					if(aplayer == player)
						break;
					pos = jugador[player];
				}
				if(aplayer == player)
					break;
				pos += lanzamiento[i];
				pos += casilla[pos];
				jugador[player] = pos;
				player++;
				if(pos == casilla.length-1)
					ganadores += (player) + " ";
				if(player == jugador.length)
					player = 0;
			}
			if(ganadores.length() > 0)
			{
				ganadores = ganadores.substring(0, ganadores.length()-1);
				pw.println(ganadores);
			}else
				pw.println("-1");
		}
		pw.flush();
	}

}
