import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

import java.util.ArrayList;
import java.util.List;

public class SocketIOServerTrial {
    public static void main(String[] args) throws Exception{
        Configuration configuration = new Configuration();
        configuration.setHostname("localhost");
        configuration.setPort(8082);
        final List<SocketIOClient> socketsClient= new ArrayList<>();
        final SocketIOServer socketIOServer=new SocketIOServer(configuration);
        socketIOServer.addConnectListener(new ConnectListener() {
            public void onConnect(SocketIOClient socketIOClient) {
                System.out.println("client connected");
                socketsClient.add(socketIOClient);
                socketsClient.forEach(s -> s.sendEvent("messages","this is amount of clients connected:"+socketsClient.size()));
                socketIOClient.sendEvent("messages","hello world!");
            }
        });
        socketIOServer.addEventListener("messages", String.class, new DataListener<String>() {
            public void onData(SocketIOClient socketIOClient, String o, AckRequest ackRequest) throws Exception {
                System.out.println("this is the received object:"+o);
//                socketIOClient.disconnect();
            }
        });
        socketIOServer.addDisconnectListener(new DisconnectListener() {
            public void onDisconnect(SocketIOClient socketIOClient) {
                System.out.println("client is not connected anymore!");
            }
        });
        socketIOServer.getAllClients()
        socketIOServer.start();

        Thread.sleep(3600000);
        socketIOServer.stop();
    }


}
