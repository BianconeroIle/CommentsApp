package com.example.ilijaangeleski.cringle;

import com.example.ilijaangeleski.cringle.api.NetworkApi;
import com.example.ilijaangeleski.cringle.model.Comment;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.any;

public class NetworkApiTest {

    @Test
    public void testApiResponse() {
        NetworkApi mockedApiInterface = Mockito.mock(NetworkApi.class);
        final Call<List<Comment>> mockedCall = Mockito.mock(Call.class);

        Mockito.when(mockedApiInterface.fetchComments()).thenReturn(mockedCall);

        Mockito.doAnswer(new Answer() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Callback<List<Comment>> callback = invocation.getArgument(0);
                callback.onResponse(mockedCall, Response.success((List<Comment>) new ArrayList<Comment>()));

                return null;
            }
        }).when(mockedCall).enqueue(any(Callback.class));

    }
}