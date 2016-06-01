import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class SocketIOTrial {
    public static void main(String[] args) throws Exception{
        final Socket socket = IO.socket("http://localhost:8081");
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                socket.emit("foo", "hi");
                System.out.println("got connection!");
            }

        }).on("messages", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                System.out.println(args[0]);
                socket.disconnect();
            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {}

        });
        socket.connect();
    }
}
