import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Test{
    
    private static InputStream in;
    private static DataOutputStream out;
    private static Socket socket;
    
    public static void main(String[] args) throws Exception {
        new Test();
        new Thread(new Runnable(){
            public void run(){
                try {
                    while(true){
                        while (in.available() > 0) {
                            byte[] buffer = new byte[128];
                            in.read(buffer, 0, in.available());
                            System.out.println(new String(buffer));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    public Test(){
        try {
            this.socket = new Socket("aynea.com", 9999);
            socket.setKeepAlive(true);
            System.out.println("Connection build");
            this.out = new DataOutputStream(socket.getOutputStream());
            this.in = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 
}
