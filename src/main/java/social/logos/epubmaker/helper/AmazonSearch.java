/**
 * 
 */
package social.logos.epubmaker.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import social.logos.epubmaker.AmazonConstants;
import social.logos.epubmaker.util.SignedRequestsHelper;

/**
 * @author naresh
 *
 */
public class AmazonSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getBooks("", "Memoirs of the Marchioness of Pompadour (vol. 1 of 2)", "");

	}

	public static String getSignedUrl(String author, String title, String isbn) {
		// TODO Auto-generated method stub

		SignedRequestsHelper helper;

		try {
			helper = new SignedRequestsHelper();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		String requestUrl = null;

		Map<String, String> params = new HashMap<String, String>();

		params.put("Service", "AWSECommerceService");
		params.put("Operation", "ItemSearch");
		params.put("AWSAccessKeyId", AmazonConstants.AWS_ACCESS_KEY_ID);
		params.put("AssociateTag", AmazonConstants.ASSOCIATE_TAG);
		params.put("SearchIndex", "Books");
		params.put("Title", title);
		params.put("ResponseGroup", "Medium");
		params.put("Version", "2011-08-01");

		requestUrl = helper.sign(params, AmazonConstants.ENDPOINT);

		// System.out.println("Signed URL: \"" + requestUrl + "\"");
		return requestUrl;
	}

	public static String getBooks(String author, String title, String isbn) {
		String description = "";
		String requestUrl = getSignedUrl(author, title, isbn);
		String line = "";
		JSONObject obj = null;
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(requestUrl);
		int retryCount = 0;
		HttpResponse response = null;
		do {
			try {
				if (retryCount > 0) {
					Thread.sleep(2000);
				} else {
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				response = client.execute(request);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println("Response Code : " +
			// response.getStatusLine().getStatusCode());
			++retryCount;
		} while (retryCount < 3 && ((response.getStatusLine().getStatusCode() == 504)
				|| (response.getStatusLine().getStatusCode() == 429)));

		if (response.getStatusLine().getStatusCode() == 200) {
			BufferedReader rd = null;
			try {
				rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			} catch (UnsupportedOperationException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			StringBuffer result = new StringBuffer();

			try {
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			// System.out.println(result);
			try {
				// System.out.println(result.toString());
				obj = XML.toJSONObject(result.toString());
				// System.out.println(obj);
			} catch (JSONException je) {
				je.printStackTrace();
			}

		}
		if (obj != null) {
			JSONObject items = obj.getJSONObject("ItemSearchResponse").getJSONObject("Items");
			JSONArray productItems = new JSONArray();
			if (items.has("Item")) {
				if (items.get("Item") instanceof JSONArray) {
					productItems = items.getJSONArray("Item");
				}
			}
			for (int i = 0; i < productItems.length(); i++) {
				try {
					JSONObject item = productItems.getJSONObject(i);
					if (item.has("EditorialReviews")) {
						System.out.println("Description :" + item.getJSONObject("EditorialReviews")
								.getJSONObject("EditorialReview").getString("Content"));
						description = item.getJSONObject("EditorialReviews").getJSONObject("EditorialReview")
								.getString("Content");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return description;
	}

}
