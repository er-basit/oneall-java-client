package com.triptomap.libs.retrofit;

import retrofit.RequestInterceptor;

import static java.lang.String.format;
import static org.apache.commons.codec.binary.Base64.encodeBase64String;

/**
 * @author smecsia
 */
public class BasicAuthInterceptor implements RequestInterceptor {
    final String login;
    final String password;

    public BasicAuthInterceptor(String login, String password) {
        this.login = login;
        this.password = password;
    }


    @Override
    public void intercept(RequestFacade request) {
        String encoding = encodeBase64String(format("%s:%s", login, password).getBytes());
        request.addHeader("Authorization", format("Basic %s", encoding));
    }
}
