package com.liviamitrica.data.remote;

import com.liviamitrica.data.remote.exception.ApiException;
import com.liviamitrica.data.remote.exception.ConnectivityException;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpSuccessInterceptor implements Interceptor {
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request request = chain.request();
        Response response;
        try {
            response = chain.proceed(request);
        } catch (IOException exception) {
            throw new ConnectivityException(exception.getMessage());
        }
        if (!response.isSuccessful()) {
            throw new ApiException(response.code());
        }
        return response;
    }
}
