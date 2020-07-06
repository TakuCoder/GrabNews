package com.thiyagu.grabnews.DI.Component;
import com.thiyagu.grabnews.Interfaces.NewsAPIInterface;
import com.thiyagu.grabnews.DI.Module.AppModule;
import com.thiyagu.grabnews.DI.Module.DatabaseModule;
import com.thiyagu.grabnews.DI.Module.NetModule;
import com.thiyagu.grabnews.DI.Module.RxModule;
import com.thiyagu.grabnews.Repo.Remote.NewsRepo;
import com.thiyagu.grabnews.models.ViewModel.NewsViewModel;
import javax.inject.Singleton;
import dagger.Component;
@Singleton
@Component(modules = {AppModule.class, NetModule.class, DatabaseModule.class, RxModule.class})
public interface NewsComponent {
    NewsAPIInterface getApiInterface();
    void inject(NewsRepo newsRepo);
    void inject(NewsViewModel newsViewModel);
}

