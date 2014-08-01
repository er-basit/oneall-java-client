package com.triptomap.libs.retrofit;

import com.triptomap.libs.oneall.OneAllApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.ErrorHandler;
import retrofit.RetrofitError;

import static java.lang.String.format;

/**
 * @author smecsia
 */
public class OneAllErrorHandler implements ErrorHandler {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Throwable handleError(RetrofitError e) {
        if (e.getResponse() != null) {
            final String error = format("Failed to fetch connection from oneall api. " +
                    "\nResponse: url=%s, status=%s, body='%s'",
                    e.getResponse().getUrl(),
                    e.getResponse().getStatus(),
                    e.getResponse().getBody()
            );
            logger.error(error, e);
            throw new OneAllApiException(error, e);
        } else {
            final String error = format("Failed to fetch the connection from oneall api. ");
            logger.error(error, e);
            throw new OneAllApiException(error, e);
        }
    }
}
