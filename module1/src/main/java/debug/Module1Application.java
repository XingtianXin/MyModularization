package debug;

import com.example.basemodule.base.BaseApplication;
import com.example.basemodule.injection.modules.BaseGlobalModule;
import com.example.module1.injection.DaggerModule1Component;
import com.example.module1.injection.Module1Component;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/8
 * Time: 13:42
 */
public class Module1Application extends BaseApplication {
    public static final String TAG = Module1Application.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        Module1Component appComponent = DaggerModule1Component.builder().build();
        appComponent.inject(this);
        return appComponent;
    }

    @Override
    protected String getBaseUrl() {
        return null;
    }
}
