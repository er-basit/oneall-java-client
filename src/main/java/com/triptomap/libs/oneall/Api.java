package com.triptomap.libs.oneall;

import com.triptomap.libs.oneall.beans.Connection;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * @author smecsia
 */
public interface Api {

    @GET("/connections/{connectionToken}.json")
    Connection getConnection(@Path("connectionToken") String connectionToken);

}
