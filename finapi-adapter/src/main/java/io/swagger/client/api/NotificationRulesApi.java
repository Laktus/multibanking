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
import io.swagger.client.model.ErrorMessage;
import io.swagger.client.model.IdentifierList;
import io.swagger.client.model.NotificationRule;
import io.swagger.client.model.NotificationRuleList;
import io.swagger.client.model.NotificationRuleParams;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationRulesApi {
    private ApiClient apiClient;

    public NotificationRulesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public NotificationRulesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createNotificationRule
     * @param body Notification rule parameters (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createNotificationRuleCall(NotificationRuleParams body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/api/v1/notificationRules";

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
    private com.squareup.okhttp.Call createNotificationRuleValidateBeforeCall(NotificationRuleParams body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling createNotificationRule(Async)");
        }
        

        com.squareup.okhttp.Call call = createNotificationRuleCall(body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create a new notification rule
     * Create a new notification rule for a specific user. Must pass the user&#39;s access_token.&lt;br/&gt;&lt;br/&gt;Setting up notification rules for a user allows your client application to get notified about changes in the user&#39;s data, e.g. when new transactions were downloaded, an account&#39;s balance has changed, or the user&#39;s banking credentials are no longer correct. Note that currently, this feature is implemented only for finAPI&#39;s automatic batch update, i.e. notification rules are only relevant when the user has activated the automatic updates (and when the automatic batch update is activated in general for your client).&lt;br/&gt;&lt;br/&gt;There are different kinds of notification rules. The kind of a rule is depicted by the &#39;triggerEvent&#39;. The trigger event specifies what data you have to pass when creating a rule (specifically, the contents of the &#39;params&#39; field), on which events finAPI will send notifications to your client application, as well as what data is contained in those notifications. The specifics of the different trigger events are documented in the following article on our Dev Portal: &lt;a href&#x3D;&#39;https://finapi.zendesk.com/hc/en-us/articles/232324608-How-to-create-notification-rules-and-receive-notifications&#39;&gt;How to create notification rules and receive notifications&lt;/a&gt;
     * @param body Notification rule parameters (required)
     * @return NotificationRule
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public NotificationRule createNotificationRule(NotificationRuleParams body) throws ApiException {
        ApiResponse<NotificationRule> resp = createNotificationRuleWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Create a new notification rule
     * Create a new notification rule for a specific user. Must pass the user&#39;s access_token.&lt;br/&gt;&lt;br/&gt;Setting up notification rules for a user allows your client application to get notified about changes in the user&#39;s data, e.g. when new transactions were downloaded, an account&#39;s balance has changed, or the user&#39;s banking credentials are no longer correct. Note that currently, this feature is implemented only for finAPI&#39;s automatic batch update, i.e. notification rules are only relevant when the user has activated the automatic updates (and when the automatic batch update is activated in general for your client).&lt;br/&gt;&lt;br/&gt;There are different kinds of notification rules. The kind of a rule is depicted by the &#39;triggerEvent&#39;. The trigger event specifies what data you have to pass when creating a rule (specifically, the contents of the &#39;params&#39; field), on which events finAPI will send notifications to your client application, as well as what data is contained in those notifications. The specifics of the different trigger events are documented in the following article on our Dev Portal: &lt;a href&#x3D;&#39;https://finapi.zendesk.com/hc/en-us/articles/232324608-How-to-create-notification-rules-and-receive-notifications&#39;&gt;How to create notification rules and receive notifications&lt;/a&gt;
     * @param body Notification rule parameters (required)
     * @return ApiResponse&lt;NotificationRule&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<NotificationRule> createNotificationRuleWithHttpInfo(NotificationRuleParams body) throws ApiException {
        com.squareup.okhttp.Call call = createNotificationRuleValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<NotificationRule>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new notification rule (asynchronously)
     * Create a new notification rule for a specific user. Must pass the user&#39;s access_token.&lt;br/&gt;&lt;br/&gt;Setting up notification rules for a user allows your client application to get notified about changes in the user&#39;s data, e.g. when new transactions were downloaded, an account&#39;s balance has changed, or the user&#39;s banking credentials are no longer correct. Note that currently, this feature is implemented only for finAPI&#39;s automatic batch update, i.e. notification rules are only relevant when the user has activated the automatic updates (and when the automatic batch update is activated in general for your client).&lt;br/&gt;&lt;br/&gt;There are different kinds of notification rules. The kind of a rule is depicted by the &#39;triggerEvent&#39;. The trigger event specifies what data you have to pass when creating a rule (specifically, the contents of the &#39;params&#39; field), on which events finAPI will send notifications to your client application, as well as what data is contained in those notifications. The specifics of the different trigger events are documented in the following article on our Dev Portal: &lt;a href&#x3D;&#39;https://finapi.zendesk.com/hc/en-us/articles/232324608-How-to-create-notification-rules-and-receive-notifications&#39;&gt;How to create notification rules and receive notifications&lt;/a&gt;
     * @param body Notification rule parameters (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createNotificationRuleAsync(NotificationRuleParams body, final ApiCallback<NotificationRule> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createNotificationRuleValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<NotificationRule>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteAllNotificationRules
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteAllNotificationRulesCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/notificationRules";

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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteAllNotificationRulesValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = deleteAllNotificationRulesCall(progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete all notification rules
     * Delete all notification rules of the user that is authorized by the access_token. Must pass the user&#39;s access_token. 
     * @return IdentifierList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IdentifierList deleteAllNotificationRules() throws ApiException {
        ApiResponse<IdentifierList> resp = deleteAllNotificationRulesWithHttpInfo();
        return resp.getData();
    }

    /**
     * Delete all notification rules
     * Delete all notification rules of the user that is authorized by the access_token. Must pass the user&#39;s access_token. 
     * @return ApiResponse&lt;IdentifierList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IdentifierList> deleteAllNotificationRulesWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = deleteAllNotificationRulesValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<IdentifierList>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete all notification rules (asynchronously)
     * Delete all notification rules of the user that is authorized by the access_token. Must pass the user&#39;s access_token. 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteAllNotificationRulesAsync(final ApiCallback<IdentifierList> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteAllNotificationRulesValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IdentifierList>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteNotificationRule
     * @param id Identifier of the notification rule to delete (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteNotificationRuleCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/notificationRules/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteNotificationRuleValidateBeforeCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteNotificationRule(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteNotificationRuleCall(id, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete a notification rule
     * Delete a single notification rule of the user that is authorized by the access_token. Must pass the notification rule&#39;s identifier and the user&#39;s access_token.
     * @param id Identifier of the notification rule to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteNotificationRule(Long id) throws ApiException {
        deleteNotificationRuleWithHttpInfo(id);
    }

    /**
     * Delete a notification rule
     * Delete a single notification rule of the user that is authorized by the access_token. Must pass the notification rule&#39;s identifier and the user&#39;s access_token.
     * @param id Identifier of the notification rule to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteNotificationRuleWithHttpInfo(Long id) throws ApiException {
        com.squareup.okhttp.Call call = deleteNotificationRuleValidateBeforeCall(id, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete a notification rule (asynchronously)
     * Delete a single notification rule of the user that is authorized by the access_token. Must pass the notification rule&#39;s identifier and the user&#39;s access_token.
     * @param id Identifier of the notification rule to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteNotificationRuleAsync(Long id, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteNotificationRuleValidateBeforeCall(id, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getAndSearchAllNotificationRules
     * @param ids A comma-separated list of notification rule identifiers. If specified, then only notification rules whose identifier match any of the given identifiers will be regarded. The maximum number of identifiers is 1000. (optional)
     * @param triggerEvent If specified, then only notification rules with given trigger event will be regarded. (optional)
     * @param includeDetails If specified, then only notification rules that include or not include details will be regarded. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getAndSearchAllNotificationRulesCall(List<Long> ids, String triggerEvent, Boolean includeDetails, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/notificationRules";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (ids != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "ids", ids));
        if (triggerEvent != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("triggerEvent", triggerEvent));
        if (includeDetails != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("includeDetails", includeDetails));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAndSearchAllNotificationRulesValidateBeforeCall(List<Long> ids, String triggerEvent, Boolean includeDetails, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getAndSearchAllNotificationRulesCall(ids, triggerEvent, includeDetails, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get and search all notification rules
     * Get notification rules of the user that is authorized by the access_token. Must pass the user&#39;s access_token. You can set optional search criteria to get only those notification rules that you are interested in. If you do not specify any search criteria, then this service functions as a &#39;get all&#39; service.
     * @param ids A comma-separated list of notification rule identifiers. If specified, then only notification rules whose identifier match any of the given identifiers will be regarded. The maximum number of identifiers is 1000. (optional)
     * @param triggerEvent If specified, then only notification rules with given trigger event will be regarded. (optional)
     * @param includeDetails If specified, then only notification rules that include or not include details will be regarded. (optional)
     * @return NotificationRuleList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public NotificationRuleList getAndSearchAllNotificationRules(List<Long> ids, String triggerEvent, Boolean includeDetails) throws ApiException {
        ApiResponse<NotificationRuleList> resp = getAndSearchAllNotificationRulesWithHttpInfo(ids, triggerEvent, includeDetails);
        return resp.getData();
    }

    /**
     * Get and search all notification rules
     * Get notification rules of the user that is authorized by the access_token. Must pass the user&#39;s access_token. You can set optional search criteria to get only those notification rules that you are interested in. If you do not specify any search criteria, then this service functions as a &#39;get all&#39; service.
     * @param ids A comma-separated list of notification rule identifiers. If specified, then only notification rules whose identifier match any of the given identifiers will be regarded. The maximum number of identifiers is 1000. (optional)
     * @param triggerEvent If specified, then only notification rules with given trigger event will be regarded. (optional)
     * @param includeDetails If specified, then only notification rules that include or not include details will be regarded. (optional)
     * @return ApiResponse&lt;NotificationRuleList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<NotificationRuleList> getAndSearchAllNotificationRulesWithHttpInfo(List<Long> ids, String triggerEvent, Boolean includeDetails) throws ApiException {
        com.squareup.okhttp.Call call = getAndSearchAllNotificationRulesValidateBeforeCall(ids, triggerEvent, includeDetails, null, null);
        Type localVarReturnType = new TypeToken<NotificationRuleList>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get and search all notification rules (asynchronously)
     * Get notification rules of the user that is authorized by the access_token. Must pass the user&#39;s access_token. You can set optional search criteria to get only those notification rules that you are interested in. If you do not specify any search criteria, then this service functions as a &#39;get all&#39; service.
     * @param ids A comma-separated list of notification rule identifiers. If specified, then only notification rules whose identifier match any of the given identifiers will be regarded. The maximum number of identifiers is 1000. (optional)
     * @param triggerEvent If specified, then only notification rules with given trigger event will be regarded. (optional)
     * @param includeDetails If specified, then only notification rules that include or not include details will be regarded. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAndSearchAllNotificationRulesAsync(List<Long> ids, String triggerEvent, Boolean includeDetails, final ApiCallback<NotificationRuleList> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getAndSearchAllNotificationRulesValidateBeforeCall(ids, triggerEvent, includeDetails, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<NotificationRuleList>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getNotificationRule
     * @param id Identifier of requested notification rule (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getNotificationRuleCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/notificationRules/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getNotificationRuleValidateBeforeCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getNotificationRule(Async)");
        }
        

        com.squareup.okhttp.Call call = getNotificationRuleCall(id, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a notification rule
     * Get a single notification rule of the user that is authorized by the access_token. Must pass the notification rule&#39;s identifier and the user&#39;s access_token.
     * @param id Identifier of requested notification rule (required)
     * @return NotificationRule
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public NotificationRule getNotificationRule(Long id) throws ApiException {
        ApiResponse<NotificationRule> resp = getNotificationRuleWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Get a notification rule
     * Get a single notification rule of the user that is authorized by the access_token. Must pass the notification rule&#39;s identifier and the user&#39;s access_token.
     * @param id Identifier of requested notification rule (required)
     * @return ApiResponse&lt;NotificationRule&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<NotificationRule> getNotificationRuleWithHttpInfo(Long id) throws ApiException {
        com.squareup.okhttp.Call call = getNotificationRuleValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<NotificationRule>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a notification rule (asynchronously)
     * Get a single notification rule of the user that is authorized by the access_token. Must pass the notification rule&#39;s identifier and the user&#39;s access_token.
     * @param id Identifier of requested notification rule (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getNotificationRuleAsync(Long id, final ApiCallback<NotificationRule> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getNotificationRuleValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<NotificationRule>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
