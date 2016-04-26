package com.fit2cloud.ksyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fit2cloud.ksyun.exceptions.KSYunClientException;
import com.fit2cloud.ksyun.exceptions.KSYunServiceException;
import com.fit2cloud.ksyun.util.GlobalConst;
import com.fit2cloud.ksyun.util.KSSign;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseModuleRequest {

    protected static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    protected static final Gson gson = new GsonBuilder().setDateFormat(ISO8601_DATE_FORMAT).create();

    protected String endpoint;
    protected String httpMethod = GlobalConst.DEFAULT_HTTPS_METHOD;

    protected KSYunCredential credentials;

    public BaseModuleRequest(KSYunCredential credentials, String endpoint) {
        this.credentials = credentials;
        this.endpoint = endpoint;
    }

    public String execute(String action, Map<String, String> parameters) throws KSYunClientException, KSYunServiceException {
        assert (action != null && action.length() > 0);
        if (parameters == null) {
            parameters = new HashMap<String, String>();
        }
        addCommonParams(action, parameters);
        return sendRequest(action, parameters);
    }

    private String sendRequest(String action, Map<String, String> parameters) throws KSYunClientException, KSYunServiceException {
        InputStream stream = null;
        try {
            String query = paramsToQueryString(parameters);
            URL url = new URL("https://" + endpoint + "?" + query);
            DefaultHttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url.toString());
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() >= 400) {
                stream = response.getEntity().getContent();
                String message = readContent(stream);
                CommonErrorResponse error = gson.fromJson(message, CommonErrorResponse.class);
                KSYunServiceException exception = new KSYunServiceException(error.getMessage());
                exception.setErrorCode(error.getCode());
                exception.setService(action);
                throw exception;
            } else {
                stream = response.getEntity().getContent();
                return readContent(stream);
            }
        } catch (IOException e) {
            throw new KSYunClientException("Failed to connect to KSYun:" + e.getMessage());
        } finally {
            safeClose(stream);
        }
    }

    protected void addCommonParams(String action, Map<String, String> parameters) {
        parameters.put("Action", action);
        parameters.put("AccessKeyId", credentials.getAccessKeyId());
        parameters.put("Format", "json");
        parameters.put("Version", "2015-05-31");
        parameters.put("SignatureMethod", "HMAC-SHA256");
        parameters.put("SignatureVersion", KSSign.SIGNATURE_VERSION);
        SimpleDateFormat sdf = new SimpleDateFormat(ISO8601_DATE_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        parameters.put("Timestamp", String.valueOf(sdf.format(new Date())));
        parameters.put("SignatureNonce", String.valueOf(UUID.randomUUID()));
        parameters.put("Signature", computeSignature(parameters, credentials.getAccessKeySecret()));
    }

    @SuppressWarnings("deprecation")
	protected String computeSignature(Map<String, String> parameters, String privateKey) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.httpMethod).append("\n");
        TreeMap<String, String> sortParams = new TreeMap<String, String>(parameters);
        for (Entry<String, String> entry : sortParams.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        String canonicalStr = sb.toString().replace("/", "%2F").replace("%7E", "~").replace("+", "%2B").replace(":", "%3A");
        try {
            return URLDecoder.decode(KSSign.sign(canonicalStr, privateKey));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String paramsToQueryString(Map<String, String> params)
            throws UnsupportedEncodingException {
        if (params == null || params.size() == 0) {
            return null;
        }

        StringBuilder paramString = new StringBuilder();
        boolean first = true;
        for (Entry<String, String> p : params.entrySet()) {
            String key = p.getKey();
            String val = p.getValue();
            if (!first) {
                paramString.append("&");
            }
            paramString.append(URLEncoder.encode(key, GlobalConst.CHARSET));

            if (val != null) {
                paramString.append("=").append(
                        URLEncoder.encode(val, GlobalConst.CHARSET));
            }
            first = false;
        }
        return paramString.toString();
    }

    private String readContent(InputStream content)
            throws IOException {
        if (content == null)
            return "";

        Reader reader = null;
        Writer writer = new StringWriter();
        String result;

        char[] buffer = new char[1024];
        try {
            reader = new BufferedReader(
                    new InputStreamReader(content, GlobalConst.CHARSET));
            int n;
            while ((n = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, n);
            }
            result = writer.toString();
        } finally {
            content.close();
            if (reader != null) {
                reader.close();
            }
            writer.close();
        }
        return result;
    }

    private void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }
}
