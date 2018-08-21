package simple;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.ssl.SSLContextBuilder;

public class Simple {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, KeyManagementException {
		 HttpAsyncClientBuilder custom = HttpAsyncClients.custom();
		 SSLContextBuilder sslContextBuilder = new SSLContextBuilder().loadKeyMaterial((KeyStore)null, "".toCharArray());
		 custom.setSSLContext(sslContextBuilder.build());
		 CloseableHttpAsyncClient client = custom.build();
		 client.start();
		 RequestBuilder rb = RequestBuilder.create("POST").setUri("https://google.com");
		 client.execute(rb.build(), new FutureCallback<HttpResponse>() {
			
			public void failed(Exception arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void completed(HttpResponse arg0) {
				System.out.println(arg0.toString());
			}
			
			public void cancelled() {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
