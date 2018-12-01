package server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.Iterator;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

public class HttpService {

	private HttpServer server;

	private HttpContext context;

	public HttpService() {
		// TODO Auto-generated constructor stub
		try {
			server = HttpServer.create(new InetSocketAddress(6700), 0);
			context = server.createContext("/");
			context.setHandler(HttpService::handleRequest);
			server.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void handleRequest(HttpExchange exchange) throws IOException {
		String requestPath = exchange.getRequestURI().getPath();
		File f = new File("./web" + requestPath);
		byte[] fileContent = Files.readAllBytes(f.toPath());
//		
		exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
		exchange.sendResponseHeaders(200, fileContent.length);// response code and length
		OutputStream os = exchange.getResponseBody();
		os.write(fileContent);
		os.close();
	}

	public static void main(String[] args) {
		HttpService hs = new HttpService();
	}

}
