package com.triptomap.libs;

import com.triptomap.libs.oneall.OneAllApiException;
import com.triptomap.libs.oneall.beans.User;
import org.junit.Ignore;
import org.junit.Test;
import retrofit.RetrofitError;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * @author smecsia
 */
public class OneAllTest {

    @Test
    @Ignore
    public void testApi() throws UnsupportedEncodingException {

        OneAll oneAll = new OneAll(
                "Your Oneall Public Key",
                "Your Oneall Private Key",
                "Your Oneall Domain"
        );

        boolean exception = false;


        try {
            User user = oneAll.getUser("8875cb47-9b2e-40f9-8ae0-8428c06937a9");
            assertThat(user, not(nullValue()));
        } catch (OneAllApiException e) {
            assertThat(e.getCause(), not(instanceOf(RetrofitError.class)));
            exception = true;
        }
        assertThat(exception, is(true));
    }

}
