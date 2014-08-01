package com.triptomap.libs;

import com.triptomap.libs.oneall.Api;
import com.triptomap.libs.oneall.OneAllApiException;
import com.triptomap.libs.oneall.beans.Result;
import com.triptomap.libs.oneall.beans.User;
import com.triptomap.libs.retrofit.BasicAuthInterceptor;
import com.triptomap.libs.retrofit.OneAllErrorHandler;
import retrofit.RestAdapter;

/**
 * @author smecsia
 */
public class OneAll {
    final Api api;

    public OneAll(String username, String password, String endpoint) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setRequestInterceptor(new BasicAuthInterceptor(username, password))
                .setEndpoint(endpoint)
                .setErrorHandler(new OneAllErrorHandler())
                .build();
        this.api = restAdapter.create(Api.class);
    }

    public Api getApi() {
        return api;
    }

    public User getUser(String connectionToken) throws OneAllApiException {
        final Result result = getApi().getConnection(connectionToken).getResponse().getResult();
        if (result.getStatus().getFlag().equals("success")) {
            return result.getData().getUser();
        }
        throw new OneAllApiException(String.format("Failed to check user auth: %s",
                result.getStatus().getInfo()));
    }
}
