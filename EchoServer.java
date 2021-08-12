
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Steven Ou
 */
public class EchoServer {
    
    public EchoServer( String bindAddr, int bindPort ) throws IOException {
        InetSocketAddress sockAddr = new InetSocketAddress(bindAddr, bindPort);
        
        //create a socket channel and bind to local bind address
        AsynchronousServerSocketChannel serverSock =  AsynchronousServerSocketChannel.open().bind(sockAddr);
        
       //start to accept the connection from client
        serverSock.accept(serverSock, new CompletionHandler<AsynchronousSocketChannel,AsynchronousServerSocketChannel >() {

            @Override
            public void completed(AsynchronousSocketChannel sockChannel, AsynchronousServerSocketChannel serverSock ) {
                //a connection is accepted, start to accept next connection
                serverSock.accept( serverSock, this );
                //start to read message from the client
                startRead( sockChannel );
                
            }

            @Override
            public void failed(Throwable exc, AsynchronousServerSocketChannel serverSock) {
                System.out.println( "fail to accept a connection");
            }
            
        } );
        
    }
    
    private void startRead( AsynchronousSocketChannel sockChannel ) {
        final ByteBuffer buf = ByteBuffer.allocate(2048);
        
        //read message from client
        sockChannel.read( buf, sockChannel, new CompletionHandler<Integer, AsynchronousSocketChannel >() {

            /**
             * some message is read from client, this callback will be called
             */
            @Override
            public void completed(Integer result, AsynchronousSocketChannel channel  ) {
                buf.flip();
                
                // echo the message
                startWrite( channel, buf );
                
                //start to read next message again
                startRead( channel );
            }

            @Override
            public void failed(Throwable exc, AsynchronousSocketChannel channel ) {
                System.out.println( "fail to read message from client");
            }
        });
    }
    
     private void startWrite( AsynchronousSocketChannel sockChannel, final ByteBuffer buf) {
         sockChannel.write(buf, sockChannel, new CompletionHandler<Integer, AsynchronousSocketChannel >() {

             @Override
             public void completed(Integer result, AsynchronousSocketChannel channel) {                 
                 //finish to write message to client, nothing to do
             }

             @Override
             public void failed(Throwable exc, AsynchronousSocketChannel channel) {
                 //fail to write message to client
                 System.out.println( "Fail to write message to client");
             }
             
         });
     }
     
     public static void main( String[] args ) {
    	 System.out.println("EchoServer Started.");
        try {
            new EchoServer( "127.0.0.1", 3575 );
            for( ; ; ) {
                Thread.sleep(10*1000);
            }
        } catch (Exception ex) {
            Logger.getLogger(EchoServer.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
