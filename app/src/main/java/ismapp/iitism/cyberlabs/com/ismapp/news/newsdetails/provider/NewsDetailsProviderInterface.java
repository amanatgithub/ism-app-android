package ismapp.iitism.cyberlabs.com.ismapp.news.newsdetails.provider;

import ismapp.iitism.cyberlabs.com.ismapp.helper.PresenterCallback;

public interface NewsDetailsProviderInterface {
    void getNewsResponse(String accessToken, int newsId, PresenterCallback presenterCallback);
}