package ismapp.iitism.cyberlabs.com.ismapp.authentication.verifyotp.Provider;



import ismapp.iitism.cyberlabs.com.ismapp.helper.ApiClient;
import ismapp.iitism.cyberlabs.com.ismapp.authentication.verifyotp.Api.VerifyOtpApi;
import ismapp.iitism.cyberlabs.com.ismapp.authentication.verifyotp.Model.VerifyOtpModel;
import ismapp.iitism.cyberlabs.com.ismapp.helper.PresenterCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyOtpProviderImp implements VerifyOtpProvider{
   private VerifyOtpApi verifyOtpApi;
   private Call<VerifyOtpModel> call;

    public VerifyOtpProviderImp()
    {
        verifyOtpApi=ApiClient.getRetrofit().create(VerifyOtpApi.class);
    }


    @Override
    public void getOtpVerificationResponse(String email, int otp, final PresenterCallback callback) {
        call=verifyOtpApi.getResponse(email,otp);
        call.enqueue(new Callback<VerifyOtpModel>() {
            @Override
            public void onResponse(Call<VerifyOtpModel> call, Response<VerifyOtpModel> response) {
                callback.onSuccess((VerifyOtpModel)response.body());
            }

            @Override
            public void onFailure(Call<VerifyOtpModel> call, Throwable t) {
               callback.OnFailure(t.toString());
            }
        });
    }
}

