import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class HttpUtils {

    public static void main(String[] args) {

        final String httpFile = "https://receitasdecodigo.com.br/resources/codeconference/img/favicon.png";
        final String localFile = "/home/wolmir/download.png";

        try {
            URL website = new URL(httpFile);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(localFile);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}