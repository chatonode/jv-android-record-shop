package org.northcoders.recordshopapp.util;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import org.northcoders.recordshopapp.dto.error.SingleErrorResponse;
import org.northcoders.recordshopapp.dto.error.ValidationErrorsResponse;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class ErrorResponseHandler {
    private static final String TAG = ErrorResponseHandler.class.getSimpleName();
    private final Gson gson;

    public ErrorResponseHandler() {
        this.gson = new Gson();
    }

    public void handleFailure(Throwable t) {
        // TODO: Remove it and use errorMessage as live data in VM, Activity, and UI
//        Toast.makeText(
//                application.getApplicationContext(),
//                "Connection Failure",
//                Toast.LENGTH_SHORT
//        ).show();

//        errorMessage.setValue("Connection Failure");

        Log.e(TAG, t.getMessage(), t);
    }

    public void handleErrorResponse(Response<?> response) {
        try (ResponseBody responseBody = response.errorBody()) {
            if (response.code() == 400) {

                String errorsBody = responseBody.string();

                ValidationErrorsResponse validationErrorsResponse = gson.fromJson(errorsBody, ValidationErrorsResponse.class);

                int numberOfInvalidFields = validationErrorsResponse.getError().size();
                String modifiedErrorMessage = validationErrorsResponse.getError().get(0).getReason()
                        + ((validationErrorsResponse.getError().size() > 1)
                        ? ", and " + (numberOfInvalidFields - 1) + " more..."
                        : "");

                // TODO: Remove it and use errorMessage as live data in VM, Activity, and UI
//                Toast.makeText(
//                        application.getApplicationContext(),
//                        modifiedErrorMessage,
//                        Toast.LENGTH_SHORT
//                ).show();

//                errorMessage.setValue(modifiedErrorMessage);

                Log.e(TAG, modifiedErrorMessage);

                return;
            }

            // Else

            String errorBody = responseBody.string();
            SingleErrorResponse singleErrorResponse = gson.fromJson(errorBody, SingleErrorResponse.class);

            // TODO: Remove it and use errorMessage as live data in VM, Activity, and UI
//            Toast.makeText(
//                    application.getApplicationContext(),
//                    singleErrorResponse.getMessage(),
//                    Toast.LENGTH_SHORT
//            ).show();

//            errorMessage.setValue(singleErrorResponse.getMessage());

            Log.e(TAG, singleErrorResponse.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "Error parsing error response: " + e.getMessage(), e);
        }
    }
}
