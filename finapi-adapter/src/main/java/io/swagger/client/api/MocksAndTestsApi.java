/*
 * finAPI RESTful Services
 * finAPI RESTful Services
 *
 * OpenAPI spec version: v1.46.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.BadCredentialsError;
import io.swagger.client.model.CategorizationCheckResults;
import io.swagger.client.model.ErrorMessage;
import io.swagger.client.model.MockBatchUpdateParams;
import io.swagger.client.model.TransactionsData;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MocksAndTestsApi {
    private ApiClient apiClient;

    public MocksAndTestsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MocksAndTestsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for checkCategorization
     * @param body Transactions data (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call checkCategorizationCall(TransactionsData body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/api/v1/tests/checkCategorization";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "finapi_auth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call checkCategorizationValidateBeforeCall(TransactionsData body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling checkCategorization(Async)");
        }
        

        com.squareup.okhttp.Call call = checkCategorizationCall(body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Check categorization
     * This service can be used to check the categorization for a given set of transactions, without the need of having the transactions actually imported in finAPI. The result of the categorization is the same as if the transactions were actually imported (the service regards the user-specific categorization rules of the user that is authorized by the access_token). Must pass the user&#39;s access_token.
     * @param body Transactions data (required)
     * @return CategorizationCheckResults
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CategorizationCheckResults checkCategorization(TransactionsData body) throws ApiException {
        ApiResponse<CategorizationCheckResults> resp = checkCategorizationWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Check categorization
     * This service can be used to check the categorization for a given set of transactions, without the need of having the transactions actually imported in finAPI. The result of the categorization is the same as if the transactions were actually imported (the service regards the user-specific categorization rules of the user that is authorized by the access_token). Must pass the user&#39;s access_token.
     * @param body Transactions data (required)
     * @return ApiResponse&lt;CategorizationCheckResults&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CategorizationCheckResults> checkCategorizationWithHttpInfo(TransactionsData body) throws ApiException {
        com.squareup.okhttp.Call call = checkCategorizationValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<CategorizationCheckResults>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Check categorization (asynchronously)
     * This service can be used to check the categorization for a given set of transactions, without the need of having the transactions actually imported in finAPI. The result of the categorization is the same as if the transactions were actually imported (the service regards the user-specific categorization rules of the user that is authorized by the access_token). Must pass the user&#39;s access_token.
     * @param body Transactions data (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call checkCategorizationAsync(TransactionsData body, final ApiCallback<CategorizationCheckResults> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = checkCategorizationValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CategorizationCheckResults>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for mockBatchUpdate
     * @param body Data for mock bank connection updates (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call mockBatchUpdateCall(MockBatchUpdateParams body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/api/v1/tests/mockBatchUpdate";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "finapi_auth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call mockBatchUpdateValidateBeforeCall(MockBatchUpdateParams body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling mockBatchUpdate(Async)");
        }
        

        com.squareup.okhttp.Call call = mockBatchUpdateCall(body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Mock batch update
     * This service can be used to mock an update of one or several bank connections by letting you simulate finAPI&#39;s communication with a bank server. More specifically, you can provide custom balances and transactions for existing accounts and finAPI will import that data into the accounts as if the data had been delivered by a real bank server during a real update. The idea of this service is to allow you to create accounts with specific data in them so that you can test your application in different scenarios.&lt;br/&gt;&lt;br/&gt;You can also test your application&#39;s reception and processing of push notifications with this service, by enabling the &#39;triggerNotifications&#39; flag in your request. When this flag is enabled, finAPI will send notifications to your application based on the notification rules that are set up for the user and on the data you provided in the request, the same way as it works with finAPI&#39;s real automatic batch update process.&lt;br/&gt;&lt;br/&gt;Note that this service behaves mostly like calling the bank connection update service, meaning that it returns immediately after having asynchronously started the update process, and also meaning that you have to check the status of the updated bank connections and accounts to find out when the update has finished and what the result is. As you can update several bank connections at once, this service is closer to how finAPI&#39;s automatic batch updates work as it is to the manual update service though. Because of this, the result of the mocked bank connection updates will be stored in the &#39;lastAutoUpdate&#39; field of the bank connections and not in the &#39;lastManualUpdate&#39; field. Also, just like with the real batch update, any bank connection that you use with this service must have a PIN stored (even though it is not actually forwarded to any bank server).&lt;br/&gt;&lt;br/&gt;Also note that this service may be called only when the user&#39;s automatic bank connection updates are disabled, to make sure that the mock updates cannot intervene with a real update (please see the User field &#39;isAutoUpdateEnabled&#39;). Also, it is not possible to use the demo bank connection in this service, so you need to have at least one real online bank connection. At last, it is currently not possible to mock data for security accounts with this service, as you can only pass transactions, but not security positions.&lt;br/&gt;&lt;br/&gt;Please be aware that you will &#39;mess up&#39; the accounts when using this service, meaning that when you perform a real update of accounts that you have previously updated with this service, finAPI might detect inconsistencies in the data that exists in its database and the data that is reported by the bank server, and try to fix this with the insertion of an adjusting entry (&#39;Zwischensaldo&#39; transaction). Also, new real transactions might not get imported as finAPI could match them to mocked transactions. &lt;b&gt;THIS SERVICE IS MEANT FOR TESTING PURPOSES DURING DEVELOPMENT OF YOUR APPLICATION ONLY!&lt;/b&gt; This is why it will work only on the sandbox or alpha environments. Calling it on the live environment will result in &lt;b&gt;403 Forbidden&lt;/b&gt;.
     * @param body Data for mock bank connection updates (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void mockBatchUpdate(MockBatchUpdateParams body) throws ApiException {
        mockBatchUpdateWithHttpInfo(body);
    }

    /**
     * Mock batch update
     * This service can be used to mock an update of one or several bank connections by letting you simulate finAPI&#39;s communication with a bank server. More specifically, you can provide custom balances and transactions for existing accounts and finAPI will import that data into the accounts as if the data had been delivered by a real bank server during a real update. The idea of this service is to allow you to create accounts with specific data in them so that you can test your application in different scenarios.&lt;br/&gt;&lt;br/&gt;You can also test your application&#39;s reception and processing of push notifications with this service, by enabling the &#39;triggerNotifications&#39; flag in your request. When this flag is enabled, finAPI will send notifications to your application based on the notification rules that are set up for the user and on the data you provided in the request, the same way as it works with finAPI&#39;s real automatic batch update process.&lt;br/&gt;&lt;br/&gt;Note that this service behaves mostly like calling the bank connection update service, meaning that it returns immediately after having asynchronously started the update process, and also meaning that you have to check the status of the updated bank connections and accounts to find out when the update has finished and what the result is. As you can update several bank connections at once, this service is closer to how finAPI&#39;s automatic batch updates work as it is to the manual update service though. Because of this, the result of the mocked bank connection updates will be stored in the &#39;lastAutoUpdate&#39; field of the bank connections and not in the &#39;lastManualUpdate&#39; field. Also, just like with the real batch update, any bank connection that you use with this service must have a PIN stored (even though it is not actually forwarded to any bank server).&lt;br/&gt;&lt;br/&gt;Also note that this service may be called only when the user&#39;s automatic bank connection updates are disabled, to make sure that the mock updates cannot intervene with a real update (please see the User field &#39;isAutoUpdateEnabled&#39;). Also, it is not possible to use the demo bank connection in this service, so you need to have at least one real online bank connection. At last, it is currently not possible to mock data for security accounts with this service, as you can only pass transactions, but not security positions.&lt;br/&gt;&lt;br/&gt;Please be aware that you will &#39;mess up&#39; the accounts when using this service, meaning that when you perform a real update of accounts that you have previously updated with this service, finAPI might detect inconsistencies in the data that exists in its database and the data that is reported by the bank server, and try to fix this with the insertion of an adjusting entry (&#39;Zwischensaldo&#39; transaction). Also, new real transactions might not get imported as finAPI could match them to mocked transactions. &lt;b&gt;THIS SERVICE IS MEANT FOR TESTING PURPOSES DURING DEVELOPMENT OF YOUR APPLICATION ONLY!&lt;/b&gt; This is why it will work only on the sandbox or alpha environments. Calling it on the live environment will result in &lt;b&gt;403 Forbidden&lt;/b&gt;.
     * @param body Data for mock bank connection updates (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> mockBatchUpdateWithHttpInfo(MockBatchUpdateParams body) throws ApiException {
        com.squareup.okhttp.Call call = mockBatchUpdateValidateBeforeCall(body, null, null);
        return apiClient.execute(call);
    }

    /**
     * Mock batch update (asynchronously)
     * This service can be used to mock an update of one or several bank connections by letting you simulate finAPI&#39;s communication with a bank server. More specifically, you can provide custom balances and transactions for existing accounts and finAPI will import that data into the accounts as if the data had been delivered by a real bank server during a real update. The idea of this service is to allow you to create accounts with specific data in them so that you can test your application in different scenarios.&lt;br/&gt;&lt;br/&gt;You can also test your application&#39;s reception and processing of push notifications with this service, by enabling the &#39;triggerNotifications&#39; flag in your request. When this flag is enabled, finAPI will send notifications to your application based on the notification rules that are set up for the user and on the data you provided in the request, the same way as it works with finAPI&#39;s real automatic batch update process.&lt;br/&gt;&lt;br/&gt;Note that this service behaves mostly like calling the bank connection update service, meaning that it returns immediately after having asynchronously started the update process, and also meaning that you have to check the status of the updated bank connections and accounts to find out when the update has finished and what the result is. As you can update several bank connections at once, this service is closer to how finAPI&#39;s automatic batch updates work as it is to the manual update service though. Because of this, the result of the mocked bank connection updates will be stored in the &#39;lastAutoUpdate&#39; field of the bank connections and not in the &#39;lastManualUpdate&#39; field. Also, just like with the real batch update, any bank connection that you use with this service must have a PIN stored (even though it is not actually forwarded to any bank server).&lt;br/&gt;&lt;br/&gt;Also note that this service may be called only when the user&#39;s automatic bank connection updates are disabled, to make sure that the mock updates cannot intervene with a real update (please see the User field &#39;isAutoUpdateEnabled&#39;). Also, it is not possible to use the demo bank connection in this service, so you need to have at least one real online bank connection. At last, it is currently not possible to mock data for security accounts with this service, as you can only pass transactions, but not security positions.&lt;br/&gt;&lt;br/&gt;Please be aware that you will &#39;mess up&#39; the accounts when using this service, meaning that when you perform a real update of accounts that you have previously updated with this service, finAPI might detect inconsistencies in the data that exists in its database and the data that is reported by the bank server, and try to fix this with the insertion of an adjusting entry (&#39;Zwischensaldo&#39; transaction). Also, new real transactions might not get imported as finAPI could match them to mocked transactions. &lt;b&gt;THIS SERVICE IS MEANT FOR TESTING PURPOSES DURING DEVELOPMENT OF YOUR APPLICATION ONLY!&lt;/b&gt; This is why it will work only on the sandbox or alpha environments. Calling it on the live environment will result in &lt;b&gt;403 Forbidden&lt;/b&gt;.
     * @param body Data for mock bank connection updates (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call mockBatchUpdateAsync(MockBatchUpdateParams body, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = mockBatchUpdateValidateBeforeCall(body, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
