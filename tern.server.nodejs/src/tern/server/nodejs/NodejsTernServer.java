package tern.server.nodejs;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;

import tern.doc.IJSDocument;
import tern.server.IResponseHandler;
import tern.server.ITernServer;
import tern.server.TernDef;
import tern.server.nodejs.protocol.TernCompletionQuery;
import tern.server.nodejs.protocol.TernDoc;
import tern.server.nodejs.protocol.TernProtocolHelper;

public class NodejsTernServer implements ITernServer {

	private TernProject project;

	private final String baseURL;
	
	private final File projectDir;

	public NodejsTernServer(int port, File projectDir) {
		this.projectDir = projectDir;
		this.baseURL = "http://localhost:" + port + "/";
	}

	@Override
	public String getFile(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDef(TernDef def) throws IOException {
		if (project == null) {
			setProject(new TernProject(projectDir));
		}
		project.addLib(def.name());
		project.save();
	}

	@Override
	public void addFile(String name, String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendDoc(IJSDocument doc, IResponseHandler handler) {
		TernDoc t = new TernDoc();
		t.addFile(doc.getName(), doc.getValue(), null);
		System.out.println(doc);

		try {
			JSONObject json = TernProtocolHelper.makeRequest(baseURL, t, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void registerDoc(IJSDocument doc) {
		TernDoc t = new TernDoc();
		t.addFile(doc.getName(), doc.getValue(), null);
		System.out.println(doc);

		try {
			JSONObject json = TernProtocolHelper.makeRequest(baseURL, t, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void requestCompletion(IJSDocument doc, IResponseHandler handler,
			boolean dataAsJson) {

		TernDoc t = new TernDoc();

		TernCompletionQuery query = new TernCompletionQuery();
		query.setTypes(true);
		query.setFile("#0");
		query.setEnd(doc.getCursor("end"));
		query.setLineCharPositions(true);
		t.setQuery(query);

		t.addFile(doc.getName(), doc.getValue(), null);

		System.out.println(t.toJSONString());

		try {
			JSONObject json = TernProtocolHelper.makeRequest(baseURL, t, false);
			handler.onSuccess(json, dataAsJson ? json.toJSONString() : null);
		} catch (IOException e) {
			handler.onError(e.getMessage());
		}

	}

	public TernProject getProject() {
		return project;
	}

	public void setProject(TernProject project) {
		this.project = project;
	}

}
