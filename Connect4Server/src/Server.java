import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server  {

	ServerSocket ss;
	
	ArrayList<Heartbeat> line = new ArrayList<Heartbeat>(); 
	
	public Server()
	{	        
		try {
			ss = new ServerSocket(4343, 10); 
		} catch (IOException e1) {
			return; 
		} 

		while(true)
		{
			try {
				Socket s = ss.accept();
				if(line.size()>0)
				{
					boolean added = false;
					for(int i = 0; i < line.size(); i++)
					{
						if(line.get(i).isActive())
						{
							new Lobby(line.get(i).s, s).start();
							line.remove(i);
							added = true;
							break;
						}
						else
						{
							line.get(i).s.close();
							line.get(i).is.close();
							line.remove(i);
							i--;
						}
					}
					if(!added)
					{
						Heartbeat temp = new Heartbeat(s);
						line.add(temp);
						temp.start();
					}
				}
				else
				{
					Heartbeat temp = new Heartbeat(s); 
					line.add(temp);
					temp.start();
				}
				
			} catch (IOException e) {
				
			}
			
		}
	}
	
	public static void main(String[] args) 
	{
		CRUD.startDatabase(); 
		new Login().start();
		new SignUp().start(); 
		new LeaderBoard().start(); 
		Server server = new Server();
	}
}

